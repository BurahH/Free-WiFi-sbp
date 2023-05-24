package com.freeWiFi.Timer;


import com.freeWiFi.service.WiFiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author nair irgalin
 * данный класс содержит таймеры необходимые для обновления базы данных
 */
@Component
public class UpdateDataBaseTimer {
    @Autowired
    WiFiService wiFiService;

    /**
     * Метод одержит таймер срабатывающий раз в час и обновляющий таблицу wifi в соответствии с актуальными данными
     */
    @Scheduled(fixedDelay = 3600000)
    public void UpdateDataBase() {
        wiFiService.updateBaseDate();
    }
}
