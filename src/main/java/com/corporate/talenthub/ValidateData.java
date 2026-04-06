package com.corporate.talenthub;

import java.util.InputMismatchException;
import java.util.Scanner;

/** Utilitario de validación para entradas de consola con Scanner y parse manual. */
public class ValidateData {

    /** Lee una línea del scanner o lanza InputMismatchException si no hay más entrada. */
    public static String readLineSafe(Scanner sc) {
        if (!sc.hasNextLine()) {
            throw new InputMismatchException("La entrada fue cerrada.");
        }
        return sc.nextLine().trim();
    }

    /** Valida nombre completo entre 3 y 50 caracteres sin números. */
    public static String validateNombre(Scanner sc, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            var input = readLineSafe(sc);
            if (input.length() >= 3 && input.length() <= 50 && !input.matches(".*\\d.*")) {
                return input;
            }
            System.out.println("Error: Nombre debe tener 3-50 caracteres sin números.");
        }
    }

    /** Valida edad en rango de 18 a 65 años. */
    public static short validateEdad(Scanner sc, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            var input = readLineSafe(sc);
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

    /** Valida salario anual en rango de 1 a 999999999. */
    public static long validateSalarioAnual(Scanner sc, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            var input = readLineSafe(sc);
            try {
                var salario = Long.parseLong(input);
                if (salario >= 1 && salario <= 999_999_999L) {
                    return salario;
                }
                System.out.println("Error: Salario entre 1 y 999,999,999.");
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese un número entero válido.");
            }
        }
    }

    /** Valida puntaje base de desempeño en escala 0.0 a 100.0. */
    public static double validatePuntaje(Scanner sc, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            var input = readLineSafe(sc);
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

    /** Valida estado activo con 1 para activo y 2 para inactivo. */
    public static boolean validateActivo(Scanner sc, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            var input = readLineSafe(sc);
            if (input.equals("1")) {
                return true;
            } else if (input.equals("2")) {
                return false;
            }
            System.out.println("Error: Ingrese 1 (activo) o 2 (inactivo).");
        }
    }

    /** Valida ID de empleado en rango entero positivo. */
    public static int validateIdEmpleado(Scanner sc, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            var input = readLineSafe(sc);
            try {
                var id = Integer.parseInt(input);
                if (id > 0) {
                    return id;
                }
                System.out.println("Error: El ID debe ser mayor que cero.");
            } catch (NumberFormatException e) {
                System.out.println("Error: El ID debe ser un entero válido.");
            }
        }
    }

    /** Valida nivel del empleado en rango byte de 1 a 10. */
    public static byte validateNivel(Scanner sc, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            var input = readLineSafe(sc);
            try {
                var nivel = Byte.parseByte(input);
                if (nivel >= 1 && nivel <= 10) {
                    return nivel;
                }
                System.out.println("Error: Nivel entre 1 y 10.");
            } catch (NumberFormatException e) {
                System.out.println("Error: Nivel inválido.");
            }
        }
    }

    /** Valida porcentaje de bono en rango 0.0 a 50.0. */
    public static float validatePorcentajeBono(Scanner sc, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            var input = readLineSafe(sc);
            try {
                var bono = Float.parseFloat(input);
                if (bono >= 0.0f && bono <= 50.0f) {
                    return bono;
                }
                System.out.println("Error: Bono entre 0.0 y 50.0.");
            } catch (NumberFormatException e) {
                System.out.println("Error: Porcentaje inválido.");
            }
        }
    }

    /** Valida categoría del empleado usando letras A, B o C. */
    public static char validateCategoria(Scanner sc, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            var input = readLineSafe(sc).toUpperCase();
            if (input.length() == 1) {
                var categoria = input.charAt(0);
                if (categoria == 'A' || categoria == 'B' || categoria == 'C') {
                    return categoria;
                }
            }
            System.out.println("Error: Categoría válida A, B o C.");
        }
    }

    /** Valida nota trimestral de 0.0 a 5.0 capturando InputMismatchException. */
    public static double validateTrimestre(Scanner sc, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                var input = readLineSafe(sc);
                if (input.isBlank()) {
                    throw new InputMismatchException("La entrada no puede estar vacía.");
                }
                var nota = Double.parseDouble(input);
                if (nota >= 0.0 && nota <= 5.0) {
                    return nota;
                }
                System.out.println("Error: Nota entre 0.0 y 5.0.");
            } catch (InputMismatchException e) {
                System.out.println("Error de captura: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese un número decimal válido.");
            }
        }
    }
}
