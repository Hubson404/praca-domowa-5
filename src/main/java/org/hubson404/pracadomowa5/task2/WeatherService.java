package org.hubson404.pracadomowa5.task2;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.hubson404.pracadomowa5.exceptions.DataProcessingException;
import org.hubson404.pracadomowa5.exceptions.InsufficientDataException;
import org.hubson404.pracadomowa5.task2.model.CurrentWeather;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Service
@RequiredArgsConstructor
public class WeatherService {

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    @Value("${org.hubson404.weather.api-key}")
    private String apiKey;


    public CurrentWeather getWeather(String location) {

        if (location.isBlank()) {
            throw new InsufficientDataException("Location parameter must be specified.");
        }

        UriComponents uri = UriComponentsBuilder.fromHttpUrl("http://api.openweathermap.org/data/2.5/weather")
                .queryParam("q", location)
                .queryParam("units", "metric")
                .queryParam("lang", "en")
                .queryParam("appid", apiKey)
                .build();

        ResponseEntity<String> responseEntity = restTemplate.getForEntity(uri.toUri(), String.class);

        String body = responseEntity.getBody();
        CurrentWeather weather;

        try {
            weather = objectMapper.readValue(body, CurrentWeather.class);
        } catch (JsonProcessingException e) {
            throw new DataProcessingException("Unable to process data.");
        }
        return weather;

    }
}
