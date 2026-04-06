package com.corporate.talenthub;

import java.util.List;

/** Gestiona calificaciones trimestrales en matriz bidimensional double[numEmpleados][3]. */
public class MatrizDesempeno {

    private final double[][] calificaciones;

    /** Inicializa la matriz de calificaciones para N empleados y 3 trimestres. */
    public MatrizDesempeno(int numEmpleados) {
        calificaciones = new double[numEmpleados][3];
    }

    /** Registra las tres calificaciones trimestrales de un empleado. */
    public void registrarCalificacion(int empleadoIndex, double q1, double q2, double q3) {
        calificaciones[empleadoIndex][0] = q1;
        calificaciones[empleadoIndex][1] = q2;
        calificaciones[empleadoIndex][2] = q3;
    }

    /** Calcula el promedio de desempeño por empleado usando for anidados. */
    public double[] calcularPromedios() {
        var promedios = new double[calificaciones.length];
        for (var i = 0; i < calificaciones.length; i++) {
            var suma = 0.0;
            for (var j = 0; j < calificaciones[i].length; j++) {
                suma += calificaciones[i][j];
            }
            promedios[i] = suma / 3.0;
        }
        return promedios;
    }

    /** Convierte promedio double a int truncado para puntaje simplificado. */
    public int obtenerPuntajeSimplificado(double promedio) {
        var puntaje = (int) promedio;
        return puntaje;
    }

    /** Evalúa promoción con operador ternario sobre el promedio del empleado. */
    public String evaluarPromocion(double promedio) {
        return promedio >= 3.5 ? "PROMOVIDO" : "EN SEGUIMIENTO";
    }

    /** Imprime reporte de promedios, casting explícito y estado de promoción por empleado. */
    public void imprimirReporte(double[] promedios, List<Empleado> empleados) {
        var header = """
                =============================
                 REPORTE DE DESEMPEÑO
                =============================
                """;
        System.out.println(header);

        for (var i = 0; i < promedios.length; i++) {
            var empleado = empleados.get(i);
            var puntajeSimplificado = obtenerPuntajeSimplificado(promedios[i]);
            var estadoPromocion = evaluarPromocion(promedios[i]);
            System.out.printf("Empleado %s: Promedio=%.2f, PuntajeSimplificado=%d, Estado=%s%n",
                    empleado.getNombreCompleto(), promedios[i], puntajeSimplificado, estadoPromocion);
        }

        var notaCasting = """
                Nota: el casting explícito de double a int trunca decimales,
                por eso el PuntajeSimplificado pierde precisión frente al promedio real.
                """;
        System.out.println(notaCasting);
    }
}

