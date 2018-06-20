/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.are.publicacion.entidades;

import java.util.ArrayList;

/**
 *
 * @author aimer
 */
public class PublicacionResult {
    private boolean encontrado;
    private boolean error;
    private String msgError;
    private ArrayList<Publicacion> publicaciones;

    public boolean isEncontrado() {
        return encontrado;
    }

    public void setEncontrado(boolean encontrado) {
        this.encontrado = encontrado;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getMsgError() {
        return msgError;
    }

    public void setMsgError(String msgError) {
        this.msgError = msgError;
    }

    public ArrayList<Publicacion> getPublicaciones() {
        return publicaciones;
    }

    public void setPublicaciones(ArrayList<Publicacion> publicaciones) {
        this.publicaciones = publicaciones;
    }

    public PublicacionResult() {
        this.encontrado = false;
        this.error = false;
        this.msgError = "";
        publicaciones = new ArrayList<Publicacion>();
    }
    
    
}
