package com.corporate.talenthub;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/** Almacena empleados en memoria con lista dinámica y búsqueda por ID. */
public class EmpleadoStore {

    private final ArrayList<Empleado> empleados;
    private final HashMap<String, Empleado> empleadosPorId;

    /** Crea el almacenamiento dinámico en memoria. */
    public EmpleadoStore() {
        this.empleados = new ArrayList<>();
        this.empleadosPorId = new HashMap<>();
    }

    /** Agrega un empleado si el ID todavía no existe. */
    public boolean agregarEmpleado(Empleado empleado) {
        var id = String.valueOf(empleado.getIdEmpleado());
        if (empleadosPorId.containsKey(id)) {
            return false;
        }
        empleados.add(empleado);
        empleadosPorId.put(id, empleado);
        return true;
    }

    /** Busca un empleado por ID. */
    public Empleado buscarPorId(String id) {
        return empleadosPorId.get(id);
    }

    /** Devuelve la lista completa de empleados. */
    public List<Empleado> listarEmpleados() {
        return empleados;
    }

    /** Elimina un empleado por ID. */
    public boolean eliminarEmpleado(String id) {
        var eliminado = empleadosPorId.remove(id);
        if (eliminado == null) {
            return false;
        }
        empleados.remove(eliminado);
        return true;
    }

    /** Indica si el almacenamiento está vacío. */
    public boolean estaVacio() {
        return empleados.isEmpty();
    }
}