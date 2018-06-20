/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.are.publicacion.entidades;

/**
 *
 * @author aimer
 */
public class Publicacion {
    private int acta;
    private String nic;
    private String departamento;
    private String municipio;
    private String localidad;
    private String fecha;
    private String fechaDevolucion;
    private String numeroFR;

    public int getActa() {
        return acta;
    }

    public void setActa(int acta) {
        this.acta = acta;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNumeroFR() {
        return numeroFR;
    }

    public void setNumeroFR(String numeroFR) {
        this.numeroFR = numeroFR;
    }

    public String getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(String fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }
    

    public Publicacion() {
        this.acta = 0;
        this.nic = "";
        this.departamento="";
        this.fecha="";
        this.fechaDevolucion="";
        this.localidad="";
        this.municipio="";
        this.numeroFR="";
    }
    
    
    
}
