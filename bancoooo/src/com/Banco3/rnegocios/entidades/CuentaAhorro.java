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
public class CuentaAhorro {
    private int id;
    private double interes;
    private Cuenta cuenta;
    private Cliente cliente;
    private double saldo;

    public CuentaAhorro() {
    }

    public CuentaAhorro(int id, double interes, Cuenta cuenta, Cliente cliente, double saldo) {
        this.id = id;
        this.interes = interes;
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

    public double getInteres() {
        return interes;
    }

    public void setInteres(double interes) {
        this.interes = interes;
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
