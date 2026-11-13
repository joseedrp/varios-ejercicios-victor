import java.util.Scanner;
import java.util.InputMismatchException;

public class Ejercicio02Edad {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        try {
            System.out.print("Introduce tu edad: ");
            int edad = teclado.nextInt();
            System.out.println("Tu edad es: " + edad);
        } catch (InputMismatchException error) {
            // nextInt no puede leer texto ni numeros fuera del rango de int.
            System.out.println("Error: Debes introducir un numero entero.");
        }
        teclado.close();
    }
}
