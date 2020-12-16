package org.hubson404.pracadomowa5.task2;


import lombok.NoArgsConstructor;
import org.hubson404.pracadomowa5.task2.model.CurrentWeather;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class WeatherMapper {

    CurrentWeatherDTO mapToCurrentWeatherDTO(CurrentWeather weather, String location){

        return CurrentWeatherDTO.builder()
                .location(location)
                .country(weather.getSys().getCountry())
                .temp(weather.getMain().getTemp())
                .feelsLike(weather.getMain().getFeelsLike())
                .tempMax(weather.getMain().getTempMax())
                .tempMin(weather.getMain().getTempMin())
                .description(weather.getWeather().get(0).getDescription())
                .icon(weather.getWeather().get(0).getIcon())
                .windSpeed(weather.getWind().getSpeed())
                .windDirection(formatWindDirection(weather.getWind().getDeg()))
                .humidity(weather.getMain().getHumidity())
                .airPressure(weather.getMain().getPressure())
                .build();
    }

    private String formatWindDirection(Integer windDir) {
        String windDirection;

        if (windDir >= 326 || windDir < 34) {
            windDirection = "N";
        } else if (windDir < 79) {
            windDirection = "NE";
        } else if (windDir < 124) {
            windDirection = "E";
        } else if (windDir < 169) {
            windDirection = "SE";
        } else if (windDir < 214) {
            windDirection = "S";
        } else if (windDir < 259) {
            windDirection = "SW";
        } else if (windDir < 304) {
            windDirection = "W";
        } else {
            windDirection = "NW";
        }
        return windDirection;
    }


}
