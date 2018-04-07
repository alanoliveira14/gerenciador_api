package br.com.docapi.models;

import br.com.docapi.dao.ProjetoDAO;
import br.com.docapi.entity.ProjetoEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProjetoModel {

    ProjetoDAO projetoDAO = new ProjetoDAO();

    public void cadastrarProjeto(ProjetoEntity projeto){
        projetoDAO.inserirProjeto(projeto);
    }

    public List<ProjetoEntity> listarProjetos(){
        return projetoDAO.listarProjetos();
    }

    public void deleteProjeto(Integer idProjeto){
        projetoDAO.deletaProjeto(idProjeto);
    }

    public void alteraProjeto(ProjetoEntity projeto){
        projetoDAO.alterarProjeto(projeto);
    }

    public ProjetoEntity buscaProjeto(String tituloProjeto){
        return projetoDAO.buscarProjeto(tituloProjeto);
    }


}

