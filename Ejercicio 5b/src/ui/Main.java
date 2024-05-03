package ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import entidades.*;

public class Main {
    public static void main(String[] args) throws Exception {
        List<Empleado> empleados = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 2; i++) {
            System.out.println("Ingrese el tipo de empleado (1 - Administrativo, 2 - Vendedor):");
            int tipoEmpleado = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Ingrese el dni del empleado: ");
            int dni = Integer.parseInt(scanner.nextLine());
            System.out.print("Ingrese el nombre del empleado: ");
            String nombre = scanner.nextLine();
            System.out.print("Ingrese el apellido del empleado: ");
            String apellido = scanner.nextLine();
            System.out.print("Ingrese el mail del empleado: ");
            String mail = scanner.nextLine();
            System.out.print("Ingrese el sueldo base del empleado: ");
            Double sueldoBase = Double.parseDouble(scanner.nextLine());

            if (tipoEmpleado == 1) {
                System.out.print("Ingrese el total de horas extras del empleado: ");
                int hsExtra = Integer.parseInt(scanner.nextLine());
                System.out.print("Ingrese el total de horas en el mes del empleado: ");
                int hsMes = Integer.parseInt(scanner.nextLine());
                empleados.add(new Administrativo(dni, nombre, apellido, mail, sueldoBase, hsExtra, hsMes));
            } else if (tipoEmpleado == 2) {
                System.out.println("Ingrese el porcentaje de comisión del empleado:");
                double porcenComision = scanner.nextDouble();
                scanner.nextLine();

                System.out.println("Ingrese el total de ventas del empleado:");
                int totalVtas = scanner.nextInt();
                scanner.nextLine();
                empleados.add(new Vendedor(dni, nombre, apellido, mail, sueldoBase, porcenComision, totalVtas));
            }
        }

        System.out.println("Lista de empleados:");
        for (int i = 0; i < empleados.size(); i++) {
            Empleado empleado = empleados.get(i);
            empleado.mostrarEmpleado(i, empleado.getSueldo());
        }
        scanner.close();
    }
}