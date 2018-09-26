package com.weather.data;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class City {

	private int id;
	private String name;
	private Coordinate coord;
	private String country;
	private int population;
}
