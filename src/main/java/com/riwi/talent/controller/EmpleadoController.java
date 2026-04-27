package com.riwi.talent.controller;

import com.riwi.talent.model.Empleado;
import com.riwi.talent.model.EmpleadoDAO;
import com.riwi.talent.model.EmpleadoDTO;

import java.util.List;

public class EmpleadoController {

    private final EmpleadoDAO empleadoDAO;

    public EmpleadoController(EmpleadoDAO empleadoDAO) {
        this.empleadoDAO = empleadoDAO;
    }

    public void crearEmpleado(Empleado empleado) {
        empleadoDAO.insertar(empleado);
    }

    public List<Empleado> obtenerEmpleados() {
        return empleadoDAO.listar();
    }

    public void actualizarEmpleado(Empleado empleado) {
        empleadoDAO.actualizar(empleado);
    }

    public void eliminarEmpleado(int idEmpleado) {
        empleadoDAO.eliminar(idEmpleado);
    }

    public String generarReporteFinal() {
        List<EmpleadoDTO> resumen = empleadoDAO.listarResumen();
        if (resumen.isEmpty()) {
            return "No hay empleados registrados para reportar.";
        }

        long totalSalarios = 0L;
        int activos = 0;
        StringBuilder detalle = new StringBuilder();

        for (EmpleadoDTO empleado : resumen) {
            totalSalarios += empleado.salarioAnual();
            if (empleado.activo()) {
                activos++;
            }
            detalle.append("- ID: ")
                    .append(empleado.idEmpleado())
                    .append(" | Nombre: ")
                    .append(empleado.nombreCompleto())
                    .append(" | Categoria: ")
                    .append(empleado.categoria())
                    .append(" | Salario: ")
                    .append(empleado.salarioAnual())
                    .append(" | Puntaje: ")
                    .append(String.format("%.2f", empleado.puntajeDesempeno()))
                    .append(" | Activo: ")
                    .append(empleado.activo() ? "Si" : "No")
                    .append(System.lineSeparator());
        }

        double promedio = (double) totalSalarios / resumen.size();

        return """
                ===========================================
                 Reporte Final - Corporate Talent Hub
                ===========================================
                Total de empleados: %d
                Empleados activos: %d
                Promedio salario anual: %.2f

                Detalle:
                %s
                """.formatted(resumen.size(), activos, promedio, detalle);
    }
}
