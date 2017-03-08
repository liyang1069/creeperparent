package com.projectapi.teardowall;

import java.util.List;

import com.projectapi.teardowall.entity.DonateInfo;
import com.projectapi.teardowall.entity.LocationTmp;

public interface CreeperService {
	
	String sayHello(String name);
	
	//Weather catchWeather(String urlString) throws DocumentException;
	
	String catchBaiduWeather(String city);
	
	LocationTmp getLocationFromIp(String ip);
	
	List<DonateInfo> getAllDonateInfos();
	
	void insertDonateInfo(DonateInfo donateInfo);
	
}
