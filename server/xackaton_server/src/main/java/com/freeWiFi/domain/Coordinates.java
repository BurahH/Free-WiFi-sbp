package com.freeWiFi.domain;

/**
 * @author nair irgalin
 * Данный класс необходим для получения данных о примерном метоположении при запросах на геокодер API
 */
public class Coordinates {
    private double longitude;
    private double latitude;

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
