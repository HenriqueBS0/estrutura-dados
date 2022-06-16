package ListaExercicios1;

import listasLineares.ListaDuplamenteEncadeada;
import listasLineares.Nodo;

public class Exercicio03 {
	public static void main(String[] args) {
		ListaDuplamenteEncadeada<Integer> lista = new ListaDuplamenteEncadeada<Integer>();
		
		lista.inserirFinal(1);
		lista.inserirFinal(2);
		lista.inserirFinal(3);
		lista.inserirFinal(4);
		
		System.out.println("Maior Elemento: " + getMaiorElemento(lista));
		System.out.println("Menor Elemento: " + getMenorElemento(lista));
		System.out.println("Média Aritmética: " + getMediaAritmeticaElementos(lista));
	}
	
	private static int getMaiorElemento(ListaDuplamenteEncadeada<Integer> lista) {		
		int maior = lista.getInicio().getDado();
		
		Nodo<Integer> nodo = lista.getInicio();

		do {
			if(nodo.getDado() > maior) {
				maior = nodo.getDado();
			}
			nodo = nodo.getProximo();
		} while (nodo != null);
		
		return maior;
	}
	
	private static int getMenorElemento(ListaDuplamenteEncadeada<Integer> lista) {
		int menor = lista.getInicio().getDado();
		
		Nodo<Integer> nodo = lista.getInicio();
		
		do {
			if(nodo.getDado() < menor) {
				menor = nodo.getDado();
			}
			nodo = nodo.getProximo();
		} while (nodo != null);
		
		return menor;
	}
	
	private static double getMediaAritmeticaElementos(ListaDuplamenteEncadeada<Integer> lista) {
		return somaElementos(lista) / (double) getNumeroElementos(lista);
	}
	
	private static int getNumeroElementos(ListaDuplamenteEncadeada<Integer> lista) {
		int elementos = 0;
		
		Nodo<Integer> nodo = lista.getInicio();
		
		do {
			elementos++;
			nodo = nodo.getProximo();
		} while (nodo != null);
		
		return elementos;
	}
	
	private static int somaElementos(ListaDuplamenteEncadeada<Integer> lista) {
		int soma = 0;
		
		Nodo<Integer> nodo = lista.getInicio();
		
		do {
			soma+= nodo.getDado();
			nodo = nodo.getProximo();
		} while (nodo != null);
		
		return soma;
	}
}
