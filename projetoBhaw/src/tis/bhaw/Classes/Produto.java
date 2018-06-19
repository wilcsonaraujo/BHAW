package tis.bhaw.Classes;

public class Produto {
	
	private String nome = "";
	private float preco = (float) 0.0;
	private int quantidade = 0;
	private String descricao ="";
	private int id;
	private String ativo;
	private String status;
	private int click;
	
	public Produto() {}
	
	public Produto(String nome, float preco, int quantidade, String descricao) {		
		this.nome = nome;
		this.preco = preco;
		this.quantidade = quantidade;
		this.descricao = descricao;	
	}
	
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	
	public void setPreco(float preco) {
		this.preco = preco;
	}
	
	public float getPreco() {
		return this.preco;
	}
	
	
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public int getQuantidade() {
		return this.quantidade;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
	
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}

	public String getAtivo() {
		return ativo;
	}

	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getClick() {
		return click;
	}

	public void setClick(int click) {
		this.click = click;
	}
	
	
	
	
	
	
	

}
