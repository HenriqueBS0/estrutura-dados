package listasLineares;
public class Nodo<T> {
	private T dado;
	private Nodo<T> proximo = null;
	private Nodo<T> anterior = null;
	
	public Nodo(T dado) {
		this.dado = dado;
		this.proximo = null;
	}
	
	public T getDado() {
		return dado;
	}
	
	public Nodo<T> getProximo() {
		return proximo;
	}
	
	public Nodo<T> getAnterior() {
		return anterior;
	}
	
	public void setDado(T dado) {
		this.dado = dado;
	}
	
	public void setProximo(Nodo<T> nodo) {
		this.proximo = nodo;
	}
	
	public void setAnterior(Nodo<T> nodo) {
		this.anterior = nodo;
	}
}
