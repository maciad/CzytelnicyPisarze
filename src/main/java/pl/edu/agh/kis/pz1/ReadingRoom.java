package pl.edu.agh.kis.pz1;

import java.util.concurrent.Semaphore;

public class ReadingRoom {
    int readers = 0;
    private final Semaphore readerSemaphore = new Semaphore(5);
    private final Semaphore writerSemaphore = new Semaphore(1);
    private final Semaphore queue = new Semaphore(1);


    public void requestWrite() throws InterruptedException {
        queue.acquire();
        writerSemaphore.acquire();
        queue.release();
    }

    public void finishWrite() {
        writerSemaphore.release();
    }

    public void requestRead() throws InterruptedException {
        queue.acquire();
        readerSemaphore.acquire();
        readers++;
        if (readers == 1) {
            writerSemaphore.acquire();
        }
        queue.release();

    }

    public void finishRead() throws InterruptedException {
        readers--;
        readerSemaphore.release();
        if (readers == 0) {
            writerSemaphore.release();
        }

    }

}
