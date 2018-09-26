package com.weather.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "open.weather.map")
public class OpenWeatherMapProperty {
	private String url;
	private String appId;
}
