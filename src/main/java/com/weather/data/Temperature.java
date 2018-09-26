package com.weather.data;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Temperature {

	private float temp;
	private int pressure;
	private int humidity;
	private float temp_min;
	private float temp_max;
}
