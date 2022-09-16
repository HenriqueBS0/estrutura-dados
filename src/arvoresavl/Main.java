package arvoresavl;

public class Main {
    public static void main(String[] args) {
        ArvoreAVL arvore = new ArvoreAVL();

        arvore.inserir(8);
        arvore.inserir(3);
        arvore.inserir(1);
        arvore.inserir(6);
        arvore.inserir(10);

        arvore.mostrarEmOrdem();
    }
}
