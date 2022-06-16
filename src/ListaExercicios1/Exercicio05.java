package ListaExercicios1;

import listasLineares.ListaEncadeada;
import listasLineares.Nodo;

public class Exercicio05 {

	public static void main(String[] args) {
		ListaEncadeada<Integer> lista = new ListaEncadeada<Integer>();
		lista.inserirFinal(1);
		lista.inserirFinal(2);
		lista.inserirFinal(3);
		
		System.out.println("Lista original:\n" + lista.mostraLista());
		System.out.println("Lista invertida:\n" + mostraListaInvertida(lista.getInicio()));

	}
	
	public static String mostraListaInvertida(Nodo<Integer> inicio) {
		return inverterLista(inicio).mostraLista();
	}

	public static ListaEncadeada<Integer> inverterLista(Nodo<Integer> inicio) {
		ListaEncadeada<Integer> invertida = new ListaEncadeada<Integer>();
		
		Nodo<Integer> nodo = inicio;
		
		while(nodo != null) {
			invertida.inserirInicio(nodo.getDado());
			nodo = nodo.getProximo();
		}
		
		return invertida;
	}
}
