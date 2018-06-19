package tis.bhaw.Main;
import java.sql.SQLException;
import java.util.List;

import tis.bhaw.Classes.Venda;
import tis.bhaw.DataAccessObject.DataAccessObjectLogin;
import tis.bhaw.DataAccessObject.DataAccessObjectVenda;

public class Main {
	
	
	public static void testeLogin() throws ClassNotFoundException, SQLException {
		DataAccessObjectLogin dao = new DataAccessObjectLogin();
		dao.buscarUsuario("11111111111", "12345");

	}
	
	public static void listaVendas() throws ClassNotFoundException, SQLException {
		DataAccessObjectVenda dao = new DataAccessObjectVenda();
		List<Venda> listaVenda = dao.getListVenda();
		
		for (Venda venda: listaVenda) {
			System.out.println("ID VENDA: " + String.valueOf(venda.getId()));
			System.out.println("ID PRODUTO: " + String.valueOf(venda.getProduto()));
			System.out.println("ID USUÁRIO: " + venda.getUsuario() );
			System.out.println("ID VENDEDOR: " + venda.getVendedor());
			System.out.println("STATUS: " + venda.getStatus() + "\n\n");
		}
	}
	
	public static void listaVendasUser() throws ClassNotFoundException, SQLException {
		DataAccessObjectVenda dao = new DataAccessObjectVenda();
		List<Venda> listaVenda = dao.getListVendaUser("11111111111");
		
		for (Venda venda: listaVenda) {
			System.out.println("ID VENDA: " + String.valueOf(venda.getId()));
			System.out.println("ID PRODUTO: " + String.valueOf(venda.getProduto()));
			System.out.println("ID USUÁRIO: " + venda.getUsuario() );
			System.out.println("ID VENDEDOR: " + venda.getVendedor());
			System.out.println("STATUS: " + venda.getStatus() + "\n\n");
		}
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		testeLogin();
		listaVendas();
		listaVendasUser();

	}

}
