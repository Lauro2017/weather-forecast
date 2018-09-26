package com.weather.type;

import java.util.List;

import com.weather.data.Clouds;
import com.weather.data.Coordinate;
import com.weather.data.Sys;
import com.weather.data.Temperature;
import com.weather.data.Weather;
import com.weather.data.Wind;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OpenWeatherMapResponse {
	
	private Coordinate coord;
	private List<Weather> weather;
	private String base;
	private Temperature main;
	private int visibility;
	private Wind wind;
	private Clouds clouds;
	private int dt;
	private Sys sys;
	private int id;
	private String name;
	private int cod;
}
