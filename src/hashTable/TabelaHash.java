package hashTable;

public class TabelaHash {
    private int tamanhoArray;
    private String[] array;

    public TabelaHash(int tamanhoArray) {
        this.tamanhoArray = tamanhoArray;
        this.array = new String[tamanhoArray];
    }

    private int hash(String chave) {
        byte bytesChave[] = chave.getBytes();
        int hashCode = 0;
        for (int i = 0; i < bytesChave.length; i++) {
            hashCode += bytesChave[i];
        }
        return hashCode % tamanhoArray;
    }

    public void inserir(String chave, String valor) {
        int indiceArray = hash(chave);
        array[indiceArray] = valor;
    }

    public String recuperar(String chave) {
        int indiceArray = hash(chave);
        return array[indiceArray];
    }
}
