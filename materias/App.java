package materias;

import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.File;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileReader;
import java.util.Scanner;
import java.io.EOFException;
import java.io.OptionalDataException;
public class App {
    public static void main(String arg[]) throws IOException   {
	Materia materias[] = {
	    new Materia("Calculo", 9),
	    new Materia("Ingles", 9.5),
	    new Materia("Etica", 8),
	    new Materia("Administracion", 10),
	    new Materia("Estructura de Datos", 9.12),
	    new Materia("Ecuaciones Diferenciales", 8.76),
	};

	File f = new File("listado.txt");

	ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(f));
	for(Materia m : materias) {
	    out.writeObject(m);
	}
	out.writeInt(3223);
	out.close();

	ObjectInputStream in = new ObjectInputStream(new FileInputStream(f));
	Scanner scanner = new Scanner(new FileReader(f));
	try {
	    while(scanner.hasNext()) {
		try {
		    Materia m = (Materia)in.readObject();
		    System.out.println(m.nombre + " " + m.calificacion);
		} catch(ClassNotFoundException nf) {
		    System.out.println("No se encontro la clase, se ignorara");
		} catch(OptionalDataException ode) {
		    System.out.println("Se encontro un dato primitivo");
		}
	    }
	} catch(EOFException eof) {
	    in.close();
	}
    }
}
	       
