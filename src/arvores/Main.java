package arvores;

public class Main {
    public static void main(String[] args) {
        ArvoreBinaria arvore = new ArvoreBinaria();

        arvore.inserir(5);
        
        arvore.inserir(2);
        arvore.inserir(1);
        arvore.inserir(3);

        arvore.inserir(8);
        arvore.inserir(7);
        arvore.inserir(9);
        arvore.inserir(6);

        arvore.mostrarPares();
    }
}
