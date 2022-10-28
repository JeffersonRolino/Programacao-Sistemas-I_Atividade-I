package entities;

public class Funcionario {
	
	private String nome;
	private Double salarioBruto;
	private Double percentualDeDesconto;
	private Double salarioLiquido;
	

	public Funcionario(String nome, Double salarioBruto, Double percentualDeDesconto) {
		this.nome = nome;
		this.salarioBruto = salarioBruto;
		this.percentualDeDesconto = percentualDeDesconto;
		this.salarioLiquido = setSalarioLiquido();
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public Double getSalarioBruto() {
		return salarioBruto;
	}


	public void setSalarioBruto(Double salarioBruto) {
		this.salarioBruto = salarioBruto;
	}


	public Double getPercentualDeDesconto() {
		return this.percentualDeDesconto;
	}


	public void setPercentualDeDesconto(Double percentualDeDesconto) {
		this.percentualDeDesconto = percentualDeDesconto;
	}


	public Double getSalarioLiquido() {
		return this.salarioLiquido;
	}


	private Double setSalarioLiquido() {
		Double descontoLiquido = this.salarioBruto * this.percentualDeDesconto / 100;
		Double salarioLiquido = this.salarioBruto - descontoLiquido;
		return salarioLiquido;
	}
	
	@Override
	public String toString() {
		
		return "Funcionário: " + this.nome + "\n" + 
			   "Salário Bruto: R$" + this.salarioBruto + "\n" +
			   "Desconto: " + this.percentualDeDesconto + "%\n" + 
			   "Salário Líquido: R$" + this.salarioLiquido;
	}
	
}
