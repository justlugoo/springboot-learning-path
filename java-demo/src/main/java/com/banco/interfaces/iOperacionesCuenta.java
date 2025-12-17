package com.banco.interfaces;

import com.banco.exceptions.MontoInvalidoException;
import com.banco.exceptions.SaldoInsuficienteException;

// Definicion del contrato que una cuenta debe hacer
public interface iOperacionesCuenta {

    void depositar(double monto) throws MontoInvalidoException;

    boolean retirar(double monto) throws SaldoInsuficienteException, MontoInvalidoException;

    void mostrarInformacion();
}