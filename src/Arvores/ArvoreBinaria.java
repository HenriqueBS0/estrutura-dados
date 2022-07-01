package Arvores;

public class ArvoreBinaria {
    
    private class Nodo {
        public int dado;
        public Nodo esquerdo;
        public Nodo direito;
    
        public Nodo(int dado) {
            this.dado = dado;
            esquerdo = null;
            direito = null;
        }
    }

    Nodo raiz;

    public ArvoreBinaria() {
        raiz = null;
    }

    public void inserir(int dado) {
        raiz = inserirDado(raiz, dado);
    }

    private Nodo inserirDado(Nodo raiz, int dado) {
        if(raiz == null) {
            raiz = new Nodo(dado);
            return raiz;
        }

        if(dado < raiz.dado) {
            raiz.esquerdo = inserirDado(raiz.esquerdo, dado);
        }
        else if(dado > raiz.dado) {
            raiz.direito = inserirDado(raiz.direito, dado);
        }

        return raiz;
    }

    public void mostrarEmOrdem() {
        mostrandoEmOrdem(raiz);
    }

    private void mostrandoEmOrdem(Nodo raiz) {
        if (raiz != null) {
            mostrandoEmOrdem(raiz.esquerdo);
            System.out.println(raiz.dado);
            mostrandoEmOrdem(raiz.direito);
        }
    }

}