package ListaExercicios1;

import java.util.Scanner;

public class Entrada {
	private static Scanner entrada = new Scanner(System.in);
	
	public static int getInt(String mensagem) {
		System.out.print(mensagem);
		int resultado = entrada.nextInt();
		entrada.nextLine();
		return resultado;
	}
	
	public static String getString(String mensagem) {
		System.out.print(mensagem);
		return entrada.nextLine();
	}
	
	public static double getDouble(String mensagem) {
		System.out.print(mensagem);
		double resultado = entrada.nextDouble();
		entrada.nextLine();
		return resultado;
	}
	
	public static float getFloat(String mensagem) {
		System.out.print(mensagem);
		float resultado = entrada.nextFloat();
		entrada.nextLine();
		return resultado;
	}	
}
