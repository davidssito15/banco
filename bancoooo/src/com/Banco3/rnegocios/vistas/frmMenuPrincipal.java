/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Banco3.rnegocios.vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
//import org.jvnet.substance.SubstanceLookAndFeel;

public class frmMenuPrincipal extends JFrame{
    JMenuBar mnbPrincipal;
    JMenu mnInicio;
    JMenuItem mniLogin;
    JMenuItem mniSalir;
    
    JMenu mnCliente;
    JMenuItem mniNuevoCliente;
    JMenuItem mniModificaCliente;
    JMenuItem mniEliminaCliente;
    JMenuItem mniBuscaCliente;
    JMenuItem mniListaCliente;
      
    
    ///SUCURSAL
    JMenu mnSucursal;
    JMenuItem mniNuevoSucursal;
    JMenuItem mniModificaSucursal;
    JMenuItem mniEliminaSucursal;
    JMenuItem mniBuscaSucursal;
    JMenuItem mniListaSucursal;

      ///PRESTAMO  
    JMenu mnPrestamo;
    JMenuItem mniNuevoPrestamo;
    JMenuItem mniModificaPrestamo;
    JMenuItem mniEliminaPrestamo;
    JMenuItem mniBuscaPrestamo;
    JMenuItem mniListaPrestamo;
//    
    ///PAGO  
    JMenu mnPago;
    JMenuItem mniNuevoPago;
    JMenuItem mniModificaPago;
    JMenuItem mniEliminaPago;
    JMenuItem mniBuscaPago;
    JMenuItem mniListaPago;
//    
//    JMenu mnMateria;
//    JMenuItem mniNuevoMateria;
//    JMenuItem mniModificaMateria;
//    JMenuItem mniEliminaMateria;
//    JMenuItem mniBuscaMateria;
//    JMenuItem mniListaMateria;
//    
//    JMenu mnDocente;
//    JMenuItem mniNuevoDocente;
//    JMenuItem mniModificaDocente;
//    JMenuItem mniEliminaDocente;
//    JMenuItem mniBuscaDocente;
//    JMenuItem mniListaDocente;
    
    JDesktopPane dkpEscritorio;
    public frmMenuPrincipal() {
        dkpEscritorio= new JDesktopPane();
        dkpEscritorio.setBackground(new Color(240, 240, 240));
        
        setTitle("***** BASE DE DATOS BANCO****");
        dkpEscritorio.setBackground(Color.GRAY);
        
        mnbPrincipal = new JMenuBar();
        mnInicio = new JMenu("Inicio");
        mniLogin = new JMenuItem("Iniciar Sesión");
        mniSalir = new JMenuItem("Salir");
        mniSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniSalirActionPerformed(e);
            }
        });
        mnCliente= new JMenu("Cliente");
        mniNuevoCliente= new JMenuItem("Nuevo");
        mniNuevoCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniNuevoClienteActionPerformed(e);
            }
        });
        mniModificaCliente= new JMenuItem("Modifica");
        mniEliminaCliente= new JMenuItem("Elimina");
        mniBuscaCliente= new JMenuItem("Busca");
        mniListaCliente= new JMenuItem("Lista");
        mniListaCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniListaClienteActionPerformed(e);
            }
        });
        
        
        mnCliente.add(mniNuevoCliente);
        mnCliente.add(mniModificaCliente);
        mnCliente.add(mniEliminaCliente);
        mnCliente.addSeparator();
        mnCliente.add(mniBuscaCliente);
        mnCliente.add(mniListaCliente);
        
        //Sucursal
        mnSucursal= new JMenu("Sucursal");
        mniNuevoSucursal= new JMenuItem("Nuevo");
        mniNuevoSucursal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniNuevoSucursalActionPerformed(e);
            }
        });
        mniModificaSucursal = new JMenuItem("Modifica");
        mniEliminaSucursal = new JMenuItem("Elimina");
        mniBuscaSucursal = new JMenuItem("Busca");
        mniListaSucursal = new JMenuItem("Lista"); 
         mniListaSucursal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniListaSucursalActionPerformed(e);
            }
        });
        mnSucursal.add(mniNuevoSucursal);
        mnSucursal.add(mniModificaSucursal);
        mnSucursal.add(mniEliminaSucursal);
        mnSucursal.addSeparator();
        mnSucursal.add(mniBuscaSucursal);
        mnSucursal.add(mniListaSucursal);
        
        
        //Prestamo
        mnSucursal= new JMenu("Prestamo");
        mniNuevoPrestamo= new JMenuItem("Nuevo");
        mniNuevoPrestamo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniNuevoPrestamoActionPerformed(e);
            }
        });
        mniModificaPrestamo = new JMenuItem("Modifica");
        mniEliminaPrestamo = new JMenuItem("Elimina");
        mniBuscaPrestamo = new JMenuItem("Busca");
        mniListaPrestamo = new JMenuItem("Lista"); 
         mniListaPrestamo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniListaPrestamoActionPerformed(e);
            }
        });
