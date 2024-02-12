package com.app.service;

import org.springframework.stereotype.Service;

@Service
public class CalcService {
    public int calculate(String operator, int num1, int num2) {
        Operator op = Operator.valueOf(operator.toUpperCase());
        return switch (op) {
            case SUM -> num1 + num2;
            case DIF -> num1 - num2;
            case DIV -> num1 / num2;
            case MULT -> num1 * num2;
        };
    }
}
