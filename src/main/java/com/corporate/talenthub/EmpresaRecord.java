package com.corporate.talenthub;

/**
 * Modelo moderno con record (Java 17).
 *
 * Ventajas principales frente a una clase tradicional:
 * - Menos código repetitivo (boilerplate).
 * - Java genera automáticamente constructor, getters, toString, equals y hashCode.
 * - Sus campos son inmutables: no hay setters, lo que reduce cambios accidentales.
 *
 * Esto es útil para representar datos que no deberían cambiar después de crearse.
 */
public record EmpresaRecord(String nombre, String nit, int anioFundacion) {
}