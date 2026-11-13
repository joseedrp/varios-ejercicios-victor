import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Locale;

public class Ejercicio04Raiz {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        teclado.useLocale(Locale.US); // Los decimales se escriben con punto.
        try {
            System.out.print("Introduce un numero (decimal con punto): ");
            double numero = teclado.nextDouble();
            System.out.println("La raiz cuadrada es: " + calcularRaiz(numero));
        } catch (InputMismatchException error) {
            System.out.println("Error: Debes introducir un numero con punto decimal.");
        } catch (IllegalArgumentException error) {
            System.out.println("Error: " + error.getMessage());
        }
        teclado.close();
    }

    // throws declara la excepcion; throw la lanza cuando se detecta el problema.
    static double calcularRaiz(double numero) throws IllegalArgumentException {
        if (numero < 0) {
            throw new IllegalArgumentException("No se puede calcular la raiz cuadrada de un numero negativo.");
        }
        if (Double.isNaN(numero) || Double.isInfinite(numero)) {
            throw new IllegalArgumentException("El numero debe ser finito.");
        }
        return Math.sqrt(numero);
    }
}
