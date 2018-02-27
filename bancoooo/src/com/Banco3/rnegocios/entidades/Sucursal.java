/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Banco3.rnegocios.entidades;

/**
 *
 * @author usuario
 */
public class Sucursal {
    
    private int CodigoS;
    private String NombreBanco;
    private String Ciudad;
    private String Direccion;
    private String Telefono;
    private String Email;
 public Sucursal() {
    }


    public Sucursal(int CodigoS, String NombreBanco, String Ciudad, String Direccion, String Telefono, String Email) {
        this.CodigoS = CodigoS;
        this.NombreBanco = NombreBanco;
        this.Ciudad = Ciudad;
        this.Direccion = Direccion;
        this.Telefono = Telefono;
        this.Email = Email;
    }

    public int getCodigoS() {
        return CodigoS;
    }

    public void setCodigoS(int CodigoS) {
        this.CodigoS = CodigoS;
    }

    public String getNombreBanco() {
        return NombreBanco;
    }

    public void setNombreBanco(String NombreBanco) {
        this.NombreBanco = NombreBanco;
    }

    public String getCiudad() {
        return Ciudad;
    }

    public void setCiudad(String Ciudad) {
        this.Ciudad = Ciudad;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

       
/*@Override
    public String toString() {
        return NombreBanco; 
    }*/
}
