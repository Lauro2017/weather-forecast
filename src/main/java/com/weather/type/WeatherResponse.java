package com.weather.type;

import java.util.List;

import com.weather.data.Coordinate;
import com.weather.data.Temperature;
import com.weather.data.Weather;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class WeatherResponse {
	private Coordinate coordinate;
	private List<Weather> weather;
	private Temperature temperature;
}