//        mnPrestamo.add(mniNuevoPrestamo);
//        mnPrestamo.add(mniModificaPrestamo);
//        mnPrestamo.add(mniEliminaPrestamo);
//        mnPrestamo.addSeparator();
//        mnPrestamo.add(mniBuscaPrestamo);
//        mnPrestamo.add(mniListaPrestamo);
        
        //Pago
        mnPago= new JMenu("Pago");
        mniNuevoPago= new JMenuItem("Nuevo");
        mniNuevoPago.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniNuevoPagoActionPerformed(e);
            }
        });
        mniModificaPago = new JMenuItem("Modifica");
        mniEliminaPago = new JMenuItem("Elimina");
        mniBuscaPago = new JMenuItem("Busca");
        mniListaPago = new JMenuItem("Lista"); 
         mniListaPago.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniListaPagoActionPerformed(e);
            }
        });
        mnPago.add(mniNuevoPago);
        mnPago.add(mniModificaPago);
        mnPago.add(mniEliminaPago);
        mnPago.addSeparator();
        mnPago.add(mniBuscaPago);
        mnPago.add(mniListaPago);
        
        
        mnbPrincipal.add(mnInicio);
        mnbPrincipal.add(mnCliente);
         mnbPrincipal.add(mnSucursal);
        mnInicio.add(mniLogin);
        mnInicio.add(mniSalir);
        
        this.setLayout(new BorderLayout());
        this.add(mnbPrincipal, BorderLayout.NORTH);
        this.add(dkpEscritorio, BorderLayout.CENTER);
        this.setExtendedState(MAXIMIZED_BOTH); //Para maximizar
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); //Para terminar el programa
        JFrame.setDefaultLookAndFeelDecorated(true); //que nos permite dejar a Substance la decoracion ( por asi decirlo) 
        //SubstanceLookAndFeel.setSkin("org.jvnet.substance.theme.SubstanceBottleGreenTheme"); // Setencia que aplica el skin Creme de Substanc
        //SubstanceLookAndFeel.setCurrentTheme("org.jvnet.substance.theme.SubstanceCharcoalTheme"); // Se aplica el tema Aqui de Substance
    }
    
    
    public void mniListaClienteActionPerformed(ActionEvent e){
        frmListaCliente frm = new frmListaCliente();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }
    
      
    public void mniNuevoClienteActionPerformed(ActionEvent e){
        frmNuevoCliente frm = new frmNuevoCliente();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }
         public void mniListaSucursalActionPerformed(ActionEvent e){
        frmListaSucursal frm = new frmListaSucursal();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }
    
      
    public void mniNuevoSucursalActionPerformed(ActionEvent e){
        frmNuevoSucursal frm = new frmNuevoSucursal();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }
    
    public void mniNuevoPrestamoActionPerformed(ActionEvent e){
        frmNuevoPrestamo frm = new frmNuevoPrestamo();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }
         public void mniListaPrestamoActionPerformed(ActionEvent e){
        frmListaPrestamo frm = new frmListaPrestamo();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }
    
         public void mniNuevoPagoActionPerformed(ActionEvent e){
        frmNuevoPago frm = new frmNuevoPago();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }
         public void mniListaPagoActionPerformed(ActionEvent e){
        frmListaPago frm = new frmListaPago();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }
         
    public void mniSalirActionPerformed(ActionEvent e){
        System.exit(0);
    }
    
    public static void main(String[] args) {
        frmMenuPrincipal frm = new frmMenuPrincipal();
        frm.setVisible(true);
    }
}