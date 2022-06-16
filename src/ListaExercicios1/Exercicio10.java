package ListaExercicios1;

import java.util.Random;

import listasLineares.ListaCircular;
import listasLineares.ListaDuplamenteEncadeada;
import listasLineares.ListaEncadeada;
import listasLineares.Nodo;

public class Exercicio10 {
	public static void main(String[] args) {
		ListaDuplamenteEncadeada<Integer> L2 = geraL2(geraL1());
		System.out.println("Números: ");
		apresentaNumeros(L2);
		System.out.println("Média: " + media(L2));
		System.out.println("Moda: " + moda(L2));
		System.out.println("Mediana: " + mediana(L2));
	}
	
	public static void apresentaNumeros(ListaDuplamenteEncadeada<Integer> L2) {
		Nodo<Integer> nodo = L2.getInicio();
		
		while(nodo != null) {
			System.out.println(nodo.getDado());
			nodo = nodo.getProximo();
		}
	}
	
	public static int moda(ListaDuplamenteEncadeada<Integer> L2) {
		return getMaiorContador(getContadores(L2)).getNumero();
	}
	
	private static ListaEncadeada<Contador> getContadores(ListaDuplamenteEncadeada<Integer> L2) {
		ListaEncadeada<Contador> contatores = new ListaEncadeada<Contador>();

		Nodo<Integer> nodo = L2.getInicio();
		
		while(nodo != null) {
			Contador contator = getContador(contatores, nodo.getDado());
			if(contator == null) {
				contatores.inserirInicio(new Contador(nodo.getDado()));
			}
			else {
				contator.addAparicoes();
			}
			nodo = nodo.getProximo();
		}
		
		return contatores;
	}
	
	private static Contador getMaiorContador(ListaEncadeada<Contador> contatores) {
		Contador maior = contatores.getInicio().getDado();
		
		Nodo<Contador> nodo = contatores.getInicio();
		
		while(nodo != null) {
			if(nodo.getDado().getAparicoes() > maior.getAparicoes()) {
				maior = nodo.getDado();
			}
			nodo = nodo.getProximo();
		}
		
		return maior;
	}
	
	private static Contador getContador(ListaEncadeada<Contador> contatores, int numero) {
		Nodo<Contador> nodo = contatores.getInicio();
		
		while(nodo != null) {
			if(nodo.getDado().getNumero() == numero) {
				return nodo.getDado();
			}
			nodo = nodo.getProximo();
		}
		
		return null;
	}
	
	private static float media(ListaDuplamenteEncadeada<Integer> L2) {
		int soma = 0;
		int quantidade = 0;
		
		Nodo<Integer> nodo = L2.getInicio();
		
		while(nodo != null) {
			soma += nodo.getDado();
			quantidade++;
			nodo = nodo.getProximo();
		}
		
		return (float) soma / (float) quantidade;
	}
	
	private static float mediana(ListaDuplamenteEncadeada<Integer> L2) {
		int soma = 0;
		int posicao = 1;
		
		Nodo<Integer> nodo = L2.getInicio();
		
		while (nodo != null) {
			if(posicao == 50 || posicao == 51) {				
				soma += nodo.getDado();
			}
			
			nodo = nodo.getProximo();
			posicao++;
		}
		
		return (float) soma / (float) 2;
	}
	
	private static ListaCircular<Integer> geraL1() {
		ListaCircular<Integer> L1 = new ListaCircular<Integer>();
		
		Random gerador = new Random();
		
		for (int i = 0; i < 100; i++) {
			L1.inserirInicio(gerador.nextInt(100));
		}
		
		return L1;
	}
	
	public static ListaDuplamenteEncadeada<Integer> geraL2(ListaCircular<Integer> L1) {
		ListaDuplamenteEncadeada<Integer> L2 = new ListaDuplamenteEncadeada<Integer>();
		
		
		Nodo<Integer> nodo = L1.getInicio();
		
		do {
			L2.inserirFinal(nodo.getDado());
			nodo = nodo.getProximo();
		} while (nodo != L1.getInicio());
		
		return ordena(L2); 
	}
	
	
	public static ListaDuplamenteEncadeada<Integer> ordena(ListaDuplamenteEncadeada<Integer> L2) {
		ListaDuplamenteEncadeada<Integer> listaOrdenada = new ListaDuplamenteEncadeada<Integer>();
		
		Nodo<Integer> nodo = L2.getInicio();
		
		while(nodo != null) {
			ListaDuplamenteEncadeada<Integer> listaMenores = new ListaDuplamenteEncadeada<Integer>();

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
	
	public static ListaDuplamenteEncadeada<Integer> unirListas(Nodo<Integer> inicioPrimeira, Nodo<Integer> inicioSegunda) {
		ListaDuplamenteEncadeada<Integer> uniao = new ListaDuplamenteEncadeada<Integer>();
		
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
