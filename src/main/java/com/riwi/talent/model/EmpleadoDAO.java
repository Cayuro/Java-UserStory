package com.riwi.talent.model;

import java.util.List;

public interface EmpleadoDAO {

    void insertar(Empleado empleado);

    List<Empleado> listar();

    void actualizar(Empleado empleado);

    void eliminar(int id);

    List<EmpleadoDTO> listarResumen();
}
