package sesion3_TDD;

public class Cuenta {

	String numero;
	String titular; 
	double saldo;
	
	public Cuenta(String numero, String titular) {
		super();
		this.numero = numero;
		this.titular = titular;
	}
	
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getTitular() {
		return titular;
	}
	public void setTitular(String titular) {
		this.titular = titular;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public void ingresar(int i) {
		saldo-=i;
	}
	
	public void reintegrar(int i) {
		saldo+=i;
	}
	
	
}
