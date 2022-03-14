package primeiraAula;
public class Data {
	
	private int dia, mes, ano;
	
	public Data(int dia, int mes, int ano) {
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
	}
	
	public boolean isDataValida() {
		return isAnoValido() && isMesValido() && isDiaValido();
	}
	
	private boolean isAnoValido() {
		return ano > 0;
	}
	
	private boolean isMesValido() {
		return mes >= 1 && mes <= 12;
	}
	
	private boolean isDiaValido() {
		int[] diasMeses = {
			31,
			isAnoBissexto() ? 29 : 28, 
			31,
			30,
			31,
			30,
			31,
			31,
			30,
			31,
			30,
			31
		};
		
		return dia > 0 && dia <= diasMeses[(mes - 1)];
	}
	
	private boolean isAnoBissexto() {
		return ano % 4 == 0;
	}
}


