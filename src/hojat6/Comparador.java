/*-----------------------------------------------------------------------
Marlon Josue Castillo Martinez				14427
Carlos Javier Lima Cordon					14373
Fernando Sebastian Castillo Echeverria		14102

Algoritmos y estructura de datos
Seccion 30
Hoja de trabajo 6
-------------------------------------------------------------------------*/

//importamos la clase comparator
import java.util.Comparator;
	public class Comparador implements Comparator<desarrollador>{
	    //compara los nombres para crear un orden alfabetico
	    public int compare(desarrollador primero, desarrollador segundo){
	        return primero.getNombre().compareTo(segundo.getNombre());
	    }
}