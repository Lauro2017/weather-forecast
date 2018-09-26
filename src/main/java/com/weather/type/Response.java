package com.weather.type;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Response {

	private List<WeatherResponse> list;
}
