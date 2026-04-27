package com.riwi.talent.model;

public class Empleado {

    private int idEmpleado;
    private String nombreCompleto;
    private short edad;
    private byte nivel;
    private long salarioAnual;
    private float porcentajeBono;
    private double puntajeDesempeno;
    private char categoria;
    private boolean activo;

    public Empleado(int idEmpleado, String nombreCompleto, short edad, byte nivel, long salarioAnual,
                    float porcentajeBono, double puntajeDesempeno, char categoria, boolean activo) {
        this.idEmpleado = idEmpleado;
        this.nombreCompleto = nombreCompleto;
        this.edad = edad;
        this.nivel = nivel;
        this.salarioAnual = salarioAnual;
        this.porcentajeBono = porcentajeBono;
        this.puntajeDesempeno = puntajeDesempeno;
        this.categoria = categoria;
        this.activo = activo;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public short getEdad() {
        return edad;
    }

    public void setEdad(short edad) {
        this.edad = edad;
    }

    public byte getNivel() {
        return nivel;
    }

    public void setNivel(byte nivel) {
        this.nivel = nivel;
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

    @Override
    public String toString() {
        return "Empleado{" +
                "idEmpleado=" + idEmpleado +
                ", nombreCompleto='" + nombreCompleto + '\'' +
                ", edad=" + edad +
                ", nivel=" + nivel +
                ", salarioAnual=" + salarioAnual +
                ", porcentajeBono=" + porcentajeBono +
                ", puntajeDesempeno=" + puntajeDesempeno +
                ", categoria=" + categoria +
                ", activo=" + activo +
                '}';
    }
}
