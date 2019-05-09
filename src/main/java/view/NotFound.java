package view;

public class NotFound extends Pagina {

    public NotFound() {
        this.header = "HTTP/1.1 200 OK\nContent-Type: text/html; charset=UTF-8\n\n";
        this.body = "<h1>404 Not Found<h1>";
    }
}