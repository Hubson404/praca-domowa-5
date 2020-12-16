package org.hubson404.pracadomowa5.task3;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CurrencyGameController {

    private final CurrencyService currencyService;

    @GetMapping("/currency-game")
    public SingleExchangeRate startGame() {
        return currencyService.getRandomSingle();
    }



}
