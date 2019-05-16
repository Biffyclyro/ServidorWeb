package conexao;

import java.util.HashMap;
import java.util.Map;

public class Requisicao {

    private final String paginaReq;

    private final Map<String, String> params = new HashMap<>();

    Requisicao(String buffer) {
        String[] linhas = buffer.split("\n");
        String header = linhas[0].split(" ")[1];

        if ( header.contains("?") ) {
            String[] pag = header.split("\\?");

            this.paginaReq = pag[0];

           String[] params = pag[1].split("&");

            for ( String param : params) {
                int idx = param.indexOf("=");
                this.params.put(param.substring(0, idx), param.substring(idx+1));
            }
        } else {
            this.paginaReq = header;
        }
    }


    String getPaginaReq() {
        return paginaReq;
    }

    public Map<String, String> getParams() {
        return params;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder().append(this.paginaReq + "\n");
        for ( String chave : this.params.keySet() ) {
            str.append( chave + "=\"" + this.params.get(chave) + "\"\n");
        }
        return str.toString();
    }
}
