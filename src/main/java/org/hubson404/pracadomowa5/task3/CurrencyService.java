package org.hubson404.pracadomowa5.task3;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.hubson404.pracadomowa5.exceptions.DataProcessingException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class CurrencyService {

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    private ExchangeRatesListing getExchangeRates() {

        UriComponents build = UriComponentsBuilder.fromHttpUrl("https://api.ratesapi.io/api/latest")
                .queryParam("base", "PLN")
                .build();

        ResponseEntity<String> responseEntity = restTemplate.getForEntity(build.toUri(), String.class);
        String responseBody = responseEntity.getBody();
        ExchangeRatesListing exchangeRatesListing;

        try {
            exchangeRatesListing = objectMapper.readValue(responseBody, ExchangeRatesListing.class);
        } catch (JsonProcessingException e) {
            throw new DataProcessingException("Unable to process data.");
        }

        return exchangeRatesListing;

    }

    public SingleExchangeRate getRandomSingle() {

        ExchangeRatesListing exchangeRates = getExchangeRates();

        Map<String, Double> rates = exchangeRates.getRates();
        ArrayList<String> currencies = new ArrayList<>(rates.keySet());

        int randomIndex = new Random().nextInt(currencies.size());
        String foreignCurrency = currencies.get(randomIndex);

        Double rate = rates.get(foreignCurrency);

        return SingleExchangeRate.builder()
                .baseCurrency(exchangeRates.getBase())
                .baseCurrencyFullName(CurrencyName.resolve(exchangeRates.getBase()))
                .foreignCurrency(foreignCurrency)
                .foreignCurrencyFullName(CurrencyName.resolve(foreignCurrency))
                .exchangeRatio(formatDoubleValue(1/rate))
                .build();
    }

    private double formatDoubleValue(double value) {
        DecimalFormat df = new DecimalFormat("#0.##");
        String format = df.format(value).replace(",",".");
        return Double.parseDouble(format);
    }

}
