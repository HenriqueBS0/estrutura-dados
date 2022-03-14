package primeiraAula;
public class CPF {
	private String numero;
	
	public CPF(String numero) {
		this.numero = numero;
	}
	
	public boolean isValido() {
		return this.isPrimeiroDigitoVerificadorValido()
			&& this.isSegundoDigitoVerificadorValido();
	}
	
	
	private boolean isPrimeiroDigitoVerificadorValido() {
		return getPrimeiroDigitoVerificador() == getPrimeiroDigitoVerificadorValido();
	}
	
	private int getPrimeiroDigitoVerificador() {
		return getDigitoNumero(12);
	}
	
	private int getPrimeiroDigitoVerificadorValido() {
		int[] posicoes = {0, 1, 2, 4, 5, 6, 8, 9, 10};
		
		int digito = 0;
		
		for (int i = 0; i <= 8; i++) {
			digito += getDigitoNumero(posicoes[i]) * (i + 1);
		}
		
		digito = digito % 11 == 10 ? 0 : digito % 11;
		
		return digito;
	}
	
	
	private boolean isSegundoDigitoVerificadorValido() {
		return getSegundoDigitoVerificador() == getSegundoDigitoVerificadorValido();
	}
	
	private int getSegundoDigitoVerificador() {
		return getDigitoNumero(13);
	}
	
	private int getSegundoDigitoVerificadorValido() {
		int[] posicoes = {0, 1, 2, 4, 5, 6, 8, 9, 10, 12};
		
		int digito = 0;
		
		for (int i = 0; i <= 9; i++) {
			digito += getDigitoNumero(posicoes[i]) * i;
		}
		
		digito = digito % 11 == 10 ? 0 : digito % 11;
		
		return digito;
	}
	
	private int getDigitoNumero(int posicao) {
		return Character.getNumericValue(numero.charAt(posicao));
	}
}