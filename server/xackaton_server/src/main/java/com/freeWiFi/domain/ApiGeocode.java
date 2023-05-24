package com.freeWiFi.domain;

import com.fasterxml.jackson.annotation.JsonSetter;

/**
 * @author nair irgalin
 * Данный класс нужен для получения данный от геокодер API
 */
public class ApiGeocode {
    @JsonSetter("ID")
    private int id;

    @JsonSetter("Building_ID")
    private int buildingId;

    @JsonSetter("Name")
    private String name;

    @JsonSetter("Longitude")
    private double longitude;

    @JsonSetter("Latitude")
    private double latitude;

    public ApiGeocode() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(int buildingId) {
        this.buildingId = buildingId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
}
