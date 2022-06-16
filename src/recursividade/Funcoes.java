package recursividade;

public class Funcoes {

    public static int fatorial(int numero) {
        int fatorial = 1;

        for (int i = 1; i <= numero; i++) {
            fatorial *= i;
        }

        return fatorial;
    }

    public static int recorrencia(int numero, boolean desenhar) {

        int resultado = numero == 0 ? 2 : 2 * recorrencia(numero - 1, desenhar) - 4;

        if (desenhar) {
            System.out.println(resultado);
        }

        return resultado;
    }

    public static int fibonacci(int numero, boolean desenhar) {

        int resultado = numero == 0 || numero == 1
                ? numero
                : fibonacci(numero - 1, desenhar) + fibonacci(numero - 2, desenhar);

        if (desenhar) {
            System.out.println(resultado);
        }

        return resultado;
    }

    public static int somatorio(int i, int n) {

        int resultado = 2 * i * i + 2 * i + 8;

        if (n == 1)
            return resultado;

        return resultado + somatorio(i + 1, n - 1);
    }

    public static void rastreamento() {
        System.out.println("Recorrência: ");
        recorrencia(4, true);

        System.out.println("Fibonacci: ");
        fibonacci(4, true);
    }
}
