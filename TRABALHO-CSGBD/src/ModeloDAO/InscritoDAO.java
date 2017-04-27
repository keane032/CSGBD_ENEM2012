package ModeloDAO;

import java.sql.Connection;

import JDBC.ConnectionFactory;
import Modelo.Inscrito;

public class InscritoDAO {

	
	private Connection connection;
	
	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	 
	   public InscritoDAO() throws ClassNotFoundException {
		// TODO Auto-generated constructor stub
		   this.connection = new ConnectionFactory().getConnection();
	   }
	   
	
	

	public void adicionar(Inscrito inscrito){
		String sql = "insert into contatos " +
	             "()" +
	             " values ()";

		
		
		
	}
	public void remover(){
		
	}
	public void atualizar(){
		
	}
}
