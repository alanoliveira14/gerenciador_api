package br.com.docapi.dao;

import br.com.docapi.database.ConnectionFactory;
import br.com.docapi.entity.UsuarioEntity;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class UsuarioDAO {

    public void inserirUsuario(UsuarioEntity usuario){

        Connection conn = null;
        PreparedStatement ps = null;

        try{
            conn = ConnectionFactory.obtemConexao();
            String sql = "insert into usuarios (usuario, senha, ativo, fkIdColaborador, dataInsercao, gerenciaProjetos) values (?, md5(?), 1, ?, now(), ?);";
            ps = conn.prepareStatement (sql);
            ps.setString(1, usuario.getUsuario());
            ps.setString(2, usuario.getSenha());
            ps.setInt(3, usuario.getIdColaborador());
            ps.setInt(4, usuario.getGerenciaProjetos());
            ps.execute();

        }catch (SQLException e){
            e.printStackTrace();
        }
        finally{
            try{
                ps.close();
                conn.close();
            }
            catch (SQLException e){
                e.printStackTrace();
            }
        }


    }

    public List<UsuarioEntity> listarUsuarios(){

        Connection conn = null;
        PreparedStatement ps = null;

        List<UsuarioEntity> usuarios = new ArrayList<UsuarioEntity>();
        try{
            conn = ConnectionFactory.obtemConexao();
            String sql = "select idUsuarios, usuario, dataInsercao, gerenciaProjetos from usuarios;";
            ps = conn.prepareStatement (sql);
            ps.execute();

            ResultSet rs = ps.getResultSet();

            while(rs.next()){
                UsuarioEntity usuario = new UsuarioEntity();

                usuario.setIdUsuario(rs.getInt(1));
                usuario.setUsuario(rs.getString(2));
                usuario.setDataInsercao(rs.getString(3));
                usuario.setGerenciaProjetos(rs.getInt(4));

                usuarios.add(usuario);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return usuarios;
    }

    public void deletarUsuario(Integer idUsuario){

        Connection conn = null;
        PreparedStatement ps = null;

        try{
            conn = ConnectionFactory.obtemConexao();
            String sql = "delete from usuarios where idUsuarios = ?";
            ps = conn.prepareStatement (sql);
            ps.setInt(1, idUsuario);
            ps.execute();

        }catch (SQLException e){
            e.printStackTrace();
        }
        finally{
            try{
                ps.close();
                conn.close();
            }
            catch (SQLException e){
                e.printStackTrace();
            }
        }

    }

    public UsuarioEntity logar(UsuarioEntity usuario){

        UsuarioEntity user = new UsuarioEntity();

        Connection conn = null;
        PreparedStatement ps = null;
        try{
            conn = ConnectionFactory.obtemConexao();
            String sql = "select idUsuarios, usuario, dataInsercao, gerenciaProjetos from usuarios where usuario = ? and senha = md5(?);";
            ps = conn.prepareStatement (sql);
            ps.setString(1,usuario.getUsuario());
            ps.setString(2, usuario.getSenha());
            ps.execute();

            ResultSet rs = ps.getResultSet();

            if(rs.next()){
                user.setIdUsuario(rs.getInt(1));
                user.setUsuario(rs.getString(2));
                user.setDataInsercao(rs.getString(3));
                user.setGerenciaProjetos(rs.getInt(4));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }



        return user;
    }

}
