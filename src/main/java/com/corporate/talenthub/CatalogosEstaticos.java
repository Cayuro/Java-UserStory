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

    /*
     * List.of() y Map.of() crean colecciones inmutables.
     * No permiten add() ni put(), así se evitan cambios accidentales en datos de referencia.
     *
     * Legacy Java 8/11: get(0) y get(size() - 1) funcionan, pero dependen de índices manuales.
     * Java 21: getFirst(), getLast() y reversed() hacen el código más legible y menos propenso a errores.
     */
}