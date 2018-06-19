package tis.bhaw.DataAccessObject;
import tis.bhaw.Classes.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import com.mysql.jdbc.PreparedStatement;

public class DataAccessObjectVenda {
	
	private Connection connection;
	
	public DataAccessObjectVenda() throws SQLException, ClassNotFoundException {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void adicionaVenda(Venda venda) {
		
		try {
			
			String query = "insert into venda" + 
	                "(produto_id, vendedor_id, usuario_id)" +
	                "values (?, ?, ?)";
	 
			PreparedStatement stmtQuery = (PreparedStatement) connection.prepareStatement(query);
	 
			stmtQuery.setInt(1, venda.getProduto());
			stmtQuery.setString(2, venda.getVendedor());
			stmtQuery.setString(3, venda.getUsuario());
			
			stmtQuery.execute();
			stmtQuery.close();
			
			
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	
	}

	public List<Venda> getListVenda(){
		try {
			List<Venda> listaVenda = new ArrayList<Venda>();
			PreparedStatement stmtQuery = (PreparedStatement) this.connection.prepareStatement("select * from venda");
			
			ResultSet resulQuery = stmtQuery.executeQuery();
			
			while(resulQuery.next()) {
				Venda v = new Venda();
			
				v.setId(resulQuery.getInt("venda_id"));
				v.setProduto(resulQuery.getInt("produto_id"));
				v.setUsuario(resulQuery.getString("usuario_id"));
				v.setVendedor(resulQuery.getString("vendedor_id"));
				v.setStatus(resulQuery.getString("venda_status"));
				listaVenda.add(v);
				
			}
			
			resulQuery.close();
			stmtQuery.close();
			
			return listaVenda;
	
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public List<Venda> getListVendaUser(String usuario_id){
		try {
			List<Venda> listaVenda = new ArrayList<Venda>();
			PreparedStatement stmtQuery = (PreparedStatement) this.connection.prepareStatement("select * from venda where usuario_id=" + usuario_id + " or vendedor_id=" + usuario_id);
			
			ResultSet resulQuery = stmtQuery.executeQuery();
			
			while(resulQuery.next()) {
				Venda v = new Venda();
			
				v.setId(resulQuery.getInt("venda_id"));
				v.setProduto(resulQuery.getInt("produto_id"));
				v.setUsuario(resulQuery.getString("usuario_id"));
				v.setVendedor(resulQuery.getString("vendedor_id"));
				v.setStatus(resulQuery.getString("venda_status"));
				listaVenda.add(v);
				
			}
			
			resulQuery.close();
			stmtQuery.close();
			
			return listaVenda;
	
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}


	public void alterarVenda(Venda venda) {
			
			try {
				
				String query = "update produto set "
		                + "produto_id = ?, "
		                + "vendedor_id = ?, "
		                + "usuario_id = ?,  "
		                + "venda_status = ?, "
		                + "where venda_id = ? ";
		 
				PreparedStatement stmtQuery = (PreparedStatement) connection.prepareStatement(query);
		 	
				stmtQuery.setInt(1, venda.getProduto());
				stmtQuery.setString(2, venda.getVendedor());
				stmtQuery.setString(3, venda.getUsuario());
				stmtQuery.setString(4, venda.getStatus());	
				stmtQuery.setInt(5, venda.getId());
				
	
				stmtQuery.execute();
				stmtQuery.close();
				
				
			}catch (SQLException e) {
				throw new RuntimeException(e);
			}
					
		}

	

}
