package br.com.docapi.dao;

import br.com.docapi.database.ConnectionFactory;
import br.com.docapi.entity.ColaboradorEntity;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Component
public class ColaboradorDAO {

    public void inserirColaborador(ColaboradorEntity colaborador){

        Connection conn = null;
        PreparedStatement ps = null;
        String retorno = "";
        String nome = null;
        Integer id = 0;

        try{
            conn = ConnectionFactory.obtemConexao();
            String sql = "insert into colaboradores(nome, email, dataNascimento, cpf) values(?,?,?,?);";
            ps = conn.prepareStatement (sql);
            ps.setString(1, colaborador.getNome());
            ps.setString(2, colaborador.getEmail());
            ps.setString(3, colaborador.getDataNascimento());
            ps.setString(4, colaborador.getCPF());
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

}
