package br.com.docapi.controllers;

import br.com.docapi.ResultadoOperacaoAPI;
import br.com.docapi.entity.UsuarioEntity;
import br.com.docapi.models.UsuarioModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/usuario")
public class UsuarioController {

    @Autowired
    UsuarioModel usuarioModel;

    @RequestMapping(value = "/criar", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    @ResponseBody
    public ResultadoOperacaoAPI inserir(@RequestBody UsuarioEntity usuario) throws Exception{

        try{
            usuarioModel.inserir(usuario);
        }
        catch (Exception e){
            return new ResultadoOperacaoAPI(e.getMessage(),false);
        }

        return new ResultadoOperacaoAPI("Inserido com sucesso",true);
    }

    @RequestMapping(value = "/listar", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    @ResponseBody
    public ResponseEntity<List<UsuarioEntity>> listar() throws Exception{

        List<UsuarioEntity> usuarios = null;

        try{
            usuarios = usuarioModel.listarUsuarios();
        }
        catch (Exception e){
            return new ResponseEntity<List<UsuarioEntity>>(usuarios, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<List<UsuarioEntity>>(usuarios,HttpStatus.OK);
    }
    @RequestMapping(value = "/deletar/{idUsuario}", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    @ResponseBody
    public ResultadoOperacaoAPI delatar(@PathVariable Integer idUsuario) throws Exception{

        try{
            usuarioModel.deletarCliente(idUsuario);
        }
        catch (Exception e){
            return new ResultadoOperacaoAPI(e.getMessage(),false);
        }

        return new ResultadoOperacaoAPI("Deletado com sucesso",true);
    }


}
