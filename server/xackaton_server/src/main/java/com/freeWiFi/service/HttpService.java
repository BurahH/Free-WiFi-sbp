package com.freeWiFi.service;

import com.freeWiFi.domain.ApiGeocode;
import com.freeWiFi.domain.ApiWiFi;
import com.freeWiFi.domain.Coordinates;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;


/**
 * @author nair irgalin
 * данный класс является сервисом для api запросов
 */
@Service
public class HttpService {

    /**
     * данный метод совершает http get запрос на api.petergurg получая данные о wifi сетях
     * @param page - страница с данными
     * @return - объект класса apiWiFi содержащий информацию о 100 wifi сетях, а также ссылку на предыдущую и следующую страницу
     */
    public ApiWiFi getFreeWiFi(int page){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        String url = "https://spb-classif.gate.petersburg.ru/api/v2/datasets/195/versions/latest/data/417/?per_page=100&page=" + page;
        headers.set("Authorization","Bearer eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJhU1RaZm42bHpTdURYcUttRkg1SzN5UDFhT0FxUkhTNm9OendMUExaTXhFIn0.eyJleHAiOjE3Nzg0OTcwMTgsImlhdCI6MTY4MzgwMjYxOCwianRpIjoiNTk4NGYzNjItYTJjZi00N2QzLWJmMTUtZTNkNTYxMWEwNDEwIiwiaXNzIjoiaHR0cHM6Ly9rYy5wZXRlcnNidXJnLnJ1L3JlYWxtcy9lZ3MtYXBpIiwiYXVkIjoiYWNjb3VudCIsInN1YiI6IjM0YjlkNTAxLTk3NDEtNGRkNy1iNjQwLTkzZmFhN2NlNDE2NCIsInR5cCI6IkJlYXJlciIsImF6cCI6ImFkbWluLXJlc3QtY2xpZW50Iiwic2Vzc2lvbl9zdGF0ZSI6ImFlNmNmYjZhLTJjNDQtNGYwMi1hMjJlLWRkNzQyNmE2NzQ5OCIsImFjciI6IjEiLCJhbGxvd2VkLW9yaWdpbnMiOlsiLyoiXSwicmVhbG1fYWNjZXNzIjp7InJvbGVzIjpbImRlZmF1bHQtcm9sZXMtZWdzLWFwaSIsIm9mZmxpbmVfYWNjZXNzIiwidW1hX2F1dGhvcml6YXRpb24iXX0sInJlc291cmNlX2FjY2VzcyI6eyJhY2NvdW50Ijp7InJvbGVzIjpbIm1hbmFnZS1hY2NvdW50IiwibWFuYWdlLWFjY291bnQtbGlua3MiLCJ2aWV3LXByb2ZpbGUiXX19LCJzY29wZSI6ImVtYWlsIHByb2ZpbGUiLCJzaWQiOiJhZTZjZmI2YS0yYzQ0LTRmMDItYTIyZS1kZDc0MjZhNjc0OTgiLCJlbWFpbF92ZXJpZmllZCI6ZmFsc2UsIm5hbWUiOiLQvdCw0LjRgCDQuNGA0LPQsNC70LjQvSIsInByZWZlcnJlZF91c2VybmFtZSI6ImZhM2NhMGVmYzA3MGI0YTIwMjI3OTdiNDNhZTAwOWRjIiwiZ2l2ZW5fbmFtZSI6ItC90LDQuNGAIiwiZmFtaWx5X25hbWUiOiLQuNGA0LPQsNC70LjQvSJ9.XIUSrh25jsPDQncKarWzTCeYKOarzbDArnIyp2fMGiicbhDvE8ABwHDOjrNBeeVqXTsoKeqrDRuL5Cly4N5diDpNfXrAMqYSZi3BLMGBqxsUWczEtsda2e-K52VXtLQhXkOCPBQVgisGzDwc01JbmNo03fAN5V4LDVGQIwM5Nlr-MgG5SBcE02WcGQ5FezaiQRmrcqtQaQo4FCntKl0iBRePtEOv__IHuBZcG-oMqER4v7fvvXKTZQvIZ0Dp-Ujk14mZNLkJ0H9pW0WK73avG0nouS2u4AybSWGUNw4hUx09uiO9vqxwAp6VzDtBtZxTF-QKzu8AhuNWhuMneMtGcg");
        HttpEntity entity = new HttpEntity(headers);
        ResponseEntity<ApiWiFi> response =  restTemplate.exchange(url, HttpMethod.GET, entity, ApiWiFi.class);
        ApiWiFi apiWiFi =  response.getBody();
        return apiWiFi;
    }

