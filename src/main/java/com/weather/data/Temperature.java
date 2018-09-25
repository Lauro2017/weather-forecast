package com.weather.data;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Temperature {

	private float present;
	private int pressure;
	private int humidity;
	private float min;
	private float max;
	
}
