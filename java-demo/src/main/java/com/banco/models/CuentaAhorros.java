package com.banco.models;

import com.banco.exceptions.SaldoInsuficienteException;

// Herencia, extends de la clase base Cuenta
public class CuentaAhorros extends Cuenta {

    // Atributo, solo las Cuentas de Ahorro tienen tasa de interés.
    private double tasaInteres;

    public CuentaAhorros(String titular, String numeroCuenta, double saldoInicial, double tasaInteres) {
        super(titular, numeroCuenta, saldoInicial);
        this.tasaInteres = tasaInteres;
    }

    // Sobrescritura de retirar, implementación específica para Ahorros.
    @Override
    public boolean retirar(double monto) throws SaldoInsuficienteException {
        // Regla: No puedes retirar si el saldo es insuficiente.
        if (monto > 0 && monto <= this.saldo) {
            this.saldo -= monto;
            IO.println("\n Retiro de $" + monto + " exitoso de Ahorros. Nuevo saldo: $" + this.saldo + "\n");
            return true;
        } else {
            throw new SaldoInsuficienteException("\n Retiro fallido en Ahorros. Saldo insuficiente. \n");
        }
    }

    // Sobrescritura de mostrarInformacion, implementación específica para
    // Ahorros.
    @Override
    public void mostrarInformacion() {
        IO.println("\n --- Cuenta de Ahorros --- \n");
        IO.println("Titular: " + titular);
        IO.println("Número: " + numeroCuenta);
        IO.println("Saldo: $" + saldo);
        IO.println("Tasa de Interés: " + tasaInteres * 100 + "%");
    }

    // Metodos unicos, logica que solo existe en CuentaAhorros
    public void aplicarInteres() {
        this.saldo += this.saldo * tasaInteres;
        IO.println("\n Interés aplicado. Saldo con interés: $" + this.saldo + "\n");
    }
}