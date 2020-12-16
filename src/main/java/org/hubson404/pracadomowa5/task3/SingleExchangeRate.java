package org.hubson404.pracadomowa5.task3;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SingleExchangeRate {

    private String baseCurrency;
    private String baseCurrencyFullName;
    private String foreignCurrency;
    private String foreignCurrencyFullName;
    private Double exchangeRatio;
}
