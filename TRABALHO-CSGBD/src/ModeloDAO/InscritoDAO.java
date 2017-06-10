package ModeloDAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import JDBC.ConnectionFactory;

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
	
	   
	   public static void clearCache() {
			Scanner sc = new Scanner(System.in);
			Runtime run = Runtime.getRuntime();
			System.out.println("Digite a senha do root do seu sistema operacional");
			String pass = sc.nextLine();	// senha do root para fazer a limpeza do cache
			try {
				run.exec("sudo su \r\n"+pass+"\r\n echo 3 > /proc/sys/vm/drop_caches \r\n service postgresql restart");
				System.out.println("Caches limpa");
			} catch (IOException e) {
				System.err.println("Erro ao Limpar as Caches");
			}
			
		}

	   
	   
	  public void Findex() throws SQLException{
			PreparedStatement stmt = this.connection
				        .prepareStatement("set enable_seqscan = false; explain analyse SELECT * from inscritos where ano_concluiu = '2010';");
			 
			 long inicial = System.currentTimeMillis();
			 ResultSet rs = stmt.executeQuery();		
			 long fim = System.currentTimeMillis();

			 
			 System.out.println(fim-inicial+" mili com index");
			 
			 	while (rs.next()) {
			 		System.out.println(rs.getObject(1));
			 	}

			 
			System.out.println("");
			 
	   }
	   
	   
	   public void explain() throws SQLException{
		 //consulta com expliain		 	 
		   PreparedStatement stmt = this.connection
				        .prepareStatement("explain analyse SELECT * from inscritos where ano_concluiu = '2010';");
			 
			long inicial = System.currentTimeMillis();
			ResultSet rs = stmt.executeQuery();		
			long fim = System.currentTimeMillis();

			 
			 System.out.println(fim-inicial+" mili com index");
			 
	 while (rs.next()) {
			System.out.println(rs.getObject(1));
	}
	   }
	
	   
	public void select() throws SQLException, ClassNotFoundException{		
		//consulta sem index
				PreparedStatement stmt = this.connection
		        .prepareStatement("SELECT * from inscritos where ano_concluiu = '2010';");
		
				long inicial = System.currentTimeMillis();
				ResultSet rs = stmt.executeQuery();		
				long fim = System.currentTimeMillis();
				System.out.println(fim-inicial+" mili sem index");
				System.out.println("");
		
//		//create index 
//		stmt = this.connection
//				        .prepareStatement("create index index1 on inscritos using hash(ano_concluiu);");
//				
//				 inicial = System.currentTimeMillis();
//				 stmt.executeUpdate();		
//				 fim = System.currentTimeMillis();
//				 
//				 System.out.println(fim-inicial+" mili cria index");
//				 
//		System.out.println("");
//					
//		clearCache();
//		
//
//
//		 
//
//		// drop index
//		 		
//		 stmt = this.connection
//			        .prepareStatement("drop index index1;");
//
//		 		stmt.executeUpdate();
//		 		
//		 		System.out.println("Foi :)");
//				 
//		rs.close();
//		stmt.close();
		
	}
	
}
