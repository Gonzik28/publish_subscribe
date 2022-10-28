package com.gonzik28.old;

public class BinaryObserver extends Observer{

    public BinaryObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    public void update() {
        System.out.println("Binary: " + Integer.toBinaryString(subject.getState()));
    }
}
