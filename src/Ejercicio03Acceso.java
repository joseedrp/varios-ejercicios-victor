import java.util.Scanner;
import java.util.InputMismatchException;

public class Ejercicio03Acceso {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        try {
            System.out.print("Introduce tu edad: ");
            int edad = teclado.nextInt();
            comprobarEdad(edad);
        } catch (InputMismatchException error) {
            System.out.println("Error: Debes introducir un numero entero.");
        } catch (IllegalArgumentException error) {
            // getMessage recupera el mensaje que pusimos al lanzar la excepcion.
            System.out.println("Error: " + error.getMessage());
        }
        teclado.close();
    }

    static void comprobarEdad(int edad) {
        if (edad < 18) {
            // throw lanza el error y termina la ejecucion normal del metodo.
            throw new IllegalArgumentException("La edad debe ser igual o superior a 18 anos.");
        }
        System.out.println("Acceso permitido.");
    }
}
