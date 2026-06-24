package com.example.weather.controller;

import com.example.weather.config.WeatherConfig;
import com.example.weather.model.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class WeatherController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CacheManager cacheManager;

    @Autowired
    private String openWeatherApiKey;

    @GetMapping("/weather")
    public Root getWeather(@RequestParam double lat, @RequestParam double lon) {
        String cacheKey = lat + "," + lon;
        Cache cache = cacheManager.getCache(WeatherConfig.WEATHER_CACHE);
        Root cached = cache != null ? cache.get(cacheKey, Root.class) : null;
        if (cached != null) {
            return cached;
        }

        Root weather = restTemplate.getForObject(
                WeatherConfig.OPENWEATHER_URL,
                Root.class,
                lat,
                lon,
                openWeatherApiKey
        );

        if (cache != null && weather != null) {
            cache.put(cacheKey, weather);
        }
        return weather;
    }
}
