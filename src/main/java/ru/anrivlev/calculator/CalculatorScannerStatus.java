package ru.anrivlev.calculator;

public enum CalculatorScannerStatus {
    WAITS_FOR_FIRST_OPERAND,
    WAITS_FOR_OPERATION,
    WAITS_FOR_SECOND_OPERATION,
    IS_CLOSED,
}
