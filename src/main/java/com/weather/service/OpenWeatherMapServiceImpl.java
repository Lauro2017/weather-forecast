package com.weather.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.weather.properties.OpenWeatherMapProperty;
import com.weather.type.OpenWeatherMapResponse;

@Service
public class OpenWeatherMapServiceImpl implements OpenWeatherMapService {

	@Autowired
	private OpenWeatherMapProperty openWeatherMapProperty;

	@Override
	public OpenWeatherMapResponse getCityWeather(String cityId) {
		RestTemplate restTemplate = new RestTemplate();
		String url = openWeatherMapProperty.getUrl();
		url = url.replace("${cityId}", cityId);
		url = url.replace("${appdId}", openWeatherMapProperty.getAppId());
		OpenWeatherMapResponse result = restTemplate.getForObject(url, OpenWeatherMapResponse.class);
		return result;
	}

}
