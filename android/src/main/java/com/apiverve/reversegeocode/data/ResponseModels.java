// Converter.java

// To use this code, add the following Maven dependency to your project:
//
//
//     com.fasterxml.jackson.core     : jackson-databind          : 2.9.0
//     com.fasterxml.jackson.datatype : jackson-datatype-jsr310   : 2.9.0
//
// Import this package:
//
//     import com.apiverve.data.Converter;
//
// Then you can deserialize a JSON string with
//
//     ReverseGeocodeData data = Converter.fromJsonString(jsonString);

package com.apiverve.reversegeocode.data;

import java.io.IOException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.*;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

public class Converter {
    // Date-time helpers

    private static final DateTimeFormatter DATE_TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ISO_DATE_TIME)
            .appendOptional(DateTimeFormatter.ISO_OFFSET_DATE_TIME)
            .appendOptional(DateTimeFormatter.ISO_INSTANT)
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SX"))
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssX"))
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
            .toFormatter()
            .withZone(ZoneOffset.UTC);

    public static OffsetDateTime parseDateTimeString(String str) {
        return ZonedDateTime.from(Converter.DATE_TIME_FORMATTER.parse(str)).toOffsetDateTime();
    }

    private static final DateTimeFormatter TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ISO_TIME)
            .appendOptional(DateTimeFormatter.ISO_OFFSET_TIME)
            .parseDefaulting(ChronoField.YEAR, 2020)
            .parseDefaulting(ChronoField.MONTH_OF_YEAR, 1)
            .parseDefaulting(ChronoField.DAY_OF_MONTH, 1)
            .toFormatter()
            .withZone(ZoneOffset.UTC);

    public static OffsetTime parseTimeString(String str) {
        return ZonedDateTime.from(Converter.TIME_FORMATTER.parse(str)).toOffsetDateTime().toOffsetTime();
    }
    // Serialize/deserialize helpers

    public static ReverseGeocodeData fromJsonString(String json) throws IOException {
        return getObjectReader().readValue(json);
    }

    public static String toJsonString(ReverseGeocodeData obj) throws JsonProcessingException {
        return getObjectWriter().writeValueAsString(obj);
    }

    private static ObjectReader reader;
    private static ObjectWriter writer;

    private static void instantiateMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        SimpleModule module = new SimpleModule();
        module.addDeserializer(OffsetDateTime.class, new JsonDeserializer<OffsetDateTime>() {
            @Override
            public OffsetDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
                String value = jsonParser.getText();
                return Converter.parseDateTimeString(value);
            }
        });
        mapper.registerModule(module);
        reader = mapper.readerFor(ReverseGeocodeData.class);
        writer = mapper.writerFor(ReverseGeocodeData.class);
    }

    private static ObjectReader getObjectReader() {
        if (reader == null) instantiateMapper();
        return reader;
    }

    private static ObjectWriter getObjectWriter() {
        if (writer == null) instantiateMapper();
        return writer;
    }
}

// ReverseGeocodeData.java

package com.apiverve.reversegeocode.data;

import com.fasterxml.jackson.annotation.*;

public class ReverseGeocodeData {
    private String zipcode;
    private String stateAbbr;
    private String city;
    private String state;
    private double distance;
    private String latitudeClosest;
    private String longitudeClosest;
    private String countryCode;
    private Object latitudeClosestCity;
    private Object longitudeClosestCity;
    private double latitude;
    private double longitude;
    private boolean estimatedCity;
    private String[] nearestCities;

    @JsonProperty("zipcode")
    public String getZipcode() { return zipcode; }
    @JsonProperty("zipcode")
    public void setZipcode(String value) { this.zipcode = value; }

    @JsonProperty("state_abbr")
    public String getStateAbbr() { return stateAbbr; }
    @JsonProperty("state_abbr")
    public void setStateAbbr(String value) { this.stateAbbr = value; }

    @JsonProperty("city")
    public String getCity() { return city; }
    @JsonProperty("city")
    public void setCity(String value) { this.city = value; }

    @JsonProperty("state")
    public String getState() { return state; }
    @JsonProperty("state")
    public void setState(String value) { this.state = value; }

    @JsonProperty("distance")
    public double getDistance() { return distance; }
    @JsonProperty("distance")
    public void setDistance(double value) { this.distance = value; }

    @JsonProperty("latitudeClosest")
    public String getLatitudeClosest() { return latitudeClosest; }
    @JsonProperty("latitudeClosest")
    public void setLatitudeClosest(String value) { this.latitudeClosest = value; }

    @JsonProperty("longitudeClosest")
    public String getLongitudeClosest() { return longitudeClosest; }
    @JsonProperty("longitudeClosest")
    public void setLongitudeClosest(String value) { this.longitudeClosest = value; }

    @JsonProperty("countryCode")
    public String getCountryCode() { return countryCode; }
    @JsonProperty("countryCode")
    public void setCountryCode(String value) { this.countryCode = value; }

    @JsonProperty("latitudeClosestCity")
    public Object getLatitudeClosestCity() { return latitudeClosestCity; }
    @JsonProperty("latitudeClosestCity")
    public void setLatitudeClosestCity(Object value) { this.latitudeClosestCity = value; }

    @JsonProperty("longitudeClosestCity")
    public Object getLongitudeClosestCity() { return longitudeClosestCity; }
    @JsonProperty("longitudeClosestCity")
    public void setLongitudeClosestCity(Object value) { this.longitudeClosestCity = value; }

    @JsonProperty("latitude")
    public double getLatitude() { return latitude; }
    @JsonProperty("latitude")
    public void setLatitude(double value) { this.latitude = value; }

    @JsonProperty("longitude")
    public double getLongitude() { return longitude; }
    @JsonProperty("longitude")
    public void setLongitude(double value) { this.longitude = value; }

    @JsonProperty("estimatedCity")
    public boolean getEstimatedCity() { return estimatedCity; }
    @JsonProperty("estimatedCity")
    public void setEstimatedCity(boolean value) { this.estimatedCity = value; }

    @JsonProperty("nearestCities")
    public String[] getNearestCities() { return nearestCities; }
    @JsonProperty("nearestCities")
    public void setNearestCities(String[] value) { this.nearestCities = value; }
}