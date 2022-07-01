package Arvores;

public class Main {
    public static void main(String[] args) {
        ArvoreBinaria arvore = new ArvoreBinaria();

        arvore.inserir(5);
        arvore.inserir(6);
        arvore.inserir(4);

        arvore.mostrarEmOrdem();
    }
}
