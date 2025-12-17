package com.banco.models;

import com.banco.interfaces.iOperacionesCuenta;
import com.banco.exceptions.MontoInvalidoException;
import com.banco.exceptions.SaldoInsuficienteException;

public abstract class Cuenta implements iOperacionesCuenta {

    // Atributos
    protected String titular;
    protected double saldo;
    protected String numeroCuenta;

    // Constructor
    public Cuenta(String titular, String numeroCuenta, double saldoInicial) {
        this.titular = titular;
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldoInicial;
    }

    // Implementacion de interfaz

    // Metodo depositar.
    @Override
    public void depositar(double monto) throws MontoInvalidoException {
        if (monto > 0) {
            this.saldo += monto;
            IO.println("\n Deposito de $" + monto + " Exitoso.\n");
        } else {
            throw new MontoInvalidoException("\n Monto de deposito no valido \n");
        }
    }

    // Metodo retirar
    @Override
    public boolean retirar(double monto) throws SaldoInsuficienteException {
        if (monto > 0 && monto <= this.saldo) {
            this.saldo -= monto;
            IO.println("\n Retiro de $" + monto + " exitoso. Nuevo saldo: $" + this.saldo + "\n");
            return true;
        } else {
            throw new SaldoInsuficienteException("\n Retiro fallido. Saldo insuficiente. \n");
        }
    }

    // Getters
    public double getSaldo() {
        return saldo;
    }

    public String getTitular() {
        return titular;
    }

}