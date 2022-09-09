package com.example.service;

import org.springframework.stereotype.Service;

@Service
public class CurrencyService implements ICurrencyService {

    @Override
    public double calculate(String unit, double money) {
        double result;
        switch (unit) {
            case "usd":
                result = money / 24000;
                break;
            case "vnd":
                result =  money * 24000;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + unit);
        }
        return result;
    }
}
