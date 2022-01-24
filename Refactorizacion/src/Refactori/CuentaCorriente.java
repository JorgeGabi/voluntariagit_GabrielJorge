package Refactori;



public class CuentaCorriente {

	private static final int ZERO = 0;
	/**
	 * 
	 */
	protected String nombre;
	private String cuenta;
	private double saldo;
	private double tipoInterés;

	public CuentaCorriente() {
	}

	public CuentaCorriente(String nom, String cue, double sal, double tipo) {
		nombre = nom;
		cuenta = cue;
		saldo = sal;
		tipoInterés = tipo;
	}

	public void asignarNombre(String nom) {
		nombre = nom;
	}

	public String getNombre() {
		return nombre;
	}

	public double getSaldo() {
		return saldo;
	}

	public void ingresar(double cantidad) throws Exception {
		if (cantidad < ZERO) {
			throw new Exception("No se puede ingresar una cantidad negativa");
		}
		setSaldo(saldo + cantidad);
	}

	public void retirar(double cantidad) throws Exception {
		if (cantidad < ZERO) {
			throw new Exception("No se puede retirar una cantidad negativa");
		}
		if (getSaldo() < cantidad) {
			throw new Exception("No se hay suficiente saldo");
		}
		setSaldo(saldo - cantidad);
	}

	public String getCuenta() {
		return cuenta;
	}

	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public double getTipoInteres() {
		return tipoInterés;
	}

	public void setTipoInteres(double tipoInteres) {
		this.tipoInterés = tipoInteres;
	}
}