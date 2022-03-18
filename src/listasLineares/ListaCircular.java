package listasLineares;

public class ListaCircular<T> {
	private Nodo<T> inicio;
	private Nodo<T> fim;
	
	public ListaCircular(T dado) {
		Nodo<T> nodo = new Nodo<T>(dado);
		inserirPrimeiroElemento(nodo);
	}
	
	public void inserirInicio(T dado) {
		Nodo<T> nodo = new Nodo<T>(dado);
		
		if(inicio == null) {
			inserirPrimeiroElemento(nodo);
			return;
		}
		
		nodo.setProximo(inicio);
		inicio = nodo;
		fim.setProximo(inicio);
	}
	
	private void inserirPrimeiroElemento(Nodo<T> nodo) {
		inicio = nodo;
		inicio.setProximo(inicio);
		fim = inicio;
		return;
	}
	
	public String mostraLista() {
		if(inicio == null) return "";
		
		String lista = "";
		
		Nodo<T> nodo = inicio;
		
		do {
			lista += nodo.getDado() + "\n";
			nodo = nodo.getProximo();
		}
		while(nodo != inicio);
		
		return lista;
	}
	
	public void deletarPeloValor(T valor) {
		if(inicio == null) return;
		
		if(inicio.getDado() == valor) {
			if(inicio == fim) {
			   inicio = null;
			   return;
			}
			
			inicio = inicio.getProximo();
			fim.setProximo(inicio);
			return;
		}
		
		Nodo<T> nodo = inicio;
		
		do {
			if(nodo.getProximo().getDado() == valor) {
				nodo.setProximo(nodo.getProximo().getProximo());
				return;
			}
			
			nodo = nodo.getProximo();
		} while(nodo != inicio);
	}
}
