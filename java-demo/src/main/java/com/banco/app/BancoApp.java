package com.banco.app;

import com.banco.ui.MenuBanco;
import com.banco.exceptions.MontoInvalidoException;
import com.banco.exceptions.SaldoInsuficienteException;
import com.banco.services.BancoService;

public class BancoApp {

    void main() {
        // Crear instancia de la clase
        MenuBanco menu = new MenuBanco();

        // Pedir datos para crear la cuenta
        IO.println("=== Bienvenido al Sistema Bancario ===\n");
        IO.print("Ingrese el nombre del titular: ");
        String titular = menu.leerTitular();
        IO.print("Ingrese el número de cuenta: ");
        String numeroCuenta = menu.leerNumeroCuenta();
        IO.print("Ingrese el saldo inicial: ");
        double saldoInicial = menu.leerSaldoInicial();
        IO.print("Ingrese la tasa de interés (ej: 0.05 para 5%): ");
        double tasaInteres = menu.leerTasaInteres();

        // Crear el servicio con los datos
        BancoService servicio = new BancoService(titular, numeroCuenta, saldoInicial, tasaInteres);

        // Loop del menu
        boolean continuar = true;
        while (continuar) {
            menu.mostrarMenu();
            int opcion = menu.leerOpcion();

            switch (opcion) {
                case 1:
                    IO.print("Ingrese el monto a depositar: ");
                    double monto = menu.leerMonto();
                    try {
                        servicio.realizarDeposito(monto);
                    } catch (MontoInvalidoException e) {
                        IO.println(e.getMessage());
                    }
                    break;
                case 2:
                    IO.print("Ingrese el monto a retirar: ");
                    monto = menu.leerMonto();
                    try {
                        servicio.realizarRetiro(monto);
                    } catch (SaldoInsuficienteException e) {
                        IO.println(e.getMessage());
                    } catch (MontoInvalidoException e) {
                        IO.println(e.getMessage());
                    }
                    break;
                case 3:
                    servicio.mostrarInformacion();
                    break;
                case 4:
                    servicio.aplicarInteres();
                    break;
                case 5:
                    continuar = false;
                    break;
                default:
                    IO.print("Opción inválida. Por favor, seleccione una opción válida.");
            }

        }
        menu.cerrarScanner();
        IO.print("Gracias por usar el sistema. Hasta luego.");
    }

}