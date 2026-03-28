package com.corporate.talenthub;

/**
 * Punto de entrada para ejecutar pruebas básicas del proyecto.
 *
 * Esta clase muestra ejemplos cortos y educativos sobre:
 * - Creación de objetos (clase y record).
 * - Manejo de null y diagnóstico de NullPointerException.
 * - Comparación de referencias en memoria heap usando ==.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("=== Corporate Talent Hub | Diagnóstico ===");

        // 1) Instanciación de clase tradicional (Java 8 style) y record (Java 17+).
        Empleado empleado = new Empleado( (byte) 2, (short) 27, 1002, 36_000_000L, 12.5f, 88.7, 'A', true, "Ana Torres"
        );
        empleado.setIdSede(1);

        EmpresaRecord empresa = new EmpresaRecord("Corporate Talent Hub", "900123456-7", 2024);

        System.out.println("Empleado creado: " + empleado);
        System.out.println("Empresa creada (record): " + empresa);

        // 2) Null Lab: asignamos null a un String para estudiar el comportamiento.
        String codigoInterno = null;

        try {
            // Esta línea provoca NPE porque codigoInterno no apunta a ningún objeto.
            System.out.println("Longitud del código interno: " + codigoInterno.length());
        } catch (NullPointerException npe) {
            System.out.println("\n[Null Lab]");
            System.out.println("Se detectó NullPointerException.");

            // Java 8 normalmente daba mensajes poco informativos (ejemplo: "null").
            System.out.println("Java 8: diagnóstico de NPE más limitado.");

            // Java 14+ incluye Helpful NPEs con más detalle sobre qué referencia fue null.
            System.out.println("Java 14+: Helpful NPE muestra más contexto del error.");
            System.out.println("Detalle recibido: " + npe.getMessage());
        }

        // 3) Comparación de objetos con ==.
        Empleado empleadoA = empleado;
        Empleado empleadoB = new Empleado( (byte) 2, (short) 27, 1002, 36_000_000L, 12.5f, 88.7, 'A', true, "Ana Torres"
        );

        System.out.println("\n[Comparación de objetos]");

        // == compara referencias (dirección en heap), no el contenido interno del objeto.
        System.out.println("empleado == empleadoA -> " + (empleado == empleadoA));
        System.out.println("empleado == empleadoB -> " + (empleado == empleadoB));

        // Explicación: en heap hay dos objetos diferentes para empleado y empleadoB
        // unque tengan los mismos datos. Por eso == devuelve false en ese caso.
    }
}