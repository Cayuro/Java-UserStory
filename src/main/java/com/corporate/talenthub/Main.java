package com.corporate.talenthub;

import java.util.Scanner;

/** Punto de entrada del sistema Corporate Talent Hub. */
public class Main {

    public static void main(String[] args) {
        var encabezado = """
                ==========================================
                 Corporate Talent Hub - Java 21
                ==========================================
                """;
        System.out.println(encabezado);
        try (var sc = new Scanner(System.in)) {
            MenuPrincipal.mostrarMenu(sc);
        }
    }
}

