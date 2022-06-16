package tempoExecucao;

public class Main {
    public static void main(String[] args) {
        int vetor[] = new int[500000000];
        int numeroProcura;

        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = i;
        }

        numeroProcura = -1;

        int totalComparacoes = 0;
        long inicio = System.currentTimeMillis();
        for (int j = 0; j < vetor.length; j++, totalComparacoes++) {
            if(vetor[j] == numeroProcura) {
                System.out.println("Número encontrado");
                break;
            }
        }

        long fim = System.currentTimeMillis() - inicio;
        System.out.println("Tempo de execução = " + fim);
        System.out.println("Total de comparações = " + totalComparacoes);
    }
}
