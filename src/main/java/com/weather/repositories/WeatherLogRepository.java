package com.weather.repositories;

import java.util.Date;

import org.springframework.data.repository.CrudRepository;

import com.weather.data.WeatherLog;

public interface WeatherLogRepository extends CrudRepository<WeatherLog, String>{
	WeatherLog findByActualWeatherAndDtimeInserted(String actualWeather, Date dtimeInserted);
}
