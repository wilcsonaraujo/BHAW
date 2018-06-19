package tis.bhaw.DataAccessObject;
import tis.bhaw.Classes.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import com.mysql.jdbc.PreparedStatement;

public class DataAccessObjectProduto {
	
	private Connection connection;
	
	public DataAccessObjectProduto() throws SQLException, ClassNotFoundException {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void adicionaProduto(Produto produto) {
		
		try {
			
			String query = "insert into produto" + 
	                "(produto_nome, produto_preco, produto_quantidade, produto_descricao)" +
	                "values (?, ?, ?, ?)";
	 
			PreparedStatement stmtQuery = (PreparedStatement) connection.prepareStatement(query);
	 
			stmtQuery.setString(1, produto.getNome());
			stmtQuery.setFloat(2, produto.getPreco());
			stmtQuery.setInt(3, produto.getQuantidade());
			stmtQuery.setString(4, produto.getDescricao());

			stmtQuery.execute();
			stmtQuery.close();
			
			
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	
	}

	public List<Produto> getListaProduto(){
		try {
			List<Produto> listaProdutos = new ArrayList<Produto>();
			PreparedStatement stmtQuery = (PreparedStatement) this.connection.prepareStatement("select * from produto");
			
			ResultSet resulQuery = stmtQuery.executeQuery();
			
			while(resulQuery.next()) {
				Produto p = new Produto();
				
				p.setId(resulQuery.getInt("produto_id"));
				p.setNome(resulQuery.getString("produto_nome"));
				p.setPreco(resulQuery.getFloat("produto_preco"));
				p.setQuantidade(resulQuery.getInt("produto_quantidade"));
				p.setDescricao(resulQuery.getString("produto_descricao"));
				p.setAtivo(resulQuery.getString("produto_ativo"));
				p.setStatus(resulQuery.getString("produto_status"));
							
				
				listaProdutos.add(p);
				
			}
			
			resulQuery.close();
			stmtQuery.close();
			
			return listaProdutos;
	
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Produto buscarProduto(String id) {

		if(id.matches("[A-Z]*")) return null;
		
				
		try {
			Produto p = new Produto();
			
			PreparedStatement stmtQuery = (PreparedStatement) this.connection.prepareStatement("select * from produto where produto_id=" + id);
			
			ResultSet resulQuery = stmtQuery.executeQuery();
			
			while(resulQuery.next()) {
								
				p.setId(resulQuery.getInt("produto_id"));
				p.setNome(resulQuery.getString("produto_nome"));
				p.setPreco(resulQuery.getFloat("produto_preco"));
				p.setQuantidade(resulQuery.getInt("produto_quantidade"));
				p.setDescricao(resulQuery.getString("produto_descricao"));
				p.setAtivo(resulQuery.getString("produto_ativo"));
				p.setStatus(resulQuery.getString("produto_status"));
							
			}
			
			resulQuery.close();
			stmtQuery.close();
			
			if(p!=null) {
				p.setClick(p.getClick() + 1);
				alterarProduto(p);
			}
			
			return p;

		
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void alterarProduto(Produto produto) {
			
			try {
				
				String query = "update produto set "
                        + "produto_nome = ?, "
		                + "produto_preco = ?, "
		                + "produto_quantidade = ?, "
		                + "produto_descricao = ?,  "
		                + "produto_ativo = ?, "
		                + "produto_status = ? "
		                + "where produto_id = ? ";
		 
				PreparedStatement stmtQuery = (PreparedStatement) connection.prepareStatement(query);
		 
				stmtQuery.setString(1, produto.getNome());
				stmtQuery.setFloat(2, produto.getPreco());
				stmtQuery.setInt(3, produto.getQuantidade());
				stmtQuery.setString(4, produto.getDescricao());
				stmtQuery.setString(5, produto.getAtivo());
				stmtQuery.setString(6, produto.getStatus());
				stmtQuery.setInt(7, produto.getId());
				
	
				stmtQuery.execute();
				stmtQuery.close();
				
				
			}catch (SQLException e) {
				throw new RuntimeException(e);
			}
					
		}

	public void excluirProduto(Produto produto) {
		
		try {
			
			String query = "update produto set "
	                + "produto_ativo = ?, "
	                + "produto_status = ? "
	                + "where produto_id = ? ";
	 
			PreparedStatement stmtQuery = (PreparedStatement) connection.prepareStatement(query);
	 
			stmtQuery.setString(1, "n");
			stmtQuery.setString(2, "indisponivel");
			stmtQuery.setInt(3, produto.getId());
			

			stmtQuery.execute();
			stmtQuery.close();
			
			
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
	

}
