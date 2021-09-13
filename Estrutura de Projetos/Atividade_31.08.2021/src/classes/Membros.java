package classes;

public abstract class Membros {
	int x, y;

	public float getPrimeiroMembro() {
		return x;
	}

	public void setPrimeiroMembro(int x) {
		this.x = x;
	}

	public float getSegundoMembro() {
		return y;
	}

	public void setSegundoMembro(int y) {
		this.y = y;
	}
	
	public abstract void start();
}