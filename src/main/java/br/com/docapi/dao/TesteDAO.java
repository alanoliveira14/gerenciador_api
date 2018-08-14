package br.com.docapi.dao;

import br.com.docapi.database.ConnectionFactory;
import org.springframework.stereotype.Component;

import java.sql.*;
@Component
public class TesteDAO {
    public String listar(){

        String retorno = "";
        String nome = null;
        Integer id = 0;
        String sql = "select * from teste limit 1;";

        try(Connection conn = ConnectionFactory.obtemConexao();
            PreparedStatement ps = conn.prepareStatement (sql);
        ){


            ps.execute();

            try(ResultSet rs = ps.getResultSet();) {

                if (rs.next()) {
                    nome = rs.getString(2);
                    id = rs.getInt(1);
                    retorno = nome + "-" + id;
                }
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return retorno;
    }

}
