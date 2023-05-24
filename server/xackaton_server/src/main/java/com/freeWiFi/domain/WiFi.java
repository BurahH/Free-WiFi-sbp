package com.freeWiFi.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

/**
 * @author nair irgalin
 * Класс является отображением wifi сети
 * и содержит данные о ее местоположении, текущем состоянии и радиусе работы
 */
@Entity
public class WiFi{
    @Id
    private long number;

    private String address;
    private String district;
    private String name_wifi;
    private int coverage;
    private String status;

    @Transient
    private double[] coordinates;

    private double lat;
    private double lon;

    /**
     * данный метод преобразует данные из 2 переменных double в массив типа double[2]
     */
    public void inArray(){
        this.coordinates = new double[2];
        coordinates[0] = lat;
        coordinates[1] = lon;
    }

    /**
     * данный метод преобразует из массива типа double[2] в 2 переменные типа double
     */
    public void outArray(){
        lat = coordinates[0];
        lon = coordinates[1];
    }

    public WiFi() {
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getName_wifi() {
        return name_wifi;
    }

    public void setName_wifi(String name_wifi) {
        this.name_wifi = name_wifi;
    }

    public int getCoverage() {
        return coverage;
    }

    public void setCoverage(int coverage) {
        this.coverage = coverage;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double[] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(double[] coordinates) {
        this.coordinates = coordinates;
    }
}
