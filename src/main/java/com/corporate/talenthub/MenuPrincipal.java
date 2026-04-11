package com.corporate.talenthub;

import java.util.InputMismatchException;
import java.util.Scanner;

/** Menú principal con flujo dinámico para múltiples empleados. */
public class MenuPrincipal {

    /** Muestra el menú principal hasta que el usuario elige salir. */
    public static void mostrarMenu(Scanner sc) {
                var store = new EmpleadoStore();
        var opcion = "-1";
        do {
            var menu = """
                    ================================
                      Corporate Talent Hub
                    ================================
                    1. Registrar empleado
                    2. Listar empleados
                    3. Eliminar empleado
                    4. Procesar desempeño trimestral
                    5. Filtrar por salario mínimo
                    0. Salir
                    ================================
                    """;
            System.out.println(menu);
            System.out.print("Seleccione una opción: ");
            try {
                opcion = ValidateData.readLineSafe(sc);
            } catch (InputMismatchException e) {
                System.out.println("No hay más entrada disponible. Cierre de sesión completado.");
                break;
            }

            switch (opcion) {
                case "1":
                    registrarEmpleado(sc, store);
                    break;
                case "2":
                    listarEmpleados(store);
                    break;
                case "3":
                    eliminarEmpleado(sc, store);
                    break;
                case "4":
                    procesarDesempeno(sc, store);
                    break;
                case "5":
                    filtrarPorSalarioMinimo(sc, store);
                    break;
                case "0":
                    System.out.println("Cierre de sesión completado.");
                    break;
                default:
                    System.out.println("Opción inválida. Elige 0, 1, 2, 3, 4 o 5.");
            }
        } while (!opcion.equals("0"));
    }

    /** Registra un empleado validando todos los datos de entrada. */
    public static void registrarEmpleado(Scanner sc, EmpleadoStore store) {
        try {
            var idEmpleado = ValidateData.validateIdEmpleado(sc, "ID del empleado (entero positivo): ");
            var nombre = ValidateData.validateNombre(sc, "Nombre completo: ");
            var nivel = ValidateData.validateNivel(sc, "Nivel (1-10): ");
            var edad = ValidateData.validateEdad(sc, "Edad (18-65): ");
            var salarioAnual = ValidateData.validateSalarioAnual(sc, "Salario anual (1 a 999999999): ");
            var porcentajeBono = ValidateData.validatePorcentajeBono(sc, "Porcentaje de bono (0.0 a 50.0): ");
            var puntajeBase = ValidateData.validatePuntaje(sc, "Puntaje base (0.0 a 100.0): ");
            var categoria = ValidateData.validateCategoria(sc, "Categoría (A/B/C): ");
            var activo = ValidateData.validateActivo(sc, "Estado 1=Activo 2=Inactivo: ");

            var empleado = new Empleado(nivel, edad, idEmpleado, salarioAnual, porcentajeBono, puntajeBase, categoria, activo, nombre);
            if (!store.agregarEmpleado(empleado)) {
                System.out.println("Ya existe un empleado con ese ID.");
                return;
            }

            var resumen = """
                    Empleado registrado correctamente.
                    Categoría salarial: %s
                    """;
            System.out.printf((resumen) + "%n", empleado.obtenerCategoriaSalarial());
        } catch (InputMismatchException e) {
            /* Java 17/21 suele entregar mensajes de excepción más claros que Java 8 para diagnosticar errores de entrada. */
            System.out.println("Entrada inválida: " + e.getMessage());
        }
    }

    /** Lista todos los empleados registrados en memoria. */
    public static void listarEmpleados(EmpleadoStore store) {
        if (store.estaVacio()) {
            System.out.println("No hay empleados registrados.");
            return;
        }
        var titulo = """
                ================================
                 Empleados Registrados
                ================================
                """;
        System.out.println(titulo);
        var empleados = store.listarEmpleados();
        for (var i = 0; i < empleados.size(); i++) {
            System.out.println("#" + (i + 1) + " " + empleados.get(i));
        }
    }

    /** Elimina un empleado por ID usando búsqueda en HashMap. */
    public static void eliminarEmpleado(Scanner sc, EmpleadoStore store) {
        if (store.estaVacio()) {
            System.out.println("No hay empleados para eliminar.");
            return;
        }
        var id = ValidateData.validateIdEmpleado(sc, "ID a eliminar: ");
        if (store.eliminarEmpleado(String.valueOf(id))) {
            System.out.println("Empleado eliminado correctamente.");
        } else {
            System.out.println("No existe un empleado con ese ID.");
        }
    }

    /** Filtra empleados por salario mínimo usando removeIf en el store. */
    public static void filtrarPorSalarioMinimo(Scanner sc, EmpleadoStore store) {
        if (store.estaVacio()) {
            System.out.println("No hay empleados para filtrar.");
            return;
        }
        var salarioMinimo = ValidateData.validateSalarioAnual(sc, "Salario mínimo para conservar empleado: ");
        var removidos = store.filtrarPorSalarioMinimo(salarioMinimo);
        System.out.println("Filtrado aplicado. Empleados removidos: " + removidos);
    }

    /** Procesa matriz double[][] de 3 trimestres, calcula promedios y muestra reporte final. */
    public static void procesarDesempeno(Scanner sc, EmpleadoStore store) {
        var empleados = store.listarEmpleados();
        if (empleados.isEmpty()) {
            System.out.println("Primero registra al menos un empleado.");
            return;
        }

        var matriz = new MatrizDesempeno(empleados.size());
        for (var i = 0; i < empleados.size(); i++) {
            var empleado = empleados.get(i);
            var bloque = """
                    --------------------------------
                    Cargar notas de: %s
                    --------------------------------
                    """;
            System.out.printf((bloque) + "%n", empleado.getNombreCompleto());
            var q1 = ValidateData.validateTrimestre(sc, "Q1 (0.0 a 5.0): ");
            var q2 = ValidateData.validateTrimestre(sc, "Q2 (0.0 a 5.0): ");
            var q3 = ValidateData.validateTrimestre(sc, "Q3 (0.0 a 5.0): ");
            matriz.registrarCalificacion(i, q1, q2, q3);
            var promedioEscala100 = ((q1 + q2 + q3) / 3.0) * 20.0;
            empleado.setPuntajeDesempeno(promedioEscala100);
        }

        var promedios = matriz.calcularPromedios();
        matriz.imprimirReporte(promedios, empleados);
    }

    /* En Java 8 el switch clásico puede tener fall-through si falta break; en Java 17/21 la switch expression con -> evita ese riesgo y es más compacta. */
}
