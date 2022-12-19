package pl.edu.agh.kis.pz1;

import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {

        ReadingRoom readingRoom = new ReadingRoom();

        for (int i = 0; i < 20; i++) {
            new Reader(i, readingRoom).start();
        }

        for (int i = 0; i < 6; i++) {
            new Writer(i, readingRoom).start();
        }

    }
}