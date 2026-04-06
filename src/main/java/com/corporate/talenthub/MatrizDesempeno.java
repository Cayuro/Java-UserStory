package com.corporate.talenthub;

/**
 * Maneja matriz de calificaciones de desempeño por trimestres (Q1, Q2, Q3).
 * Usa array bidimensional double[numEmpleados][3].
 */
public class MatrizDesempeno {

    private double[][] calificaciones;

    /**
     * Constructor inicializa matriz con N empleados y 3 columnas (Q1,Q2,Q3).
     *
     * @param numEmpleados Número de empleados.
     */
    public MatrizDesempeno(int numEmpleados) {
        calificaciones = new double[numEmpleados][3]; // Fila=empleado, columna=trimestre
    }

    /**
     * Registra calificaciones de 3 trimestres para un empleado.
     *
     * @param empleadoIndex Índice del empleado (0-based).
     * @param q1 Calificación Q1.
     * @param q2 Calificación Q2.
     * @param q3 Calificación Q3.
     */
    public void registrarCalificacion(int empleadoIndex, double q1, double q2, double q3) {
        calificaciones[empleadoIndex][0] = q1;
        calificaciones[empleadoIndex][1] = q2;
        calificaciones[empleadoIndex][2] = q3;
    }

    /**
     * Calcula promedios por empleado usando bucles anidados.
     * @return Array de promedios (un double por empleado).
     */
    public double[] calcularPromedios() {
        var promedios = new double[calificaciones.length];
        for (int i = 0; i < calificaciones.length; i++) { // Bucle externo: empleados
            var suma = 0.0;
            for (int j = 0; j < calificaciones[i].length; j++) { // Bucle interno: trimestres
                suma += calificaciones[i][j];
            }
            promedios[i] = suma / 3.0;
        }
        return promedios;
    }

    /**
     * Obtiene puntaje simplificado truncado (no redondeado).
     *
     * @param promedio Promedio del empleado.
     * @return Puntaje int truncado.
     */
    public int obtenerPuntajeSimplificado(double promedio) {
        // Cast explícito: trunca (floor) decimales, NO redondea.
        // Ejemplo: 88.9 -> 88 (pierde .9), 88.1 -> 88.
        int puntaje = (int) promedio;
        return puntaje;
    }

    /**
     * Evalúa promoción con operador ternario.
     *
     * @param promedio Promedio del empleado.
     * @return "PROMOVIDO" o "EN SEGUIMIENTO".
     */
    public String evaluarPromocion(double promedio) {
        // Ternario: condición ? verdadero : falso
        return promedio >= 3.5 ? "PROMOVIDO" : "EN SEGUIMIENTO";
    }

    /**
     * Imprime reporte formateado de promedios.
     *
     * @param promedios Array de promedios por empleado.
     */
    public void imprimirReporte(double[] promedios) {
        var header = """
                =============================
                 REPORTE DE DESEMPEÑO
                =============================
                """;
        System.out.println(header);

        for (int i = 0; i < promedios.length; i++) {
            var puntajeSimplificado = obtenerPuntajeSimplificado(promedios[i]);
            var estadoPromocion = evaluarPromocion(promedios[i]);
            System.out.printf("Empleado %d: Promedio=%.2f, Puntaje=%d, Estado=%s%n",
                              i, promedios[i], puntajeSimplificado, estadoPromocion);
        }
    }
}

