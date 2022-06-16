package ListaExercicios1;

import listasLineares.ListaEncadeada;
import listasLineares.Nodo;

public class Exercicio09 {
	public static void main(String[] args) {
		System.out.println(relatorio(getFuncionarios(8), Entrada.getFloat("Informe um salário base: ")));
	}
	
	private static String relatorio(ListaEncadeada<Funcionario> funcionarios, float salario) {
		return "Funcionários:\n" +
				getFuncionarios(funcionarios) +
				"Funcionários com maior salário:\n" +
				getFuncionarioComMaiorSalario(funcionarios) +
				"Média salárial: " + getMediaSalarial(funcionarios) + "\n" +
				"Número de funcionários com o salário maior que o salário base: " + getFuncionariosComSalarioMaiorBase(funcionarios, salario);
	}
	
	public static String getFuncionariosComSalarioMaiorBase(ListaEncadeada<Funcionario> funcionarios, float salarioBase) {
		int numeroFuncionarios = 0;
		
		Nodo<Funcionario> nodo = funcionarios.getInicio();
		
		while(nodo != null) {	
			Funcionario funcionario = nodo.getDado();
			if(funcionario.getSalario() > salarioBase) {
				numeroFuncionarios++;
			}
			nodo = nodo.getProximo();
		}
		
		if(numeroFuncionarios == 0) return "Nenhum funcionário";
		
		return String.valueOf(numeroFuncionarios);
	}
	
	public static String getFuncionarios(ListaEncadeada<Funcionario> funcionarios) {
		String listaFuncionarios = "";
		
		Nodo<Funcionario> nodo = funcionarios.getInicio();
		
		while(nodo != null) {	
			Funcionario funcionario = nodo.getDado();
			listaFuncionarios+= funcionario.getDescritivo() + "\n";
			nodo = nodo.getProximo();
		}
		
		return listaFuncionarios;
	}
	
	public static ListaEncadeada<Funcionario> getFuncionarios(int numeroFuncionarios) {
		ListaEncadeada<Funcionario> funcionarios = new ListaEncadeada<Funcionario>();
		
		for (int i = 0; i < numeroFuncionarios; i++) {
			funcionarios.inserirFinal(new Funcionario(Entrada.getString("Informe o nome: "), Entrada.getFloat("Informe o salário: ")));
		}
		
		return ordenarLista(funcionarios);
	}
	
	public static float getMediaSalarial(ListaEncadeada<Funcionario> funcionarios) {
		float somaSalarial = 0;
		int numeroFuncionarios = 0;
		
		Nodo<Funcionario> nodo = funcionarios.getInicio();
		
		while(nodo != null) {	
			Funcionario funcionario = nodo.getDado();
			somaSalarial+= funcionario.getSalario();
			numeroFuncionarios++;
			nodo = nodo.getProximo();
		}
		
		return (float) somaSalarial / (float) numeroFuncionarios;
	}
	
	public static String getFuncionarioComMaiorSalario(ListaEncadeada<Funcionario> funcionarios) {
		float maiorSalario = getMaiorSalario(funcionarios);
		String nomes = "";
		
		Nodo<Funcionario> nodo = funcionarios.getInicio();
		
		while(nodo != null) {	
			Funcionario funcionario = nodo.getDado();
			if(funcionario.getSalario() == maiorSalario) {
				nomes+= funcionario.getDescritivo() + "\n";
			}
			nodo = nodo.getProximo();
		}
		
		return nomes;
	}
	
	public static float getMaiorSalario(ListaEncadeada<Funcionario> funcionarios) {
		float maior = funcionarios.getInicio().getDado().getSalario();
		
		Nodo<Funcionario> nodo = funcionarios.getInicio(); 
		
		while(nodo != null) {
			if(nodo.getDado().getSalario() > maior) {
				maior = nodo.getDado().getSalario();
			}
			
			nodo = nodo.getProximo();
		}
		
		return maior;
	}
	
	public static ListaEncadeada<Funcionario> ordenarLista(ListaEncadeada<Funcionario> funcionarios) {
		ListaEncadeada<Funcionario> listaOrdenada = new ListaEncadeada<Funcionario>();
		
		Nodo<Funcionario> nodo = funcionarios.getInicio();
		
		while(nodo != null) {
			ListaEncadeada<Funcionario> listaMenores = new ListaEncadeada<Funcionario>();

			Nodo<Funcionario> nodoListaOrdenada = listaOrdenada.getInicio();
			
			while(nodoListaOrdenada != null && nodo.getDado().getSalario() >= nodoListaOrdenada.getDado().getSalario()) {
				listaMenores.inserirFinal(nodoListaOrdenada.getDado());
				nodoListaOrdenada = nodoListaOrdenada.getProximo();
			}
			
			listaMenores.inserirFinal(nodo.getDado());
			
			listaOrdenada = unirListas(listaMenores.getInicio(), nodoListaOrdenada);
			
			
			nodo = nodo.getProximo();
		}
		
		return listaOrdenada;
	}
	
	public static ListaEncadeada<Funcionario> unirListas(Nodo<Funcionario> inicioPrimeira, Nodo<Funcionario> inicioSegunda) {
		ListaEncadeada<Funcionario> uniao = new ListaEncadeada<Funcionario>();
		
		Nodo<Funcionario> nodo;
		
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
