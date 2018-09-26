package com.weather.controller;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.weather.data.DailyWeathers;
import com.weather.data.Weather;
import com.weather.data.WeatherLog;
import com.weather.properties.OpenWeatherMapProperty;
import com.weather.service.DbLoggingService;
import com.weather.service.OpenWeatherMapService;
import com.weather.type.OpenWeatherMapResponse;
import com.weather.type.Response;
import com.weather.type.WeatherList;
import com.weather.type.WeatherResponse;

@RestController
@Configuration
public class WeatherController {

	private static final Logger log = LoggerFactory.getLogger(WeatherController.class.getName());

	@Autowired
	private OpenWeatherMapService openWeatherMapService;

	@Autowired
	private OpenWeatherMapProperty openWeatherMapProperty;

	@Autowired
	private DbLoggingService dbLogging;

	@RequestMapping(value = "/getWeathers", method = RequestMethod.GET)
	public ResponseEntity<Response> getWeathers()
			throws RestClientException, URISyntaxException, JsonProcessingException {
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
		logDB(response);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	private OpenWeatherMapResponse getCityWeather(String cityId) throws RestClientException, URISyntaxException {
		OpenWeatherMapResponse weather = openWeatherMapService.getCityWeather(cityId);
		return weather;
	}

	private void logDB(Response response) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		for (WeatherResponse data : response.getList()) {
			String location = objectMapper.writeValueAsString(data.getLocation());
			Date dtimeInserted = GregorianCalendar.getInstance().getTime();
			for (DailyWeathers dw : data.getWeather()) {
				String temperature = objectMapper.writeValueAsString(dw.getTemperature());
				for (Weather weatherObject : dw.getWeather()) {
					String weather = objectMapper.writeValueAsString(weatherObject);
					WeatherLog weatherLog = dbLogging.findByWeatherAndDtimeInserted(weather, dtimeInserted);
					if (weatherLog == null || weatherLog.getActualWeather().equalsIgnoreCase(weather)) {
						dbLogging.save(new WeatherLog(UUID.randomUUID().toString(), location, weather, temperature,
								dtimeInserted));
					}

				}
			}
		}
	}
}
