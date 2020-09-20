package com.example;

class MonitorThread extends Thread {

    private Calculator calculator;
    private Monitor monitor;

    @Override
    public void run() {
        while (!KeyBoardThread.stopNow) {
            monitor.showIt();
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void setCalculator(Calculator calculator) {
        this.calculator = calculator;
        if (monitor != null) monitor.setCalculator(this.calculator);
    }

    public void setMonitor(Monitor monitor) {
        this.monitor = monitor;
        if (calculator != null) monitor.setCalculator(this.calculator);
    }
}
