package primeiraAula;

public class Numero {
	int numero;
	
	public Numero(int numero) {
		this.numero = numero;
	}
	
	public boolean isPrimo() {		
		for(int i = 2; i < (numero - 1); i++) {
			if(numero % i == 0) {
				return false;
			}
		}
		
		return true;
	}
}


