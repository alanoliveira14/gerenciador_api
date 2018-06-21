package br.com.docapi.entity;

public class TarefaEntity {

    private Integer idTarefas;
    private String descricao	;
    private String dataInicio	;
    private String dataPrevista	;
    private String dataFinalizacao	;
    private String situacao	;
    private Integer fkIdProjeto	;
    private Integer fkIdColaborador	;
    private String nomeColaborador;
    private String nomeProjeto;
    public Integer getIdTarefas() {
        return idTarefas;
    }

    public void setIdTarefas(Integer idTarefas) {
        this.idTarefas = idTarefas;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataPrevista() {
        return dataPrevista;
    }

    public void setDataPrevista(String dataPrevista) {
        this.dataPrevista = dataPrevista;
    }

    public String getDataFinalizacao() {
        return dataFinalizacao;
    }

    public void setDataFinalizacao(String dataFinalizacao) {
        this.dataFinalizacao = dataFinalizacao;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public Integer getFkIdProjeto() {
        return fkIdProjeto;
    }

    public void setFkIdProjeto(Integer fkIdProjeto) {
        this.fkIdProjeto = fkIdProjeto;
    }

    public Integer getFkIdColaborador() {
        return fkIdColaborador;
    }

    public void setFkIdColaborador(Integer fkIdColaborador) {
        this.fkIdColaborador = fkIdColaborador;
    }

    public String getNomeColaborador() {
        return nomeColaborador;
    }

    public void setNomeColaborador(String nomeColaborador) {
        this.nomeColaborador = nomeColaborador;
    }

    public String getNomeProjeto() {
        return nomeProjeto;
    }

    public void setNomeProjeto(String nomeProjeto) {
        this.nomeProjeto = nomeProjeto;
    }
}
