package com.creeperImpl.service;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import javax.annotation.Resource;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.creeperImpl.Common;
import com.creeperImpl.domain.repository.WeatherMapper;
import com.creeperImpl.service.thread.InsertWeather;
import com.google.gson.Gson;
import com.projectapi.teardowall.CreeperService;
import com.projectapi.teardowall.entity.LocationTmp;
import com.projectapi.teardowall.entity.Weather;
import com.projectapi.teardowall.entity.WeatherBaidu;
import com.projectapi.teardowall.entity.WeatherTmp;
import com.projectapi.teardowall.entity.WeatherTmp.Results;
import com.projectapi.teardowall.entity.WeatherTmp.Results.WeatherData;


@Component
@Transactional
public class WeatherService extends BaseService implements CreeperService {
	
	@Resource
	private WeatherMapper weatherMapper;

	public Weather catchWeather(String urlString) throws DocumentException{
		URL url = null;
		try {
			if(StringUtils.isBlank(urlString))
				urlString = Common.weatherRootUrl;
			url = new URL(urlString);
		} catch (MalformedURLException e) {
			System.out.println("URL ERROR:" + urlString);
		}
		//创建SAXReader对象
        SAXReader reader = new SAXReader();
        //读取文件 转换成Document
        Document document = reader.read(url);
        //获取根节点元素对象
        Element root = document.getRootElement();
        System.out.println(root.getName());
        for ( @SuppressWarnings("unchecked")
		Iterator<Element> i = root.elementIterator(); i.hasNext(); ) {
            Element element = i.next();
            Weather weather = element2Weather(element);
            System.out.println(weather.getCityname());
            if("济南市".equals(weather.getCityname())){
            	return weather;
            }
        }
        return null;
	}
	
	private Weather element2Weather(Element element){
		Weather weather = null;
		if(element == null){
			return weather;
		}
		weather = new Weather();
		weather.setCityname(element.attributeValue("cityname"));
		weather.setHighTem(Integer.parseInt(element.attributeValue("tem1")));
		weather.setLowTem(Integer.parseInt(element.attributeValue("tem2")));
		weather.setNowTem(Integer.parseInt(element.attributeValue("temNow")));
		weather.setWindState(element.attributeValue("windState"));
		weather.setHumidity(element.attributeValue("humidity"));
		return weather;
	}

	@Override
	public String sayHello(String name) {
		return "Jerry say hello to " + name;
	}

	@Override
	public LocationTmp getLocationFromIp(String ip) {
		StringBuilder urlString = new StringBuilder(Common.baiduIpApi);
		if(!Common.isBlank(ip)){
			urlString.append("&ip=");
			urlString.append(ip);
		}
		String jsonString = Common.getUrlContext(urlString.toString(), "GET");
		Gson gson = new Gson();
		LocationTmp o = gson.fromJson(jsonString, LocationTmp.class);
		return o;
	}

	@Override
	public WeatherBaidu catchBaiduWeather(String city) {
		String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		WeatherBaidu weather = null;
		weather = weatherMapper.getWeatherFromDB(city, date);
		if(weather == null){
			weather = creeperWeatherFromBaidu(city);
			System.out.println(weather.getCreeperDate() + weather.getTemperature());
		}
		return weather;
	}
	
	public WeatherBaidu creeperWeatherFromBaidu(String city){
		WeatherBaidu weather = null;
		if(!Common.isBlank(city)){
			String urlString = Common.baiduWeatherApi+"&location="+city;
			String json = Common.getUrlContext(urlString, "GET");
			System.out.println(json);
			WeatherTmp tmp = new Gson().fromJson(json, WeatherTmp.class);
			if(tmp != null && "0".equals(tmp.getError()) && tmp.getResults().size() > 0){
				Results result = tmp.getResults().get(0);
				for(int i = result.getWeather_data().size() - 1; i >= 0; i--){
					WeatherData wd = result.getWeather_data().get(i);
					weather = new WeatherBaidu(city, result.getPm25(), wd.getDate(), wd.getWeather(), wd.getWind(), 
							wd.getTemperature(), wd.getDayPictureUrl(), wd.getNightPictureUrl(), tmp.getDate(),i);
					InsertWeather insertThread = new InsertWeather(weather);
					Thread thread = new Thread(insertThread);
					thread.start();
				}
			}
		}
		return weather;
	}
}
