package ListaExercicios1;

import listasLineares.ListaEncadeada;
import listasLineares.Nodo;

public class Exercicio01 {
	public static void main(String[] args) {
		ListaEncadeada<Integer> lista = new ListaEncadeada<Integer>();
		
		lista.inserirFinal(1);
		lista.inserirFinal(2);
		lista.inserirFinal(3);
		lista.inserirFinal(3);
		lista.inserirFinal(4);
		lista.inserirFinal(5);
		
		System.out.println(exercicio(lista.getInicio(), 3));
		
	}
	
	public static String exercicio(Nodo<Integer> inicio, Integer dado) {
		return "Número de nodos: " + contaNodos(inicio) + "\n" +
			   "Número de nodos com o valor: " + contaNodosComDado(inicio, dado) + "\n" +
			   "Posição dos nodos com o valor: " + getPosicoesNodosComDado(inicio, dado) + "\n" +
			   "Número de nodos com o valor maior que o valor informado: " + contaNodosComValorMaiorDado(inicio, dado) + "\n";
	}	
	
	public static int contaNodos(Nodo<Integer> inicio) {
		int nodos = 0;
		
		Nodo<Integer> nodo = inicio;
		
		while(nodo != null) {
			nodos++;
			nodo = nodo.getProximo();
		}
		
		return nodos;
	}
	
	public static int contaNodosComDado(Nodo<Integer> inicio, Integer dado) {
		int nodos = 0;
		
		Nodo<Integer> nodo = inicio;
		
		while(nodo != null) {
			if(nodo.getDado() == dado) {
				nodos++;
			}
			nodo = nodo.getProximo();
		}
		
		return nodos;
	}
	
	public static String getPosicoesNodosComDado(Nodo<Integer> inicio, Integer dado) {
		String posicoes = "";
		int posicao = 1;
		
		Nodo<Integer> nodo = inicio;
		
		while(nodo != null) {
			if(nodo.getDado() == dado) {
				posicoes += posicao + ", ";
			}
			posicao++;
			nodo = nodo.getProximo();
		}
		
		return posicoes;
	}
	
	public static int contaNodosComValorMaiorDado(Nodo<Integer> inicio, Integer dado) {
		int nodos = 0;
		
		Nodo<Integer> nodo = inicio;
		
		while(nodo != null) {
			if(nodo.getDado() > dado) {
				nodos++;
			}
			nodo = nodo.getProximo();
		}
		
		return nodos;
	}
}
