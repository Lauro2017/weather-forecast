package com.weather.data;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;

@Getter
@Entity
public class WeatherLog {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String responseId;
	private String location;
	private String actualWeather;
	private String temperature;
	private Date dtimeInserted;

	protected WeatherLog() {
	}

	public WeatherLog(String responseId, String location, String actualWeather, String temperature, Date dtimeInserted) {
		this.responseId = responseId;
		this.location = location;
		this.actualWeather = actualWeather;
		this.temperature = temperature;
		this.dtimeInserted = dtimeInserted;
	}

	@Override
	public String toString() {
		return String.format(
				"WeatherLog[id=%d, responseId=%s, location=%s, actualWeather=%s, temperature=%s, dtimeInserted=%d]", id,
				responseId, location, actualWeather, temperature, dtimeInserted);
	}
}
