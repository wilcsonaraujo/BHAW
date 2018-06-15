<%@page import="java.util.List"%>
<%@page import="tis.bhaw.DataAccessObject.DataAccessObjectProduto"%>
<%@page import="tis.bhaw.DataAccessObject.DataAccessObjectUsuario"%>
<%@page import="tis.bhaw.Classes.Produto" %>

<html>
	<body>
		<table>
		
		<% 
		DataAccessObjectProduto daoProduto  = new DataAccessObjectProduto();
        List<Produto> listaProdutos = daoProduto.getListaProduto();
           
        for(Produto p: listaProdutos){ 
        %>   
        	<tr>
	        	<td><%= p.getNome() %>  </td>
	        	<td><%=p.getPreco() %>  </td>
	        	<td><%= p.getQuantidade() %>  </td>
        	</tr>
        <% } %>
       
       
	
	
		</table>
	</body>
</html>