package logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.Queue;

public class LogService implements Runnable {

    private final File file = new File("/tmp/servidorWeb-" + LocalDateTime.now());
    private final FileWriter logFile = new FileWriter(file);

    private final int TAM_MAX_BUFFER = 50;
    private final Queue<String> buffer = new LinkedList<>();
    private final Object cheio = new Object();
    private final Object vazio = new Object();

    private LogService() throws IOException {
    }

    public static LogService logServiceBuilder() {
        LogService ls = null;

        try {
            ls = new LogService();
        } catch (IOException e) {
            e.printStackTrace();
        }

        new Thread(ls).start();
        return ls;
    }

    @Override
    public void run() {
        while ( true ) {
            writeToFile();
        }
    }

    private void writeToFile() {
        synchronized (vazio) {
            if ( buffer.size()==0 ) {
                try {
                    vazio.wait();
                } catch ( InterruptedException e ) {
                    e.printStackTrace();
                }
            }

            synchronized ( buffer ) {
                try {
                    System.out.println(buffer.peek());
                    logFile.write(buffer.poll());
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        logFile.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }


            synchronized ( cheio ){
                cheio.notify();
            }
        }
    }

    public void log(String msg) {
        if ( this.buffer.size() == TAM_MAX_BUFFER ) {
            synchronized (this.cheio) {
                try {
                    this.cheio.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        synchronized (this.buffer) {
            this.buffer.add("[" + LocalDateTime.now() + "]: " + msg);
        }

        synchronized ( this.vazio ) {
            if ( this.buffer.size() == 1 ){
                this.vazio.notify();
            }
        }
    }
}
