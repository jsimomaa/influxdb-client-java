/*
 * Influx API Service
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * OpenAPI spec version: 0.1.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.influxdb.client.domain;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.influxdb.client.domain.Links;
import com.influxdb.client.domain.NotificationEndpoint;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * NotificationEndpoints
 */

public class NotificationEndpoints {
  public static final String SERIALIZED_NAME_NOTIFICATION_ENDPOINTS = "notificationEndpoints";
  @SerializedName(SERIALIZED_NAME_NOTIFICATION_ENDPOINTS)
  @JsonAdapter(NotificationEndpointsNotificationEndpointsAdapter.class)
  private List<NotificationEndpoint> notificationEndpoints = new ArrayList<>();

  public static final String SERIALIZED_NAME_LINKS = "links";
  @SerializedName(SERIALIZED_NAME_LINKS)
  private Links links = null;

  public NotificationEndpoints notificationEndpoints(List<NotificationEndpoint> notificationEndpoints) {
    this.notificationEndpoints = notificationEndpoints;
    return this;
  }

  public NotificationEndpoints addNotificationEndpointsItem(NotificationEndpoint notificationEndpointsItem) {
    if (this.notificationEndpoints == null) {
      this.notificationEndpoints = new ArrayList<>();
    }
    this.notificationEndpoints.add(notificationEndpointsItem);
    return this;
  }

   /**
   * Get notificationEndpoints
   * @return notificationEndpoints
  **/
  @ApiModelProperty(value = "")
  public List<NotificationEndpoint> getNotificationEndpoints() {
    return notificationEndpoints;
  }

  public void setNotificationEndpoints(List<NotificationEndpoint> notificationEndpoints) {
    this.notificationEndpoints = notificationEndpoints;
  }

  public NotificationEndpoints links(Links links) {
    this.links = links;
    return this;
  }

   /**
   * Get links
   * @return links
  **/
  @ApiModelProperty(value = "")
  public Links getLinks() {
    return links;
  }

  public void setLinks(Links links) {
    this.links = links;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NotificationEndpoints notificationEndpoints = (NotificationEndpoints) o;
    return Objects.equals(this.notificationEndpoints, notificationEndpoints.notificationEndpoints) &&
        Objects.equals(this.links, notificationEndpoints.links);
  }

  @Override
  public int hashCode() {
    return Objects.hash(notificationEndpoints, links);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NotificationEndpoints {\n");
    sb.append("    notificationEndpoints: ").append(toIndentedString(notificationEndpoints)).append("\n");
    sb.append("    links: ").append(toIndentedString(links)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

  public class NotificationEndpointsNotificationEndpointsAdapter implements JsonDeserializer<Object>, JsonSerializer<Object> {

    public NotificationEndpointsNotificationEndpointsAdapter() {
    }

    @Override
    public Object deserialize(final JsonElement json, final Type typeOfT, final JsonDeserializationContext context) throws JsonParseException {

      List<String> discriminator = Arrays.asList("type");

      List<Object> results = new ArrayList<>();

      for (JsonElement arrayItem: json.getAsJsonArray()){
        JsonObject jsonObject = arrayItem.getAsJsonObject();

        String[] types = discriminator.stream().map(d -> jsonObject.get(d).getAsString()).toArray(String[]::new);

        results.add(deserialize(types, jsonObject, context));
      }

      return results;
    }

    @Override
    public JsonElement serialize(Object object, Type typeOfSrc, JsonSerializationContext context) {

      return context.serialize(object);
    }

    private Object deserialize(final String[] types, final JsonElement json, final JsonDeserializationContext context) {

      if (Arrays.equals(new String[]{ "slack" }, types)) {
        return context.deserialize(json, SlackNotificationEndpoint.class);
      }
      if (Arrays.equals(new String[]{ "pagerduty" }, types)) {
        return context.deserialize(json, PagerDutyNotificationEndpoint.class);
      }
      if (Arrays.equals(new String[]{ "http" }, types)) {
        return context.deserialize(json, HTTPNotificationEndpoint.class);
      }

      return context.deserialize(json, Object.class);
    }
  }
}

