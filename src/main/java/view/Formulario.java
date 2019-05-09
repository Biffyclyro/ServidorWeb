package view;

import model.Html;

public class Formulario extends Pagina{
    private String body = "<!doctype html>\n" +
            "<html lang=\"pt-br\">\n" +
            "  <head>\n" +
            "    \n" +
            "    <meta charset=\"utf-8\">\n" +
            "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n" +
            "    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">\n" +
            "\n" +
            "    <title>Sistema de Reservas</title>\n" +
            "  </head>\n" +
            "  <body>\n" +
            "    \n" +
            "    <div class=\"container col-md-6 mt-5\">\n" +
            "      <h1><b>Sistema de Reservas</b></h1>\n" +
            "      <form method=\"get\" action=\"/\">\n" +
            "      <div class=\"form-group\">\n" +
            "        <label for=\"nome\">Nome</label>\n" +
            "        <input type=\"text\" class=\"form-control\" id=\"nome\" placeholder=\"Entre com o Nome\">\n" +
            "        \n" +
            "      </div>\n" +

            "      <button type=\"submit\" class=\"btn btn-primary\">Reservar</button>\n" +
            "    </form>\n" +
            "    </div>\n" +
            "\n" +
            "    \n" +
            "  </body>\n" +
            "</html>\n";

    @Override
    public String render() {
        return body;
    }

}
