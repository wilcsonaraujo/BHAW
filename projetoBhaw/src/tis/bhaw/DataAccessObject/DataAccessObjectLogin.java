package tis.bhaw.DataAccessObject;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.jdbc.PreparedStatement;
import tis.bhaw.Classes.Usuario;

public class DataAccessObjectLogin {
	
	
	private Connection connection;
	
	public DataAccessObjectLogin() throws SQLException, ClassNotFoundException {
		this.connection = new ConnectionFactory().getConnection();
	}

	
	public void buscarUsuario(String cpf, String senha) {

		if(cpf.matches("[A-Z]*") || (senha.length() > 8 || senha.length() < 0) ) ;
		
				
		try {
			Usuario u = new Usuario();
			
			PreparedStatement stmtQuery = (PreparedStatement) this.connection.prepareStatement("select * from usuario where usuario_cpf=" + cpf + " and usuario_senha=" + senha);
			
			ResultSet resulQuery = stmtQuery.executeQuery();
			
			System.out.println(resulQuery);
			
			while(resulQuery.next()) {
			
				u.setCpf(resulQuery.getString("usuario_cpf"));
				u.setNome(resulQuery.getString("usuario_nome"));
				u.setTelefone(resulQuery.getString("usuario_telefone"));
				u.setEmail(resulQuery.getString("usuario_email"));
				u.setSenha(resulQuery.getString("usuario_senha"));
							
			}
			
			resulQuery.close();
			stmtQuery.close();
			
			System.out.println(u.getNome());

		
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	
	
}
