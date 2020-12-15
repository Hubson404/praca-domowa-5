package org.hubson404.pracadomowa5;

import org.hubson404.pracadomowa5.task2.WeatherConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;


@SpringBootApplication
@EnableConfigurationProperties(WeatherConfig.class)
public class PracaDomowa5Application {

    public static void main(String[] args) {
        SpringApplication.run(PracaDomowa5Application.class, args);
    }

}
