package com.example;

class CalculatorThread extends Thread {

    Calculator calculator;

    @Override
    public void run() {
        super.run();

        while (!KeyBoardThread.stopNow) {
            try {
                calculator.calcPart();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void setCalculator(Calculator calculator) {
        this.calculator = calculator;
    }
}
