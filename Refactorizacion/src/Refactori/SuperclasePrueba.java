package Refactori;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SuperclasePrueba {

	public static BufferedReader getDato() {
		return dato;
	}

	public static void setDato(BufferedReader dato) {
		Main.dato = dato;
	}

	protected static BufferedReader dato = new BufferedReader(new InputStreamReader(System.in));

	public SuperclasePrueba() {
		super();
	}

}