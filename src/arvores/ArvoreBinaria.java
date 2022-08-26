package arvores;

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

    public void remover(int dado) {
        raiz = removerDado(raiz, dado);
    }

    private Nodo removerDado(Nodo raiz, int dado) {
        Nodo raizDireita, raizEsquerda;

        if(raiz.dado == dado) {
            if(raiz.esquerdo == null && raiz.direito == null) {
                //o elemento a ser removido não tem filhos
                return null;
            }
            else if(raiz.esquerdo == null) {
                //o elemento a ser removido não tem filho
                //para esquerda

                return raiz.direito;
            }
            else if(raiz.direito == null) {
                //o elemento a ser removido não tem filho
                //para direita

                return raiz.esquerdo;
            }
            else {
                //o elemento a ser removido tem filhos
                //para ambos os lados

                raizDireita = raiz.direito;
                raizEsquerda = raiz.esquerdo;

                while(raizDireita.esquerdo != null) {
                    raizDireita = raiz.esquerdo;
                }

                raizDireita.esquerdo = raiz.esquerdo;
                return raizEsquerda;
            }
        }

        else if(raiz.dado < dado) {
            raiz.direito = removerDado(raiz.direito, dado);
        }
        else {
            raiz.esquerdo = removerDado(raiz.esquerdo, dado);
        }

        return raiz;
    }

    public int maiorNumero() {
        Nodo raiz = this.raiz;

        while(raiz.direito != null) {
            raiz = raiz.direito;
        }

        return raiz.dado;
    }

    public int menorNumero() {
        Nodo raiz = this.raiz;

        while(raiz.esquerdo != null) {
            raiz = raiz.esquerdo;
        }

        return raiz.dado;
    }

    public void mostrarFolhas() {
        
    }
    
}