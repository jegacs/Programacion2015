package banco;

public class NegativeStartingBalance extends Exception {
    public NegativeStartingBalance() {
        super("Error: Balance inicial negativo");
    }
    public NegativeStartingBalance(double amount) {
        super("Error: Balance incial negativo = " + amount);
    }
}
