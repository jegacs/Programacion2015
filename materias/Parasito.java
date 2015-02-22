/* Clase dummy, para probar que pasa si se 'deserializa' 
   un objeto diferente al esperado
*/

package materias;

import java.io.Serializable;

public class Parasito implements Serializable {
    public int entero = 10;
    public String string = new String("");
    public double flotante = 4.30;
        
}
