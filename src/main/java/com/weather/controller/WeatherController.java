package com.weather.controller;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;

import com.weather.data.DailyWeathers;
import com.weather.properties.OpenWeatherMapProperty;
import com.weather.service.OpenWeatherMapService;
import com.weather.type.OpenWeatherMapResponse;
import com.weather.type.Response;
import com.weather.type.WeatherList;
import com.weather.type.WeatherResponse;

@RestController
@Configuration
public class WeatherController {

	@Autowired
	private OpenWeatherMapService openWeatherMapService;

	@Autowired
	private OpenWeatherMapProperty openWeatherMapProperty;

	@RequestMapping(value = "/getWeathers", method = RequestMethod.GET)
	public ResponseEntity<Response> getWeathers() throws RestClientException, URISyntaxException {
		List<WeatherResponse> cityWeather = new ArrayList<WeatherResponse>();
		for (String data : openWeatherMapProperty.getCities()) {
			OpenWeatherMapResponse openWeatherMapResponse = getCityWeather(data);
			List<DailyWeathers> dailyWeathersList = new ArrayList<DailyWeathers>();
			for (WeatherList weatherList : openWeatherMapResponse.getList()) {
				DailyWeathers dailyWeathers = new DailyWeathers();
				dailyWeathers.setTemperature(weatherList.getTemp());
				dailyWeathers.setWeather(weatherList.getWeather());
				dailyWeathersList.add(dailyWeathers);
			}
			WeatherResponse weatherResponse = WeatherResponse.builder().location(openWeatherMapResponse.getCity())
					.weather(dailyWeathersList).build();
			cityWeather.add(weatherResponse);
		}
		Response response = new Response();
		response.setList(cityWeather);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	private OpenWeatherMapResponse getCityWeather(String cityId) throws RestClientException, URISyntaxException {
		OpenWeatherMapResponse weather = openWeatherMapService.getCityWeather(cityId);
		return weather;
	}
}
