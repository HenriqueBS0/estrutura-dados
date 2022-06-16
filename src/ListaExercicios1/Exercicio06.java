package ListaExercicios1;

import listasLineares.ListaEncadeada;
import listasLineares.Nodo;

public class Exercicio06 {

	public static void main(String[] args) {
		ListaEncadeada<Integer> listaUm = new ListaEncadeada<Integer>();
		listaUm.inserirFinal(3);
		listaUm.inserirFinal(4);
		listaUm.inserirFinal(5);
		listaUm.inserirFinal(6);
		listaUm.inserirFinal(7);
		
		ListaEncadeada<Integer> listaDois = new ListaEncadeada<Integer>();
		listaDois.inserirFinal(1);
		listaDois.inserirFinal(2);
		listaDois.inserirFinal(3);
		listaDois.inserirFinal(4);
		listaDois.inserirFinal(5);
		
		System.out.println(unirEOrdenarListas(listaUm, listaDois).mostraLista());

	}

	public static ListaEncadeada<Integer> unirEOrdenarListas(ListaEncadeada<Integer> listaUm, ListaEncadeada<Integer> listaDois) {
		return ordenarListaCrescente(unirListas(listaUm.getInicio(), listaDois.getInicio()));
	}
	
	public static ListaEncadeada<Integer> ordenarListaCrescente(ListaEncadeada<Integer> lista) {
		ListaEncadeada<Integer> listaOrdenada = new ListaEncadeada<Integer>();
		
		Nodo<Integer> nodo = lista.getInicio();
		
		while(nodo != null) {
			ListaEncadeada<Integer> listaMenores = new ListaEncadeada<Integer>();

			Nodo<Integer> nodoListaOrdenada = listaOrdenada.getInicio();
			
			while(nodoListaOrdenada != null && nodo.getDado() >= nodoListaOrdenada.getDado()) {
				listaMenores.inserirFinal(nodoListaOrdenada.getDado());
				nodoListaOrdenada = nodoListaOrdenada.getProximo();
			}
			
			listaMenores.inserirFinal(nodo.getDado());
			
			listaOrdenada = unirListas(listaMenores.getInicio(), nodoListaOrdenada);
			
			
			nodo = nodo.getProximo();
		}
		
		return listaOrdenada;
	}
	
	public static ListaEncadeada<Integer> unirListas(Nodo<Integer> inicioPrimeira, Nodo<Integer> inicioSegunda) {
		ListaEncadeada<Integer> uniao = new ListaEncadeada<Integer>();
		
		Nodo<Integer> nodo;
		
		nodo = inicioPrimeira;
		
		while(nodo != null) {
			uniao.inserirFinal(nodo.getDado());
			nodo = nodo.getProximo();
		}
		
		nodo = inicioSegunda;
		
		while(nodo != null) {
			uniao.inserirFinal(nodo.getDado());
			nodo = nodo.getProximo();
		}
		
		return uniao;
	}
	
}
