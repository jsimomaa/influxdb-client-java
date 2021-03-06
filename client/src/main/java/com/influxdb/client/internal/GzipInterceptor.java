/*
 * The MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.influxdb.client.internal;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;
import javax.annotation.Nonnull;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.BufferedSink;
import okio.GzipSink;
import okio.Okio;

/**
 * @author Jakub Bednar (bednar@github) (15/10/2018 11:26)
 */
public class GzipInterceptor implements Interceptor {

    private static final Pattern CONTENT_PATTERN = Pattern.compile(".*/write", Pattern.CASE_INSENSITIVE);
    private static final Pattern ACCEPT_PATTERN = Pattern.compile(".*/query", Pattern.CASE_INSENSITIVE);

    private AtomicBoolean enabled = new AtomicBoolean(false);

    @Nonnull
    @Override
    public Response intercept(@Nonnull final Chain chain) throws IOException {

        Request request = chain.request();
        RequestBody body = request.body();

        Request enhancedRequest;
        if (!enabled.get()) {
            //
            // Disabled
            //
            Request.Builder builder = request.newBuilder();
            builder = addHeader(request, builder, "Accept-Encoding", "identity");
            enhancedRequest = builder.build();
        } else if (CONTENT_PATTERN.matcher(request.url().encodedPath()).matches()) {
            //
            // GZIP content
            //
            Request.Builder builder = request.newBuilder();
            if (body == null || request.header("Content-Encoding") != null) {
                enhancedRequest = builder.build();
            } else {
                builder = addHeader(request, builder, "Content-Encoding", "gzip");
                builder = addHeader(request, builder, "Accept-Encoding", "identity");
                enhancedRequest = builder.method(request.method(), gzip(body)).build();
            }
        } else if (ACCEPT_PATTERN.matcher(request.url().encodedPath()).matches()) {
            //
            // GZIP response
            //
            // The okhttp3.internal.http.BridgeInterceptor add gzip accept
            //
            enhancedRequest = request;
        } else {
            //
            // DISABLED
            //
            Request.Builder builder = request.newBuilder();
            builder = addHeader(request, builder, "Accept-Encoding", "identity");
            enhancedRequest = builder.build();
        }

        return chain.proceed(enhancedRequest);
    }

    public void enableGzip() {
        enabled.set(true);
    }

    public boolean isEnabledGzip() {
        return enabled.get();
    }

    public void disableGzip() {
        enabled.set(false);
    }

    @Nonnull
    private Request.Builder addHeader(@Nonnull final Request request,
                                      @Nonnull final Request.Builder builder,
                                      @Nonnull final String headerName,
                                      @Nonnull final String headerValue) {

        // do not override specified headers
        if (request.header(headerName) != null) {
            return builder;
        }

        return builder.header(headerName, headerValue);
    }

    @Nonnull
    private RequestBody gzip(@Nonnull final RequestBody body) {
        return new RequestBody() {
            @Override
            public MediaType contentType() {
                return body.contentType();
            }

            @Override
            public long contentLength() {
                return -1;
            }

            @Override
            public void writeTo(@Nonnull final BufferedSink sink) throws IOException {
                BufferedSink gzipSink = Okio.buffer(new GzipSink(sink));
                body.writeTo(gzipSink);
                gzipSink.close();
            }
        };
    }
}