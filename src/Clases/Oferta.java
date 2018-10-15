/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.Date;

/**
 *
 * @author Sony
 */
public class Oferta {
    private int id;
    private int vigencia;
    private Date fechaInicio;
    private Date fechaTermino;
    private int publica;
    private int id_tienda;
    private String tienda;
    private int tipoOferta;
    
    public static Oferta sOferta;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVigencia() {
        return vigencia;
    }

    public void setVigencia(int vigencia) {
        this.vigencia = vigencia;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaTermino() {
        return fechaTermino;
    }

    public void setFechaTermino(Date fechaTermino) {
        this.fechaTermino = fechaTermino;
    }

    public int getPublica() {
        return publica;
    }

    public void setPublica(int publica) {
        this.publica = publica;
    }

    public int getId_tienda() {
        return id_tienda;
    }

    public void setId_tienda(int id_tienda) {
        this.id_tienda = id_tienda;
    }

    public String getTienda() {
        return tienda;
    }

    public void setTienda(String tienda) {
        this.tienda = tienda;
    }

    public int getTipoOferta() {
        return tipoOferta;
    }

    public void setTipoOferta(int tipoOferta) {
        this.tipoOferta = tipoOferta;
    }
    
    
    
}
