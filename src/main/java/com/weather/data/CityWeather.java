package com.weather.data;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CityWeather {
	
	private String location;
	private List<Weather> weathers;
}
