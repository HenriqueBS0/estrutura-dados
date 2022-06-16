package ListaExercicios1;

import listasLineares.ListaCircular;
import listasLineares.Nodo;

public class Exercicio02 {
	
	public static void main(String[] args) {
		System.out.println(relatorio(getProdutos(), Entrada.getFloat("Informe a taxa de desconto")));
	}
	
	private static ListaCircular<Produto> getProdutos() {
		
		boolean cadastrarProduto = true;
		
		ListaCircular<Produto> produtos = new ListaCircular<Produto>();
		
		while(cadastrarProduto) {
			Produto produto = new Produto(); 
			produto.setCodigo(Entrada.getInt("Informe o código: "));
			produto.setPreco(Entrada.getFloat("Informe o preço: "));
			produto.setQuantidadeEstoque(Entrada.getInt("Informe a quantidade em estoque: "));
			
			produtos.inserirInicio(produto);

			cadastrarProduto = Entrada.getString("Cadastrar mais um produto? (S|N)").equals("S");
		}
		
		return produtos;
	}
	
	private static String relatorio(ListaCircular<Produto> produtos, float taxaDesconto) {
		return getDescontosProdutos(produtos, taxaDesconto) + getQuantidadeEstoqueProdutosComMaisDe100(produtos);
	}
	
	private static String getDescontosProdutos(ListaCircular<Produto> produtos, float taxaDesconto) {
		String descontos = "Produtos com desconto: \n";
		
		Nodo<Produto> nodo = produtos.getInicio();
		
		do {
			Produto produto = nodo.getDado();
			descontos = descontos.concat(produto.getCodigo() + " - " + produto.getPrecoComDesconto(taxaDesconto) + "\n");
			nodo = nodo.getProximo();
		} while (nodo != produtos.getInicio());
		
		return descontos;
	}
	
	private static String getQuantidadeEstoqueProdutosComMaisDe100(ListaCircular<Produto> produtos) {		
		String quantidades = "Estoque dos produtos com mais de 100 de estoque: \n";
		
		Nodo<Produto> nodo = produtos.getInicio();
		
		do {
			Produto produto = nodo.getDado(); 
			if(produto.getQuantidadeEstoque() > 100) {
				quantidades = quantidades.concat(produto.getCodigo() + " - " + produto.getQuantidadeEstoque() + "\n");
			}
			nodo = nodo.getProximo();
		} while (nodo != produtos.getInicio());
		
		return quantidades;
	}
}
