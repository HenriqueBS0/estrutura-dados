package arvoresavl;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArvoreAVL arvore = new ArvoreAVL();

        arvore.inserir(8);
        arvore.inserir(3);
        arvore.inserir(1);
        arvore.inserir(6);
        arvore.inserir(10);

        arvore.mostrarPorNivel();

    //     ArvoreAVL arvore2 = new ArvoreAVL();

    //     arvore2.inserir(8);
    //     arvore2.inserir(3);
    //     arvore2.inserir(1);
    //     arvore2.inserir(6);
    //     arvore2.inserir(10);

    //     System.out.println(ArvoreAVL.arvoresIguais(arvore, arvore2));
    }
}
