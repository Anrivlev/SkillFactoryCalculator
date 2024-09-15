package ru.anrivlev.calculator;

public class Calculator {
    private Double firstOperand;

    private Double secondOperand;

    private CalculatorOperation calculatorOperation;

    private Double result;

    public Calculator() {

    }

    public Double getFirstOperand() {
        return firstOperand;
    }

    public void setFirstOperand(Double firstOperand) {
        this.firstOperand = firstOperand;
    }

    public Double getSecondOperand() {
        return secondOperand;
    }

    public void setSecondOperand(Double secondOperand) {
        this.secondOperand = secondOperand;
    }

    public CalculatorOperation getCalculatorOperation() {
        return calculatorOperation;
    }

    public void setCalculatorOperation(CalculatorOperation calculatorOperation) {
        this.calculatorOperation = calculatorOperation;
    }

    public Double getResult() {
        return result;
    }

    private void setResult(Double result) {
        this.result = result;
    }

    public void calculate() {
        switch (this.calculatorOperation) {
            case ADDITION -> {
                this.add();
            }
            case SUBTRACTION -> {
                this.subtract();
            }
            case MULTIPLICATION -> {
                this.multiply();
            }
            case DIVISION -> {
                this.divide();
            }
            case POWER -> {
                this.power();
            }
            default -> throw new NoCalculatorParameterException("Не указан тип операции");
        }
    }

    private void add() {
        this.checkAllParametersAreSet();
        this.result = this.firstOperand + this.secondOperand;
    }

    private void subtract() {
        this.checkAllParametersAreSet();
        this.result = this.firstOperand - this.secondOperand;
    }

    private void multiply() {
        this.checkAllParametersAreSet();
        this.result = this.firstOperand * this.secondOperand;
    }

    private void divide() {
        this.checkAllParametersAreSet();
        this.result = this.firstOperand / this.secondOperand;
    }

    private void power() {
        this.checkAllParametersAreSet();
        this.result = Math.pow(this.firstOperand, this.secondOperand);
    }

    private void checkAllParametersAreSet() {
        if (this.firstOperand == null) throw new NoCalculatorParameterException("Не указан первый операнд");
        if (this.secondOperand == null) throw new NoCalculatorParameterException("Не указан второй операнд");
        if (this.calculatorOperation == null) throw new NoCalculatorParameterException("Не указан тип операции");
    }

    public void setResultAsFirstOperand() {
        this.firstOperand = result;
        this.calculatorOperation = null;
        this.secondOperand = null;
        this.result = null;
    }
}
