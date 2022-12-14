package application;

import java.util.ArrayList;
import java.util.Scanner;

import entities.Funcionario;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<Funcionario> Funcionarios = new ArrayList<Funcionario>();
		
		int option = 42;
		
		while(option != 0) {
			System.out.println("--------------------------------------------------------");
			System.out.println("\t\t MENU");
			System.out.println("--------------------------------------------------------");
			System.out.println("Escolha uma opção");
			System.out.println("1 - Cadastrar Funcionário");
			System.out.println("2 - Listar Funcionários");
			System.out.println("0 - Sair");
			
			
			if(scanner.hasNextInt()) {
				option = scanner.nextInt();
				scanner.nextLine();
				if(option == 0) {
					return;
				}
				else if(option == 1) {
					cadastrarFuncionario(scanner, Funcionarios);				
				}
				else if(option == 2) {
					listarFuncionarios(Funcionarios);
				}
				else {
					System.out.println("Valor inválido, por favor informe um novo valor...");
					option = scanner.nextInt();
					scanner.nextLine();
				}				
			}
			else {
				System.out.println("\n\tValor inválido...");
				System.out.println("\tRetornando ao Menu Principal...\n");
				scanner.nextLine();
			}			
		}

		scanner.close();
	}
	
	public static void cadastrarFuncionario(Scanner scanner, ArrayList<Funcionario> funcionarios) {
		String nome = null;
		Double salarioBruto = 0.0;
		Double valorDoDesconto = 0.0;
		
		System.out.println("Informe o nome do funcionário: ");
		
		if(scanner.hasNextLine()) {
			nome = scanner.nextLine();
		}
		
		System.out.println("Informe o Salário Bruto do funcionário: ");
		if(scanner.hasNextDouble()) {
			salarioBruto = scanner.nextDouble();
			scanner.nextLine();
		}
		else {
			System.out.println("\n\tValor inválido...");
			System.out.println("\tRetornando ao Menu Principal...\n");
			scanner.nextLine();
			return;
		}
		
		System.out.println("Informe o Valor do Desconto salarial do funcionário: ");
		if(scanner.hasNextDouble()) {
			valorDoDesconto = scanner.nextDouble();
			scanner.nextLine();
		}
		else {
			System.out.println("\n\tValor inválido...");
			System.out.println("\tRetornando ao Menu Principal...\n");
			scanner.nextLine();
			return;
		}
		
		Funcionario funcionario  = new Funcionario(nome, salarioBruto, valorDoDesconto);
		
		funcionarios.add(funcionario);
		
		System.out.println("\nFuncionário cadastrado com sucesso: ");
		System.out.println("--------------------------------------------------------");
		System.out.println(funcionario);
		System.out.println("--------------------------------------------------------");
		
		System.out.println("\nGostaria de cadastrar outro funcionário?");
		System.out.println("1 - Sim");
		System.out.println("2 - Não");
		
		int cadastrar = 42;
		if(scanner.hasNextInt()) {
			cadastrar = scanner.nextInt();
			scanner.nextLine();
		}
		else {
			System.out.println("\n\tValor inválido...");
			System.out.println("\tRetornando para o Menu Principal...\n");
			scanner.nextLine();
			return;
		}
		 		
		if(cadastrar == 2) {
			return;
		}
		else if(cadastrar == 1) {
			cadastrarFuncionario(scanner, funcionarios);
		}
		else {
			System.out.println("\nValor inválido...");
			System.out.println("Gostaria de cadastrar outro funcionário?");
			System.out.println("1 - Sim");
			System.out.println("2 - Não");
			scanner.nextLine();
		}
		
	}
	
	public static void listarFuncionarios(ArrayList<Funcionario> funcionarios) {
		if(funcionarios.size() == 0) {
			System.out.println("\n\tAinda não há funcionários cadastrados...");
			System.out.println("\tRetornando ao Menu Principal...\n");
			return;
		}
		else {
			System.out.println();
			System.out.println("\n--------------------------------------------------------");
			System.out.println("\t\t FUNCIONARIOS");
			System.out.println("--------------------------------------------------------");
			
			funcionarios.forEach((funcionario) -> System.out.println(funcionario + "\n"));
		}		
	}
}


