package com.freeWiFi.service;

import com.freeWiFi.domain.ApiWiFi;
import com.freeWiFi.domain.WiFi;
import com.freeWiFi.domain.WiFiSending;
import com.freeWiFi.repo.WiFiRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.rmi.ServerException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author nair irgalin
 * Данный сервис взаимодействует с таблицей wifi базы данных
 */
@Service
public class WiFiService {
    @Autowired
    WiFiRepo wiFiRepo;
    @Autowired
    HttpService httpService;

    /**
     * данный метод обновляет таблицу wifi в соответствии с актуальными данными
     */
    public void updateBaseDate() {
        ApiWiFi apiWiFi;
        WiFi[] wiFi;
        int page = 1;
        do {
            apiWiFi = httpService.getFreeWiFi(page);
            page++;
            wiFi = apiWiFi.getResults();
            for (WiFi i : wiFi) {
                i.outArray();
                wiFiRepo.save(i);
            }
        } while(apiWiFi.getNext() != null);
    }

    /**
     * Данный метод ищет wifi точки находящиеся в определенном радиусе от заданных координат,
     * данные отсортированы по возрастанию дальности от указанных координат
     * @param lon - долгота точки поиска
     * @param lat - широта точки поиска
     * @param radius - радиус поиска
     * @return список wifi точек в неоходимом радиусе
     */
    public List<WiFi> getPointInsideCircle(double lon, double lat, double radius) {
        List<WiFi> wiFis= wiFiRepo.findNeedPoint(lon, lat, radius);
        for(WiFi wiFi : wiFis)
        {
            wiFi.inArray();
        }
        return wiFis;
    }

    /**
     * Данный метод ищет ближайщую wifi точку от заданных координат
     * @param lon - долгота точки поиска
     * @param lat - широта точки поиска
     * @return список wifi точек в неоходимом радиусе
     */
    public WiFi getPointNear(double lon, double lat) {
        List<WiFi> wiFis= wiFiRepo.findFirstNeedPoint(lon, lat);
        WiFi wiFi = null;
        if(wiFis.size() != 0) {
            wiFi = wiFis.get(0);
            wiFi.inArray();
        }
        return wiFi;
    }

    /**
     * Метод возвращает координаты дома
     * @param address - адресс дома
     * @return - координаты дома
     * @throws ServerException  - исключение возникает при ненахождении адресса геокодером
     */
    public double[] getCoordinatesAddress(String address) throws ServerException {
        double[] coordinates = httpService.ApiGeoCode(address);
        if((coordinates[0] == 0) && (coordinates[1] == 0)){
            coordinates = httpService.ApiGeoCodeJustAbout(address);
            if(coordinates == null) {
                throw new ServerException("Адрес не найден");
            }
        }
        return coordinates;
    }

    /**
     * Метод возвращает набор wifi точек в заданном радиусе от указанного адресса
     * @param address - адресс дома
     * @param radius - радиус поиска
     * @return - список wifi точек и координаты адреса
     * @throws ServerException - исключение возникает при ненахождении адресса геокодером
     */
    public WiFiSending getPointInsideCircleFromAddress(String address, double radius) throws ServerException {
        double[] coordinates = getCoordinatesAddress(address);
        WiFiSending sending = new WiFiSending();
        List<WiFi> wiFiList = getPointInsideCircle(coordinates[1], coordinates[0], radius);
        sending.setWiFis(wiFiList);
        sending.setCoordinates(coordinates);
        return sending;
    }

    /**
     * Метод возвращает ближайшую к дому wifi точку
     * @param address - адресс дома
     * @return - wifi точка и координаты адреса
     * @throws ServerException - исключение возникает при ненахождении адресса геокодером
     */
    public WiFiSending getPointNearFromAddress(String address) throws ServerException {
        double[] coordinates = getCoordinatesAddress(address);
        WiFiSending sending = new WiFiSending();
        WiFi wiFi = getPointNear(coordinates[1], coordinates[0]);
        List<WiFi> wiFiList = new ArrayList<>();
        wiFiList.add(wiFi);
        sending.setWiFis(wiFiList);
        sending.setCoordinates(coordinates);
        return sending;
    }

    /**
     * Данный метод возвращет все wifi точки
     * @return список wifi точек
     */
    public List<WiFi> getPoint() {
        List<WiFi> wiFiList = wiFiRepo.findAll();
        for (WiFi wiFi : wiFiList) {
            wiFi.inArray();
        }
        return wiFiList;
    }
}
