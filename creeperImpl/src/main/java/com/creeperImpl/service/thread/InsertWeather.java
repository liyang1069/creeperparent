package com.creeperImpl.service.thread;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.creeperImpl.domain.repository.WeatherMapper;
import com.projectapi.teardowall.entity.WeatherBaidu;

public class InsertWeather implements Runnable {
	
	private WeatherBaidu weatherBaidu;
	
	@Resource
	private WeatherMapper weatherMapper;
	
	public InsertWeather(){
		
	}
	
	public InsertWeather(WeatherBaidu weatherBaidu){
		this.weatherBaidu = weatherBaidu;
	}

	@Override
	public void run() {
		if(weatherBaidu != null)
			weatherMapper.insert(weatherBaidu);
	}

}
