package br.com.docapi.models;

import br.com.docapi.dao.ProjetoHasColaboradoresDAO;
import br.com.docapi.entity.ProjetoHasColaboradoresEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProjetoHasColaboradoresModel {

    ProjetoHasColaboradoresDAO projetoDAO = new ProjetoHasColaboradoresDAO();

    public void inserirColaboradorProjeto(ProjetoHasColaboradoresEntity projetoColab){
        projetoDAO.inserirColab_Projeto(projetoColab);
    }




}

