package com.corporate.talenthub;

/**
 * Modelo tradicional estilo Java 8.
 *
 * Aquí se ve el enfoque clásico: más líneas (constructor, getters, setters, toString).
 * Un record en Java 17 reduce este boilerplate cuando solo queremos representar datos.
 */
public class Empleado {

    private static final double VALOR_EXTRA_BONO = 75.0;

    private byte nivel;
    private short edad;
    private int idEmpleado;
    private long salarioAnual;
    private float porcentajeBono;
    private double puntajeDesempeno;
    private int idSede;
    private char categoria;
    private boolean activo;
    private String nombreCompleto;

    /** Constructor completo del empleado. */
    public Empleado(byte nivel, short edad, int idEmpleado, long salarioAnual, float porcentajeBono, double puntajeDesempeno, char categoria, boolean activo, String nombreCompleto) {
        this.nivel = nivel;
        this.edad = edad;
        this.idEmpleado = idEmpleado;
        this.salarioAnual = salarioAnual;
        this.porcentajeBono = porcentajeBono;
        this.puntajeDesempeno = puntajeDesempeno;
        this.idSede = 0;
        this.categoria = categoria;
        this.activo = activo;
        this.nombreCompleto = nombreCompleto;
    }

    public byte getNivel() { return nivel; }
    public void setNivel(byte nivel) { this.nivel = nivel; }

    public short getEdad() { return edad; }
    public void setEdad(short edad) { this.edad = edad; }

    public int getIdEmpleado() { return idEmpleado; }
    public void setIdEmpleado(int idEmpleado) { this.idEmpleado = idEmpleado; }

    public long getSalarioAnual() { return salarioAnual; }
    public void setSalarioAnual(long salarioAnual) { this.salarioAnual = salarioAnual; }

    public float getPorcentajeBono() { return porcentajeBono; }
    public void setPorcentajeBono(float porcentajeBono) { this.porcentajeBono = porcentajeBono; }

    public double getPuntajeDesempeno() { return puntajeDesempeno; }
    public void setPuntajeDesempeno(double puntajeDesempeno) { this.puntajeDesempeno = puntajeDesempeno; }

    public int getIdSede() { return idSede; }
    public void setIdSede(int idSede) { this.idSede = idSede; }

    public char getCategoria() { return categoria; }
    public void setCategoria(char categoria) { this.categoria = categoria; }

    public boolean isActivo() { return activo; }
    public void setActivo(boolean activo) { this.activo = activo; }

    public String getNombreCompleto() { return nombreCompleto; }
    public void setNombreCompleto(String nombreCompleto) { this.nombreCompleto = nombreCompleto; }

    /**
     * Text Block de Java moderno para mostrar un encabezado del sistema.
     */
    public static void imprimirEncabezadoSistema() {
        String encabezado = """
                Corporate Talent Hub System
                """;
        System.out.println(encabezado);
    }

    /**
     * Calcula el salario final mensual.
     */
    public double calcularSalarioFinal() {
        double salarioBase = salarioAnual / 12.0;
        double bonoMensual = salarioBase * (porcentajeBono / 100.0);
        if (idEmpleado % 2 == 0) {
            bonoMensual += VALOR_EXTRA_BONO;
        }
        return (salarioBase + (bonoMensual * 1.10)) - (salarioBase * 0.05);
    }

    /**
     * Evalúa si el empleado cumple la regla de elegibilidad.
     */
    public boolean validarElegibilidad() {
        double puntajeTest = this.puntajeDesempeno;
        boolean esActivo = this.activo;
        return (puntajeTest > 85 && edad < 30) || (idSede == 1 && !esActivo);
    }

    /**
     * Obtiene la categoría salarial usando Switch Expression moderna (Java 17/21).
     * Compara con el switch clásico de Java 8 que requería break en cada caso.
     */
    public String obtenerCategoriaSalarial() {
        double salarioMensual = salarioAnual / 12.0;
        // Modern switch with int ranges (Java 17+ multi-const, no preview needed)
        int salarioMensualInt = (int) salarioMensual;
        return switch (salarioMensualInt / 1000000) {
            case 8 -> "Senior Developer";
            case 4, 5, 6, 7 -> "Middle Developer";
            case 2, 3 -> "Junior Developer";
            default -> "Salario fuera de rango registrado";
        };
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
                ", idSede=" + idSede +
                ", categoria=" + categoria +
                ", activo=" + activo +
                ", nombreCompleto='" + nombreCompleto + '\'' +
                '}';
    }
}

