/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Banco3.rnegocios.entidades;

/**
 *
 * @author Angel-Pc
 */
public class CuentaCredito {
    private int id;
    private double sobrejiro;
    private Cuenta cuenta;
    private Cliente cliente;
    private double saldo;

    public CuentaCredito() {
    }

    public CuentaCredito(int id, double sobrejiro, Cuenta cuenta, Cliente cliente, double saldo) {
        this.id = id;
        this.sobrejiro = sobrejiro;
        this.cuenta = cuenta;
        this.cliente = cliente;
        this.saldo = saldo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSobrejiro() {
        return sobrejiro;
    }

    public void setSobrejiro(double sobrejiro) {
        this.sobrejiro = sobrejiro;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    
}
