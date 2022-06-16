package hashTable;

public class Nodo<T> {

    private Nodo<T> anterior = null;
    private Nodo<T> proximo = null;
    private T dado = null;
    private String chave;

    public Nodo(String chave, T dado) {
        this.setChave(chave);
        this.setDado(dado);
    }

    public void setAnterior(Nodo<T> anterior) {
        this.anterior = anterior;
    }

    public Nodo<T> getAnterior() {
        return anterior;
    }

    public void setProximo(Nodo<T> proximo) {
        this.proximo = proximo;
    }

    public Nodo<T> getProximo() {
        return this.proximo;
    }

    public void setDado(T dado) {
        this.dado = dado;
    }

    public T getDado() {
        return dado;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }

    public String getChave() {
        return this.chave;
    }
}
