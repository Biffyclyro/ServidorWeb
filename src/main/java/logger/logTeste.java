package logger;

public class logTeste {
    public static void main(String[] args) {
        LogService ls = LogService.logServiceBuilder();
        ls.log("Mensagem teste");
    }
}
