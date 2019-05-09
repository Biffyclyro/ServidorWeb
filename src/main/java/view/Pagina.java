package view;

public abstract class Pagina {
    String header = "HTTP/1.1 200 OK\nContent-Type: text/html; charset=UTF-8\n\n";
    String body;

    public String render() {
        return header + body;
    }
}
