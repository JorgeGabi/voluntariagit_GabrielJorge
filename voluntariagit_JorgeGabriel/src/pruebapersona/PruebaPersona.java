/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebapersona;

import java.util.Scanner;

/**
 *
 * @author mario
 */
public class PruebaPersona {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         // Instanciamos personas
        Scanner teclado = new Scanner (System.in);
      
              
        /* 
         if (Persona.validarDNI(dni)){
         
            Persona per1 = new Persona();
            per1.setApellidos(ape);
            per1.setDni(dni);
            per1.setEdad(edad);
            per1.setNombre(nombre);}
         
         else {
            System.err.println("ERROR, FORMATO DE DNI INCORRECTO. EL OBJETO NO HA SIDO CREADO");
             
         }*/
                  
      
         Persona per2 = new Persona("20222444L", "María", "Carcelén Sánchez", 67);
         Persona per3 = new Persona("José", "Serrano Márquez", 25);
         Persona per4 = new Persona("64578488K","Pedro", "De la Calle García", 55);
         
      //   System.out.println(per2.toString()); //Sin override, java se va a buscar toString a la clase String
                                              //Con override, java busca primero en mi clase el método override, y si no encuentra ya se va a String  
         
         
         
       //  per3.imprime();
       //  per3.setEdad(per3.getEdad()+1);
      //   per3.imprime();
      //   per3.updateEdad();
      //   per3.imprime();
         
         /*
        System.out.println("La persona con DNI: " + per2.getDni() + " ¿es menor de edad? --> " + per2.esMenor());
         System.out.println("La persona con DNI: " + per3.getDni() + " ¿es menor de edad? --> " + per3.esMenor());
         
         System.out.println("La persona con DNI: " + per2.getDni() + " ¿es jubilado/a? --> " + per2.esJubilado());
         System.out.println("La persona con DNI: " + per3.getDni() + " ¿es jubilado/a? --> " + per3.esJubilado());
         
         
         int dif=per2.diferenciaEdad(per3);
         System.out.println("Diferencia de edad: " + dif);
         
         dif=per3.diferenciaEdad(per2);
         System.out.println("Diferencia de edad: " + dif);
         
         */
         
     
     
     
     
     
        
         Persona[] arrayPersonas = new Persona[2];
        /**
         * Este bucle recorre el array de personas. Para ello declaramos una
         * variable del tipo de dato que contiene el array y la estructura
         * automáticamente hace que la variable per (de tipo Persona) apunte a
         * una posición del array en cada iteración;primero apunta a la primera
         * posición (primera per), luego la segunda, etc consecutivamente
         */
         for (Persona per : arrayPersonas) {
            per = new Persona();            
            per.imprime();
        }
        
        System.out.println("");
     /*   for (Persona perAux : arrayPersonas) {
            perAux.imprime();
        }
       */  
         /*
        for (int i=0;i<arrayPersonas.length;i++){
            
                System.out.println("Introduce el DNI");
                String dni=teclado.next();
                System.out.println("Introduce el nombre");
                String nombre=teclado.next();
                System.out.println("Introduce apellidos");
                String ape=teclado.next();
                System.out.println("Introduce la edad");
                int edad=teclado.nextInt();
                System.out.println("----------------------------");
                System.out.println("");
            
            arrayPersonas[i] = new Persona(dni,nombre,ape,edad);
            arrayPersonas[i].imprime();
            
        }*/
        
        
        
        /*Debemos tener en cuenta que creamos un array CAPAZ DE APUNTAR (pero que de inicio no apunta
        a objetos de tipo persona en cada una de sus posiciones. Primero debemos crear objetos de tipo Persona
        para cada posición y luego decirle a la referencia de cada una de esas posiciones que apunte a dicha estructura*/
      
     
         
        for (int i = 0; i < arrayPersonas.length; i++) {
            
            
            arrayPersonas[i] = new Persona("74785847K", "Lourdes", "García Palacios",43);//creamos 3 personas iguales
        }
         System.out.println("");
        for (Persona perAux : arrayPersonas) {
            perAux.imprime();
        }
        
        int dif=arrayPersonas[0].diferenciaEdad(arrayPersonas[1]);
        System.out.println("Diferencia de edad: " + dif);
        
        
         
     
        
        
    }
    
}
