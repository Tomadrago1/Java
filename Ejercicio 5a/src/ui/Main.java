package ui;

import java.util.Scanner;
import entidades.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String preg, nombre, apellido, mail;
        int dni, hsExtra, hsMes, totalVentas;
        Double porcenComision, sueldoBase;
        Persona[] empleados = new Persona[20];
        // Loop para ingresar datos de empleados
        for (int i = 0; i < empleados.length; i++) {
            System.out.print("Ingrese el tipo de empleado (1- Vendedor : 2- Administrativo): ");
            preg = scanner.nextLine();
            System.out.print("Ingrese el dni del empleado: ");
            dni = Integer.parseInt(scanner.nextLine());
            System.out.print("Ingrese el nombre del empleado: ");
            nombre = scanner.nextLine();
            System.out.print("Ingrese el apellido del empleado: ");
            apellido = scanner.nextLine();
            System.out.print("Ingrese el mail del empleado: ");
            mail = scanner.nextLine();
            System.out.print("Ingrese el sueldo base del empleado: ");
            sueldoBase = Double.parseDouble(scanner.nextLine());
            // Verificación del tipo de empleado y creación del objeto correspondiente
            if (preg.equals("1")) {
                System.out.print("Ingrese el porcentaje de comision del empleado: ");
                porcenComision = Double.parseDouble(scanner.nextLine());
                System.out.print("Ingrese el total de ventas del empleado: ");
                totalVentas = Integer.parseInt(scanner.nextLine());
                Persona p1 = new Vendedor(dni, nombre, apellido, mail, sueldoBase, porcenComision, totalVentas);
                empleados[i] = p1;
            } else if (preg.equals("2")) {
                System.out.print("Ingrese el total de horas extras del empleado: ");
                hsExtra = Integer.parseInt(scanner.nextLine());
                System.out.print("Ingrese el total de horas en el mes del empleado: ");
                hsMes = Integer.parseInt(scanner.nextLine());
                Persona p1 = new Administrativo(dni, nombre, apellido, mail, sueldoBase, hsExtra, hsMes);
                empleados[i] = p1;
            }
            // Preguntar al usuario si quiere cargar mas empleados (?)
            System.out.print("¿Desea cargar otro empleado? (1 - Sí, 0 - No): ");
            int cargarOtro = Integer.parseInt(scanner.nextLine());
            // Verificar la respuesta del usuario
            if (cargarOtro == 0) {
                break; // Salir del bucle si el usuario no desea cargar otro empleado
            }
        }
        // Mostrar detalles de cada empleado
        for (int i = 0; i < empleados.length; i++) {
            if (empleados[i] != null) {
                Double sueldo = 0.0;
                /*
                 * if (empleados[i] instanceof Vendedor) {
                 * sueldo = ((Vendedor) empleados[i]).getSueldo();
                 * } else if (empleados[i] instanceof Administrativo) {
                 * sueldo = ((Administrativo) empleados[i]).getSueldo();
                 * }
                 */
                sueldo = empleados[i].getSueldo();
                empleados[i].mostrarPersona(sueldo);
            }
        }
        scanner.close();
    }
}