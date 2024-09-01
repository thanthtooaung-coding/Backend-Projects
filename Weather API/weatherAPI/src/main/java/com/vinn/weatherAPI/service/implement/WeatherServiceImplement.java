package com.vinn.weatherAPI.service.implement;

import com.vinn.weatherAPI.service.WeatherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherServiceImplement implements WeatherService {

    private static final Logger log = LoggerFactory.getLogger(WeatherServiceImplement.class);
    private final RestTemplate restTemplate;

    @Autowired
    public WeatherServiceImplement(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @Override
    @Cacheable("weather")
    public String getWeather(String city) {
        System.out.println(city);
        String apiUrl = "https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/";
        String apiKey = "WEATHER_API_KEY";
        String url = String.format("%s%s?key=%s", apiUrl, city, apiKey);
        System.out.println(url);
        return restTemplate.getForObject(url, String.class);
    }
}
