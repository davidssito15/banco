package com.Banco3.rnegocios.entidades;


public class Inspector {
 private int id ;
 private String nombres ;
 private String apellidos ;
 private String direccion ;
 private String titulo ;
 private ClientePrestamo clientePrestamo;
 

    public Inspector() {
    }

    public Inspector(int id, String nombres, String apellidos, String direccion, String titulo, ClientePrestamo clientePrestamo) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.titulo = titulo;
        this.clientePrestamo = clientePrestamo;
    }

    public Inspector(int i, String iker, String jim, String junin, int i0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }  

    public ClientePrestamo getClientePrestamo() {
        return clientePrestamo;
    }

    public void setClientePrestamo(ClientePrestamo clientePrestamo) {
        this.clientePrestamo = clientePrestamo;
    }

}
