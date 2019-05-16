package logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.Queue;

public class LogService implements Runnable {

    private final File file = new File("servidorWeb-log.txt");
    private final FileWriter logFile = new FileWriter(file);

    private static final DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern(
            "yyyy/MM/dd-HH:mm");

    private static final Queue<String> buffer = new LinkedList<>();
    private static final Object vazio = new Object();


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
        synchronized ( vazio ) {
            if ( buffer.size() == 0 ) {
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
                } catch ( IOException e ) {
                    e.printStackTrace();
                } finally {
                    try {
                        logFile.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void log(String msg) {

        synchronized (buffer) {
            buffer.add("[" + LocalDateTime.now().format(formatter) + "]: " + msg);
        }

        synchronized ( vazio ) {
            if ( buffer.size() == 1 ){
                vazio.notify();
            }
        }
    }
}
