package com.banco.ui;

import java.util.Locale;
import java.util.Scanner;

public class MenuBanco {

    // Atributos
    private Scanner scanner;

    // Constructor
    public MenuBanco() {
        this.scanner = new Scanner(System.in);
        this.scanner.useLocale(Locale.US);
    }

    // Metodos
    public void mostrarMenu() {
        IO.println("\n === MENU === \n");
        IO.println("1. Depositar");
        IO.println("2. Retirar");
        IO.println("3. Ver información");
        IO.println("4. Aplicar interés");
        IO.println("5. Salir");
        IO.print("Seleccione una opción: ");
    }

    // Metodo para leer la opcion seleccionada
    public int leerOpcion() {
        return scanner.nextInt();
    }

    // Metodo para leer el monto
    public double leerMonto() {
        return scanner.nextDouble();
    }

    // Metodo para leer el titular
    public String leerTitular() {
        return scanner.nextLine();
    }

    // Metodo para leer el numero de cuenta
    public String leerNumeroCuenta() {
        return scanner.nextLine();
    }

    // Metodo para leer el saldo inicial
    public double leerSaldoInicial() {
        return scanner.nextDouble();
    }

    // Metodo para leer la tasa de interes
    public double leerTasaInteres() {
        return scanner.nextDouble();
    }

    // Metodo para cerrar el scanner
    public void cerrarScanner() {
        scanner.close();
    }
}
