package com.riwi.talent.model;

import com.riwi.talent.util.DatabaseConnection;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDAOImpl implements EmpleadoDAO {

    public EmpleadoDAOImpl() {
        crearTablaSiNoExiste();
    }

    @Override
    public void insertar(Empleado empleado) {
        String sql = """
                INSERT INTO empleados
                (id_empleado, nombre_completo, edad, nivel, salario_anual, porcentaje_bono, puntaje_desempeno, categoria, activo)
                VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)
                """;

        /*
         * try-with-resources cierra automaticamente Connection y PreparedStatement,
         * incluso cuando ocurre una excepcion. Esto evita fugas de memoria/conexiones.
         */
        try (var connection = DatabaseConnection.getConnection();
             var statement = connection.prepareStatement(sql)) {

            statement.setInt(1, empleado.getIdEmpleado());
            statement.setString(2, empleado.getNombreCompleto());
            statement.setShort(3, empleado.getEdad());
            statement.setByte(4, empleado.getNivel());
            statement.setLong(5, empleado.getSalarioAnual());
            statement.setFloat(6, empleado.getPorcentajeBono());
            statement.setDouble(7, empleado.getPuntajeDesempeno());
            statement.setString(8, String.valueOf(empleado.getCategoria()));
            statement.setBoolean(9, empleado.isActivo());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalStateException("No fue posible insertar el empleado.", e);
        }
    }

    @Override
    public List<Empleado> listar() {
        String sql = """
                SELECT id_empleado, nombre_completo, edad, nivel, salario_anual, porcentaje_bono, puntaje_desempeno, categoria, activo
                FROM empleados
                ORDER BY id_empleado
                """;
        List<Empleado> empleados = new ArrayList<>();

        /*
         * Aqui se cierran automaticamente Connection, PreparedStatement y ResultSet.
         * No hay necesidad de finally manual.
         */
        try (var connection = DatabaseConnection.getConnection();
             var statement = connection.prepareStatement(sql);
             var resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Empleado empleado = new Empleado(
                        resultSet.getInt("id_empleado"),
                        resultSet.getString("nombre_completo"),
                        resultSet.getShort("edad"),
                        resultSet.getByte("nivel"),
                        resultSet.getLong("salario_anual"),
                        resultSet.getFloat("porcentaje_bono"),
                        resultSet.getDouble("puntaje_desempeno"),
                        resultSet.getString("categoria").charAt(0),
                        resultSet.getBoolean("activo")
                );
                empleados.add(empleado);
            }
            return empleados;
        } catch (SQLException e) {
            throw new IllegalStateException("No fue posible listar empleados.", e);
        }
    }

    @Override
    public void actualizar(Empleado empleado) {
        String sql = """
                UPDATE empleados
                SET nombre_completo = ?, edad = ?, nivel = ?, salario_anual = ?, porcentaje_bono = ?,
                    puntaje_desempeno = ?, categoria = ?, activo = ?
                WHERE id_empleado = ?
                """;

        try (var connection = DatabaseConnection.getConnection();
             var statement = connection.prepareStatement(sql)) {

            statement.setString(1, empleado.getNombreCompleto());
            statement.setShort(2, empleado.getEdad());
            statement.setByte(3, empleado.getNivel());
            statement.setLong(4, empleado.getSalarioAnual());
            statement.setFloat(5, empleado.getPorcentajeBono());
            statement.setDouble(6, empleado.getPuntajeDesempeno());
            statement.setString(7, String.valueOf(empleado.getCategoria()));
            statement.setBoolean(8, empleado.isActivo());
            statement.setInt(9, empleado.getIdEmpleado());

            int filasAfectadas = statement.executeUpdate();
            if (filasAfectadas == 0) {
                throw new IllegalArgumentException("No existe un empleado con ID " + empleado.getIdEmpleado());
            }
        } catch (SQLException e) {
            throw new IllegalStateException("No fue posible actualizar el empleado.", e);
        }
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM empleados WHERE id_empleado = ?";

        try (var connection = DatabaseConnection.getConnection();
             var statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);
            int filasAfectadas = statement.executeUpdate();
            if (filasAfectadas == 0) {
                throw new IllegalArgumentException("No existe un empleado con ID " + id);
            }
        } catch (SQLException e) {
            throw new IllegalStateException("No fue posible eliminar el empleado.", e);
        }
    }

    @Override
    public List<EmpleadoDTO> listarResumen() {
        String sql = """
                SELECT id_empleado, nombre_completo, categoria, salario_anual, activo, puntaje_desempeno
                FROM empleados
                ORDER BY id_empleado
                """;
        List<EmpleadoDTO> resumen = new ArrayList<>();

        try (var connection = DatabaseConnection.getConnection();
             var statement = connection.prepareStatement(sql);
             var resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                EmpleadoDTO dto = new EmpleadoDTO(
                        resultSet.getInt("id_empleado"),
                        resultSet.getString("nombre_completo"),
                        resultSet.getString("categoria").charAt(0),
                        resultSet.getLong("salario_anual"),
                        resultSet.getBoolean("activo"),
                        resultSet.getDouble("puntaje_desempeno")
                );
                resumen.add(dto);
            }
            return resumen;
        } catch (SQLException e) {
            throw new IllegalStateException("No fue posible consultar el resumen de empleados.", e);
        }
    }

    private void crearTablaSiNoExiste() {
        String sql = """
                CREATE TABLE IF NOT EXISTS empleados (
                    id_empleado INT PRIMARY KEY,
                    nombre_completo VARCHAR(120) NOT NULL,
                    edad SMALLINT NOT NULL,
                    nivel SMALLINT NOT NULL,
                    salario_anual BIGINT NOT NULL,
                    porcentaje_bono REAL NOT NULL,
                    puntaje_desempeno DOUBLE PRECISION NOT NULL,
                    categoria CHAR(1) NOT NULL,
                    activo BOOLEAN NOT NULL
                )
                """;

        try (var connection = DatabaseConnection.getConnection();
             var statement = connection.prepareStatement(sql)) {
            statement.execute();
        } catch (SQLException e) {
            throw new IllegalStateException("No fue posible validar/crear la tabla empleados.", e);
        }
    }
}
