package view;

import model.Onibus;
import model.Passageiro;

public class Index extends Pagina {

    private String onibus1 = gerarOnibus();

    private static String style = ".onibus{\n" +
            "        width: 1150px;\n" +
            "        height: 330px;\n" +
            "        margin-left: 55px;\n" +
            "        margin-top: 200px;\n" +
            "        border-style: solid;\n" +
            "        \n" +
            "        \n" +
            "        \n" +
            "    }\n" +
            "\n" +
            "    .bancos{\n" +
            "font-size: 12px;"+
            "        background-color: #20B2AA;\n" +
            "        width: 70px;\n" +
            "        height: 50px;\n" +
            "        margin: 8px;\n" +
            "        float: left;\n" +
            "    }\n" +
            "\n" +
            "\n" +
            "    .corredor{\n" +
            "        background-color: #fff;\n" +
            "        width: 70px;\n" +
            "        height: 50px;\n" +
            "        margin: 8px;\n" +
            "        float: left;\n" +
            "    }"+
            "a{"+
            "color: #000;"+
            "text-decoration: none;"+
            "}";

    private  String content = "<div class=\"onibus\">\n" + onibus1 + "    </div>";



    public Index(String alert) {
        gerarOnibus();
        this.body = "<!DOCTYPE Html>\n" +
                "<Html lang =" + "pt-BR" + ">\n" +
                "<head>\n" +
                "<style>\n"+
                style+
                "</style>\n"+
                "\t<title>Sistema de Reservas</title>\n" +
                "</head>\n" +
                "<content>\n" +
                "<h1><b>Sistema de Reservas</b></h1>\n"+
                content +
                "</content>"+
                "<script> " + alert  + "</script>"+
                "</Html>";
    }



    public Index() {
        gerarOnibus();
        this.body = "<!DOCTYPE Html>\n" +
                        "<Html lang =" + "pt-BR" + ">\n" +
                        "<head>\n" +
                        "<style>\n"+
                        style+
                        "</style>\n"+
                        "\t<title>Sistema de Reservas</title>\n" +
                        "</head>\n" +
                        "<content>\n" +
                        "<h1><b>Sistema de Reservas</b></h1>\n"+
                        content +
                        "</content>"+"</Html>";
    }


    private String gerarOnibus() {
        StringBuilder onibus= new StringBuilder();

        for ( int i = 1; i < Onibus.getLugares().size(); i += 2 ){
            Passageiro psg = Onibus.getLugares().get(i).getPassageiro();

            if( !Onibus.getLugares().get(i).isReservado() ) {
                onibus.append("<a href=\"/formulario?lugar=")
                        .append(i).append("\" class=\"bancos\">")
                        .append(i).append(" Livre").append("</a>\n");
            } else {
                onibus.append("<div onclick=\"alert('Lugar reservado por ")
                        .append(psg.getNome())
                        .append("')\" class=\"bancos\" style=\" background-color: #ff3911;\">")
                        .append(i).append(" "+psg.getNome())
                        .append("</br>").append(psg.getDataPassgem())
                        .append( "</div>\n");
            }
            if ( i==25 ) {
                i = 0;
            } else if ( i==26 ) {
                for ( int j = 0; j < 13; j++ ){
                    onibus.append("<div class=\"corredor\"></div>\n");
                }
                i = 25;
            } else if ( i == 51) {
                i = 26;
            }
        }
        return onibus.toString();
    }
}
