package com.freeWiFi.domain;

import java.util.List;

/**
 * @author nair irgalin
 * Данный класс необходим для отправки данных на клиент
 * Содержит список wifi точек и координаты отправленного с клиента адресса
 */
public class WiFiSending {
    private double[] coordinates;
    private List<WiFi> wiFis;

    public double[] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(double[] coordinates) {
        this.coordinates = coordinates;
    }

    public List<WiFi> getWiFis() {
        return wiFis;
    }

    public void setWiFis(List<WiFi> wiFis) {
        this.wiFis = wiFis;
    }
}
