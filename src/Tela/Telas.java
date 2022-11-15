package Tela;
// CLI para facilitar testes com o sistema.
import java.util.Scanner;

import Exception.CepInvalidoException;
import Main.Program;
import Service.ConsultaCep;

public class Telas {

	public static String inicial() throws CepInvalidoException {
		Scanner scan = new Scanner(System.in);

		ConsultaCep cepApi = new ConsultaCep();
		System.out.println("CEP SEARCH - NTT DATA - Rafael Andrade");
		System.out.println("Informe somente numeros.");
		System.out.print("CEP: ");
		String cep = scan.next();

		if (cepApi.cepValido(cep)) {
			return cep;
		}

		throw new CepInvalidoException("Confira se o CEP foi preenchido corretamente");

	}

	public static void opcao() {
		Scanner scan = new Scanner(System.in);
		System.out.println("\n 1 - Nova Busca | 2 - Encerrar");
		int op = scan.nextInt();

		switch (op) {
		case 1:
			Program.main(null);
			break;
		case 2:
			System.out.println("Obrigado por utilizar!");
			System.out.println("Ansioso para fazer parte da empresa!");
			break;

		default:
			Telas.opcao();
			break;
		}

	}

}
