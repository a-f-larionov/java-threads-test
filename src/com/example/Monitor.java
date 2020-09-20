package com.example;

class Monitor {

    private Calculator calculator;

    public void showIt() {

        System.out.print(" " + calculator.x);
    }

    public void setCalculator(Calculator calculator) {
        this.calculator = calculator;
    }
}
