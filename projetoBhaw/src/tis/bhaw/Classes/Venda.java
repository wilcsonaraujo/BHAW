package tis.bhaw.Classes;

public class Venda {
	
	private int id;
	private int produto;
	private String usuario;
	private String vendedor;
	private String status;

	public Venda () {}
	
	public Venda (Produto produto, Usuario usuario, Usuario vendedor) {
		
		this.setProduto(produto.getId());
		this.setUsuario(usuario.getCpf());
		this.setVendedor(vendedor.getCpf());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProduto() {
		return produto;
	}

	public void setProduto(int produto) {
		this.produto = produto;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getVendedor() {
		return vendedor;
	}

	public void setVendedor(String vendedor) {
		this.vendedor = vendedor;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	




}

	
