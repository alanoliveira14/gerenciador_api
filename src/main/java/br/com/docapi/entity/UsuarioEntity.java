package br.com.docapi.entity;

public class UsuarioEntity {

    private Integer idUsuario;
    private String usuario;
    private String senha;
    private Integer ativo;
    private Integer idColaborador;
    private String dataInsercao;
    private Integer gerenciaProjetos;

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Integer getAtivo() {
        return ativo;
    }

    public void setAtivo(Integer ativo) {
        this.ativo = ativo;
    }

    public Integer getIdColaborador() {
        return idColaborador;
    }

    public void setIdColaborador(Integer idColaborador) {
        this.idColaborador = idColaborador;
    }

    public String getDataInsercao() {
        return dataInsercao;
    }

    public void setDataInsercao(String dataInsercao) {
        this.dataInsercao = dataInsercao;
    }

    public Integer getGerenciaProjetos() {
        return gerenciaProjetos;
    }

    public void setGerenciaProjetos(Integer gerenciaProjetos) {
        this.gerenciaProjetos = gerenciaProjetos;
    }
}
