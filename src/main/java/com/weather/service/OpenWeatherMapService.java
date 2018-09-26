package com.weather.service;

import java.net.URISyntaxException;

import org.springframework.web.client.RestClientException;

import com.weather.type.WeatherResponse;

public interface OpenWeatherMapService {
	WeatherResponse getCityWeather(String city) throws RestClientException, URISyntaxException;
}
