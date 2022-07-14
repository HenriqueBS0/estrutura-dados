package Arvores;

public class Main {
    public static void main(String[] args) {
        ArvoreBinaria arvore = new ArvoreBinaria();

        arvore.inserir(5);
        arvore.inserir(6);
        arvore.inserir(4);
        arvore.inserir(7);
        arvore.inserir(1);

        arvore.remover(6);
        arvore.remover(1);

        System.out.println(arvore.menorNumero());
    }
}
