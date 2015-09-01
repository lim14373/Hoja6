/*-----------------------------------------------------------------------
Marlon Josue Castillo Martinez              14427
Carlos Javier Lima Cordon                   14373
Fernando Sebastian Castillo Echeverria      14102

Algoritmos y estructura de datos
Seccion 30
Hoja de trabajo 6
-------------------------------------------------------------------------*/

import java.util.Scanner;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Iterator;

public class main {
    public static void main(String[] args) {
        Scanner leer = new Scanner (System.in); //scanner para leer datos
        NameFactory nfactory = new NameFactory(); //creamos el factory para definir la clase
        AbstractSet desarrolladores = null;
        ArrayList grupo1 = new ArrayList(); //grupo de desarrolladores java, web y celulares
        ArrayList grupo2 = new ArrayList(); //grupo de desarrolladores java pero sin experiencia web
        ArrayList grupo3 = new ArrayList(); //grupo de desarrolladores web y celulares pero sin experiencia java
        ArrayList grupo4 = new ArrayList(); //grupo de desarrolladores con experiencia web o celulares pero no de java
		ArrayList grupoJava = new ArrayList(); //grupo de desarrolladores con experiencia java
		ArrayList grupoWeb = new ArrayList(); //grupo de desarrolladores con experiencia web
		ArrayList grupoCelulares = new ArrayList(); //grupo de desarrolladores con experiencia en celulares
        String nombre, grupo, opcion, opcion2;
        int java, web, celulares, cantjava, cantweb, cantcelulares, a=0, subjavaweb;
		boolean javasubweb = false;

        while (a==0){
            System.out.println("\nSeleccione una de las siguientes opciones:\n\n1)Tipo de implementacion SET.\n2)Ingresar persona.\n3)Mostrar resultados.\n4)Salir.");
            System.out.print("\nOpcion: ");
            opcion = leer.nextLine();
            //verifica que la opcion ingresada sea correcta
            if (opcion.equals("1") || opcion.equals("2") || opcion.equals("3")){ opcion = opcion; }
            else if(opcion.equals("4")){ System.out.println("\nGracias por utilizar nuestro programa."); a = 1; }
            else { System.out.println("\nERROR. La opcion ingresada no es valida, recuerde que solo puede ingresar numeros de 1 a 3."); }

            //seleccionamos la implementacion que queremos utilizar
            while (opcion.equals("1")){
                System.out.println("\nSeleccione una implementacion:\n\n1)HashSet.\n2)TreeSet.\n3)LinkedHashSet.");
                System.out.print("\nOpcion: ");
                opcion2 = leer.nextLine();
                //verifica que la opcion ingresada sea correcta
                if (opcion2.equals("1") || opcion2.equals("2") || opcion2.equals("3")) { //creamos la implementacion seleccionada
					opcion="5"; desarrolladores = nfactory.getClase(opcion2);
				}
                else{ System.out.println("\nERROR. La opcion ingresada no es valida, recuerde que solo puede ingresar numeros de 1 a 3."); }
            }

            //ingresamos el nombre y el grupo al que pertenecen
            while (opcion.equals("2")){
                System.out.println("\nIngrese el nombre y luego el grupo al que pertenece. Puede ingresar varios grupos, pero estos se deben ingresar en orden y separadas por coma(,)."); 
                System.out.println("\nEjemplo:\n  Nombre: Marlon\n  Grupo: 2,3"); 
                System.out.print("\nNombre:"); 
                nombre = leer.nextLine();//leemos el nombre
                System.out.print("\n\n1)Desarrolladores Java.\n2)Desarrolladores Web.\n3)Desarrolladores Celulares.\n"); 
                System.out.print("\nGrupo:");
                //se pone dos veces la instruccion para que se vacie el buffer 
                grupo = leer.nextLine();
                //mapeamos cada persona al grupo que pertenece
                if (grupo.equals("1")){ java=1; web=0; celulares=0;  opcion = "5"; desarrollador persona = new desarrollador(nombre, java, web, celulares); desarrolladores.add(persona); }
                else if (grupo.equals("2")){ java=0; web=1; celulares=0; opcion = "5"; desarrollador persona = new desarrollador(nombre, java, web, celulares); desarrolladores.add(persona); }
                else if (grupo.equals("3")){ java=0; web=0; celulares=1;  opcion = "5"; desarrollador persona = new desarrollador(nombre, java, web, celulares); desarrolladores.add(persona); }
                else if (grupo.equals("1,2")){ java=1; web=1; celulares=0; opcion = "5"; desarrollador persona = new desarrollador(nombre, java, web, celulares); desarrolladores.add(persona); }
                else if (grupo.equals("1,3")){ java=1; web=0; celulares=1; opcion = "5"; desarrollador persona = new desarrollador(nombre, java, web, celulares); desarrolladores.add(persona); }
                else if (grupo.equals("2,3")){ java=0; web=1; celulares=1; opcion = "5"; desarrollador persona = new desarrollador(nombre, java, web, celulares); desarrolladores.add(persona); }
                else if (grupo.equals("1,2,3")){ java=1; web=1; celulares=1; opcion = "5"; desarrollador persona = new desarrollador(nombre, java, web, celulares); desarrolladores.add(persona); }
                else { System.out.println("La forma ingresada de los grupos no es correcta, por favor intente de nuevo. Recuerde que debe ingresar en orden los grupos y separados por coma(,)."); }
            }
            while (opcion.equals("3")){
                //los iteradores ayudan a poder recorrer los set y extraer sus valores
                Iterator<desarrollador> nombres= desarrolladores.iterator();
                Iterator<desarrollador> javas= desarrolladores.iterator();
                Iterator<desarrollador> webs= desarrolladores.iterator();
                Iterator<desarrollador> celular= desarrolladores.iterator();
				
                //contadores para la cantidad de desarrolladores en cada grupo
                cantjava=0;
                cantweb=0;
                cantcelulares=0;
				subjavaweb=0;
				
                //recorremos el set
                while (nombres.hasNext()) {
                    //extraemos los valores
                    nombre = nombres.next().getNombre();
                    java = javas.next().getJava();
                    web = webs.next().getWeb();
                    celulares = celular.next().getCelulares();
                    //incrementamos los contadores de cada grupo
                    if (java==1){ grupoJava.add(nombre); cantjava = cantjava + 1; }
                    if (web==1){ grupoWeb.add(nombre); cantweb = cantweb + 1; }
                    if (celulares==1){ grupoCelulares.add(nombre); cantcelulares = cantcelulares +1; }
					if (java == 1 && web == 1){ subjavaweb = subjavaweb + 1; }
                    if (java==1 && web==1 && celulares==1){ grupo1.add(nombre); }
                    if ((java==1 && web==0 && celulares==1) || (java==1 && web==0 && celulares==0)){ grupo2.add(nombre); }
                    if (java==0 && web==1 && celulares==1){ grupo3.add(nombre); }
                    if (java==0 && (web==1 || celulares==1)){ grupo4.add(nombre); }
					if (cantjava == subjavaweb && cantweb >= cantjava){ javasubweb = true; }
					else{ javasubweb = false; }
                }
                //imprimimos las cantidades de cada grupo
                System.out.println("\n--------------------------------------------------\nGRUPO CON EXPERIENCIA EN JAVA, WEB Y CELULARES\n--------------------------------------------------\n");
                System.out.println(" " + grupo1);
                System.out.println("\n--------------------------------------------------\nGRUPO CON EXPERIENCIA EN JAVA PERO NO EN WEB\n--------------------------------------------------\n");
                System.out.println(" " + grupo2);
                System.out.println("\n------------------------------------------------------------\nGRUPO CON EXPERIENCIA EN WEB Y CELULARES PERO NO EN JAVA\n------------------------------------------------------------\n");
                System.out.println(" " + grupo3);
                System.out.println("\n------------------------------------------------------------\nGRUPO CON EXPERIENCIA EN WEB O CELULARES PERO NO EN JAVA\n------------------------------------------------------------\n");
                System.out.println(" " + grupo4);
				System.out.println("\n-----------------------------------\n¿JAVA ES UN SUBCONJUNTO DE WEB?\n-----------------------------------\n");
                if(javasubweb){ System.out.println(" SI"); }
				else { System.out.println(" NO"); }
				System.out.println("\n----------------------------------------------------\nEL GRUPO CON MAYOR CANTIDAD DE DESARROLLADORES\n----------------------------------------------------\n");
				if(cantjava == cantweb && cantjava == cantcelulares){
					System.out.println(" TODOS LOS GRUPOS TIENEN LA MISMA CANTIDAD DE DESARROLLADORES\n");
					System.out.println(" JAVA: " + grupoJava);
					System.out.println(" WEB: " + grupoWeb);
					System.out.println(" CELULARES: " + grupoCelulares);
				}else if(cantjava == cantweb && cantcelulares < cantjava){
					System.out.println(" JAVA Y WEB TIENEN LA MAYOR CANTIDAD DE DESARROLLADORES\n");
					System.out.println(" JAVA: " + grupoJava);
					System.out.println(" WEB: " + grupoWeb);
				}else if(cantjava == cantcelulares && cantweb < cantjava){
					System.out.println(" JAVA Y CELULARES TIENEN LA MAYOR CANTIDAD DE DESARROLLADORES\n");
					System.out.println(" JAVA: " + grupoJava);
					System.out.println(" CELULARES: " + grupoCelulares);
				}else if(cantweb == cantcelulares && cantjava < cantweb){
					System.out.println(" WEB Y CELULARES TIENEN LA MAYOR CANTIDAD DE DESARROLLADORES\n");
					System.out.println(" WEB: " + grupoWeb);
					System.out.println(" CELULARES: " + grupoCelulares);
				}else if (cantjava > cantweb){
					if(cantjava > cantcelulares){
						System.out.println(" JAVA TIENE LA MAYOR CANTIDAD DE DESARROLLADORES\n");
						System.out.println(grupoJava);
					}else{
						System.out.println(" CELULARES TIENE LA MAYOR CANTIDAD DE DESARROLLADORES\n");
						System.out.println(grupoCelulares);
					}
				}else if(cantweb > cantcelulares){
					System.out.println(" WEB TIENE LA MAYOR CANTIDAD DE DESARROLLADORES\n");
					System.out.println(grupoWeb);
				}else{
					System.out.println(" CELULARES TIENE LA MAYOR CANTIDAD DE DESARROLLADORES\n");
					System.out.println(grupoCelulares);
				}
				grupo1.clear();
				grupo2.clear();
				grupo3.clear();
				grupo4.clear();
				grupoJava.clear();
				grupoWeb.clear();
				grupoCelulares.clear();					
                break;
            }
        }
    }
}
