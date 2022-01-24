
package Refactori;

import java.io.IOException;


public class Main extends SuperclasePrueba {
	public static void main(String[] args) {
		CuentaCorriente cuenta1;
		double saldoActual;
		int opcion = 0;
		cuenta1 = new CuentaCorriente("Juan López", "1000-2365-85-123456789", 2500, 0);
		do {
			try {
				System.out.println("MENÚ DE OPERACIONES");
				System.out.println("-------------------");
				System.out.println("1 - Ingresar");
				System.out.println("2 - Retirar");
				System.out.println("3 - Finalizar");
				opcion = Integer.parseInt(dato.readLine());
				if (opcion == 1) {
					System.out.println("¿Cuánto desea ingresar?: ");
					float ingresar = Integer.parseInt(dato.readLine());
					operativa_cuenta(cuenta1, ingresar, opcion);
				} else if (opcion == 2) {
					System.out.println("¿Cuátno desea retirar?: ");
					float retirar = Integer.parseInt(dato.readLine());
					operativa_cuenta(cuenta1, retirar, opcion);
				} else if (opcion == 3) {
					System.out.println("Finalizamos la ejecución");
				} else {
					System.err.println("Opción errónea");
				}
/*               switch(opcion){
                case 1:
                    System.out.println("¿Cuánto desea ingresar?: ");
                    float ingresar=Integer.parseInt(dato.readLine());
                    operativa_cuenta(cuenta1,ingresar,opcion);
                    break;
                case 2:
                    System.out.println("¿Cuátno desea retirar?: ");
                    float retirar=Integer.parseInt(dato.readLine());
                    operativa_cuenta(cuenta1,retirar,opcion);
                    break;
                case 3:
                    System.out.println("Finalizamos la ejecución");
            }
*/
			} catch (IOException ex) {
				System.out.println("Error: " + ex.getMessage());
			}
		} while (opcion != 3);
		saldoActual = cuenta1.getSaldo();
		System.out.println("El saldo actual es: " + saldoActual);
		
		CuentaCorriente cuenta2;
		cuenta2 = new CuentaCorriente("Julian López", "1000-2365-85-123455219", 1900, 0);
		visualizarDatosCuenta(cuenta1, cuenta2, "Buenos dias");
	}

	private static void visualizarDatosCuenta(CuentaCorriente cuenta1, CuentaCorriente cuenta2, String saludo) {
		System.out.println("Datos clientes");
		System.out.println(cuenta1.toString());
		System.out.println(cuenta2.toString());
	}

	public static void operativa_cuenta(CuentaCorriente cuenta1, float cantidad, int opcion) {
		if (opcion == 2) {
			try {
				cuenta1.retirar(cantidad);
			} catch (Exception e) {
				System.out.println("Fallo al retirar");
			}
		} else if (opcion == 1) {
			try {
				System.out.println("Ingreso en cuenta");
				cuenta1.ingresar(cantidad);
			} catch (Exception e) {
				System.out.println("Fallo al ingresar");
			}
		}
	}
	
}