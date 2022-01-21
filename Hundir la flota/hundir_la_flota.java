import java.util.Scanner;
import java.lang.Math;
public class hundir_la_flota {
	/*
		Se declaran final que se usaran en todos los metodos.
		Intente declarar las variables aqui fuera pero no me permite usarlas
	  si los metedos son static.
	 */	
		public static final char AGUA='A';
		public static final char AGUA_NO_TOCADO='.';
		public static final char TOCADO='X';
		public static final int TAMANNO=10;
		public static Scanner sc=new Scanner(System.in);
		public static int f,c;
	
	public static void main(String[] args) throws InterruptedException{
		//Se declaran variables y arrays
		int puntosJugador=24;
		int puntosOrdenador=24;
		boolean juegoTerminado=false;
		boolean tiroCorrecto=false;
		char[][] mapaUsuario=new char[TAMANNO][TAMANNO];
		char[][] mapaOrdenador=new char[TAMANNO][TAMANNO];
		char[][] mapaOrdenadorParaUsuario=new char[TAMANNO][TAMANNO];
		int disparo[]= new int[2];
		boolean disparoCorrecto=false;
		char resuladoDisparo="A";
		
		inicializacionMapa(mapaUsuario);
		inicializacionMapa(mapaOrdenador);
		inicializacionMapa(mapaOrdenadorParaUsuario);
		registraBarcos(mapaUsuario);
		registraBarcos(mapaOrdenador);
		
		while(puntosOrdenador!=0 && puntosJugador!=0){
			//Dispara usuario
			System.out.println("TU TURNO");
			System.out.println("PUNTOS ORDENADOR: "+puntosOrdenador);
			System.out.println("TUS PUNTOS: "+puntosJugador);
			imprimirMapa("\tMAPA ORDENADOR PARA USUARIO", mapaOrdenadorParaUsuario);
			disparoCorrecto=false;
			while(!disparoCorrecto){
				disparo=pedirCasilla();
				if (disparo[0]=-1){
					resultadoDisparo=evaluarDisparo(disparo, mapaOrdenador);
					if(resuladoDisparo=='E'){
						System.out.println("DISPARO NO VALIDO");
					}else{				
						disparoCorrecto=true;	
						fila=disparo[0];
						columna=disparo[1];
						mapaOrdenadorParaUsuario[fila][columna]=resultadoDisparo;
						mapaOrdenador[fila][columna]=resutladoDisparo;
						if(resultadoDisparo=='X') puntosOrdenador--;
					}
				}else System.out.println("COORDENADAS NO VALIDAS");
			}
			System.out.println("PUNTOS ORDENADOR: "+puntosOrdenador);
			imprimirMapa("\tMAPA ORDENADOR PARA USUARIO", mapaOrdenadorParaUsuario);
			Thread.sleep(3000);
			
			if(puntosOrdenador!=0){
				//dispara ordenador
				System.out.println("TURNO ORDENADOR");
				System.out.println("PUNTOS ORDENADOR: "+puntosOrdenador);
				System.out.println("TUS PUNTOS: "+puntosJugador);
				
				disparoCorrecto=false;
				while(!disparoCorrecto){
				disparo=generarDisparoAleatorio();
				
					resultadoDisparo=evaluarDisparo(disparo, mapaUsuario);
					if(resuladoDisparo=='E'){
						System.out.println("DISPARO NO VALIDO");
					}else{				
						disparoCorrecto=true;	
						fila=disparo[0];
						columna=disparo[1];
						mapaUsuario[fila][columna]=resultadoDisparo;
						if(resultadoDisparo=='X') puntosJugador--;
					}
				
			}
			System.out.println("PUNTOS ORDENADOR: "+puntosOrdenador);
				System.out.println("TUS PUNTOS: "+puntosJugador);
			System.out.println("PUNTOS ORDENADOR: "+puntosOrdenador);
			imprimirMapa("MAPA USUARIO", mapaUsuario);
			Thread.sleep(3000);
				
			}
		}
		if(puntosOrdenador==0)System.out.println("ENHORABUENA, HAS GANADO");
		if(puntosJugador==0)System.out.println("ERES UN PERDEDOR");
	}
	
