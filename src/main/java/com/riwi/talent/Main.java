package com.riwi.talent;

import com.riwi.talent.controller.EmpleadoController;
import com.riwi.talent.model.EmpleadoDAO;
import com.riwi.talent.model.EmpleadoDAOImpl;
import com.riwi.talent.view.EmpleadoView;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        EmpleadoDAO empleadoDAO = new EmpleadoDAOImpl();
        EmpleadoController controller = new EmpleadoController(empleadoDAO);

        try (Scanner scanner = new Scanner(System.in)) {
            EmpleadoView view = new EmpleadoView(controller, scanner);
            view.iniciarMenu();
        }
    }
}
