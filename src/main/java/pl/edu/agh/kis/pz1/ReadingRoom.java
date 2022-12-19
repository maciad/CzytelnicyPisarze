package pl.edu.agh.kis.pz1;

import java.util.concurrent.Semaphore;


/**
 * Class representing reading room and managing access to it
 */
public class ReadingRoom {

    private int readers = 0;
    private final Semaphore readerSemaphore = new Semaphore(5);
    private final Semaphore writerSemaphore = new Semaphore(1);
    private final Semaphore queue = new Semaphore(1);


    /**
     * Tries to get access to the reading room.
     * If there are no writers or readers in the room it allows the reader to enter,
     * otherwise it puts the reader in a queue.
     * @throws InterruptedException - if the thread is interrupted
     */
    public void requestWrite() throws InterruptedException {
        queue.acquire();
        writerSemaphore.acquire();
        queue.release();
    }

    /**
     * Finishes the access to the reading room by releasing the writer semaphore.
     */
    public void finishWrite() {
        writerSemaphore.release();
    }


    /**
     * Tries to get access to the reading room.
     * If the room isn't full it allows the reader to enter,
     * otherwise it puts the reader in a queue.
     * @throws InterruptedException - if the thread is interrupted
     */
    public void requestRead() throws InterruptedException {
        queue.acquire();
        readerSemaphore.acquire();
        readers++;
        if (readers == 1) {
            writerSemaphore.acquire();
        }
        queue.release();

    }

    /**
     * Finishes the access to the reading room by releasing the reader semaphore.
     * If there are no more readers in the room it releases the writer semaphore.
     */
    public void finishRead()  {
        readers--;
        readerSemaphore.release();
        if (readers == 0) {
            writerSemaphore.release();
        }

    }

}
