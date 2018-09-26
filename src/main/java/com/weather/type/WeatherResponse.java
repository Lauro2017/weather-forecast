package com.weather.type;

import java.util.List;

import com.weather.data.City;
import com.weather.data.DailyWeathers;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class WeatherResponse {
	private City location;
	private List<DailyWeathers> weather;
}
