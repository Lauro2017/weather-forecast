package com.weather.service;

import java.net.URISyntaxException;

import org.springframework.web.client.RestClientException;

import com.weather.type.OpenWeatherMapResponse;

public interface OpenWeatherMapService {
	OpenWeatherMapResponse getCityWeather(String city) throws RestClientException, URISyntaxException;
}
