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
        String nombre;
        String grupo;
        int java;
        int web;
        int celulares;
        int cantjava;
        int cantweb;
        int cantcelulares;
        int opcion;
        int opcion2;
        int a=0;

        while (a==0){
            System.out.println("\nSeleccione una de las siguientes opciones:\n\n1)Tipo de implementacion SET.\n2)Ingresar persona.\n3)Mostrar resultados.\n4)Salir.");
            System.out.print("\nOpcion: ");
            opcion = leer.nextInt();
            //verifica que la opcion ingresada sea correcta
            if (opcion==1 || opcion==2 || opcion==3){ opcion = opcion; }
            else if(opcion==4){ System.out.println("\nGracias por utilizar nuestro programa."); a = 1; }
            else { System.out.println("\nERROR. La opcion ingresada no es valida, recuerde que solo puede ingresar numeros de 1 a 3."); }

            //seleccionamos la implementacion que queremos utilizar
            while (opcion==1){ 
                System.out.println("\nSeleccione una implementacion:\n\n1)HashSet.\n2)TreeSet.\n3)LinkedHashSet.");
                System.out.print("\nOpcion: ");
                opcion2 = leer.nextInt();
                //verifica que la opcion ingresada sea correcta
                if (opcion2==1 || opcion2==2 || opcion2==3) { opcion=5; desarrolladores=nfactory.getClase(opcion2); } //creamos la implementacion seleccionada
                else { System.out.println("\nERROR. La opcion ingresada no es valida, recuerde que solo puede ingresar numeros de 1 a 3."); }
            }

            //ingresamos el nombre y el grupo al que pertenecen
            while (opcion==2){ 
                System.out.println("\nIngrese el nombre y luego el grupo al que pertenece. Puede ingresar varios grupos, pero estos se deben ingresar en orden y separadas por coma(,)."); 
                System.out.println("\nNombre: Marlon\nGrupo: 2,3"); 
                System.out.print("\nNombre:"); 
                nombre = leer.next();//leemos el nombre
                System.out.print("\n\n1)Desarrolladores Java.\n2)Desarrolladores Web.\n3)Desarrolladores Celulares.\n"); 
                System.out.print("\nGrupo:");
                //se pone dos veces la instruccion para que se vacie el buffer 
                grupo = leer.nextLine();
                grupo = leer.nextLine();
                //mapeamos cada persona al grupo que pertenece
                if (grupo.equals("1")){ java=1; web=0; celulares=0;  opcion = 5; desarrollador persona = new desarrollador(nombre, java, web, celulares); desarrolladores.add(persona); }
                else if (grupo.equals("2")){ java=0; web=1; celulares=0; opcion = 5; desarrollador persona = new desarrollador(nombre, java, web, celulares); desarrolladores.add(persona); }
                else if (grupo.equals("3")){ java=0; web=0; celulares=1;  opcion = 5; desarrollador persona = new desarrollador(nombre, java, web, celulares); desarrolladores.add(persona); }
                else if (grupo.equals("1,2")){ java=1; web=1; celulares=0; opcion = 5; desarrollador persona = new desarrollador(nombre, java, web, celulares); desarrolladores.add(persona); }
                else if (grupo.equals("1,3")){ java=1; web=0; celulares=1; opcion = 5; desarrollador persona = new desarrollador(nombre, java, web, celulares); desarrolladores.add(persona); }
                else if (grupo.equals("2,3")){ java=0; web=1; celulares=1; opcion = 5; desarrollador persona = new desarrollador(nombre, java, web, celulares); desarrolladores.add(persona); }
                else if (grupo.equals("1,2,3")){ java=1; web=1; celulares=1; opcion = 5; desarrollador persona = new desarrollador(nombre, java, web, celulares); desarrolladores.add(persona); }
                else { System.out.println("La forma ingresada de los grupos no es correcta, por favor intente de nuevo. Recuerde que debe ingresar en orden los grupos y separados por coma(,)."); }
            }
            while (opcion==3){
                //los iteradores ayudan a poder recorrer los set y extraer sus valores
                Iterator<desarrollador> nombres= desarrolladores.iterator();
                Iterator<desarrollador> javas= desarrolladores.iterator();
                Iterator<desarrollador> webs= desarrolladores.iterator();
                Iterator<desarrollador> celular= desarrolladores.iterator();
                //contadores para la cantidad de desarrolladores en cada grupo
                cantjava=0;
                cantweb=0;
                cantcelulares=0;
                //recorremos el set
                while (nombres.hasNext()) {
                    //extraemos los valores
                    nombre = nombres.next().getNombre();
                    java = javas.next().getJava();
                    web = webs.next().getWeb();
                    celulares = celular.next().getCelulares();
                    //incrementamos los contadores de cada grupo
                    if (java==1){ cantjava = cantjava + 1; }
                    if (web==1){ cantweb = cantweb + 1; }
                    if (celulares==1){ cantcelulares = cantcelulares +1; }
                    if (java==1 && web==1 && celulares==1){ grupo1.add(nombre); }
                    if ((java==1 && web==0 && celulares==1) || (java==1 && web==0 && celulares==0)){ grupo2.add(nombre); }
                    if (java==0 && web==1 && celulares==1){ grupo3.add(nombre); }
                    if (java==0 && (web==1 || celulares==1)){ grupo4.add(nombre); }
                }
                //imprimimos las cantidades de cada grupo
                System.out.println("\n--------------------------------------------------\nGRUPO CON EXPERIENCIA EN JAVA, WEB Y CELULARES\n--------------------------------------------------\n");
                System.out.println(grupo1);
                System.out.println("\n--------------------------------------------------\nGRUPO CON EXPERIENCIA EN JAVA PERO NO EN WEB\n--------------------------------------------------\n");
                System.out.println(grupo2);
                System.out.println("\n------------------------------------------------------------\nGRUPO CON EXPERIENCIA EN WEB Y CELULARES PERO NO EN JAVA\n------------------------------------------------------------\n");
                System.out.println(grupo3);
                System.out.println("\n------------------------------------------------------------\nGRUPO CON EXPERIENCIA EN WEB O CELULARES PERO NO EN JAVA\n------------------------------------------------------------\n");
                System.out.println(grupo4);
                break;
            }
            
        }
    }
}