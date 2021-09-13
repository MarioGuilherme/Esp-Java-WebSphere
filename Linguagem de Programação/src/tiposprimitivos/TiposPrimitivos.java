package tiposprimitivos;

import java.util.Scanner;

public class TiposPrimitivos {

	public static void main(String[] args) {
		// Entrada e saídas de dados formatados
		Scanner teclado = new Scanner(System.in);
		System.out.println("Digite o nome do aluno: ");
		String nome = teclado.nextLine();
		System.out.println("Digite a nota do aluno: ");
		float nota = teclado.nextFloat();
		System.out.format("A nota de %s foi %.1f", nome, nota);

		// Convertendo de int para string
		/*int idade = 30;
		String valor = Integer.toString(idade);
		System.out.println(valor);
		*/
		// Convertendo de string para int
		/*String valor = "30";
		int idade = Interger.parseInt(valor);
		System.out.println("%.3f", idade);
		*/
	}
	// Mário Guilherme
}