    /**
     * Метод совершает http get запрос на геокодер API получая коордианты по адресу
     * @param address - адресс дома
     * @return - координаты дома
     */
    public double[] ApiGeoCode(String address){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        String url = "https://geocode.gate.petersburg.ru/parse/eas?street=" + address;
        headers.set("Authorization","Bearer eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJhU1RaZm42bHpTdURYcUttRkg1SzN5UDFhT0FxUkhTNm9OendMUExaTXhFIn0.eyJleHAiOjE3Nzg0OTcwMTgsImlhdCI6MTY4MzgwMjYxOCwianRpIjoiNTk4NGYzNjItYTJjZi00N2QzLWJmMTUtZTNkNTYxMWEwNDEwIiwiaXNzIjoiaHR0cHM6Ly9rYy5wZXRlcnNidXJnLnJ1L3JlYWxtcy9lZ3MtYXBpIiwiYXVkIjoiYWNjb3VudCIsInN1YiI6IjM0YjlkNTAxLTk3NDEtNGRkNy1iNjQwLTkzZmFhN2NlNDE2NCIsInR5cCI6IkJlYXJlciIsImF6cCI6ImFkbWluLXJlc3QtY2xpZW50Iiwic2Vzc2lvbl9zdGF0ZSI6ImFlNmNmYjZhLTJjNDQtNGYwMi1hMjJlLWRkNzQyNmE2NzQ5OCIsImFjciI6IjEiLCJhbGxvd2VkLW9yaWdpbnMiOlsiLyoiXSwicmVhbG1fYWNjZXNzIjp7InJvbGVzIjpbImRlZmF1bHQtcm9sZXMtZWdzLWFwaSIsIm9mZmxpbmVfYWNjZXNzIiwidW1hX2F1dGhvcml6YXRpb24iXX0sInJlc291cmNlX2FjY2VzcyI6eyJhY2NvdW50Ijp7InJvbGVzIjpbIm1hbmFnZS1hY2NvdW50IiwibWFuYWdlLWFjY291bnQtbGlua3MiLCJ2aWV3LXByb2ZpbGUiXX19LCJzY29wZSI6ImVtYWlsIHByb2ZpbGUiLCJzaWQiOiJhZTZjZmI2YS0yYzQ0LTRmMDItYTIyZS1kZDc0MjZhNjc0OTgiLCJlbWFpbF92ZXJpZmllZCI6ZmFsc2UsIm5hbWUiOiLQvdCw0LjRgCDQuNGA0LPQsNC70LjQvSIsInByZWZlcnJlZF91c2VybmFtZSI6ImZhM2NhMGVmYzA3MGI0YTIwMjI3OTdiNDNhZTAwOWRjIiwiZ2l2ZW5fbmFtZSI6ItC90LDQuNGAIiwiZmFtaWx5X25hbWUiOiLQuNGA0LPQsNC70LjQvSJ9.XIUSrh25jsPDQncKarWzTCeYKOarzbDArnIyp2fMGiicbhDvE8ABwHDOjrNBeeVqXTsoKeqrDRuL5Cly4N5diDpNfXrAMqYSZi3BLMGBqxsUWczEtsda2e-K52VXtLQhXkOCPBQVgisGzDwc01JbmNo03fAN5V4LDVGQIwM5Nlr-MgG5SBcE02WcGQ5FezaiQRmrcqtQaQo4FCntKl0iBRePtEOv__IHuBZcG-oMqER4v7fvvXKTZQvIZ0Dp-Ujk14mZNLkJ0H9pW0WK73avG0nouS2u4AybSWGUNw4hUx09uiO9vqxwAp6VzDtBtZxTF-QKzu8AhuNWhuMneMtGcg");
        HttpEntity entity = new HttpEntity(headers);
        ResponseEntity<ApiGeocode> response =  restTemplate.exchange(url, HttpMethod.GET, entity, ApiGeocode.class);
        ApiGeocode apiGeocode = response.getBody();
        double[] coordinates = new double[2];
        coordinates[0] = apiGeocode.getLatitude();
        coordinates[1] = apiGeocode.getLongitude();
        return coordinates;
    }

