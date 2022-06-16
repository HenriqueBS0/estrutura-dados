package listasLineares;

public class Fila<T> {
	private Nodo<T> inicio;
	private Nodo<T> fim;
	
	private int limite = 0;
	private int tamanho = 0;

	public Fila(int limite) {
		this.limite = limite;
	}
	
	public int getTamanho() {
		return tamanho;
	}
	
	public boolean temEspaco() {
		return tamanho < limite;
	}
	
	public boolean estaVazio() {
		return tamanho == 0; 
	}
	
	public void inserir(T dado) {
		if(!temEspaco()) {
			System.out.println("Fila Cheia");
			return;
		}
		
		Nodo<T> nodo = new Nodo<T>(dado);
		
		if(estaVazio()) { 
			inicio = nodo;
		}
		else { 
			fim.setProximo(nodo);
		}
		
		fim = nodo;
		
		tamanho++;

	}
	
	public void remover() {
		if(tamanho == 0) return;
		
		if(getTamanho() == 1) {
			inicio = null;
			fim = null;
			tamanho--;
			return;
		}
		
		
		inicio = inicio.getProximo();
		
		tamanho--;
	}
	
	public T getInicio() {
		if(estaVazio()) {
			System.out.println("Fila está vazia");
			return null;
		};
		return inicio.getDado();
	}
}
