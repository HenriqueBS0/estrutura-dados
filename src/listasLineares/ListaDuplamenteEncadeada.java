package listasLineares;

public class ListaDuplamenteEncadeada<T> {
	private Nodo<T> inicio = null;
	private Nodo<T> fim = null;
	
	public void inserirInicio(T dado) {
		Nodo<T> nodo = new Nodo<T>(dado);
		
		if(inicio != null) {
			inicio.setAnterior(nodo);
			nodo.setProximo(inicio);
		}
		
		inicio = nodo;
		
		if(fim == null) {
			fim = nodo;
		}
	}
	
	
	public Nodo<T> getInicio() {
		return inicio;
	}

	public void setInicio(Nodo<T> inicio) {
		this.inicio = inicio;
	}

	public Nodo<T> getFim() {
		return fim;
	}

	public void setFim(Nodo<T> fim) {
		this.fim = fim;
	}

	public void inserirFinal(T dado) {
		Nodo<T> nodo = new Nodo<T>(dado);
		
		if(fim != null) {
			fim.setProximo(nodo);
			nodo.setAnterior(fim);
		}
		
		fim = nodo;
		
		if(inicio == null) {
			inicio = nodo;
		}
	}
	
	public void removerInicio() {
		if(inicio == null) return;
		
		Nodo<T> nodo = inicio;
		
		inicio = inicio.getProximo();
		
		if(inicio != null) {
			inicio.setAnterior(null);
		}
		
		if(nodo == fim) {
			removerFinal();
		}
	}
	
	public void removerFinal() {
		if(fim == null) return;
		
		Nodo<T> nodo = fim;
		
		fim = fim.getAnterior();
		
		if(fim != null) {
			fim.setProximo(null);
		}
		
		if(nodo == inicio) {
			removerInicio();
		}
	}
	
	public void removerComValor(T dado) {
		Nodo<T> nodoRemovido = null;
		Nodo<T> nodoAuxiliar = inicio;
		
		while(nodoAuxiliar != null) {
			if(nodoAuxiliar.getDado() == dado) {
				nodoRemovido = nodoAuxiliar;
				break;
			}
			
			nodoAuxiliar = nodoAuxiliar.getProximo();
		}
		
		if (nodoRemovido == null) return;
		
		if (nodoRemovido == inicio) {
			removerInicio();
		}
		else if (nodoRemovido == fim) {
			removerFinal();
		}
		else {
			nodoRemovido.getAnterior().setProximo(nodoRemovido.getProximo());
			nodoRemovido.getProximo().setAnterior(nodoRemovido.getAnterior());
		}
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
	
	public int contaNodos() {
		int numeroNodos = 0;
		
		Nodo<T> nodo = inicio;
		
		while(nodo != null) {
			numeroNodos++;
			nodo = nodo.getProximo();
		}
		
		return numeroNodos;
	}
}
