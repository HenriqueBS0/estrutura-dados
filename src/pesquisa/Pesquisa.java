package pesquisa;

import java.util.LinkedList;

public class Pesquisa {
    public static void main(String[] args) {
        int[] array = {1,2,3,4};

        System.out.println(binaria(array, 4));

        // for (int i : sequencialListaEncontrados(array, 4)) {
        //     System.out.println(i);
        // }
    }

    public static int sequencial(int[] array, int x) {
        for (int i = 0; i < array.length; i++) {
            if(array[i] == x) {
                return i;
            }
        }

        return -1;
    }

    public static LinkedList<Integer> sequencialListaEncontrados(int[] array, int x) {
        LinkedList<Integer> encontrados = new LinkedList<Integer>();

        for (int i = 0; i < array.length; i++) {
            if(array[i] == x) {
                encontrados.add(i);
            }
        }

        return encontrados;
    }

    public static int binaria(int[] array, int x) {
        int min = 0;
        int max = array.length - 1;

        while(min <= max) {
            int meio = (min + max) / 2;

            if(array[meio] == x) {
                return meio;
            }
            else if(x > array[meio]) {
                min = meio + 1;
            }
            else {
                max = meio - 1;
            }
        }

        return -1;
    }
}
