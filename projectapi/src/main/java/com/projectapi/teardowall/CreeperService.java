package com.projectapi.teardowall;

import com.projectapi.teardowall.entity.LocationTmp;
import com.projectapi.teardowall.entity.WeatherBaidu;

public interface CreeperService {
	
	String sayHello(String name);
	
	//Weather catchWeather(String urlString) throws DocumentException;
	
	WeatherBaidu catchBaiduWeather(String city);
	
	LocationTmp getLocationFromIp(String ip);
	
}
