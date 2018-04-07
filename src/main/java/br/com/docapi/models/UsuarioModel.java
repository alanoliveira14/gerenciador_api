package br.com.docapi.models;

import br.com.docapi.entity.UsuarioEntity;
import br.com.docapi.dao.UsuarioDAO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UsuarioModel {
    UsuarioDAO usuarioDAO = new UsuarioDAO();

    public void inserir(UsuarioEntity usuario){
        usuarioDAO.inserirUsuario(usuario);
    }

    public List<UsuarioEntity> listarUsuarios(){

        return usuarioDAO.listarUsuarios();
    }

    public void deletarCliente(Integer idUsuario){

        usuarioDAO.deletarUsuario(idUsuario);

    }

}
