package tis.bhaw.servlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/oi")
public class OiMundo extends HttpServlet {
	protected void service (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        PrintWriter out = response.getWriter();
	        
	// escreve o texto
	        out.println("<html>");
	        out.println("<body>");
	        out.println("Teste");
	        out.println("</body>");	        
	        out.println("</html>");
	    }
}