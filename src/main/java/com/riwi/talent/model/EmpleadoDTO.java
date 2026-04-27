package com.riwi.talent.model;

/*
 * Un record es inmutable y genera constructor, accessors, equals/hashCode y toString
 * de forma automatica. Un POJO tradicional requiere mas boilerplate (getters/setters,
 * constructor y metodos utilitarios), lo que reduce legibilidad para objetos de lectura.
 */
public record EmpleadoDTO(
        int idEmpleado,
        String nombreCompleto,
        char categoria,
        long salarioAnual,
        boolean activo,
        double puntajeDesempeno
) {
}
