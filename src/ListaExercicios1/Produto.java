package ListaExercicios1;

public class Produto {
	private int codigo;
	private float preco;
	private int quantidadeEstoque;
	
	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public float getPreco() {
		return preco;
	}
	
	public float getPrecoComDesconto(float desconto) {
		return preco * (1 - (desconto / 100));
	}
	
	public void setPreco(float preco) {
		this.preco = preco;
	}
	
	public int getQuantidadeEstoque() {
		return quantidadeEstoque;
	}
	
	public void setQuantidadeEstoque(int quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}
	
	
}
