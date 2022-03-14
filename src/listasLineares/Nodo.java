package listasLineares;
public class Nodo<T> {
	private T dado;
	private Nodo<T> nodo;
	
	public Nodo(T dado) {
		this.dado = dado;
		this.nodo = null;
	}
	
	public T getDado() {
		return dado;
	}
	
	public Nodo<T> getProximo() {
		return nodo;
	}
	
	public void setDado(T dado) {
		this.dado = dado;
	}
	
	public void setProximo(Nodo<T> nodo) {
		this.nodo = nodo;
	}
	
}
