
package com.Banco3.rnegocios.entidades;

public class Pedido {
    private int codigo;
    private Cliente cliente;
    private Inspector inspector;
    private Prestamo prestamo;
    private String resultado;

    public Pedido() {
    }

    public Pedido(int codigo, Cliente cliente, Inspector inspector, Prestamo prestamo, String resultado) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.inspector = inspector;
        this.prestamo = prestamo;
        this.resultado = resultado;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Inspector getInspector() {
        return inspector;
    }

    public void setInspector(Inspector inspector) {
        this.inspector = inspector;
    }

    public Prestamo getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(Prestamo prestamo) {
        this.prestamo = prestamo;
    }
    
}
