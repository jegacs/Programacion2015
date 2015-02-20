package materias;

import java.io.Serializable;

public class Materia implements Serializable {
    public String nombre;
    public double calificacion;
    public Materia(String nombre, double calificacion) {
	this.nombre = nombre;
	this.calificacion = calificacion;
    }
		    
}
				     
