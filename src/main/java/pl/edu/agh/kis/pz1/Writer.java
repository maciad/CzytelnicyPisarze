package pl.edu.agh.kis.pz1;

public class Writer extends Thread {
    private final int id;
    private final ReadingRoom readingRoom;

    public Writer(int id, ReadingRoom readingRoom) {
        this.id = id;
        this.readingRoom = readingRoom;
    }

    @Override
    public void run() {
        while (true)
        {
            try
            {
                System.out.println(this + " WANTS TO WRITE");
                readingRoom.requestWrite();
                System.out.println(this + " IS WRITING\n.");
                sleep(3000);
                System.out.println(this + " FINISHED WRITING");
                readingRoom.finishWrite();
                sleep(10000);
            }
            catch (InterruptedException e)
            {
                throw new RuntimeException(e);
            }
        }
    }

    public String toString() {
        return "WRITER " + id;
    }
}
