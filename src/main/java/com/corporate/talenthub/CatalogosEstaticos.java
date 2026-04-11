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

    /** Explica por qué estos catálogos son más seguros que una lista mutable. */
    public static String explicarInmutabilidad() {
        return "Las colecciones creadas con List.of() y Map.of() son inmutables, por eso no permiten add ni put y evitan cambios accidentales en datos de referencia.";
    }

    /** Explica la forma legacy de tomar extremos de una lista. */
    public static String explicarAccesoLegacy() {
        return "En Java 8/11 se usa get(0) y size()-1 para leer primero y ultimo elemento; funciona, pero obliga a manejar indices manualmente.";
    }
}