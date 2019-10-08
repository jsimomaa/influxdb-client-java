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
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * Defines an encoding of data value into color space.
 */
@ApiModel(description = "Defines an encoding of data value into color space.")

public class DashboardColor {
  public static final String SERIALIZED_NAME_ID = "id";
  @SerializedName(SERIALIZED_NAME_ID)
  private String id;

  /**
   * Type is how the color is used.
   */
  @JsonAdapter(TypeEnum.Adapter.class)
  public enum TypeEnum {
    MIN("min"),
    
    MAX("max"),
    
    THRESHOLD("threshold"),
    
    SCALE("scale"),
    
    TEXT("text"),
    
    BACKGROUND("background");

    private String value;

    TypeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static TypeEnum fromValue(String text) {
      for (TypeEnum b : TypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<TypeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final TypeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public TypeEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return TypeEnum.fromValue(String.valueOf(value));
      }
    }
  }

  public static final String SERIALIZED_NAME_TYPE = "type";
  @SerializedName(SERIALIZED_NAME_TYPE)
  private TypeEnum type;

  public static final String SERIALIZED_NAME_HEX = "hex";
  @SerializedName(SERIALIZED_NAME_HEX)
  private String hex;

  public static final String SERIALIZED_NAME_NAME = "name";
  @SerializedName(SERIALIZED_NAME_NAME)
  private String name;

  public static final String SERIALIZED_NAME_VALUE = "value";
  @SerializedName(SERIALIZED_NAME_VALUE)
  private Float value;

  public DashboardColor id(String id) {
    this.id = id;
    return this;
  }

   /**
   * The unique ID of the view color.
   * @return id
  **/
  @ApiModelProperty(required = true, value = "The unique ID of the view color.")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public DashboardColor type(TypeEnum type) {
    this.type = type;
    return this;
  }

   /**
   * Type is how the color is used.
   * @return type
  **/
  @ApiModelProperty(required = true, value = "Type is how the color is used.")
  public TypeEnum getType() {
    return type;
  }

  public void setType(TypeEnum type) {
    this.type = type;
  }

  public DashboardColor hex(String hex) {
    this.hex = hex;
    return this;
  }

   /**
   * The hex number of the color
   * @return hex
  **/
  @ApiModelProperty(required = true, value = "The hex number of the color")
  public String getHex() {
    return hex;
  }

  public void setHex(String hex) {
    this.hex = hex;
  }

  public DashboardColor name(String name) {
    this.name = name;
    return this;
  }

   /**
   * The user-facing name of the hex color.
   * @return name
  **/
  @ApiModelProperty(required = true, value = "The user-facing name of the hex color.")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public DashboardColor value(Float value) {
    this.value = value;
    return this;
  }

   /**
   * The data value mapped to this color.
   * @return value
  **/
  @ApiModelProperty(required = true, value = "The data value mapped to this color.")
  public Float getValue() {
    return value;
  }

  public void setValue(Float value) {
    this.value = value;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DashboardColor dashboardColor = (DashboardColor) o;
    return Objects.equals(this.id, dashboardColor.id) &&
        Objects.equals(this.type, dashboardColor.type) &&
        Objects.equals(this.hex, dashboardColor.hex) &&
        Objects.equals(this.name, dashboardColor.name) &&
        Objects.equals(this.value, dashboardColor.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, type, hex, name, value);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DashboardColor {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    hex: ").append(toIndentedString(hex)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
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

}

