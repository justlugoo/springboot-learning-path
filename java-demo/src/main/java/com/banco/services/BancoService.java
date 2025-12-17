package com.banco.services;

import com.banco.exceptions.MontoInvalidoException;
import com.banco.exceptions.SaldoInsuficienteException;
import com.banco.models.CuentaAhorros;

public class BancoService {

    // Atributo
    private CuentaAhorros cuenta;

    // Constructor - recibe los datos para crear la cuenta
    public BancoService(String titular, String numeroCuenta, double saldoInicial, double tasaInteres) {
        this.cuenta = new CuentaAhorros(titular, numeroCuenta, saldoInicial, tasaInteres);
    }

    // Metodos de operaciones
    public void realizarDeposito(double monto) throws MontoInvalidoException {
        this.cuenta.depositar(monto);
    }

    public void realizarRetiro(double monto) throws SaldoInsuficienteException, MontoInvalidoException {
        this.cuenta.retirar(monto);
    }

    public void mostrarInformacion() {
        this.cuenta.mostrarInformacion();
    }

    public void aplicarInteres() {
        this.cuenta.aplicarInteres();
    }

}
