package com.weather.data;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DailyWeathers {
	private List<Weather> weather;
	private Temperature temperature;
}
