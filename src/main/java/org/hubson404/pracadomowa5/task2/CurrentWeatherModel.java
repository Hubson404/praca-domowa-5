
package org.hubson404.pracadomowa5.task2;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class CurrentWeatherModel {

    private List<Weather> weather;
    private Main main;
    private Wind wind;
    private Sys sys;

    @Data
    public static class Weather {
        private String description;
        private String icon;
    }

    @Data
    public static class Main {
        private float temp;
        @JsonProperty("feels_like")
        private float feelsLike;
        @JsonProperty("temp_min")
        private float tempMin;
        @JsonProperty("temp_max")
        private float tempMax;
        private int pressure;
        private int humidity;
    }

    @Data
    public static class Wind {
        private float speed;
        private int deg;
    }

    @Data
    public static class Sys {
        private String country;
    }
}
