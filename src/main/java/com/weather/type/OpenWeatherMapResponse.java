package com.weather.type;

import java.util.List;

import com.weather.data.City;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OpenWeatherMapResponse {
	
	private int code;
	private City city;
	private float message;
	private int cnt;
	private List<WeatherList> list;
}