package ListaExercicios1;

public class Funcionario {
	private String nome;
	private float salario;
	
	public Funcionario(String nome, float salario) {
		setNome(nome);
		setSalario(salario);
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public float getSalario() {
		return salario;
	}
	
	public void setSalario(float salario) {
		this.salario = salario;
	}
	
	public String getDescritivo() {
		return "Nome: " + getNome() + " Salário: " + getSalario();
	}
}
