package com.creeperImpl.domain.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.projectapi.teardowall.entity.WeatherBaidu;

//@CreeperMapper
@Mapper
public interface WeatherMapper {
	
	List<WeatherBaidu> getWeatherFromDB(String city, String date);
	
	void insert(WeatherBaidu weatherBaidu);
	
}
