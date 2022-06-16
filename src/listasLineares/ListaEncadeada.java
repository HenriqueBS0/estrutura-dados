package listasLineares;
public class ListaEncadeada<T> {
	private Nodo<T> inicio;
	
	public ListaEncadeada() {
	}
	
	public ListaEncadeada(T dado) {
		inicio = new Nodo<T>(dado);
	}
	
	public Nodo<T> getInicio() {
		return inicio;
	}
	
	public void inserirInicio(T dado) {
		Nodo<T> nodo = new Nodo<T>(dado);
		nodo.setProximo(inicio);
		inicio = nodo;
	}
	
	public void inserirFinal(T dado) {
		Nodo<T> nodo = new Nodo<T>(dado);
		
		if(this.getUltimoNodo() == null) {
			inicio = nodo;
			return;
		}
		
		this.getUltimoNodo().setProximo(nodo);
	}
	
	public void deletarInicio() {
		if(inicio == null) return;
		inicio = inicio.getProximo();
	}
	
	public void deletarFinal() {
		if(inicio == null) return;
		
		if(inicio.getProximo() == null) {
			inicio = null;
			return;
		}
		
		Nodo<T> nodo = inicio;
				
		while(nodo.getProximo().getProximo() != null) {
			nodo = nodo.getProximo();
		}
		
		nodo.setProximo(null);
	}
	
	public String mostraLista() {
		String lista = "";
		Nodo<T> nodo = inicio;
		
		while(nodo != null) {
			lista+= nodo.getDado() + "\n";
			nodo = nodo.getProximo();
		}
		
		return lista;
	}
	
	public void deleteComDado(T dado) {
		if(inicio == null) return;
		
		if(inicio.getDado() == dado) {
			inicio = inicio.getProximo();
			return;
		}
		
		Nodo<T> nodo = inicio;
		
		while(nodo.getProximo() != null) {
			if(nodo.getProximo().getDado() == dado) {
				nodo.setProximo(nodo.getProximo().getProximo());
				return;
			}
			
			nodo = nodo.getProximo();
		}
	}
	
	
	public int contaNodos() {
		int numeroNodos = 0;
		
		Nodo<T> nodo = inicio;
		
		while(nodo != null) {
			numeroNodos++;
			nodo = nodo.getProximo();
		}
		
		return numeroNodos;
	}
	
	public Nodo<T> getUltimoNodo() {
		if(inicio == null) return inicio;
		
		Nodo<T> nodo = inicio;
		
		while(nodo.getProximo() != null) { 
			nodo = nodo.getProximo();
		}
		
		return nodo;
	}
	
	public int getPosicaoDado(T dado) {		
		int posicao = 1;
		
		Nodo<T> nodo = inicio;
		
		while(nodo != null) {
			if(nodo.getDado() == dado) {
				return posicao;
			}
			
			posicao++;
			nodo =nodo.getProximo();
		}
		
		return 0;
	}
}
