package com.creeperImpl;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import java.util.concurrent.CountDownLatch;

@SpringBootApplication
@ImportResource({"classpath:spring-dubbo.xml"})
public class CreeperApp {
	
    @Bean
    public CountDownLatch closeLatch() {
        return new CountDownLatch(1);
    }
    
	public static void main(String[] args) throws InterruptedException {
		//SpringApplication.run(CreeperApplication.class, args);
		ApplicationContext ctx = new SpringApplicationBuilder().sources(CreeperApp.class).web(false).run(args);

        System.out.println("项目启动!");

        CountDownLatch closeLatch = ctx.getBean(CountDownLatch.class);
        closeLatch.await();
		//test();
	}
	
	public static void test(){
		//new WeatherService().getLocationFromIp("182.50.126.10");
		//weatherService.catchBaiduWeather("济南市");
	}
}
