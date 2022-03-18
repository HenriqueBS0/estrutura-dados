package listasLineares;

public class Pilha<T> {
	private Nodo<T> topo;
	private int tamanho = 0;
	private int limite = 0;
	
	public Pilha(int limite) {
		this.limite = limite;
	}
	
	public boolean estaVazia() {
		return tamanho == 0;
	}
	
	public boolean temEspaco() {
		return tamanho < limite;
	}
	
	public void push(T dado) {
		if(!temEspaco()) {
			System.out.println("Pilha Cheia");
			return;
		}
		
		Nodo<T> nodo = new Nodo<T>(dado);		
		nodo.setProximo(topo);		
		topo = nodo;		
		tamanho++;
	}
	
	public void pop() {
		if(estaVazia()) return;
		
		tamanho--;
		
		if(topo.getProximo() == null) {
			topo = null;
			return;
		}
		
		topo = topo.getProximo();
	}
	
	public String mostraPilha() {
		if(estaVazia()) return "";
		
		String pilha = "";
		
		Nodo<T> nodo = topo;
		
		do {
			pilha += nodo.getDado() + "\n";
			nodo = nodo.getProximo();
		}
		while(nodo != null);
		
		return pilha;
	}
	
	public Nodo<T> getTopo() {
		return topo;
	}
}