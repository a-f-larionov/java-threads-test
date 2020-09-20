package com.example;

import java.io.IOException;

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
