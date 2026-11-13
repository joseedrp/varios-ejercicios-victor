import java.util.Scanner;
import java.util.InputMismatchException;

public class Ejercicio01Division {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        try {
            System.out.print("Introduce el primer numero: ");
            int primero = teclado.nextInt();
            System.out.print("Introduce el segundo numero: ");
            int segundo = teclado.nextInt();
            // La division entera entre cero produce ArithmeticException.
            System.out.println("Resultado (division entera): " + (primero / segundo));
        } catch (ArithmeticException error) {
            System.out.println("Error: No se puede dividir entre cero.");
        } catch (InputMismatchException error) {
            System.out.println("Error: Debes introducir numeros enteros.");
        }
        // Se llega aqui tanto si la division funciona como si se captura un error.
        System.out.println("Fin del programa.");
        teclado.close();
    }
}
