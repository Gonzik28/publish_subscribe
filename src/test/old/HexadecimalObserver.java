package com.gonzik28.old;

public class HexadecimalObserver extends Observer {

    public HexadecimalObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    public void update() {
        System.out.println("Hexadecimal: " + Integer.toHexString(subject.getState()));
    }
}
