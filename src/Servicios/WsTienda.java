/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

/**
 *
 * @author Sony
 */
public class WsTienda {

    public String WSfn_TraerTienda(java.lang.Integer tnd_id) {

        org.tempuri.Consultas service = new org.tempuri.Consultas();
        org.tempuri.IConsultas port = service.getBasicHttpBindingIConsultas();
        return port.traeTienda(tnd_id);
    }
    
    
    public String WSfn_GuardarTienda(java.lang.String tipo, java.lang.String nombre, java.lang.String direccion, 
                                        java.lang.Integer cmn_id, java.lang.Integer tnd_id) {

        org.tempuri.Consultas service = new org.tempuri.Consultas();
        org.tempuri.IConsultas port = service.getBasicHttpBindingIConsultas();
        return port.guardarTienda(tipo,nombre,1,cmn_id,tnd_id);
    }
    
    public String WSfn_EliminarTienda( java.lang.Integer tnd_id) {

        org.tempuri.Consultas service = new org.tempuri.Consultas();
        org.tempuri.IConsultas port = service.getBasicHttpBindingIConsultas();
        return port.eliminarTienda(tnd_id);
    }
}
