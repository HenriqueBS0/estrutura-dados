package hashTable;

public class Main {
    public static void main(String[] args) {
        TabelaHashNodo<String> tabelaHash = new TabelaHashNodo<String>(10);
        
        tabelaHash.inserir("IFC", "Henrique Borges dos Santos");
        tabelaHash.inserir("CFI", "Susana Borges dos Santos");

        System.out.println(tabelaHash.recuperar("CFI"));
    }
}
