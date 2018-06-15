package tis.bhaw.DataAccessObject;
import tis.bhaw.Classes.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import com.mysql.jdbc.PreparedStatement;

public class DataAccessObjectUsuario {
	
	private Connection connection;
	
	public DataAccessObjectUsuario() throws SQLException, ClassNotFoundException {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void adicionaUsuario(Usuario usuario) {
		
		try {
			
			String query = "insert into usuario" + 
	                "(usuario_cpf, usuario_nome, usuario_telefone, usuario_email, usuario_senha)" +
	                "values (?, ?, ?, ?, ?)";
	 
			PreparedStatement stmtQuery = (PreparedStatement) connection.prepareStatement(query);
	 
			stmtQuery.setString(1, usuario.getCpf());
			stmtQuery.setString(2, usuario.getNome());
			stmtQuery.setString(3, usuario.getTelefone());
			stmtQuery.setString(4, usuario.getEmail());
			stmtQuery.setString(5, usuario.getSenha());
			
			stmtQuery.execute();
			stmtQuery.close();
			
			
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	
	}

	public List<Usuario> getListaUsuario(){
		try {
			List<Usuario> listaUsuario = new ArrayList<Usuario>();
			PreparedStatement stmtQuery = (PreparedStatement) this.connection.prepareStatement("select * from usuario");
			
			ResultSet resulQuery = stmtQuery.executeQuery();
			
			while(resulQuery.next()) {
				Usuario u = new Usuario();
			
				u.setCpf(resulQuery.getString("usuario_cpf"));
				u.setNome(resulQuery.getString("usuario_nome"));
				u.setTelefone(resulQuery.getString("usuario_telefone"));
				u.setEmail(resulQuery.getString("usuario_email"));
				u.setSenha(resulQuery.getString("usuario_senha"));

				listaUsuario.add(u);
				
			}
			
			resulQuery.close();
			stmtQuery.close();
			
			return listaUsuario;
	
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Usuario buscarUsuario(String cpf) {

		if(cpf.matches("[A-Z]*") ) return null;
		
				
		try {
			Usuario u = new Usuario();
			
			PreparedStatement stmtQuery = (PreparedStatement) this.connection.prepareStatement("select * from usuario where usuario_cpf=" + cpf);
			
			ResultSet resulQuery = stmtQuery.executeQuery();
			
			while(resulQuery.next()) {
			
				u.setCpf(resulQuery.getString("usuario_cpf"));
				u.setNome(resulQuery.getString("usuario_nome"));
				u.setTelefone(resulQuery.getString("usuario_telefone"));
				u.setEmail(resulQuery.getString("usuario_email"));
				u.setSenha(resulQuery.getString("usuario_senha"));
							
			}
			
			resulQuery.close();
			stmtQuery.close();
			
			return u;

		
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void alterarUsuario(Usuario usuario) {
			
			try {
				
				String query = "update produto set "
		                + "usuario_nome = ?, "
		                + "usuario_telefone = ?, "
		                + "usuario_email = ?,  "
		                + "usuario_senha = ?, "
		                + "where usuario_cpf = ? ";
		 
				PreparedStatement stmtQuery = (PreparedStatement) connection.prepareStatement(query);
		 
			
				stmtQuery.setString(1, usuario.getNome());
				stmtQuery.setString(2, usuario.getTelefone());
				stmtQuery.setString(3, usuario.getEmail());
				stmtQuery.setString(4, usuario.getSenha());	
				stmtQuery.setString(5, usuario.getCpf());
				
	
				stmtQuery.execute();
				stmtQuery.close();
				
				
			}catch (SQLException e) {
				throw new RuntimeException(e);
			}
					
		}

	public void excluirUsuario(Usuario usuario) {
		
		try {
			
			String query = "update usuario set "
	                + "usuario_ativo = ? "
	                + "where usuario_cpf = ? ";
	 
			PreparedStatement stmtQuery = (PreparedStatement) connection.prepareStatement(query);
	 
			stmtQuery.setString(1, "n");
			stmtQuery.setString(2, usuario.getCpf());
		
			

			stmtQuery.execute();
			stmtQuery.close();
			
			
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
	

}
