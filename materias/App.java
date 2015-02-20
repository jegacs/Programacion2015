package materias;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.File;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class App {
    public static void main(String arg[]) {
	Materia materias[] = {
	    new Materia("Calculo", 9),
	    new Materia("Ingles", 9.5),
	    new Materia("Etica", 8),
	    new Materia("Administracion", 10),
	    new Materia("Estructura de Datos", 9.12),
	    new Materia("Ecuaciones Diferenciales", 8.76),
	};
	try {
	File f = new File("listado.txt");
	} catch(Exception e) {
	    e.printStackTrace();
	    return;
	}
	
    }
}
	       
