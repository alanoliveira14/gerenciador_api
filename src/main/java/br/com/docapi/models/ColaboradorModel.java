package br.com.docapi.models;

import br.com.docapi.entity.ColaboradorEntity;
        import  br.com.docapi.dao.ColaboradorDAO;
        import br.com.docapi.database.ConnectionFactory;

        import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class ColaboradorModel {

    ColaboradorDAO colaboradorDAO = new ColaboradorDAO();

    public void cadastrarColaborador(ColaboradorEntity colaborador){
        colaboradorDAO.inserirColaborador(colaborador);
    }

    public List<ColaboradorEntity> getColaboradores(){

        List<ColaboradorEntity> colaboradores = colaboradorDAO.getColaboradores();

        return colaboradores;

    }

    public void deletarColaborador(Integer idColaborador){

        colaboradorDAO.deletarColaborador(idColaborador);

    }

    public void alterarColaborador(ColaboradorEntity colaborador){
        colaboradorDAO.alterarColaborador(colaborador);
    }

    public ColaboradorEntity pesquisar(String cpf){
     return  colaboradorDAO.pesquisar(cpf);
    }

}
