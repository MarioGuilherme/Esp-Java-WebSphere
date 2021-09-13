package atividade_26_08_2021;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		float nota1, nota2, media;
		System.out.print("Digite a 1ª nota do aluno: ");
		nota1 = teclado.nextFloat();
		System.out.print("Digite a 2ª nota do aluno: ");
		nota2 = teclado.nextFloat();
		
		media = (nota1 + nota2) / 2;

		if(media >= 7.0){
			System.out.println("APROVADO");
		}else if(media <= 5){
			System.out.println("EM EXAME");
		}else {
			System.out.println("REPROVADO");
		}
		System.out.format("MEDIA = %.2f", media);
	}
}