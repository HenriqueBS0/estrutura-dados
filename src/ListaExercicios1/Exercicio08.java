package ListaExercicios1;

import listasLineares.Fila;

public class Exercicio08 {
	public static void main(String[] args) {
		Fila<Integer> fila = new Fila<Integer>(5);
		fila.inserir(1);
		fila.inserir(2);
		fila.inserir(3);
		fila.inserir(4);
		
		Fila<Integer> fila_pares = new Fila<Integer>(5);
		Fila<Integer> fila_impares = new Fila<Integer>(5);
		
		mostraParesImpares(fila, fila_pares, fila_impares);
		
		System.out.println("Pares:");
		mostrarFila(fila_pares);
		
		System.out.println("Impares:");
		mostrarFila(fila_impares);
	}
	
	public static void mostraParesImpares(Fila<Integer> fila, Fila<Integer> fila_pares, Fila<Integer> fila_impares) {
		while(fila.getTamanho() != 0) {
			if(fila.getInicio() % 2 == 0) {
				fila_pares.inserir(fila.getInicio());
			} else {
				fila_impares.inserir(fila.getInicio());
			}
			fila.remover();
		}
	}
	
	public static void mostrarFila(Fila<Integer> fila) {
		while(fila.getTamanho() != 0) {
			System.out.println(fila.getInicio());
			fila.remover();
		}
	}
}
