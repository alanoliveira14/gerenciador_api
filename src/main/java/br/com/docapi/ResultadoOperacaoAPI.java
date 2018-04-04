package br.com.docapi;

public class ResultadoOperacaoAPI {

    private String mensagem;
    private boolean resultado;

    public ResultadoOperacaoAPI(String mensagem, boolean resultado) {
        super();
        this.mensagem = mensagem;
        this.resultado = resultado;
    }
    public String getMensagem() {
        return mensagem;
    }
    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
    public boolean isResultado() {
        return resultado;
    }
    public void setResultado(boolean resultado) {
        this.resultado = resultado;
    }

}