package br.com.docapi.models;

import org.springframework.stereotype.Component;
import br.com.docapi.dao.TarefaDAO;
import br.com.docapi.entity.TarefaEntity;

import java.util.List;

@Component
public class TarefaModel {
    TarefaDAO tarefaDAO = new TarefaDAO();
    public void inserirTarefa(TarefaEntity tarefa){
        tarefaDAO.inserirTarefa(tarefa);
    }
    public void atualizar(TarefaEntity tarefa){
        tarefaDAO.alterarTarefa(tarefa);
    }

    public List<TarefaEntity> listarTarefas(){
        return tarefaDAO.listarTarefas();
    }

}
