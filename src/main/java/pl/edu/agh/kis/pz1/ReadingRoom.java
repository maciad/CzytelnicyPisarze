package pl.edu.agh.kis.pz1;

import java.util.concurrent.Semaphore;

public class ReadingRoom {
    int readers = 0;
    private final int MaxSize = 5;
    private final Semaphore readerSemaphore = new Semaphore(5);
    private final Semaphore writerSemaphore = new Semaphore(1);
    private final Semaphore kolejka = new Semaphore(1);



    public void requestWrite() throws InterruptedException {
        //writerSemaphore.acquire(1);
//        while (writerSemaphore.availablePermits() == 0) {
//            wait();
//        }
        kolejka.acquire();
        writerSemaphore.acquire(1);
        kolejka.release();
    }

    public void finishWrite() {
        //writerSemaphore.release(1);

        writerSemaphore.release(1);

    }

    public void requestRead() throws InterruptedException {
//        readerSemaphore.acquire(1);
////        while (readerSemaphore.availablePermits() == 0 || readers == MaxSize) {
////            wait();
////        }
//        readers++;
//        if (readers == 1) {
//            writerSemaphore.acquire(1);
//        }

        kolejka.acquire(1);
        readerSemaphore.acquire(1);
        readers++;
        if (readers == 1) {
            writerSemaphore.acquire(1);
        }
        kolejka.release(1);
        readerSemaphore.release(1);
    }

    public void finishRead() throws InterruptedException {
//        readers--;
//        readerSemaphore.release(1);
//        if (readers == 0) {
//            writerSemaphore.release(1);
//        }
        readerSemaphore.acquire(1);
        readers--;
        readerSemaphore.release(1);
        if (readers == 0) {
            writerSemaphore.release(1);
        }

    }

}