	public static int[] generarDisparoAleatorio(){
	int[]c=new int [2];
	c[0]=(int)(Math.random()*TAMANNO);
	c[1]=(int)(Math.random()*TAMANNO);
	return c;
	}
	
	public static int [] pedirCasilla(){
		//Declaracion del vector donde se van a guardar las coordenadas
		int[] c= new int[2];
		String coordenadas;
		char coordenada1, coordenada2;
		System.out.println("Introduce las coordenadas del disparo");
		coordenadas=sc.next();
		coordenada1=Character.toUpperCase(coordenadas.charAt(0));
		coordenada2=coordenadas.charAt(1);
		if(Character.getNumericValue(coordenada1)<Character.getNumericValue('A')+TAMANNO)&&(Character.getNumericValue(coordenada2)<Character.getNumericValue('0')+TAMANNO){
			c[0]=Character.getNumericValue(coordenada1)-Character.getNumericValue('A');
			c[1]=Character.getNumericValue(coordenada2)-Character.getNumericValue('0');
		}else{
			c[0]=-1;
			c[1]=-1;
	} 
		return c;
	}
	
	public static char evaluarDisparo(int[] d, char[][] m){
		int fila, columna;
		fila=d[0];
		columna= d[1];
		if(m[fila][columna]>=1 && m[fila][columna]<=5) return 'X';
		else 
			if(m[fila][columna]== AGUA_NO_TOCADO) return 'A';
			else return 'E';
	
	}
	
  
	//Se crea metodo para iniciar los mapas
	public static void inicializacionMapa(char[][] mapa) {
		
		
		for( f=0; f<TAMANNO; f++){
			for( c=0; c<TAMANNO; c++){
				mapa[f][c]=AGUA_NO_TOCADO;
			}
		}
	}
		
	//Se crea metodo para colocar los barcos
	public static void registraBarcos(char[][] mapa) {
		int[] barcos={5,5,3,3,3,1,1,1,1,1};
		char[] posicion={'H','V'};
		int fila,columna, direccion;
		boolean ok=true;
		for(int i=0; i<barcos.length;i++){				
			do{
				ok=true;
				fila=(int)(Math.random()*10);
				columna=(int)(Math.random()*10);
				direccion=(fila+columna)%2;
				if(posicion[direccion]=='H'){
					if(columna+barcos[i]<TAMANNO){
						for(c=columna;c<TAMANNO;c++){
							
							if(mapa[fila][c]!='.'){
								ok=false;								
							}
						}							
					}else ok=false;
				}else if (posicion[direccion]=='V'){
					if(fila+barcos[i]<TAMANNO){
						for(f=fila;f<TAMANNO;f++){
							
							if(mapa[f][columna]!='.'){
								ok=false;
							}
						}							
					}else ok=false;
				}
			}while(!ok);
			if(ok && posicion[direccion]=='H'){
				for(c=columna;c<(columna+barcos[i]);c++){
					mapa[fila][c]=(char)(barcos[i]+48);
				}
			}else{
				for(f=fila;f<(fila+barcos[i]);f++){
					mapa[f][columna]=(char)(barcos[i]+48);
				}
			}
		}
	}	
	
	//Se crea metodo para visulizar los mapas
	public static void imprimirMapa(char[][] mapa) {
		String[] numeros={"[0]","[1]","[2]","[3]","[4]","[5]","[6]","[7]","[8]","[9]"};
		String[] letras={"[A]","[B]","[C]","[D]","[E]","[F]","[G]","[H]","[I]","[J]"};
		System.out.print("     ");
		for( f=0; f<TAMANNO; f++){
			System.out.print(numeros[f]+" ");
		}
		System.out.println();
		for( f=0; f<TAMANNO; f++){
			System.out.print(letras[f]);
			for( c=0; c<TAMANNO; c++){
				System.out.print("   "+mapa[f][c]);
			}
		System.out.println();
		}
	}
}
	