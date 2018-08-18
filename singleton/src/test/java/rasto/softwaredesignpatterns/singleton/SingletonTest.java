package rasto.softwaredesignpatterns.singleton;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Rastislav Zlacky (rastislav.zlacky@inventi.cz) on 12.08.2018.
 */
public class SingletonTest {

    private static final int THREAD_COUNT = 150;

    @Test
    public void singletonTest() throws InterruptedException {
        List<Singleton> list = Collections.synchronizedList(new ArrayList<>());
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < THREAD_COUNT; i++) {
            Thread thread = new Thread(() -> list.add(Singleton.getInstance()));
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        Singleton singleton = Singleton.getInstance();
        Assert.assertEquals(THREAD_COUNT, list.size());
        for (Singleton sing : list) {
            Assert.assertEquals(singleton, sing);
        }
    }
}
