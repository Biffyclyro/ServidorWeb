package model;

public class Html {
    private static String header = "<!DOCTYPE Html>\n" +
            "<Html lang =" + "pt-BR" + ">\n" +
            "<head>\n" +
            "\t<title>Sistema de Reservas</title>\n" +
            "</head>\n" +
            "<body>\n";

    private static String footer = "</body>"+"</Html>";

    public static String getHeader() {
        return header;
    }

    public static String getFooter() {
        return footer;
    }
}