    /**
     * Метод совершает http get запрос на геокодер API получая коордианты по примерному адресу
     * @param address - адресс дома
     * @return - координаты дома
     */
    public double[] ApiGeoCodeJustAbout(String address){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        String url = "https://geocode.gate.petersburg.ru/autocomplete/universal?s=" + address;
        headers.set("Authorization","Bearer eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJhU1RaZm42bHpTdURYcUttRkg1SzN5UDFhT0FxUkhTNm9OendMUExaTXhFIn0.eyJleHAiOjE3Nzg0OTcwMTgsImlhdCI6MTY4MzgwMjYxOCwianRpIjoiNTk4NGYzNjItYTJjZi00N2QzLWJmMTUtZTNkNTYxMWEwNDEwIiwiaXNzIjoiaHR0cHM6Ly9rYy5wZXRlcnNidXJnLnJ1L3JlYWxtcy9lZ3MtYXBpIiwiYXVkIjoiYWNjb3VudCIsInN1YiI6IjM0YjlkNTAxLTk3NDEtNGRkNy1iNjQwLTkzZmFhN2NlNDE2NCIsInR5cCI6IkJlYXJlciIsImF6cCI6ImFkbWluLXJlc3QtY2xpZW50Iiwic2Vzc2lvbl9zdGF0ZSI6ImFlNmNmYjZhLTJjNDQtNGYwMi1hMjJlLWRkNzQyNmE2NzQ5OCIsImFjciI6IjEiLCJhbGxvd2VkLW9yaWdpbnMiOlsiLyoiXSwicmVhbG1fYWNjZXNzIjp7InJvbGVzIjpbImRlZmF1bHQtcm9sZXMtZWdzLWFwaSIsIm9mZmxpbmVfYWNjZXNzIiwidW1hX2F1dGhvcml6YXRpb24iXX0sInJlc291cmNlX2FjY2VzcyI6eyJhY2NvdW50Ijp7InJvbGVzIjpbIm1hbmFnZS1hY2NvdW50IiwibWFuYWdlLWFjY291bnQtbGlua3MiLCJ2aWV3LXByb2ZpbGUiXX19LCJzY29wZSI6ImVtYWlsIHByb2ZpbGUiLCJzaWQiOiJhZTZjZmI2YS0yYzQ0LTRmMDItYTIyZS1kZDc0MjZhNjc0OTgiLCJlbWFpbF92ZXJpZmllZCI6ZmFsc2UsIm5hbWUiOiLQvdCw0LjRgCDQuNGA0LPQsNC70LjQvSIsInByZWZlcnJlZF91c2VybmFtZSI6ImZhM2NhMGVmYzA3MGI0YTIwMjI3OTdiNDNhZTAwOWRjIiwiZ2l2ZW5fbmFtZSI6ItC90LDQuNGAIiwiZmFtaWx5X25hbWUiOiLQuNGA0LPQsNC70LjQvSJ9.XIUSrh25jsPDQncKarWzTCeYKOarzbDArnIyp2fMGiicbhDvE8ABwHDOjrNBeeVqXTsoKeqrDRuL5Cly4N5diDpNfXrAMqYSZi3BLMGBqxsUWczEtsda2e-K52VXtLQhXkOCPBQVgisGzDwc01JbmNo03fAN5V4LDVGQIwM5Nlr-MgG5SBcE02WcGQ5FezaiQRmrcqtQaQo4FCntKl0iBRePtEOv__IHuBZcG-oMqER4v7fvvXKTZQvIZ0Dp-Ujk14mZNLkJ0H9pW0WK73avG0nouS2u4AybSWGUNw4hUx09uiO9vqxwAp6VzDtBtZxTF-QKzu8AhuNWhuMneMtGcg");
        HttpEntity entity = new HttpEntity(headers);
        ResponseEntity<Coordinates[]> response =  restTemplate.exchange(url, HttpMethod.GET, entity, Coordinates[].class);
        Coordinates[] apiGeocode = response.getBody();
        List<Coordinates> apiGeocodes = Arrays.stream(apiGeocode).toList();
        if(apiGeocodes.size() != 0){
            double[] coordinates = new double[2];
            coordinates[0] = apiGeocodes.get(0).getLatitude();
            coordinates[1] = apiGeocodes.get(0).getLongitude();
            return coordinates;
        }
        return null;
    }
}
