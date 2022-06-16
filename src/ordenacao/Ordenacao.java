package ordenacao;

public class Ordenacao {
    public static void main(String[] args) {    
        int[] array = {1, 4, 23, 2, 5, 6};
        for (int numero : insertsort(array)) {
            System.out.println(numero);
        }
    }

    public static int[] insertsort(int[] array) {
        for (int i = 0; i < array.length; i++) {

            int pivo = array[i];
            int j = i-1;

            while(j >= 0 && array[j] > pivo) {
                array[j + 1] = array[j];
                j = j-1;
            }

            array[j + 1] = pivo;
        }

        return array;
    }

    public static int[] selectionsort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int posicaoMenor = i;

            for (int j = i+1; j < array.length; j++) {
                if(array[j] < array[posicaoMenor]) {
                    posicaoMenor = j;
                }
            }

            int temp = array[i];
            array[i] = array[posicaoMenor];
            array[posicaoMenor] = temp;
        }

        return array;
    }

    public static int[] bublesort(int[] array) {

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if(array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }
}
