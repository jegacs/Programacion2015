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
import java.lang.ClassCastException;
public class App {
    public static void main(String arg[]) throws IOException   {
	double promedio = 0;
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
	out.writeObject(new Parasito());
	for(Materia m : materias) {
	    out.writeObject(m);
	    promedio = promedio + m.calificacion;
	}
	promedio = promedio/materias.length;
	out.writeInt(3223);
	out.writeObject(new Parasito());
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
		    // Excepcion lanzada cuando se encuentra un dato primitivo
		    // al leer el archivo.
		    System.out.println("Error: se intento leer un dato primitivo");
		    //ode.printStackTrace();
		    
		    /*
		      La clase OptionalDataException tiene un atributo publico length, 
		      donde se almacena el numero de bytes encontrados de datos primitivos.
		      Usamos el metodo skip() de ObjectInputStream, pasando como argumento
		      el numero de bytes, para saltar el numero de bytes encontrados.
		    */
		    in.skip(ode.length); 
		} catch (ClassCastException cce){
		    System.out.println("Error: Encontrado un objeto diferente a Materia");
		}
	    }
	} catch(EOFException eof) {
	    /*
	      La clase scanner no cuenta con una funcion que determine EOF,
	      sin embargo, lanza una excepcion cuando se ha encontrado el final
	      del archivo. Se ha optado por hacerlo de esta manera para leer 
	      una cantidad arbitraria de objetos.
	     */
	    in.close();
	}
	System.out.println("Promedio " + promedio);
    }
}
	       
