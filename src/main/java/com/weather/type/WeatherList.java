package com.weather.type;

import java.util.List;

import com.weather.data.Temperature;
import com.weather.data.Weather;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WeatherList {

	private int dt;
	private Temperature temp;
	private float pressure;
	private int humidity;
	private List<Weather> weather;
	private float speed;
	private int deg;
	private int clouds;
}
