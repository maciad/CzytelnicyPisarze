package pl.edu.agh.kis.pz1;

public class ReadersWriters {

    public static void main(String[] args) {

        ReadingRoom readingRoom = new ReadingRoom();

        for (int i = 0; i < 10; i++) {
            new Reader(i, readingRoom).start();
        }

        for (int i = 0; i < 3; i++) {
            new Writer(i, readingRoom).start();
        }

    }
}