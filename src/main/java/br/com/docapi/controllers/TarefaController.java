package br.com.docapi.controllers;
import br.com.docapi.ResultadoOperacaoAPI;
import br.com.docapi.entity.TarefaEntity;
import br.com.docapi.models.TarefaModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.Console;
import java.util.List;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping(value = "/tarefa")
public class TarefaController {
    @Autowired
   private TarefaModel tarefaModel;
    @RequestMapping(value = "/criar", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    @ResponseBody
    public ResultadoOperacaoAPI inserir(@RequestBody TarefaEntity tarefa) throws Exception{

        try{
            tarefaModel.inserirTarefa(tarefa);
        }
        catch (Exception e){
            return new ResultadoOperacaoAPI(e.getMessage(),false);
        }

        return new ResultadoOperacaoAPI("Inserido com sucesso",true);
    }
    @RequestMapping(value = "/alterar", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    @ResponseBody
    public ResultadoOperacaoAPI alterar(@RequestBody TarefaEntity tarefa) throws Exception{

        try{
            tarefaModel.atualizar(tarefa);
        }
        catch (Exception e){
            return new ResultadoOperacaoAPI(e.getMessage(),false);
        }

        return new ResultadoOperacaoAPI("Alterado com sucesso",true);
    }

    @RequestMapping(value = "/listar", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    @ResponseBody
    public ResponseEntity<List<TarefaEntity>> listar() throws Exception{

        List<TarefaEntity> tarefas = null;

        try{
            tarefas = tarefaModel.listarTarefas();
        }
        catch (Exception e){
            return new ResponseEntity<List<TarefaEntity>>(tarefas,HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<List<TarefaEntity>>(tarefas,HttpStatus.OK);
    }

}
