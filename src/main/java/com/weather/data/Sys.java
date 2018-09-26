package com.weather.data;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Sys {
	private int type;
	private int id;
	private float message;
	private String country;
	private int sunrise;
	private int sunset;

}
