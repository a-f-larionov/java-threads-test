import java.io.IOException;

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

class KeyBoardThread extends Thread {
    public static boolean stopNow = false;

    @Override
    public void run() {
        super.run();
        int i;

        while (!stopNow) {
            try {
                System.out.println("some stopNow" + stopNow);
                i = System.in.read();
                System.out.println("symbol" + i);
                if (i == 10) {
                    stopNow = true;
                    System.out.print("STOPNOW!");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}


class Monitor {

    private Calculator calculator;

    public void showIt() {

        System.out.print(" " + calculator.x);
    }

    public void setCalculator(Calculator calculator) {
        this.calculator = calculator;
    }
}

class Calculator {

    public long x;

    public void calcPart() throws InterruptedException {
        Thread.sleep(1);
        x++;
    }
}

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

class MonitorThread extends java.lang.Thread {

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