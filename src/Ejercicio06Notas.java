import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Locale;

public class Ejercicio06Notas {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        teclado.useLocale(Locale.US);
        boolean notaValida = false;
        while (!notaValida) {
            try {
                System.out.print("Introduce una nota (decimal con punto): ");
                double nota = teclado.nextDouble();
                validarNota(nota);
                notaValida = true; // Solo salimos si la validacion no lanza errores.
            } catch (InputMismatchException error) {
                System.out.println("Error: Debes introducir un numero con punto decimal.");
                teclado.nextLine(); // Descarta la entrada incorrecta para no repetir el error.
            } catch (IllegalArgumentException error) {
                System.out.println("Error: " + error.getMessage());
            }
        }
        teclado.close();
    }

    static void validarNota(double nota) throws IllegalArgumentException {
        if (Double.isNaN(nota) || nota < 0 || nota > 10) {
            throw new IllegalArgumentException("La nota debe estar comprendida entre 0 y 10.");
        }
        System.out.println("Nota introducida correctamente: " + nota);
    }
}
