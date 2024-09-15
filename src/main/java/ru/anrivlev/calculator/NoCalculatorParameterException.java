package ru.anrivlev.calculator;

public class NoCalculatorParameterException extends RuntimeException {
    public NoCalculatorParameterException(String message) {
        super(message);
    }
}
