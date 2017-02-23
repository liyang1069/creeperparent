package com.creeperImpl;

import java.net.URL;

public class Common {
	
	public static final String ak = "uWO00WfmYepQodFtOektzpLD84LYAu3c";
	public static final String weatherRootUrl = "http://flash.weather.com.cn/wmaps/xml/jinan.xml";
	public static final String baiduIpApi = "http://api.map.baidu.com/location/ip?&coor=bd09ll&ak="+ak;
	public static final String baiduWeatherApi = "http://api.map.baidu.com/telematics/v3/weather?output=json&ak="+ak;
	//public static final String weatherRootUrl = "http://www.weather.com.cn/data/sk/101010100.html";
	
	public static String getUrlContext(String urlString, String method){
		String resource = ""; 
		try { 
			URL url = new URL(urlString);
			java.net.HttpURLConnection conn = (java.net.HttpURLConnection)url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod(method);
			java.io.BufferedReader in = new java.io.BufferedReader(new java.io.InputStreamReader(conn.getInputStream(),"UTF-8"));
			String line;
			while ((line = in.readLine()) != null) {
				resource += line;
			}
			in.close();
		} catch (Exception e) {
			
		}
		return resource;
	}
	
	public static boolean isBlank(String str){
		if(str == null)
			return true;
		if(str.length() > 0)
			str = str.replaceAll(" ", "");
		return str.length() <= 0;
	}
	
}
