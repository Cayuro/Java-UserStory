package com.corporate.talenthub;

/**
 * Notas de arquitectura del proyecto Corporate Talent Hub.
 *
 * Estas notas están hechas como guía de estudio mientras avanzo en Java.
 * La idea es entender poco a poco qué cambia entre Java 8 y Java 17/21,
 * y por qué la JVM moderna ayuda al rendimiento.
 */
public class NotasArquitectura {

    /**
     * 1) Java 8 (Legacy) vs Java 17/21 (LTS)
     *
      * Modelo de releases:
        * - Java 8: se usó mucho tiempo como base legacy en muchas empresas.
        * - Java 17/21: forman parte del esquema moderno con versiones LTS,
        *   lo que hace más claro cuándo actualizar proyectos.
     *
      * Evolución del lenguaje:
        * - Java 8: introdujo lambdas y streams, que siguen siendo muy usados.
        * - Java 17/21: agregan cosas más modernas como records, sealed classes
        *   y pattern matching, para escribir código más claro.
     *
      * Mejoras de rendimiento:
        * - Java 8: es estable, pero su runtime y GC son más antiguos.
        * - Java 17/21: traen mejoras internas en JIT, GC y manejo de memoria,
        *   por eso suele mejorar el rendimiento sin tocar toda la app.
     *
        * Resumen corto: Java 8 = base clásica; Java 17/21 = plataforma moderna
        * con mejor soporte para proyectos actuales.
     */

    /**
     * 2) Internals de JVM
     *
      * Creación de objetos en Heap:
        * - Cuando usamos "new", normalmente el objeto se guarda en Heap.
        * - Muchos objetos primero van a zona joven y, si viven más tiempo,
        *   pasan a zonas de larga vida.
     *
      * Stack vs Heap:
        * - Stack: guarda variables locales y llamadas de métodos por cada hilo.
        * - Heap: guarda objetos y datos dinámicos compartidos.
        * - Idea práctica: referencia en stack, objeto real en heap.
     *
      * Estrategias de optimización de memoria:
        * - Evitar crear objetos innecesarios en bucles.
        * - Limpiar referencias que ya no se usan.
        * - Elegir bien colecciones para no gastar memoria de más.
        * - Medir antes de optimizar (heap y pausas de GC).
     */

    /**
     * 3) Garbage Collector: evolución y diferencias
     *
      * Java 8: Parallel GC y base de G1:
        * - Parallel GC: busca buen rendimiento general, pero puede generar pausas visibles.
        * - G1 en Java 8: ya mejora el control de pausas frente a esquemas más antiguos.
     *
      * Java 17/21: G1 más maduro y ZGC:
        * - G1 en Java 17/21: está más optimizado y estable para cargas modernas.
        * - ZGC: está pensado para pausas muy bajas, útil en sistemas sensibles a latencia.
     *
      * Latencia y escalabilidad:
        * - Java 8: puede funcionar bien, pero con más riesgo de pausas largas.
        * - Java 17/21: mejoran latencia y escalan mejor en servidores actuales.
     */

    /**
     * 4) Idea clave: mejora automática en JVM moderna
     *
        * Al migrar de Java 8 a Java 17/21 no solo cambia el lenguaje.
        * También mejora el motor interno de la JVM (JIT, GC y manejo de memoria).
     *
        * Lo importante para el proyecto es que varias mejoras vienen "automáticas"
        * al usar una LTS moderna: mejor uso de CPU y memoria, y menos pausas.
      * Después, con más experiencia, se puede ajustar la JVM según cada caso.
     */
}
