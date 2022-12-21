package pl.edu.agh.kis.pz1;

/**
 * Class representing a reader in the reading room.
 */
public class Reader extends Thread {

    /**
     * ID of the reader.
     */
    private final int id;

    /**
     * Reading room in which the reader is.
     */
    private final ReadingRoom readingRoom;

    /**
     * Creates a new reader with the given id and reading room.
     * @param id the id of the reader
     * @param readingRoom the reading room
     */
    public Reader(int id, ReadingRoom readingRoom) {
        this.id = id;
        this.readingRoom = readingRoom;
    }

    /**
     * @return the id of the reader
     */
    public int getReaderId() {
        return id;
    }

    /**
     * @return the reading room
     */
    public ReadingRoom getReadingRoom() {
        return readingRoom;
    }

    /**
     * Runs the thread in an infinite loop where it tries to access the reading room.
     * When it gets access it prints a message and sleeps for 1 seconds,
     * blocking a slot in the reading room.
     * After it finishes it prints a message and sleeps for 3 seconds.
     */
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
            catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    /**
     * @return a string representation of the reader
     */
    @Override
    public String toString() {
        return "Reader " + id;
    }
}