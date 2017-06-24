package minesweeper;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class HelloMessageTest {

    /**
     * open several client connections, check the entire hello msg on the last one.
     *
     * @throws IOException
     * @throws InterruptedException
     */
    @Test(timeout=10000)
    public void testHelloMessage() throws IOException, InterruptedException {
        final int THREADS = 2;

        final ThreadWithObituary serverThread = TestUtils.startServer(false);

        Thread threads[] = new Thread[THREADS];
        final CountDownLatch latch = new CountDownLatch(THREADS);

        for(int i = 0; i < THREADS; i++) {
            threads[i] = new Thread(new Runnable() {
                public void run() {
                    try {
                        Socket sock = TestUtils.connect(serverThread);
                        BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
                        String hello = in.readLine();
                        assertTrue(hello != null);
                        // Don't actually close this connection.
                        latch.countDown();
                    } catch (IOException ignored) {}
                }
            });
        }
        for(int i=0; i<THREADS; i++) {
            threads[i].start();
        }

        latch.await(2, TimeUnit.SECONDS);

        final String expected = "Welcome to Minesweeper. "
                + "Players: " + (THREADS+1) + " including you. "
                + "Board: 10 columns by 10 rows. "
                + "Type 'help' for help.";

        Socket sock = TestUtils.connect(serverThread);
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
            String tester = in.readLine();
            assertEquals(expected, tester);
        } catch (SocketTimeoutException e) {
            fail("server timeout");
        } finally {
            sock.close();
        }
    }

}