package ru.anrivlev.calculator;

import java.util.Objects;
import java.util.Scanner;

public class CalculatorScanner {
    private Calculator calculator;

    private Scanner scanner;

    private CalculatorScannerStatus status;

    public CalculatorScanner() {
        this.calculator = new Calculator();
        this.scanner = new Scanner(System.in);
        this.status = CalculatorScannerStatus.WAITS_FOR_FIRST_OPERAND;
    }

    public void init() {
        this.printCloseInfo();
        while (this.status != CalculatorScannerStatus.IS_CLOSED) {
            switch (this.status) {
                case WAITS_FOR_FIRST_OPERAND -> {
                    this.readFirstOperand();
                }
                case WAITS_FOR_OPERATION -> {
                    this.readCalculatorOperation();
                }
                case WAITS_FOR_SECOND_OPERATION -> {
                    this.readSecondOperand();
                }
                default -> throw new IllegalStateException("Unexpected value: " + this.status);
            }
        }
    }

    private void printCloseInfo() {
        System.out.println("Чтобы начать заново введите: \"C\"");
        System.out.println("Для выхода напишите в любой момент: \"s\"");
    }

    private boolean checkIfClosed(String inputLine) {
        String inputLineLowerCased = inputLine.toLowerCase();
        if (Objects.equals(inputLineLowerCased, "c")) {
            this.status = CalculatorScannerStatus.WAITS_FOR_FIRST_OPERAND;
            return true;
        }
        if (Objects.equals(inputLineLowerCased, "s")) {
            this.status = CalculatorScannerStatus.IS_CLOSED;
            return true;
        }
        return false;
    }

    private Double readDouble() {
        String inputLine = this.scanner.nextLine();

        if (this.checkIfClosed(inputLine)) return null;

        double inputDouble;
        try {
            inputDouble = Double.parseDouble(inputLine);
        } catch (NumberFormatException exception) {
            System.out.println("Не удалось прочитать число");
            return null;
        }

        return inputDouble;
    }

    private void readFirstOperand() {
        System.out.println("Введите первый операнд:");
        Double inputDouble = this.readDouble();
        if (inputDouble == null) return;
        this.calculator.setFirstOperand(inputDouble);
        this.status = CalculatorScannerStatus.WAITS_FOR_OPERATION;
    }

    private void readCalculatorOperation() {
        System.out.println("Введите операцию:");
        String inputLine = this.scanner.nextLine();

        if (this.checkIfClosed(inputLine)) return;

        CalculatorOperation calculatorOperation;
        try {
            calculatorOperation = CalculatorOperation.fromCharacter(inputLine);
        } catch (InvalidCalculatorOperationCharacterException exception) {
            System.out.println("Неизвестный вид операции");
            return;
        }

        this.calculator.setCalculatorOperation(calculatorOperation);
        this.status = CalculatorScannerStatus.WAITS_FOR_SECOND_OPERATION;
    }

    private void readSecondOperand() {
        System.out.println("Введите второй операнд:");
        Double inputDouble = this.readDouble();
        if (inputDouble == null) return;
        this.calculator.setSecondOperand(inputDouble);
        this.performCalculation();
        this.calculator.setResultAsFirstOperand();
        this.status = CalculatorScannerStatus.WAITS_FOR_OPERATION;
    }

    private void performCalculation() {
        this.calculator.calculate();
        System.out.printf("Результат вычислений:\n%f\n", this.calculator.getResult());
        this.printCloseInfo();
    }
}
