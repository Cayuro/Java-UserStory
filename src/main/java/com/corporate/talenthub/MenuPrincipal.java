package com.corporate.talenthub;

import java.util.Scanner;

public class MenuPrincipal {

    /**
     * Muestra el menú principal del sistema.
     * Utiliza un bucle do-while para mantener el menú activo hasta que el usuario elija salir.
     *
     * @param sc Scanner para leer la entrada del usuario.
     */
    public static void mostrarMenu(Scanner sc) {
        var bandera = "";
        do {
            String menu = """
                    ===== Menú Principal =====
                    1. Registrar empleado
                    2. Ver empleados
                    3. Calcular desempeño
                    0. Salir
                    ==========================
                    """;
            System.out.println(menu);

            System.out.print("Seleccione una opción: ");
            bandera = sc.nextLine(); // Leer entrada como String

            switch (bandera.trim()) {
                case "1":
                    System.out.println("Opción 1: Registrar empleado seleccionada.");
                    // Lógica para registrar empleado
                    break;
                case "2":
                    System.out.println("Opción 2: Ver empleados seleccionada.");
                    // Lógica para ver empleados
                    break;
                case "3":
                    System.out.println("Opción 3: Calcular desempeño seleccionada.");
                    // Lógica para calcular desempeño
                    break;
                case "0":
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (!bandera.trim().equals("0"));
    }

    /**
     * Muestra una demostración de la categoría salarial usando el método obtenerCategoriaSalarial.
     */
    private static void mostrarCategoriaDemo() {
        Empleado empleadoDemo = new Empleado((byte) 2, (short) 25, 12345, 50000L, 10.0f, 90.0, 'A', true, "Demo Empleado");
        System.out.println("Categoría salarial del empleado demo: " + empleadoDemo.obtenerCategoriaSalarial());
    }

    /*
     * Comentario explicativo sobre switch clásico y moderno:
     *
     * En Java 8, el switch clásico requiere break para evitar el "fall-through":
     * switch (opcion) {
     *     case 1:
     *         System.out.println("Caso 1");
     *         break;
     *     case 2:
     *         System.out.println("Caso 2");
     *         break;
     *     default:
     *         System.out.println("Caso por defecto");
     * }
     *
     * En Java 21, el switch moderno con -> elimina el riesgo de "fall-through":
     * switch (opcion) {
     *     case 1 -> System.out.println("Caso 1");
     *     case 2 -> System.out.println("Caso 2");
     *     default -> System.out.println("Caso por defecto");
     * }
     */
}
