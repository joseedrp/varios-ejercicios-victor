// Unica clase adicional permitida por el ejercicio 5.
// Al heredar de Exception, es una excepcion comprobada (checked).
public class SaldoInsuficienteException extends Exception {
    public SaldoInsuficienteException(String mensaje) {
        super(mensaje); // Guarda el mensaje para recuperarlo con getMessage().
    }
}
