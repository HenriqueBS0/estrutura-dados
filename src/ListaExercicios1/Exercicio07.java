package ListaExercicios1;
import listasLineares.ListaDuplamenteEncadeada;
import listasLineares.Nodo;

public class Exercicio07 {

	public static void main(String[] args) {
		ListaDuplamenteEncadeada<Integer> listaUm = new ListaDuplamenteEncadeada<Integer>();
		
		ListaDuplamenteEncadeada<Integer> listaDois = new ListaDuplamenteEncadeada<Integer>();
		
		System.out.println((listasIguais(listaUm, listaDois) ? "Listas Iguais" : "Listas Diferentes"));
	}
	
	public static boolean listasIguais(ListaDuplamenteEncadeada<Integer> listaUm, ListaDuplamenteEncadeada<Integer> listaDois) {
		if(listaUm.contaNodos() != listaDois.contaNodos()) return false;
		
		if(listaUm.contaNodos() == 0) return true;
		
		Nodo<Integer> nodo = listaUm.getInicio();
		
		int posicao = 1;
		
		
		while(nodo != null) {
			if(nodo.getDado() != getNodoPelaPosicaoLista(posicao, listaDois).getDado()) return false;
			nodo = nodo.getProximo();
			posicao++;
		}
		
		return true;
	}
	
	private static Nodo<Integer> getNodoPelaPosicaoLista(int posicao, ListaDuplamenteEncadeada<Integer> lista) {
		
		Nodo<Integer> nodo = lista.getInicio();
		
		int posicaoAtual = 1;
		
		while(posicaoAtual != posicao) {
			nodo = nodo.getProximo();
			posicaoAtual++;
		}
		
		return nodo;
	}

}
