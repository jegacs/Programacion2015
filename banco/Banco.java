package banco;

public class Banco {
    private double cantidadInicial;
    public Banco(double cantidadInicial) throws NegativeStartingBalance { 
	if(cantidadInicial < 0) {
	    throw new NegativeStartingBalance(); 
	}
	else {
	    this.cantidadInicial = cantidadInicial;
	} 
	    
    }
}
