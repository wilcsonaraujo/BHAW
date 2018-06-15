package tis.bhaw.Classes;

public class Venda {
	
	private int id;
	private Produto produto;
	private Usuario usuario;
	private Usuario vendedor;

	public Venda () {}
	
	public Venda (Produto produto, Usuario usuario, Usuario vendedor ) {
		this.setProduto(produto);
		this.setUsuario(usuario);
		this.setVendedor(vendedor);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Usuario getVendedor() {
		return vendedor;
	}

	public void setVendedor(Usuario vendedor) {
		this.vendedor = vendedor;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	
	
}
