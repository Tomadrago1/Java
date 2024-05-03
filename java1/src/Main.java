import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] palabras = new String[3];
        for (int i = 0; i < palabras.length; i++) {
            System.out.println("Por favor, ingrese la palabra " + (i + 1) + ":");
            palabras[i] = scanner.nextLine();
        }
        System.out.println("Ingrese la palabra que desea buscar");
        String palabraBuscar = scanner.nextLine();
        boolean encontrada = false;
        for (String palabra : palabras) {
            if (palabra.equals(palabraBuscar)) {
                encontrada = true;
                break;
            }
        }
        if (encontrada) {
            System.out.println("La palabra fue encontrada en el array.");
        } else {
            System.out.println("No se ha encontrado la palabra en el array.");
        }

        scanner.close();
    }
}