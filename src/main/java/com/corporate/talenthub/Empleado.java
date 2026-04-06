package com.corporate.talenthub;

/** Modelo de empleado en estilo de clase tradicional. */
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

    /** Crea un empleado con su información laboral y personal. */
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

    /** Imprime encabezado del sistema usando Text Block. */
    public static void imprimirEncabezadoSistema() {
        var encabezado = """
                Corporate Talent Hub System
                """;
        System.out.println(encabezado);
    }

    /** Calcula el salario mensual final del empleado. */
    public double calcularSalarioFinal() {
        double salarioBase = salarioAnual / 12.0;
        double bonoMensual = salarioBase * (porcentajeBono / 100.0);
        if (idEmpleado % 2 == 0) {
            bonoMensual += VALOR_EXTRA_BONO;
        }
        return (salarioBase + (bonoMensual * 1.10)) - (salarioBase * 0.05);
    }

    /** Evalúa elegibilidad del empleado según reglas de negocio. */
    public boolean validarElegibilidad() {
        double puntajeTest = this.puntajeDesempeno;
        boolean esActivo = this.activo;
        return (puntajeTest > 85 && edad < 30) || (idSede == 1 && !esActivo);
    }

    /** Obtiene categoría salarial con switch expression moderna de Java 17/21. */
    public String obtenerCategoriaSalarial() {
        var salarioMensual = salarioAnual / 12.0;
        var salarioMensualInt = (int) salarioMensual;
        return switch (salarioMensualInt / 1000000) {
            case 8 -> "Senior Developer";
            case 4, 5, 6, 7 -> "Middle Developer";
            case 2, 3 -> "Junior Developer";
            default -> "Salario fuera de rango registrado";
        };
    }

    /* Java 8 depende de case:break y puede caer en fall-through si falta break; Java 17/21 con -> evita ese riesgo por diseño. */

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

