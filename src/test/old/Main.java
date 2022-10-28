package com.gonzik28.old;

public class Main {
    public static void main(String[] args) {
         Subject subject = new Subject();

         new BinaryObserver(subject);
         new OctalObserver(subject);
         new HexadecimalObserver(subject);

        System.out.println("First state: ");
        subject.setState(117);

        System.out.println();

        System.out.println("Second state: ");
        subject.setState(226);
    }
}
