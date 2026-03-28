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

    public int getIdSede() {
        return idSede;
    }

    public void setIdSede(int idSede) {
        this.idSede = idSede;
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
     *
     * Precedencia aplicada: paréntesis > multiplicación > suma/resta.
     * También usa módulo (%) para identificar ids pares y sumar bono extra.
     *
     * @return salario final mensual calculado.
     */
    public double calcularSalarioFinal() {
        // Pasamos salario anual a mensual para aplicar la fórmula.
        double salarioBase = salarioAnual / 12.0;

        // Bono mensual como porcentaje del salario base.
        double bonoMensual = salarioBase * (porcentajeBono / 100.0);

        // Si el id es par (residuo 0), aplicamos bono extra.
        if (idEmpleado % 2 == 0) {
            double valorExtra = VALOR_EXTRA_BONO;

            // Asignación compuesta: equivalente a bonoMensual = bonoMensual + valorExtra
            bonoMensual += valorExtra;
        }

        // Fórmula solicitada con la jerarquía de operadores respetada.
        return (salarioBase + (bonoMensual * 1.10)) - (salarioBase * 0.05);
    }

    /**
      * Evalúa si el empleado cumple la regla de elegibilidad.
      *
      * Precedencia lógica usada: ! > && > ||
     *
     * @return true si cumple la condición completa, false en caso contrario.
     */
    public boolean validarElegibilidad() {
          // Nombres intermedios para que la expresión sea fácil de leer.
        double puntajeTest = this.puntajeDesempeno;
        boolean esActivo = this.activo;

        return (puntajeTest > 85 && edad < 30) || (idSede == 1 && !esActivo);
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