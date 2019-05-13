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


package org.influxdata.client.domain;

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
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import org.influxdata.client.domain.Expression;
import org.influxdata.client.domain.PropertyKey;

/**
 * represents accessing a property of an object
 */
@ApiModel(description = "represents accessing a property of an object")

public class MemberExpression extends Expression {
  public static final String SERIALIZED_NAME_TYPE = "type";
  @SerializedName(SERIALIZED_NAME_TYPE)
  private String type;

  public static final String SERIALIZED_NAME_OBJECT = "object";
  @SerializedName(SERIALIZED_NAME_OBJECT)
  @JsonAdapter(MemberExpressionObjectAdapter.class)
  private Expression object = null;

  public static final String SERIALIZED_NAME_PROPERTY = "property";
  @SerializedName(SERIALIZED_NAME_PROPERTY)
  @JsonAdapter(MemberExpressionPropertyAdapter.class)
  private PropertyKey property = null;

  public MemberExpression type(String type) {
    this.type = type;
    return this;
  }

   /**
   * type of AST node
   * @return type
  **/
  @ApiModelProperty(value = "type of AST node")
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public MemberExpression object(Expression object) {
    this.object = object;
    return this;
  }

   /**
   * Get object
   * @return object
  **/
  @ApiModelProperty(value = "")
  public Expression getObject() {
    return object;
  }

  public void setObject(Expression object) {
    this.object = object;
  }

  public MemberExpression property(PropertyKey property) {
    this.property = property;
    return this;
  }

   /**
   * Get property
   * @return property
  **/
  @ApiModelProperty(value = "")
  public PropertyKey getProperty() {
    return property;
  }

  public void setProperty(PropertyKey property) {
    this.property = property;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MemberExpression memberExpression = (MemberExpression) o;
    return Objects.equals(this.type, memberExpression.type) &&
        Objects.equals(this.object, memberExpression.object) &&
        Objects.equals(this.property, memberExpression.property) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, object, property, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MemberExpression {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    object: ").append(toIndentedString(object)).append("\n");
    sb.append("    property: ").append(toIndentedString(property)).append("\n");
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

  public class MemberExpressionPropertyAdapter implements JsonDeserializer<Object>, JsonSerializer<Object> {
    private final String discriminator = "type";

    public MemberExpressionPropertyAdapter() {
    }

    @Override
    public Object deserialize(final JsonElement json, final Type typeOfT, final JsonDeserializationContext context) throws JsonParseException {

      JsonObject jsonObject = json.getAsJsonObject();

      String type = jsonObject.get(discriminator).getAsString();

      return deserialize(type, jsonObject, context);
    }

    @Override
    public JsonElement serialize(Object object, Type typeOfSrc, JsonSerializationContext context) {

      return context.serialize(object);
    }

    private Object deserialize(final String type, final JsonElement json, final JsonDeserializationContext context) {

      if ("Identifier".equals(type)) {
        return context.deserialize(json, Identifier.class);
      }
      if ("StringLiteral".equals(type)) {
        return context.deserialize(json, StringLiteral.class);
      }

      return context.deserialize(json, Object.class);
    }
  }
  public class MemberExpressionObjectAdapter implements JsonDeserializer<Object>, JsonSerializer<Object> {
    private final String discriminator = "type";

    public MemberExpressionObjectAdapter() {
    }

    @Override
    public Object deserialize(final JsonElement json, final Type typeOfT, final JsonDeserializationContext context) throws JsonParseException {

      JsonObject jsonObject = json.getAsJsonObject();

      String type = jsonObject.get(discriminator).getAsString();

      return deserialize(type, jsonObject, context);
    }

    @Override
    public JsonElement serialize(Object object, Type typeOfSrc, JsonSerializationContext context) {

      return context.serialize(object);
    }

    private Object deserialize(final String type, final JsonElement json, final JsonDeserializationContext context) {

      if ("ArrayExpression".equals(type)) {
        return context.deserialize(json, ArrayExpression.class);
      }
      if ("FunctionExpression".equals(type)) {
        return context.deserialize(json, FunctionExpression.class);
      }
      if ("BinaryExpression".equals(type)) {
        return context.deserialize(json, BinaryExpression.class);
      }
      if ("CallExpression".equals(type)) {
        return context.deserialize(json, CallExpression.class);
      }
      if ("ConditionalExpression".equals(type)) {
        return context.deserialize(json, ConditionalExpression.class);
      }
      if ("LogicalExpression".equals(type)) {
        return context.deserialize(json, LogicalExpression.class);
      }
      if ("MemberExpression".equals(type)) {
        return context.deserialize(json, MemberExpression.class);
      }
      if ("IndexExpression".equals(type)) {
        return context.deserialize(json, IndexExpression.class);
      }
      if ("ObjectExpression".equals(type)) {
        return context.deserialize(json, ObjectExpression.class);
      }
      if ("PipeExpression".equals(type)) {
        return context.deserialize(json, PipeExpression.class);
      }
      if ("UnaryExpression".equals(type)) {
        return context.deserialize(json, UnaryExpression.class);
      }
      if ("BooleanLiteral".equals(type)) {
        return context.deserialize(json, BooleanLiteral.class);
      }
      if ("DateTimeLiteral".equals(type)) {
        return context.deserialize(json, DateTimeLiteral.class);
      }
      if ("DurationLiteral".equals(type)) {
        return context.deserialize(json, DurationLiteral.class);
      }
      if ("FloatLiteral".equals(type)) {
        return context.deserialize(json, FloatLiteral.class);
      }
      if ("IntegerLiteral".equals(type)) {
        return context.deserialize(json, IntegerLiteral.class);
      }
      if ("PipeLiteral".equals(type)) {
        return context.deserialize(json, PipeLiteral.class);
      }
      if ("RegexpLiteral".equals(type)) {
        return context.deserialize(json, RegexpLiteral.class);
      }
      if ("StringLiteral".equals(type)) {
        return context.deserialize(json, StringLiteral.class);
      }
      if ("UnsignedIntegerLiteral".equals(type)) {
        return context.deserialize(json, UnsignedIntegerLiteral.class);
      }
      if ("Identifier".equals(type)) {
        return context.deserialize(json, Identifier.class);
      }

      return context.deserialize(json, Object.class);
    }
  }
}
