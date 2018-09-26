package com.weather.controller;

import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;

import com.weather.service.OpenWeatherMapService;
import com.weather.type.WeatherResponse;

@RestController
@Configuration
public class WeatherController {
	
	@Autowired
	private OpenWeatherMapService openWeatherMapService;

	@RequestMapping(value = "/getWeathers", method = RequestMethod.GET)
	public HttpEntity<WeatherResponse> getWeathers() throws RestClientException, URISyntaxException {
		WeatherResponse  weather = openWeatherMapService.getCityWeather("London");
		return new ResponseEntity<>(weather, HttpStatus.OK);
	}
}
