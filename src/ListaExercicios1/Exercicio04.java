package ListaExercicios1;

import listasLineares.ListaEncadeada;
import listasLineares.Nodo;

public class Exercicio04<T> {
	
	public static void main(String[] args) {
		ListaEncadeada<Integer> primeiroConjunto = new ListaEncadeada<Integer>();
		primeiroConjunto.inserirFinal(1);
		primeiroConjunto.inserirFinal(2);
		primeiroConjunto.inserirFinal(3);
		primeiroConjunto.inserirFinal(4);
		primeiroConjunto.inserirFinal(5);
		
		ListaEncadeada<Integer> segundoConjunto = new ListaEncadeada<Integer>();
		segundoConjunto.inserirFinal(3);
		segundoConjunto.inserirFinal(4);
		segundoConjunto.inserirFinal(5);
		segundoConjunto.inserirFinal(6);
		segundoConjunto.inserirFinal(7);
		
		System.out.println("Intersecção:\n" + interseccao(primeiroConjunto, segundoConjunto).mostraLista());
		System.out.println("Diferença do primeiro para o segundo:\n" + diferenca(primeiroConjunto, segundoConjunto).mostraLista());
		System.out.println("Diferença do segundo para o primeiro:\n" + diferenca(segundoConjunto, primeiroConjunto).mostraLista());
		System.out.println("União:\n" + uniao(primeiroConjunto, segundoConjunto).mostraLista());
	}
	
	public static ListaEncadeada<Integer> uniao(ListaEncadeada<Integer> primeiroConjunto, ListaEncadeada<Integer> segundoConjunto) {
		ListaEncadeada<Integer> diferencaPrimeiroProSegundo = diferenca(primeiroConjunto, segundoConjunto);
		ListaEncadeada<Integer> interseccao = interseccao(primeiroConjunto, segundoConjunto);
		ListaEncadeada<Integer> diferencaSegundoProPrimeiro = diferenca(segundoConjunto, primeiroConjunto);
		
		ListaEncadeada<Integer> uniao = new ListaEncadeada<Integer>();
		
		Nodo<Integer> nodo = diferencaPrimeiroProSegundo.getInicio();
		
		while(nodo != null) {
			uniao.inserirFinal(nodo.getDado());
			nodo = nodo.getProximo();
		}
		
		nodo = interseccao.getInicio();
		
		while(nodo != null) {
			uniao.inserirFinal(nodo.getDado());
			nodo = nodo.getProximo();
		}
		
		nodo = diferencaSegundoProPrimeiro.getInicio();
		
		while(nodo != null) {
			uniao.inserirFinal(nodo.getDado());
			nodo = nodo.getProximo();
		}
		
		return uniao;
	} 
	
	public static ListaEncadeada<Integer> interseccao(ListaEncadeada<Integer> primeiroConjunto, ListaEncadeada<Integer> segundoConjunto) {
		ListaEncadeada<Integer> interseccao = new ListaEncadeada<Integer>();
		
		Nodo<Integer> nodo = primeiroConjunto.getInicio();
		
		while(nodo != null) {
			if(valorNoConjunto(segundoConjunto, nodo.getDado())) {
				interseccao.inserirFinal(nodo.getDado());
			}
			nodo = nodo.getProximo();
		}
		
		return interseccao;
	}
	
	public static ListaEncadeada<Integer> diferenca(ListaEncadeada<Integer> primeiroConjunto, ListaEncadeada<Integer> segundoConjunto) {
		ListaEncadeada<Integer> diferenca = new ListaEncadeada<Integer>();
		
		Nodo<Integer> nodo = primeiroConjunto.getInicio();
		
		while(nodo != null) {
			if(!valorNoConjunto(segundoConjunto, nodo.getDado())) {
				diferenca.inserirFinal(nodo.getDado());
			}
			nodo = nodo.getProximo();
		}
		
		return diferenca;
	}
	
	public static boolean valorNoConjunto(ListaEncadeada<Integer> conjunto, Integer valor) {
		Nodo<Integer> nodo = conjunto.getInicio();
		
		while(nodo != null) {
			if(nodo.getDado() == valor) {
				return true;
			}
			nodo = nodo.getProximo();
		}
		
		return false;
	}
}
