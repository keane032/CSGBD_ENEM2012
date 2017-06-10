package Menu;

import java.sql.SQLException;
import java.util.Scanner;

import ModeloDAO.InscritoDAO;

public class MenuAplicacao {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
	
		int acao = -1;
		InscritoDAO dao = new InscritoDAO();
		
		Scanner sc = new Scanner(System.in);

		while (acao != 0) {
		
		System.out.println("0-sair");
		System.out.println("1-consulta sem index");
		System.out.println("2-consuta forcada ");
		System.out.println("3-limpar cache");
		System.out.println("4-explain");
		

		acao = sc.nextInt();
		
		
		switch (acao) {
		case 0:
			
			break;
		case 1:
			dao.select();
			break;
		case 2:
			dao.Findex();
			break;
		case 3:
			dao.clearCache();
			break;
		case 4:
			dao.explain();
			break;
		default:
			break;
		}
		
		
		}
	}
}
