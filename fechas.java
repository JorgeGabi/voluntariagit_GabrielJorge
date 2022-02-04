package practica7_3;
import java.util.Scanner;
public class Fecha {
	int dia, mes, anio;
	Scanner sc=new Scanner(System.in);

	public Fecha(int dia, int mes, int anio) {
		this.dia=dia;
		this.mes=mes;
		this.anio=anio;
	}
	
	public Fecha() {
		do {
			System.out.println("Introduce el día: ");
			dia=sc.nextInt();
		}while(dia>0 && dia<31);
		do {
			System.out.println("Introduce el mes: ");
			mes=sc.nextInt();
		}while(mes>0 && mes<=12);
		do {
			System.out.println("Introduce el año: ");
			anio=sc.nextInt();
		}while(anio>0);
	}
	
	public boolean anioBisiesto(int anno){
		boolean bisiesto=false;
		
		
		
		return bisiesto;
	}
	public int tiempoTranscurrido(int dia, int mes, int anio) {
		int diferencia=0, dia2, mes2, anio2;
		do {
			System.out.println("Introduce el día: ");
			dia2=sc.nextInt();
		}while(dia2>0 && dia<31);
		do {
			System.out.println("Introduce el mes: ");
			mes2=sc.nextInt();
		}while(mes2>0 && mes<=12);
		do {
			System.out.println("Introduce el año: ");
			anio2=sc.nextInt();
		}while(anio2>0);
		diferencia=(anio*365+mes*30+dia)-(anio2*365+mes2*30+dia2);
		return diferencia;
	}
	
	public String cadenaFecha() {
		String formato;
		
		
		return formato;
	}
}