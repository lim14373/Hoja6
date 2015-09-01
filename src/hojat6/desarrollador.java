/*-----------------------------------------------------------------------
Marlon Josue Castillo Martinez				14427
Carlos Javier Lima Cordon					14373
Fernando Sebastian Castillo Echeverria		14102

Algoritmos y estructura de datos
Seccion 30
Hoja de trabajo 6
-------------------------------------------------------------------------*/

class desarrollador {

	//se almacenana los nombres y los grupos a los que pertenecen
	private String nombre;
	int[] conjuntos= new int[3];

//constructor
	public desarrollador(String nombre, int conjunto1, int conjunto2, int conjunto3) {
		this.nombre = nombre;
		conjuntos[0]=conjunto1;
        conjuntos[1]=conjunto2;
        conjuntos[2]=conjunto3;
	}

//get y set para nombres y conjuntos
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setConjuntos (int[] conjuntos){
        this.conjuntos=conjuntos;
    }

	public int getJava(){
        return conjuntos[0];
    }

    public int getWeb(){
        return conjuntos[1];
    }
    
    public int getCelulares(){
        return conjuntos[2];
    }

}