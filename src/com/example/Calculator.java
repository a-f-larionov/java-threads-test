package com.example;

class Calculator {

    public long x;

    public void calcPart() throws InterruptedException {
        Thread.sleep(1);
        x++;
    }
}
