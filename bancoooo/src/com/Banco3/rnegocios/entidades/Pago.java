/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Banco3.rnegocios.entidades;

import java.util.Date;

/**
 *
 * @author usuario
 */
public class Pago {
    
    private int id;
    private Date fecha;
    private double valor;
    private int numero_pago;
    private Prestamo prestamo;

    public Pago() {
    }

    public Pago(int id, Date fecha, double valor, int numero_pago, Prestamo prestamo) {
        this.id = id;
        this.fecha = fecha;
        this.valor = valor;
        this.numero_pago = numero_pago;
        this.prestamo = prestamo;
    }

    public Prestamo getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(Prestamo prestamo) {
        this.prestamo = prestamo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getNumero_pago() {
        return numero_pago;
    }

    public void setNumero_pago(int numero_pago) {
        this.numero_pago = numero_pago;
    }
    
    
    
}
