package ru.anrivlev.calculator;

public class InvalidCalculatorOperationCharacterException extends RuntimeException {
    public InvalidCalculatorOperationCharacterException(String message) {
        super(message);
    }
}
