import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Locale;

public class Ejercicio05CuentaBancaria {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        teclado.useLocale(Locale.US);
        String titular = "Juan";
        double saldo = 500;
        System.out.println("Titular: " + titular);
        System.out.println("Saldo inicial: " + saldo + " EUR");
        try {
            System.out.print("Cantidad que desea retirar (decimal con punto): ");
            double cantidad = teclado.nextDouble();
            // Solo se asigna el nuevo saldo si el metodo termina sin excepciones.
            saldo = retirarDinero(saldo, cantidad);
            System.out.println("Retirada realizada correctamente.");
        } catch (InputMismatchException error) {
            System.out.println("Error: Debes introducir un numero con punto decimal.");
        } catch (SaldoInsuficienteException error) {
            System.out.println("Error: " + error.getMessage());
        } catch (IllegalArgumentException error) {
            System.out.println("Error: " + error.getMessage());
        }
        System.out.println("Saldo actual: " + saldo + " EUR");
        teclado.close();
    }

    static double retirarDinero(double saldo, double cantidad) throws SaldoInsuficienteException {
        if (Double.isNaN(cantidad) || Double.isInfinite(cantidad) || cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser positiva y finita.");
        }
        if (cantidad > saldo) {
            throw new SaldoInsuficienteException("Saldo insuficiente para realizar la operacion.");
        }
        return saldo - cantidad;
    }
}
