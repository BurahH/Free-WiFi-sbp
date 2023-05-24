package com.freeWiFi.domain;

/**
 * @author nair irgalin
 * Класс необходимый для получения данные с api.peterburg
 * содержит указатели на следующий и предыдущий url с точками, их количество
 * и массив с самими точками
 */
public class ApiWiFi {
    private int count;
    private String next;
    private String previous;
    private WiFi[] results;

    public ApiWiFi() {
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public WiFi[] getResults() {
        return results;
    }

    public void setResults(WiFi[] results) {
        this.results = results;
    }


}
