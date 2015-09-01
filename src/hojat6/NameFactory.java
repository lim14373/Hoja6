/*-----------------------------------------------------------------------
Marlon Josue Castillo Martinez            14427
Carlos Javier Lima Cordon                 14373
Fernando Sebastian Castillo Echeverria    14102

Algoritmos y estructura de datos
Seccion 30
Hoja de trabajo 6
-------------------------------------------------------------------------*/

//importamos las clases set
import java.util.AbstractSet;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.LinkedHashSet;

class NameFactory {
//regresa la implementacion de la clase
   	public  AbstractSet getClase(int entry) {
   		AbstractSet implementacion = null;
   		if (entry==1)
      		implementacion= new HashSet<desarrollador>();
   		if (entry==2)
      		implementacion= new TreeSet<desarrollador>(new Comparador()); //para crear un orden especifico se utiliza el comparador
      	if (entry==3)
      		implementacion= new LinkedHashSet<desarrollador>();
      	return implementacion;
   }
}