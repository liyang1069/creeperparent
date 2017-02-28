package com.creeperImpl.service.thread;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.creeperImpl.domain.repository.WeatherMapper;
import com.projectapi.teardowall.entity.WeatherBaidu;

@Component
@Transactional
public class InsertWeather implements Runnable {
	
	private WeatherBaidu weatherBaidu;
	
	private WeatherMapper weatherMapper;
	
	public InsertWeather(){
		
	}
	
	public InsertWeather(WeatherBaidu weatherBaidu, WeatherMapper weatherMapper){
		this.weatherBaidu = weatherBaidu;
		this.weatherMapper = weatherMapper;
	}

	@Override
	public void run() {
		if(weatherBaidu != null && weatherMapper != null)
			weatherMapper.insert(weatherBaidu);
	}

}
