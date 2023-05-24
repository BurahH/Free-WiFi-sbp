package com.freeWiFi.repo;

import com.freeWiFi.domain.WiFi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author nair irgalin
 * Данный интерфейс описывает запросы в базу данных
 */
public interface WiFiRepo extends JpaRepository<WiFi, Long> {
    /**
     * Данный метод ищет в базе данных точки в определенном радиусе от заданных координат
     * @param longitude - долгота
     * @param latitude - широта
     * @param radius - радиус
     * @return набор wifi точек
     */
    @Query(value = "SELECT t " +
            "FROM WiFi t " +
            "WHERE sqrt(((t.lat - :latitude)*111153)*((t.lat - :latitude)*111153) + ((t.lon - :longitude)*62555)*((t.lon - :longitude)*62555)) < :radius " +
            "order by sqrt(((t.lat - :latitude)*111153)*((t.lat - :latitude)*111153) + ((t.lon - :longitude)*62555)*((t.lon - :longitude)*62555))")
    List<WiFi> findNeedPoint(@Param("longitude") double longitude, @Param("latitude") double latitude, @Param("radius") double radius);

    /**
     * Данный метод выводит все wifi точки сортируя их по удалению от указанных координат
     * @param longitude - долгота
     * @param latitude - широта
     * @return - wifi точка
     */
    @Query(value = "SELECT t " +
            "FROM WiFi t " +
            "order by sqrt(((t.lat - :latitude)*111153)*((t.lat - :latitude)*111153) + ((t.lon - :longitude)*62555)*((t.lon - :longitude)*62555))")
    List<WiFi> findFirstNeedPoint(@Param("longitude") double longitude, @Param("latitude") double latitude);

    /**
     * Данный метод возвращает все wifi точки в базе данных
     * @return все wifi точки
     */
    List<WiFi> findAll();
}
