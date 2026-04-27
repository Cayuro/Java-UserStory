package com.riwi.talent.view;

import com.riwi.talent.controller.EmpleadoController;
import com.riwi.talent.model.Empleado;

import java.util.List;
import java.util.Scanner;

public class EmpleadoView {

    private final EmpleadoController controller;
    private final Scanner scanner;

    public EmpleadoView(EmpleadoController controller, Scanner scanner) {
        this.controller = controller;
        this.scanner = scanner;
    }

    public void iniciarMenu() {
        String opcion;
        do {
            System.out.println("""
                    ===========================================
                     Corporate Talent Hub - MVC + JDBC
                    ===========================================
                    1. Insertar empleado
                    2. Listar empleados
                    3. Actualizar empleado
                    4. Eliminar empleado
                    5. Generar reporte final
                    0. Salir
                    """);
            System.out.print("Seleccione una opcion: ");
            opcion = leerLinea();

            try {
                switch (opcion) {
                    case "1" -> insertarEmpleado();
                    case "2" -> listarEmpleados();
                    case "3" -> actualizarEmpleado();
                    case "4" -> eliminarEmpleado();
                    case "5" -> System.out.println(controller.generarReporteFinal());
                    case "0" -> System.out.println("Sesion finalizada.");
                    default -> System.out.println("Opcion invalida.");
                }
            } catch (IllegalArgumentException | IllegalStateException e) {
                System.out.println("Operacion fallida: " + e.getMessage());
            }
        } while (!"0".equals(opcion));
    }

    private void insertarEmpleado() {
        Empleado empleado = capturarEmpleado();
        controller.crearEmpleado(empleado);
        System.out.println("Empleado insertado correctamente.");
    }

    private void listarEmpleados() {
        List<Empleado> empleados = controller.obtenerEmpleados();
        if (empleados.isEmpty()) {
            System.out.println("No hay empleados registrados.");
            return;
        }
        for (Empleado empleado : empleados) {
            System.out.println(empleado);
        }
    }

    private void actualizarEmpleado() {
        Empleado empleado = capturarEmpleado();
        controller.actualizarEmpleado(empleado);
        System.out.println("Empleado actualizado correctamente.");
    }

    private void eliminarEmpleado() {
        int id = leerInt("ID del empleado a eliminar: ");
        controller.eliminarEmpleado(id);
        System.out.println("Empleado eliminado correctamente.");
    }

    private Empleado capturarEmpleado() {
        int idEmpleado = leerInt("ID: ");
        String nombre = leerTexto("Nombre completo: ");
        short edad = (short) leerInt("Edad: ");
        byte nivel = (byte) leerInt("Nivel (1-10): ");
        long salarioAnual = leerLong("Salario anual: ");
        float porcentajeBono = leerFloat("Porcentaje bono: ");
        double puntaje = leerDouble("Puntaje desempeno: ");
        char categoria = leerCategoria("Categoria (A/B/C): ");
        boolean activo = leerBooleano("Activo (1=Si, 2=No): ");

        return new Empleado(idEmpleado, nombre, edad, nivel, salarioAnual, porcentajeBono, puntaje, categoria, activo);
    }

    private String leerTexto(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String texto = leerLinea();
            if (!texto.isBlank()) {
                return texto;
            }
            System.out.println("El texto no puede ser vacio.");
        }
    }

    private int leerInt(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                return Integer.parseInt(leerLinea());
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un entero valido.");
            }
        }
    }

    private long leerLong(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                return Long.parseLong(leerLinea());
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un numero entero valido.");
            }
        }
    }

    private float leerFloat(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                return Float.parseFloat(leerLinea());
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un numero decimal valido.");
            }
        }
    }

    private double leerDouble(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                return Double.parseDouble(leerLinea());
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un numero decimal valido.");
            }
        }
    }

    private char leerCategoria(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String valor = leerLinea().toUpperCase();
            if (valor.length() == 1 && (valor.charAt(0) == 'A' || valor.charAt(0) == 'B' || valor.charAt(0) == 'C')) {
                return valor.charAt(0);
            }
            System.out.println("Categoria invalida. Use A, B o C.");
        }
    }

    private boolean leerBooleano(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String valor = leerLinea();
            if ("1".equals(valor)) {
                return true;
            }
            if ("2".equals(valor)) {
                return false;
            }
            System.out.println("Valor invalido. Use 1 o 2.");
        }
    }

    private String leerLinea() {
        return scanner.hasNextLine() ? scanner.nextLine().trim() : "";
    }
}
