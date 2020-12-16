package org.hubson404.pracadomowa5.task2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CurrentWeatherDTO {

    private String location;
    private String country;
    private String description;
    private String icon;
    private float temp;
    private float feelsLike;
    private float tempMin;
    private float tempMax;
    private int airPressure;
    private int humidity;
    private float windSpeed;
    private String windDirection;

}
