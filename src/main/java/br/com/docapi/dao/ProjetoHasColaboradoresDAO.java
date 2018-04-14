package br.com.docapi.dao;

import br.com.docapi.database.ConnectionFactory;
import br.com.docapi.entity.ProjetoHasColaboradoresEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProjetoHasColaboradoresDAO {

    public void inserirColab_Projeto(ProjetoHasColaboradoresEntity projetoColab) {

        Connection conn = null;
        PreparedStatement ps = null;

        try{
            conn = ConnectionFactory.obtemConexao();
            String sql = "insert into projeto_has_colaboradores(fkIdColaborador, fkIdProjeto) values(?,?);";
            ps = conn.prepareStatement (sql);
            ps.setInt(1, projetoColab.getIdColaborador());
            ps.setInt(2, projetoColab.getIdProjeto());


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
