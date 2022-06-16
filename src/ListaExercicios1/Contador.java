package ListaExercicios1;

public class Contador {
	private int numero;
	
	private int aparicoes = 0;
	
	public Contador(int numero) {
		setNumero(numero);
		addAparicoes();
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getAparicoes() {
		return aparicoes;
	}

	public void addAparicoes() {
		this.aparicoes++;
	}
}
