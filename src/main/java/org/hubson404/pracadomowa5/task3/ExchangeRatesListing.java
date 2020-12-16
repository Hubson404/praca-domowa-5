package org.hubson404.pracadomowa5.task3;

import lombok.Data;

import java.util.Map;

@Data
public class ExchangeRatesListing {

    private String base;
    private Map<String,Double> rates;

}
