package ru.anrivlev.calculator;

public enum CalculatorOperation {
    ADDITION("+"),
    SUBTRACTION("-"),
    MULTIPLICATION("*"),
    DIVISION("/"),
    POWER("^");

    public final String character;

    private CalculatorOperation(String character) {
        this.character = character;
    }

    public static CalculatorOperation fromCharacter(String character) {
        switch (character) {
            case "+" -> {
                return CalculatorOperation.ADDITION;
            }
            case "-" -> {
                return CalculatorOperation.SUBTRACTION;
            }
            case "*" -> {
                return CalculatorOperation.MULTIPLICATION;
            }
            case "/" -> {
                return CalculatorOperation.DIVISION;
            }
            case "^" -> {
                return CalculatorOperation.POWER;
            }
        }
        throw new InvalidCalculatorOperationCharacterException(String.format("Неизвестный тип операции: %s", character));
    }
}
