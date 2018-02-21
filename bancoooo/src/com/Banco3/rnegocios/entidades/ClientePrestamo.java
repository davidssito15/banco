package com.Banco3.rnegocios.entidades;

public class ClientePrestamo {
    private int id;
    private Cliente cliente;
    private Prestamo prestamo;
    private Sucursal sucursal;

    public ClientePrestamo() {
    }

    public ClientePrestamo(int id, Cliente cliente, Prestamo prestamo, Sucursal sucursal) {
        this.id = id;
        this.cliente = cliente;
        this.prestamo = prestamo;
        this.sucursal = sucursal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Prestamo getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(Prestamo prestamo) {
        this.prestamo = prestamo;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }
    
    
    
}
