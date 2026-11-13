import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Locale;

public class RetoReservasHotel {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        teclado.useLocale(Locale.US);
        System.out.println("===== SISTEMA DE RESERVAS DE HOTEL =====");
        try {
            System.out.print("Nombre del cliente: ");
            String nombre = teclado.nextLine();
            System.out.print("Numero de habitacion: ");
            int habitacion = teclado.nextInt();
            System.out.print("Numero de noches: ");
            int noches = teclado.nextInt();
            System.out.print("Precio por noche (decimal con punto): ");
            double precio = teclado.nextDouble();
            validarReserva(nombre, habitacion, noches, precio);
            double total = calcularPrecio(noches, precio);
            mostrarReserva(nombre, habitacion, noches, precio, total);
        } catch (InputMismatchException error) {
            System.out.println("ERROR: Introduce enteros para habitacion y noches, y un precio con punto decimal.");
        } catch (IllegalArgumentException error) {
            System.out.println("ERROR: " + error.getMessage());
        }
        teclado.close();
    }

    // Validacion separada del calculo y de la presentacion de resultados.
    static void validarReserva(String nombre, int habitacion, int noches, double precio)
            throws IllegalArgumentException {
        if (nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del cliente no puede estar vacio.");
        }
        if (habitacion <= 0) {
            throw new IllegalArgumentException("El numero de habitacion debe ser mayor que cero.");
        }
        if (noches <= 0) {
            throw new IllegalArgumentException("El numero de noches debe ser mayor que cero.");
        }
        if (Double.isNaN(precio) || Double.isInfinite(precio) || precio <= 0) {
            throw new IllegalArgumentException("El precio por noche debe ser positivo y finito.");
        }
    }

    static double calcularPrecio(int noches, double precio) {
        double total = noches * precio;
        if (Double.isInfinite(total)) {
            throw new IllegalArgumentException("El importe total es demasiado grande.");
        }
        return total;
    }

    static void mostrarReserva(String nombre, int habitacion, int noches, double precio, double total) {
        System.out.println("\nRESERVA REALIZADA CORRECTAMENTE");
        System.out.println("Cliente: " + nombre);
        System.out.println("Habitacion: " + habitacion);
        System.out.println("Noches: " + noches);
        System.out.println("Precio por noche: " + precio + " EUR");
        System.out.println("Precio total: " + total + " EUR");
    }
}
