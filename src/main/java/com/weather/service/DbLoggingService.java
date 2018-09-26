package com.weather.service;

import java.util.Date;

import com.weather.data.WeatherLog;

public interface DbLoggingService {
	void save(WeatherLog weatherLog);
	WeatherLog findByWeatherAndDtimeInserted(String weather, Date dtimeInserted);
}
