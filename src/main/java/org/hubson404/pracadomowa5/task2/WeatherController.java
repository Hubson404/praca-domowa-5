package org.hubson404.pracadomowa5.task2;

import lombok.RequiredArgsConstructor;
import org.hubson404.pracadomowa5.task2.model.CurrentWeatherModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class WeatherController {

    private final WeatherMapper weatherMapper;
    private final WeatherService weatherService;

    @GetMapping("/weather")
    public CurrentWeatherDTO getCurrentWeather(@RequestParam String location) {
        CurrentWeatherModel weather = weatherService.getWeather(location);
        CurrentWeatherDTO currentWeatherDTO = weatherMapper.mapToCurrentWeatherDTO(weather,location);
        return currentWeatherDTO;
    }
}
