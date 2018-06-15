package tis.bhaw.servlet;
import tis.bhaw.Classes.*;
import tis.bhaw.DataAccessObject.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cadastrarUsuario")
public class cadastrarUsuarioServlet extends HttpServlet{
	
	protected void service(HttpServletRequest request, HttpServletResponse response) 
	throws IOException, ServletException {
		
		PrintWriter saida = response.getWriter();
		
		String cpf = request.getParameter("boxCPF");
		String nome = request.getParameter("boxNome");
		String email = request.getParameter("boxEmail");
		String telefone = request.getParameter("boxTelefone");
		String senha = request.getParameter("boxSenha");
		String senhaConf = request.getParameter("boxSenhaConf");
		
		System.out.println("Aqui" + Integer.toString(cpf.length()));
				
		if(cpf.length()==11) {
			
			System.out.println("Aqui 2");
			Usuario u = new Usuario();
			u.setCpf(cpf);
			u.setNome(nome);
			u.setEmail(email);
			u.setSenha(senha);
			u.setTelefone(telefone);
			
			try {
				DataAccessObjectUsuario dao = new DataAccessObjectUsuario();
				dao.adicionaUsuario(u);
				
				saida.println("<html>");
				saida.println("<body>");
				saida.println("Usuário " + u.getNome() + " cadastrado com sucesso!");
				saida.println("</body>");	        
				saida.println("</html>");
				
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
		}
		
		
		
		

		
		
		
		
		
		
	}
	
	
}
