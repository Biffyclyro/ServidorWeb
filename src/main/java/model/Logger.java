package model;

import java.util.ArrayList;

public class Logger {
    private static int TAM_MAX_BUFFER =10;
    private static ArrayList<String> buffer = new ArrayList<>();
    private static Object cheio = new Object();
    private static Object vazio = new Object();

    public static int getTAM_MAX_BUFFER() {
        return TAM_MAX_BUFFER;
    }

    public static ArrayList<String> getBuffer() {
        return buffer;
    }

    public static Object getCheio() {
        return cheio;
    }

    public static Object getVazio() {
        return vazio;
    }

    public static void adicionaBuffer(String log){
        buffer.add(log);
    }

    public static String limparBuffer(){
        return buffer.remove(0);
    }
}
