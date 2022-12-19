package pl.edu.agh.kis.pz1;

public class Reader extends Thread {
    private final int id;
    private final ReadingRoom readingRoom;

    public Reader(int id, ReadingRoom readingRoom) {
        this.id = id;
        this.readingRoom = readingRoom;
    }

    @Override
    public void run() {
        while (true)
        {
            try
            {
                System.out.println(this + " wants to read");
                readingRoom.requestRead();
                System.out.println(this + " is reading");
                sleep(1000);
                System.out.println(this + " finished reading");
                readingRoom.finishRead();
                sleep(3000);
            }
            catch (InterruptedException e)
            {
                throw new RuntimeException(e);
            }
        }
    }

    public String toString() {
        return "Reader " + id;
    }
}
