package br.com.docapi.models;

import br.com.docapi.entity.ColaboradorEntity;
import  br.com.docapi.dao.ColaboradorDAO;
import br.com.docapi.database.ConnectionFactory;

import org.springframework.stereotype.Component;


@Component
public class ColaboradorModel {

    ColaboradorDAO colaboradorDAO = new ColaboradorDAO();

    public void cadastrarColaborador(ColaboradorEntity colaborador){
        colaboradorDAO.inserirColaborador(colaborador);
    }

}
