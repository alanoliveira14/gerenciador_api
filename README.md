# gerenciador_api

Para conectar ao BD, é necessário criar o pacote database e a classe ConnectionFactory dentro dele, com o código abaixo:


package br.com.docapi.database;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class ConnectionFactory{
	
	//bloco inicializador estático
	static {
		try{
			Class.forName ("com.mysql.jdbc.Driver");
		}
		catch (ClassNotFoundException e){
			e.printStackTrace();
		}		
	}

	public static Connection obtemConexao () throws SQLException {
		Connection c = DriverManager.getConnection ("jdbc:mysql://stringConexao", "nomeDoBanco", "senha");
		return c;		
	}
}
