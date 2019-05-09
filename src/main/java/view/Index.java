package view;

import model.Html;

public class Index {
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
            "    }";

    private  String content = "<div class=\"onibus\">\n" + onibus1 + "    </div>";


    public String body = "<!DOCTYPE Html>\n" +
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

    public Index() {
        gerarOnibus();
    }

    public String gerarOnibus() {
        String onibus="";
        for (int i = 1; i<56; i += 2 ){
            
            onibus +="<div onclick=\"window.open('?lugar=" + i + "','_self')\" class=\"bancos\">" + i + "</div>\n";

            if(i==25){
                i=0;
            }else if(i==26){
                for(int j=0; j<13;j++){
                    onibus+="<div class=\"corredor\"></div>\n";
                }
                i=25;
            }else if(i==51){
                i=28;
            }
        }
        return onibus;
    }

    public String getBody() {
        return body;
    }

}
