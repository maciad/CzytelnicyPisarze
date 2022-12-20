package pl.edu.agh.kis.pz1;

/**
 * Class representing a writer in the reading room.
 */
public class Writer extends Thread {

    private final int id;
    private final ReadingRoom readingRoom;

    /**
     * Creates a new writer with the given id and reading room.
     * @param id the id of the writer
     * @param readingRoom the reading room
     */
    public Writer(int id, ReadingRoom readingRoom) {
        this.id = id;
        this.readingRoom = readingRoom;
    }

    /**
     * Runs the thread in an infinite loop where it tries to access the reading room.
     * When it gets access it prints a message and sleeps for 3 seconds,
     * blocking access to the reading room.
     * After it finishes it prints a message and sleeps for 10 seconds.
     */
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
            catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    /**
     * @return a string representation of the writer
     */
    @Override
    public String toString() {
        return "WRITER " + id;
    }
}