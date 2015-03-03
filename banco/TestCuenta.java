package banco;

import java.util.Scanner;

public class TestCuenta {
    public static void main(String args[]) throws NegativeStartingBalance {
	Scanner scanner = new Scanner(System.in);
	System.out.println("Inserte cantidad inicial");
	double in = scanner.nextDouble();
	
	Banco banco = new Banco(in);
	
    }
}
