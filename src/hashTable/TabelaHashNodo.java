package hashTable;

public class TabelaHashNodo <T> {
    private int tamanhoArray;
    private Nodo<T>[] array;

    public TabelaHashNodo(int tamanhoArray) {
        this.tamanhoArray = tamanhoArray;
        this.array = new Nodo[tamanhoArray];
    }

    private int hash(String chave) {
        byte bytesChaves[] = chave.getBytes();
        int hashCode = 0;
        for(int i: bytesChaves) {
            hashCode+=i;
        }
        return hashCode % tamanhoArray;
    }

    private int hash(String chave, int colisoes) {
        byte bytesChaves[] = chave.getBytes();
        int hashCode = 0;
        for(int i: bytesChaves) {
            hashCode+=i;
        }
        return (hashCode + colisoes) % tamanhoArray;
    }

    public void inserir(String chave, T dado) {
        int indiceArray = hash(chave);
        
        if(array[indiceArray] == null) {
            array[indiceArray] = new Nodo<T>(chave, dado);
            return;
        }

        if(array[indiceArray].getChave() == chave) {
            array[indiceArray].setDado(dado);
            return;
        }

        int numeroColisoes = 1;
        int novoIndice = 0;

        while(array[indiceArray].getChave() != chave) {
            novoIndice = hash(chave, numeroColisoes);

            if(array[novoIndice] == null) {
                array[novoIndice] = new Nodo<T>(chave, dado);
                return;
            }
    
            if(array[novoIndice].getChave() == chave) {
                array[novoIndice].setDado(dado);
                return;
            }

            numeroColisoes++;
            indiceArray = novoIndice;
        }
    }

    public T recuperar(String chave) {
        int indiceArray = hash(chave);
        
        if(array[indiceArray] == null) {
            System.out.println("Chave não está na tabela");
            return null;
        }

        if(array[indiceArray].getChave() == chave) {
            return array[indiceArray].getDado();
        }

        int numeroColisoes = 1;
        int novoIndice = 0;

        while(array[indiceArray].getChave() != chave) {
            novoIndice = hash(chave, numeroColisoes);

            if(array[novoIndice] == null) {
                System.out.println("Chave não está na tabela");
                return null;
            }
    
            if(array[novoIndice].getChave() == chave) {
                return array[novoIndice].getDado();
            }

            numeroColisoes++;
            indiceArray = novoIndice;
        }

        return null;
    }
}
