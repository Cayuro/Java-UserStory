package com.corporate.talenthub;

import java.util.Scanner;

/**
 * Clase utilitaria para validación de datos de entrada.
 * Implementa patrón seguro: nextLine() + parse manual + try-catch, evitando problemas de Scanner.
 */
public class ValidateData {

    /**
     * Valida nombre completo.
     * Rango: 3-50 caracteres, sin dígitos.
     *
     * @param sc Scanner para entrada.
     * @param mensaje Mensaje a mostrar.
     * @return Nombre validado.
     */
    public static String validateNombre(Scanner sc, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            var input = sc.nextLine().trim();
            if (input.length() >= 3 && input.length() <= 50 && !input.matches(".*\\d.*")) {
                return input;
            }
            System.out.println("Error: Nombre debe tener 3-50 caracteres sin números.");
        }
    }

    /**
     * Valida edad.
     * Rango: 18-65 años.
     *
     * @param sc Scanner para entrada.
     * @param mensaje Mensaje a mostrar.
     * @return Edad validada (short).
     */
    public static short validateEdad(Scanner sc, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            var input = sc.nextLine().trim();
            try {
                var edad = Short.parseShort(input);
                if (edad >= 18 && edad <= 65) {
                    return edad;
                }
                System.out.println("Error: Edad debe estar entre 18 y 65.");
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese un número entero válido.");
            }
        }
    }

    /**
     * Valida salario anual.
     * Rango: 1 a 49,999,999.
     *
     * @param sc Scanner para entrada.
     * @param mensaje Mensaje a mostrar.
     * @return Salario validado (long).
     */
    public static long validateSalarioAnual(Scanner sc, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            var input = sc.nextLine().trim();
            try {
                var salario = Long.parseLong(input);
                if (salario >= 1 && salario <= 49_999_999L) {
                    return salario;
                }
                System.out.println("Error: Salario entre 1 y 999,999,999.");
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese un número entero válido.");
            }
        }
    }

    /**
     * Valida puntaje de desempeño.
     * Rango: 0.0 a 100.0.
     *
     * @param sc Scanner para entrada.
     * @param mensaje Mensaje a mostrar.
     * @return Puntaje validado (double).
     */
    public static double validatePuntaje(Scanner sc, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            var input = sc.nextLine().trim();
            try {
                var puntaje = Double.parseDouble(input);
                if (puntaje >= 0.0 && puntaje <= 100.0) {
                    return puntaje;
                }
                System.out.println("Error: Puntaje entre 0.0 y 100.0.");
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese un número decimal válido.");
            }
        }
    }

    /**
     * Valida estado activo.
     * 1=true, 2=false.
     *
     * @param sc Scanner para entrada.
     * @param mensaje Mensaje a mostrar.
     * @return Estado activo (boolean).
     */
    public static boolean validateActivo(Scanner sc, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            var input = sc.nextLine().trim();
            if (input.equals("1")) {
                return true;
            } else if (input.equals("2")) {
                return false;
            }
            System.out.println("Error: Ingrese 1 (activo) o 2 (inactivo).");
        }
    }

    /**
     * Validación riesgosa estilo Java 8: nextDouble() directo.
     * Muestra por qué nextLine()+parse es más seguro.
     *
     * @param sc Scanner para entrada.
     * @param mensaje Mensaje a mostrar.
     * @return Valor numérico double.
     */
    public static double validateEntradaNumerica(Scanner sc, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                double valor = sc.nextDouble();
                sc.nextLine(); // Consumir newline leftover
                return valor;
            } catch (java.util.InputMismatchException e) {
                System.out.println("Error: Ingrese un número válido (no texto).");
                sc.nextLine(); // Limpiar buffer corrupto
                /*
                 * Java 8: NPE y exception messages vagas, ejemplo: "null" sin contexto.
                 * Java 14+: Helpful NullPointerExceptions muestran exactamente qué variable era null.
                 * Java 17/21: Mensajes de excepción aún más detallados para debugging rápido.
                 *
                 * Patrón nextLine()+parse del estudiante es MÁS SEGURO que este método:
                 * - No deja buffer corrupto.
                 * - Maneja texto inválido sin exception.
                 * - Usa var para inferencia de tipos (Java 11+).
                 */
            }
        }
    }
}
