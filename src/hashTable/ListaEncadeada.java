package hashTable;

public class ListaEncadeada<T> {
    private Nodo<T> inicio = null;

    public void setInicio(Nodo<T> nodo) {
        inicio = nodo;
    }

    public Nodo<T> getInicio() {
        return inicio;
    }

    public void inserir(String chave, T dado) {
        Nodo<T> inicio = getInicio();

        if(inicio == null) {
            setInicio(new Nodo<T>(chave, dado));
            return;
        }

        Nodo<T> nodo = inicio;

        while(nodo.getProximo() != null) {
            nodo = nodo.getProximo();
        }

        nodo.setProximo(new Nodo<T>(chave, dado));
    }

    public void remover(String chave) {
        if(inicio == null) return;
        if(inicio.getChave() == chave) {
            inicio = inicio.getProximo();
        }

        Nodo<T> nodo = inicio;

        while(nodo.getProximo() != null) {
            if(nodo.getProximo().getChave() == chave) {
				nodo.setProximo(nodo.getProximo().getProximo());
				return;
			}
			
			nodo = nodo.getProximo();
        }
    }

    public T getDado(String chave) {
        if(inicio == null) return null;

        Nodo<T> nodo = inicio;

        while(nodo.getProximo() != null) {
			
			nodo = nodo.getProximo();
        }

        return null;
    }

    public int numeroElementos() {
        int numeroElementos = 0;

        Nodo<T> nodo = getInicio();

        while(nodo != null) {
            numeroElementos++;
            nodo = nodo.getProximo();
        }

        return numeroElementos;
    }

    @Override
    public String toString() {
        String lista = "";
        
        Nodo<T> nodo = getInicio();

        while(nodo != null) {
            lista+= nodo.getDado() + "\n";
            nodo = nodo.getProximo();
        }

        return lista;
    }
}
