package com.weather.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.weather.properties.OpenWeatherMapProperty;
import com.weather.type.OpenWeatherMapResponse;
import com.weather.type.WeatherResponse;

@Service
public class OpenWeatherMapServiceImpl implements OpenWeatherMapService {

	@Autowired
	private OpenWeatherMapProperty openWeatherMapProperty;

	@Override
	public WeatherResponse getCityWeather(String city) {
		RestTemplate restTemplate = new RestTemplate();
		OpenWeatherMapResponse result = restTemplate.getForObject(
				openWeatherMapProperty.getUrl() + "?q=" + city + "&APPID=" + openWeatherMapProperty.getAppId(),
				OpenWeatherMapResponse.class);
		WeatherResponse weatherResponse = WeatherResponse.builder()
				.coordinate(result.getCoord())
				.weather(result.getWeather())
				.temperature(result.getMain()).build();
		return weatherResponse;
	}

}
