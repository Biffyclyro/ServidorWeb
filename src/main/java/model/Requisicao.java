package model;

import java.util.HashMap;
import java.util.Map;

public class Requisicao {
    private String paginaReq;
    private Map<String, String> params = new HashMap<>();





    public Requisicao(String buffer) {
        String[] linhas = buffer.split("\n");
        String header = linhas[1].split("GET /")[0].split(" ")[0];

        if ( header.contains("?") ) {
            String[] pag = header.split("\\?", 1);
            this.paginaReq = pag[0];

            String[] params = pag[1].split("&");

            for ( String param : params) {
                String[] separado = param.split("=");
                String chave = separado[0];
                String valor = separado[1];

                this.params.put(chave, valor);


            }
        } else {
            this.paginaReq = header;
        }

    }


    public String getPaginaReq() {
        return paginaReq;
    }

    public void setPaginaReq(String paginaReq) {
        this.paginaReq = paginaReq;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }
}
