package com.weather.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weather.data.WeatherLog;
import com.weather.repositories.WeatherLogRepository;

@Service
public class DbLoggingServiceImpl implements DbLoggingService {

	@Autowired
	private WeatherLogRepository weatherLogRepository;

	@Override
	public void save(WeatherLog weatherLog) {
		weatherLogRepository.save(weatherLog);
	}

	@Override
	public WeatherLog findByWeatherAndDtimeInserted(String weather, Date dtimeInserted) {
		return weatherLogRepository.findByActualWeatherAndDtimeInserted(weather, dtimeInserted);
	}
	
	
}
