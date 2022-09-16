package arvoresavl;

import java.util.LinkedList;

public class ArvoreAVL {

	private class Nodo {

		private int dado;
		private Nodo esq, dir;
		private int alturaDireita, alturaEsquerda;

		public Nodo(int dado) {
			this.dado = dado;
			dir = esq = null;
			alturaDireita = alturaEsquerda = 0;
		}
	}

	Nodo raiz;

	public ArvoreAVL() {
		raiz = null;
	}

	public void inserir(int dado) {
		raiz = inserirDado(raiz, dado);

	}

	private Nodo inserirDado(Nodo raiz, int dado) {
		if (raiz == null) {
			raiz = new Nodo(dado);
			return raiz;
		}
		// inserção pela esquerda
		if (dado < raiz.dado) {
			raiz.esq = inserirDado(raiz.esq, dado);
			if (raiz.esq.alturaDireita > raiz.esq.alturaEsquerda) {
				// aumenta um nivel daquela posição
				raiz.alturaEsquerda = raiz.esq.alturaDireita + 1;
			} else {
				raiz.alturaEsquerda = raiz.esq.alturaEsquerda + 1;
			}
			raiz = balanceamento(raiz);
		}
		// inserção pela direita

		else if (dado > raiz.dado) {
			raiz.dir = inserirDado(raiz.dir, dado);
			if (raiz.dir.alturaDireita > raiz.dir.alturaEsquerda) {
				// aumenta um nivel daquela posição
				raiz.alturaDireita = raiz.dir.alturaDireita + 1;
			} else {
				raiz.alturaDireita = raiz.dir.alturaEsquerda + 1;
			}
			raiz = balanceamento(raiz);
		}
		return raiz;
	}

	private Nodo balanceamento(Nodo raiz) {
		int fatorBalanceamento = raiz.alturaDireita - raiz.alturaEsquerda;
		int fatorBalanceamentoSubArv;

		if (fatorBalanceamento == 2) {
			fatorBalanceamentoSubArv = raiz.dir.alturaDireita - raiz.dir.alturaEsquerda;
			if (fatorBalanceamentoSubArv >= 0) {
				// rotação simples à esquerda
				raiz = rotacaoEsquerda(raiz);
			} else {
				// rotação dupla à esquerda
				raiz.dir = rotacaoDireita(raiz.dir);
				raiz = rotacaoEsquerda(raiz);
			}
		} else if (fatorBalanceamento == -2) {
			fatorBalanceamentoSubArv = raiz.esq.alturaDireita - raiz.esq.alturaEsquerda;
			if (fatorBalanceamentoSubArv <= 0) {
				// rotação simples à direita
				raiz = rotacaoDireita(raiz);
			} else {
				//rotação dupla à direita
				raiz.esq = rotacaoEsquerda(raiz.esq);
				raiz = rotacaoDireita(raiz);
			}
		}
		return raiz;
	}
	
	private Nodo rotacaoEsquerda(Nodo raiz) {
		Nodo auxiliar1, auxiliar2;
		
		//troca
		auxiliar1 = raiz.dir;
		auxiliar2 = auxiliar1.esq;
		raiz.dir = auxiliar2;
		auxiliar1.esq = raiz;
		
		//atualização das alturas
		
		if(raiz.dir == null) {
			raiz.alturaDireita = 0;
		}
		else if(raiz.dir.alturaEsquerda > raiz.dir.alturaDireita) {
			raiz.alturaDireita = raiz.dir.alturaEsquerda + 1;
		}
		else {
			raiz.alturaDireita = raiz.dir.alturaDireita + 1;
		}
		
		if (auxiliar1.esq.alturaEsquerda > auxiliar1.esq.alturaDireita) {
			auxiliar1.alturaEsquerda = auxiliar1.esq.alturaEsquerda + 1;
		}
		else {
			auxiliar1.alturaEsquerda = auxiliar1.esq.alturaDireita + 1;
		}
		
		return auxiliar1;
	}
	
	
	private Nodo rotacaoDireita(Nodo raiz) {
		
		//troca
		
		Nodo auxiliar1, auxiliar2;
		auxiliar1 = raiz.esq;
		auxiliar2 = auxiliar1.dir;
		raiz.esq = auxiliar2;
		auxiliar1.dir = raiz;
		
		//atualização de altura
		
		if (raiz.esq == null) {
			raiz.alturaEsquerda = 0;
		}
		else if (raiz.esq.alturaEsquerda > raiz.esq.alturaDireita) {
			raiz.alturaEsquerda = raiz.alturaEsquerda + 1;
		}
		else {
			raiz.alturaEsquerda = raiz.esq.alturaDireita + 1;
		}
		if (auxiliar1.dir.alturaEsquerda > auxiliar1.dir.alturaDireita) {
			auxiliar1.alturaDireita = auxiliar1.dir.alturaEsquerda + 1;
		}
		else {
			auxiliar1.alturaDireita = auxiliar1.dir.alturaDireita + 1;
		}
		return auxiliar1;
	}
	
	
	

	public void mostrarEmOrdem() {
		mostrandoOrdenado(raiz);

	}

