package com.example;

import com.example.*;

class ThreadAndRunnable {

    public static void main(String[] args) {

        var calculatorThread = new CalculatorThread();
        var monitorThread = new MonitorThread();
        var keyBoardThread = new KeyBoardThread();

        Calculator calculator = new Calculator();
        Monitor monitor = new Monitor();

        calculatorThread.setCalculator(calculator);


        monitorThread.setCalculator(calculator);
        monitorThread.setMonitor(monitor);

        monitorThread.start();
        calculatorThread.start();
        keyBoardThread.start();

        System.out.print("END OF MAIN");
    }
}


