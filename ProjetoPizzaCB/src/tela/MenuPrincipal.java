package tela;

import java.util.Scanner;

import processamento.Pizzas;
import processamento.RegistrarPizzas;


/**
 * DATE: 03 Sep - 2020
 * @author Thalia Isabel de Souza
 *
 */
public class MenuPrincipal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int menu = 0;
		RegistrarPizzas registrar = new RegistrarPizzas();
		
		while (menu != 3) {
			System.out.println("--- Precificação de Pizzas ---");
			System.out.println("1 - Cadastrar Pizza");
			System.out.println("2 - Acessar Relatório");
			System.out.println("3 - Sair.");
			menu = sc.nextInt();
			System.out.println();
			
			switch (menu) {
			case 1:
				while (menu == 1) {
					System.out.println("Nome comercial da pizza: ");
					String nome = sc.next();
					
					System.out.println("Tamanho (diâmetro em cm): ");
					int tamanho = sc.nextInt();
					
					System.out.println("Preço: ");
					double preco = sc.nextDouble();
					
					Pizzas pizza = new Pizzas(nome, tamanho, preco);
					System.out.println(registrar.adicionaPizza(pizza));
					
					System.out.println("Deseja registrar mais uma pizza? 1 - Sim, 2 - Não.");
					menu = sc.nextInt();
					System.out.println();
				}
				break;
			case 2:
				registrar.ordernarPcm();
				registrar.calculaVP();
				System.out.println();
				System.out.println("------------------------- Relatório ---------------------------");
				System.out.println("Nome  Tamanho  Preço    Preço/cm               Custo Benefício");
				for (int i = 0; i < registrar.getPizzas().length-1; i++) {
					System.out.println(registrar.getPizzas()[i].toString());
				}
				System.out.println("---------------------------------------------------------------");
				System.out.println();
				break;
			case 3:
				break;
			default:
				System.out.println("Opção Inválida.");
				break;
			}
		}
		System.out.println("Encerrando o Programa...");
	}

}
