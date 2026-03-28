package com.corporate.talenthub;

/**
 * Modelo tradicional estilo Java 8.
 *
 * Esta clase muestra el enfoque clásico: más código repetitivo,
 * pero control total con constructor, getters, setters y toString.
 *
 * Comparación rápida con record:
 * - Clase tradicional: más verbosa, porque hay que escribir mucho boilerplate.
 * - Record: más simple para datos, porque Java genera automáticamente partes comunes.
 */
public class Empleado {

    private byte nivel;
    private short edad;
    private int idEmpleado;
    private long salarioAnual;
    private float porcentajeBono;
    private double puntajeDesempeno;
    private char categoria;
    private boolean activo;
    private String nombreCompleto;

    /**
     * Constructor completo del empleado.
     *
     * Se incluye el sufijo L en long y f en float para mantener claridad
     * en el tipo de dato cuando se creen instancias.
     */
    public Empleado(byte nivel,
                    short edad,
                    int idEmpleado,
                    long salarioAnual,
                    float porcentajeBono,
                    double puntajeDesempeno,
                    char categoria,
                    boolean activo,
                    String nombreCompleto) {
        this.nivel = nivel;
        this.edad = edad;
        this.idEmpleado = idEmpleado;
        this.salarioAnual = salarioAnual;
        this.porcentajeBono = porcentajeBono;
        this.puntajeDesempeno = puntajeDesempeno;
        this.categoria = categoria;
        this.activo = activo;
        this.nombreCompleto = nombreCompleto;
    }

    public byte getNivel() {
        return nivel;
    }

    public void setNivel(byte nivel) {
        this.nivel = nivel;
    }

    public short getEdad() {
        return edad;
    }

    public void setEdad(short edad) {
        this.edad = edad;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public long getSalarioAnual() {
        return salarioAnual;
    }

    public void setSalarioAnual(long salarioAnual) {
        this.salarioAnual = salarioAnual;
    }

    public float getPorcentajeBono() {
        return porcentajeBono;
    }

    public void setPorcentajeBono(float porcentajeBono) {
        this.porcentajeBono = porcentajeBono;
    }

    public double getPuntajeDesempeno() {
        return puntajeDesempeno;
    }

    public void setPuntajeDesempeno(double puntajeDesempeno) {
        this.puntajeDesempeno = puntajeDesempeno;
    }

    public char getCategoria() {
        return categoria;
    }

    public void setCategoria(char categoria) {
        this.categoria = categoria;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    /**
     * Ejemplo de Text Block (Java moderno) para imprimir un encabezado simple.
     *
     * Aunque esta clase es estilo Java 8, el proyecto usa Java 17/21,
     * por eso se puede aprovechar esta sintaxis más limpia.
     */
    public static void imprimirEncabezadoSistema() {
        String encabezado = """
                Corporate Talent Hub System
                """;
        System.out.println(encabezado);
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "nivel=" + nivel +
                ", edad=" + edad +
                ", idEmpleado=" + idEmpleado +
                ", salarioAnual=" + salarioAnual +
                ", porcentajeBono=" + porcentajeBono +
                ", puntajeDesempeno=" + puntajeDesempeno +
                ", categoria=" + categoria +
                ", activo=" + activo +
                ", nombreCompleto='" + nombreCompleto + '\'' +
                '}';
    }
}