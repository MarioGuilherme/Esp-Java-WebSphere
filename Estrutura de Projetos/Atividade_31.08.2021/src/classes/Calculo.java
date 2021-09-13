package classes;

public class Calculo extends Membros implements Soma_Multiplicacao, Subtracao_Divisao{
	public Calculo(int x, int y) {
		this.setPrimeiroMembro(x);
		this.setSegundoMembro(y);
	}
	
	@Override
	public void start() {
		System.out.println("Iniciando cálculo");
	}

	@Override
	public float Soma() {
		return this.x + this.y;
	}

	@Override
	public float Multiplicacao() {
		return this.x * this.y;
	}

	@Override
	public float Substracao() {
		return this.x - this.y;
	}

	@Override
	public float Divisao() {
		return this.x / this.y;
	}
}