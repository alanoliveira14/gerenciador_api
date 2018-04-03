package br.com.docapi.models;

import br.com.docapi.entity.TesteEntity;
import org.springframework.stereotype.Component;
import  br.com.docapi.dao.TesteDAO;

@Component
public class TesteModel {

    TesteDAO dao = new TesteDAO();

    public TesteEntity  teste(){

        String retorno = dao.listar();

        String splited[] = retorno.split("-");

        TesteEntity entidade = new TesteEntity();

        entidade.setDescricao(splited[0]);
        entidade.setId(Integer.parseInt(splited[1]));

        return entidade;
    }

}
