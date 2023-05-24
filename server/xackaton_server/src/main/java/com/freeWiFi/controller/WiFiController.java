package com.freeWiFi.controller;

import com.freeWiFi.domain.WiFi;
import com.freeWiFi.domain.WiFiSending;
import com.freeWiFi.service.WiFiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.rmi.ServerException;
import java.util.List;

/**
 * @author nair irgalin
 * данный контроллер содержит запросы связанные с wifi
 */
@RestController
public class WiFiController {
    @Autowired
    WiFiService wiFiService;

    /**
     * Данные метод возвращает набор wifi точек находящихся в
     * определенном радиусе от заданных координат
     * @param lon - долгота, указывается в параметрах запроса
     * @param lat - широта, указывается в параметрах запроса
     * @param radius - радиус, указывается в параметрах запроса
     * @return - набор wifi точек
     */
    @CrossOrigin
    @GetMapping("/getWiFi")
    public List<WiFi> getWiFi(@RequestParam double lon, @RequestParam double lat, @RequestParam double radius) {
        return wiFiService.getPointInsideCircle(lon, lat, radius);
    }

    /**
     * Данные метод возвращает ближайшую к заданными координатам wifi точку
     * @param lon - долгота, указывается в параметрах запроса
     * @param lat - широта, указывается в параметрах запроса
     * @return wifi точка
     */
    @CrossOrigin
    @GetMapping("/getWiFiNear")
    public WiFi getWiFiNear(@RequestParam double lon, @RequestParam double lat) {
        return wiFiService.getPointNear(lon, lat);
    }

    /**
     * Данный метод возвращает набор точек находящихся в определенном радиусе от заданного адресса
     * @param address - адрес дома, указывается в параметрах запроса
     * @param radius - радиус поиска, указывается в параметрах запроса
     * @return - набор wifi точек
     * @throws ServerException - возникает в случае ввода неверного адресса
     */
    @CrossOrigin
    @GetMapping("/address/getWiFi")
    public WiFiSending getWiFiFromAddress(@RequestParam String address, @RequestParam double radius) throws ServerException {
        return wiFiService.getPointInsideCircleFromAddress(address, radius);
    }

    /**
     * Данный метод возвращает ближайющую wifi точку к дому
     * @param address - адресс дома, указывается в параметрах запроса
     * @return - wifi точка
     * @throws ServerException - возникает в случае ввода неверного адресса
     */
    @CrossOrigin
    @GetMapping("/address/getWiFiNear")
    public WiFiSending getWiFiNearFromAddress(@RequestParam String address) throws ServerException {
        return wiFiService.getPointNearFromAddress(address);
    }

    /**
     * Данный метод возвращает случайную цитату с волками
     * @return цитата с волками
     */
    @CrossOrigin
    @GetMapping("/")
    public String getWolf() {
        String[] wolf = {"Работа не волк, волк это ходить, работа это work", "Враги не предают, предают враги" ,
                "Каждый может кинуть камень в волка, но не каждый может кинуть камень в волка", "Волк в цирке не выступает", "Лучше быть чем не быть",
                "Волк говно не скажет волк его покажет", "Кодовые волки вперед!!! давай, давай, ура, ура!!!", "Лучше иметь друга, чем друг друга",
                "Если волк молчит, то лучше его переебать", "Ты думал что твоя жизнь это трагедия, а она оказалась комедией", "Легко вставать, когда ты не ложился",
                "Лучше выпить литр водки, чем не выпить литр водки", "Я не боюсь ударов в спину, гораздо страшнее если это моя спина...",
                "Если ты не видишь, значит ты слепой", "Запомните твари, а то забудите", "Будь сильным но не сильным будь",
                "Я такой человек, который терпит терпит, а потом терпит, терпит", "Бегать за овцами удел баранов, я бегаю только за пивом",
                "Если тебе тяжело идти, значит ты жирный", "Даже если нет шансов, всегда есть шанс", "Громче это как тихо, только громче",
                "Сделал дело - дело сделано", "Лекой бывает только легкая дорога, тяжелая дорога всегда тяжелая",
                "Жизнь как рюкзак нагруженный пивом - чем больше пьешь пива, тем легче идти", "Не люблю стопки с учебниками, потому что стопка должна быть только с водкой"};
        double d = (Math.random()*wolf.length);
        int amount = (int) d;
        return wolf[amount];
    }

    /**
     * Данный метод возвращет все wifi точки
     * @return список wifi точек
     */
    @CrossOrigin
    @GetMapping("/getWiFiAll")
    public List<WiFi> getWiFiAll(){
        return wiFiService.getPoint();
    }
}
