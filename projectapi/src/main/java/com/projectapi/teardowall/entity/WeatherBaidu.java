package com.projectapi.teardowall.entity;

import java.io.Serializable;

public class WeatherBaidu implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1115753880727717415L;
	private String id;
	private String cityName;
	private String pm25;
	private String weatherDate;
	private String weather;
	private String wind;
	private String temperature;
	private String dayPng;
	private String nightPng;
	private String creeperDate;
	private int num;
	
	public WeatherBaidu(){
		
	}
	
	public WeatherBaidu(String city,String pm25,String weatherDate,String weather,String wind,String temperature,String dayPng,
			String nightPng,String creeperDate,int num){
		this.cityName = city;
		this.pm25 = pm25;
		this.weatherDate = weatherDate;
		this.weather = weather;
		this.wind = wind;
		this.temperature = temperature;
		this.dayPng = dayPng;
		this.nightPng = nightPng;
		this.creeperDate = creeperDate;
		this.num = num;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getPm25() {
		return pm25;
	}
	public void setPm25(String pm25) {
		this.pm25 = pm25;
	}
	public String getWeatherDate() {
		return weatherDate;
	}
	public void setWeatherDate(String weatherDate) {
		this.weatherDate = weatherDate;
	}
	public String getWeather() {
		return weather;
	}
	public void setWeather(String weather) {
		this.weather = weather;
	}
	public String getWind() {
		return wind;
	}
	public void setWind(String wind) {
		this.wind = wind;
	}
	public String getTemperature() {
		return temperature;
	}
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}
	public String getDayPng() {
		return dayPng;
	}
	public void setDayPng(String dayPng) {
		this.dayPng = dayPng;
	}
	public String getNightPng() {
		return nightPng;
	}
	public void setNightPng(String nightPng) {
		this.nightPng = nightPng;
	}
	public String getCreeperDate() {
		return creeperDate;
	}
	public void setCreeperDate(String creeperDate) {
		this.creeperDate = creeperDate;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
}