	private void mostrandoOrdenado(Nodo raiz) {
		if (raiz != null) {
			mostrandoOrdenado(raiz.esq);
			System.out.println(raiz.dado);
			mostrandoOrdenado(raiz.dir);
		}
	}

	public void remover(int dado) {
		raiz = removerDado(raiz, dado);
	}

	private Nodo removerDado(Nodo raiz, int dado) {
		Nodo aux1, aux2;
		if (raiz.dado == dado) {
			if (raiz.esq == null && raiz.dir == null) {
				// o elemento a ser removido nao tem filhos
				return null;
			} else if (raiz.esq == null) {
				// o elemento a ser removido não tem filho
				// para esquerda

				return raiz.dir;
			} else if (raiz.dir == null) {
				// o elemento a ser removido não tem filho para direta
				return raiz.esq;
			} else {
				// o elemento a ser removido tem filhos para ambos lados

				aux1 = raiz.dir;
				aux2 = raiz.esq;
				while (aux1.esq != null) {
					aux1 = aux1.esq;
				}
				aux1.esq = raiz.esq;
				return aux2;
			}
		} else if (raiz.dado < dado)
			raiz.dir = removerDado(raiz.dir, dado);
		else
			raiz.esq = removerDado(raiz.esq, dado);
		return raiz;
	}

	public int maiorDado() {
		Nodo raiz = this.raiz;

		while (raiz.dir != null) {
			raiz = raiz.dir;
		}

		return raiz.dado;
	}

	public int menorDado() {
		Nodo raiz = this.raiz;

		while (raiz.esq != null) {
			raiz = raiz.esq;
		}

		return raiz.dado;
	}

	public void mostraFolhas() {
		folhas(raiz);
	}

	private void folhas(Nodo raiz) {
		if (raiz == null) {
			return;
		} else if (raiz.esq == null && raiz.dir == null) {
			System.out.println(raiz.dado);
		}
		folhas(raiz.esq);
		folhas(raiz.dir);
	}

	public void contarNos() {
		System.out.println(nos(raiz));
	}

	public int nos(Nodo raiz) {
		Nodo aux = raiz;
		if (raiz == null)
			return 0;
		else {
			return (1 + nos(aux.dir) + nos(aux.esq));
		}
	}

	public void mostrarPares() {
		mostrandoPares(raiz);

	}

	private void mostrandoPares(Nodo raiz) {
		if (raiz != null) {
			if (raiz.dado % 2 == 0) {
				System.out.println(raiz.dado);
			}
			mostrandoPares(raiz.esq);
			mostrandoPares(raiz.dir);
		}
	}

	public void mostrarAncestrais(int dado) {
		mostrandoAncestrais(raiz, dado);
	}

	private void mostrandoAncestrais(Nodo raiz, int dado) {
		if (dado == raiz.dado || raiz == null) {
			return;
		}
		System.out.println(raiz.dado);
		if (dado > raiz.dado) {
			mostrandoAncestrais(raiz.dir, dado);
		} else
			mostrandoAncestrais(raiz.esq, dado);
	}

	public void mostrarDescendentes(int dado) {
		mostrandoDescendentes(raiz, dado, false);
	}

	private void mostrandoDescendentes(Nodo raiz, int dado, boolean nodoAchado) {
		if (raiz == null) {
			return;
		}
		if (nodoAchado) {
			System.out.println(raiz.dado);
		}
		if (raiz.dado == dado) {
			nodoAchado = true;
		}
		mostrandoDescendentes(raiz.dir, dado, nodoAchado);
		mostrandoDescendentes(raiz.esq, dado, nodoAchado);
	}

	public void mostrarSubArvDireita(int dado) {
		mostrandoSubDireita(raiz, dado);

	}

	private void mostrandoSubDireita(Nodo raiz, int dado) {
		if (raiz.dado == dado) {
			mostrandoOrdenado(raiz.dir);
		}

		if (raiz.dir != null) {
			mostrandoSubDireita(raiz.dir, dado);
		}

		if (raiz.esq != null) {
			mostrandoSubDireita(raiz.esq, dado);
		}
	}

	public void mostrarSubArvEsquerda(int dado) {
		mostrandoSubEsquerda(raiz, dado);

	}

	private void mostrandoSubEsquerda(Nodo raiz, int dado) {
		if (raiz.dado == dado) {
			mostrandoOrdenado(raiz.esq);
		}

		if (raiz.dir != null) {
			mostrandoSubEsquerda(raiz.dir, dado);
		}

		if (raiz.esq != null) {
			mostrandoSubEsquerda(raiz.esq, dado);
		}
	}

	public LinkedList<Integer> listaEncadeada() {
		return listaEncadeada(raiz);
	}

	private LinkedList<Integer> listaEncadeada(Nodo raiz) {
		LinkedList<Integer> lista = new LinkedList<Integer>();

		if (raiz == null) {
			return lista;
		}

		for (Integer dado : listaEncadeada(raiz.esq)) {
			lista.add(dado);
		}

		lista.add(raiz.dado);

		for (Integer dado : listaEncadeada(raiz.dir)) {
			lista.add(dado);
		}

		return lista;
	}

}