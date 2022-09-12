package com.example.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements ICalculatorService {
    @Override
    public String calculate(double numberFirst, double numberSecond, String calcul) {
        double result = 0;
        switch (calcul) {
            case "Addition(+)":
                result = numberFirst + numberSecond;
                break;
            case "Subtraction(-)":
                result = numberFirst - numberSecond;
                break;
            case "Multiplication(X)":
                result = numberFirst * numberSecond;
                break;
            case "Division(/)":
                if (numberSecond!=0){
                    result = numberFirst / numberSecond;
                    break;
                }
                return "Can not division for 0";


        }
        return String.valueOf(result);
    }
}
