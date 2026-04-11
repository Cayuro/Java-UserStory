package com.corporate.talenthub;

import java.util.List;
import java.util.Map;

/** Catálogos inmutables de soporte para el sistema. */
public class CatalogosEstaticos {

    private static final List<String> TECNOLOGIAS = List.of("Java 8", "Java 11", "Java 21");
    private static final Map<String, String> SEDES = Map.of(
            "1", "Bogota",
            "2", "Medellin",
            "3", "Cali"
    );

    /** Devuelve la lista inmutable de tecnologías. */
    public static List<String> obtenerTecnologias() {
        return TECNOLOGIAS;
    }

    /** Devuelve el mapa inmutable de sedes. */
    public static Map<String, String> obtenerSedes() {
        return SEDES;
    }

    /** Obtiene la primera tecnología con la forma clásica de Java 8/11. */
    public static String obtenerPrimeraTecnologiaLegacy() {
        var tecnologias = TECNOLOGIAS;
        return tecnologias.get(0);
    }

    /** Obtiene la última tecnología con la forma clásica de Java 8/11. */
    public static String obtenerUltimaTecnologiaLegacy() {
        var tecnologias = TECNOLOGIAS;
        return tecnologias.get(tecnologias.size() - 1);
    }

    /** Obtiene la primera tecnología con la forma moderna de Java 21. */
    public static String obtenerPrimeraTecnologiaModerna() {
        return TECNOLOGIAS.getFirst();
    }

    /** Obtiene la última tecnología con la forma moderna de Java 21. */
    public static String obtenerUltimaTecnologiaModerna() {
        return TECNOLOGIAS.getLast();
    }

    /** Devuelve vista reversa de tecnologías usando Java 21. */
    public static List<String> obtenerTecnologiasEnReversaModerna() {
        return TECNOLOGIAS.reversed();
    }

        /** Explica la ventaja de usar List.of() y Map.of() para inmutabilidad. 
     *      "List.of() y Map.of() crean colecciones inmutables que no pueden ser modificadas 
     *      después de su creación, no permiten add ni put, lo que previene errores accidentales
     *       de mutación y mejora la seguridad del código.";
    */

    /** Explica la forma legacy de tomar extremos de una lista. 
     *         "En Java 8/11 se usa get(0) y size()-1 para leer primero y ultimo elemento; 
     *          funciona, pero obliga a manejar indices manualmente.";
    */
    
    /** Explica la mejora de Java 21 en colecciones secuenciadas.
     *      "En Java 21 getFirst(), getLast() y reversed() expresan la intención directamente, 
     *      mejoran la legibilidad y reducen errores por manejo manual de índices.";
     */
    
}