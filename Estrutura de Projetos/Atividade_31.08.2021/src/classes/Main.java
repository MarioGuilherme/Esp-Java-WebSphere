package classes;

public class Main {

	public static void main(String[] args){
		Calculo operadores = new Calculo(3, 4);
		System.out.println(operadores.Soma());
		System.out.println(operadores.Multiplicacao());
		System.out.println(operadores.Divisao());
		System.out.println(operadores.Substracao());
	}
}