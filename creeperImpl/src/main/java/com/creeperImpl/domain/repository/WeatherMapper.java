package com.creeperImpl.domain.repository;

import com.projectapi.teardowall.entity.WeatherBaidu;

public interface WeatherMapper {
	
	WeatherBaidu getWeatherFromDB(String city, String date);
	
	void insert(WeatherBaidu weatherBaidu);
	
}
