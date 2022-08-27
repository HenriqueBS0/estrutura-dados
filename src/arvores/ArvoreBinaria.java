package arvores;

import listasLineares.ListaEncadeada;

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
        mostrarEmOrdem(raiz);
    }

    private void mostrarEmOrdem(Nodo raiz) {
        if (raiz != null) {
            mostrarEmOrdem(raiz.esquerdo);
            System.out.println(raiz.dado);
            mostrarEmOrdem(raiz.direito);
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
        mostrarFolhas(this.raiz);
    }

    private void mostrarFolhas(Nodo raiz) {
        if(raiz == null) {
            return;
        }

        if(raiz.esquerdo == null && raiz.direito == null) {
            System.out.println(raiz.dado);
            return;
        }

        mostrarFolhas(raiz.esquerdo);
        mostrarFolhas(raiz.direito);
    }
    

    public void mostrarAncestrais(int dado) {
        mostrarAncestrais(raiz, dado);
    }

    private void mostrarAncestrais(Nodo raiz, int dado) {
        if(!isAncestral(raiz, dado)) {
            return;
        }
        
        System.out.println(raiz.dado);

        mostrarAncestrais(raiz.esquerdo, dado);
        mostrarAncestrais(raiz.direito, dado);
    }

    private boolean isAncestral(Nodo raiz, int dado) {
        if(raiz == null || (raiz.esquerdo == null && raiz.direito == null)) {
            return false;
        }

        if(raiz.esquerdo != null && raiz.esquerdo.dado == dado) {
            return true;
        }

        if(raiz.direito != null && raiz.esquerdo.dado == dado) {
            return true;
        }

        return isAncestral(raiz.esquerdo, dado) || isAncestral(raiz.direito, dado);
    }

    public void mostrarDescendentes(int dado) {
        mostrarDescendentes(raiz, dado);
    } 

    private boolean mostrarDescendentes(Nodo raiz, int dado) {
        if(raiz == null) {
            return false;
        }

        if(raiz.dado == dado)  {
            mostrarEmOrdem(raiz.esquerdo);
            mostrarEmOrdem(raiz.direito);
            return true;
        }

        return mostrarDescendentes(raiz.esquerdo, dado) || mostrarDescendentes(raiz.direito, dado);
    }

    public void mostrarSubarvoreDireita(int dado) {
        mostrarSubarvoreDireita(raiz, dado);
    }

    private boolean mostrarSubarvoreDireita(Nodo raiz, int dado) {
        if(raiz == null) {
            return false;
        }

        if(raiz.dado == dado) {
            mostrarEmOrdem(raiz.direito);
            return true;
        }

        return mostrarSubarvoreDireita(raiz.esquerdo, dado) || mostrarSubarvoreDireita(raiz.direito, dado);
    }

    public void mostrarSubarvoreEsquerda(int dado) {
        mostrarSubarvoreEsquerda(raiz, dado);
    }

    private boolean mostrarSubarvoreEsquerda(Nodo raiz, int dado) {
        if(raiz == null) {
            return false;
        }

        if(raiz.dado == dado) {
            mostrarEmOrdem(raiz.esquerdo);
            return true;
        }

        return mostrarSubarvoreEsquerda(raiz.esquerdo, dado) || mostrarSubarvoreEsquerda(raiz.direito, dado);
    }

    public int numeroElementos() {
        return numeroElementos(raiz);
    }

    private int numeroElementos(Nodo raiz) {
        if(raiz == null) {
            return 0;
        }

        return 1 + numeroElementos(raiz.esquerdo) + numeroElementos(raiz.direito);
    }

    public ListaEncadeada<Integer> retornaListaEncadeada() {
        return retornaListaEncadeada(raiz);
    }

    private ListaEncadeada<Integer> retornaListaEncadeada(Nodo raiz) {
        if(raiz == null) {
            return new ListaEncadeada<Integer>();
        }

        ListaEncadeada<Integer> lista = new ListaEncadeada<Integer>();

        lista.inserirFinal(raiz.dado);

        lista.unir(retornaListaEncadeada(raiz.esquerdo));
        lista.unir(retornaListaEncadeada(raiz.direito));

        return lista;
    }

    public void mostrarPares() {
        mostrarPares(raiz);
    }

    private void mostrarPares(Nodo raiz) {
        if (raiz == null) {
            return;
        }

        if(raiz.dado % 2 == 0) {
            System.out.println(raiz.dado);
        }
            
        mostrarPares(raiz.esquerdo);
        mostrarPares(raiz.direito);
    }
}