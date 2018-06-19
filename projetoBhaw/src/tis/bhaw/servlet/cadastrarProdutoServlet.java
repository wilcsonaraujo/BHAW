package tis.bhaw.servlet;
import tis.bhaw.Classes.Produto;
import tis.bhaw.DataAccessObject.DataAccessObjectProduto;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cadastrarProduto")
public class cadastrarProdutoServlet extends HttpServlet{	
	protected void service(HttpServletRequest request, HttpServletResponse response) 
	throws IOException, ServletException {
		
		PrintWriter saida = response.getWriter();
			
		String nome = request.getParameter("boxNome");
		String preco = request.getParameter("boxPreco");
		String quantidade = request.getParameter("boxQuantidade");
		String descricao = request.getParameter("boxDescricao");
		
				
		if(nome.length()>0) {
			
			System.out.println("Aqui 2");
			Produto u = new Produto();
			u.setNome(nome);
			u.setPreco(Float.parseFloat(preco));
			u.setQuantidade(Integer.parseInt(quantidade));
			u.setDescricao(descricao);
			
			
			try {
				DataAccessObjectProduto dao = new DataAccessObjectProduto();
				dao.adicionaProduto(u);
				
				saida.println("<html>");
				saida.println("<body>");
				saida.println("Produto " + u.getNome() + " cadastrado com sucesso!");
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
