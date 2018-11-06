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
public class WsProducto {
    public String WSfn_TraerProductosTienda(java.lang.Integer tnd_id) {

        org.tempuri.Consultas service = new org.tempuri.Consultas();
        org.tempuri.IConsultas port = service.getBasicHttpBindingIConsultas();
        return port.traeProductosTienda(tnd_id);
    }
    
    
    public String WSfn_GuardarProducto(java.lang.String tipo,java.lang.Integer prd_cod,java.lang.String nombre,
                                        java.lang.Integer precio_c,java.lang.Integer ctg_id,java.lang.Integer precio_v,
                                        java.lang.Integer tnd_id,java.lang.Integer prd_id) {

        org.tempuri.Consultas service = new org.tempuri.Consultas();
        org.tempuri.IConsultas port = service.getBasicHttpBindingIConsultas();
        return port.guardarProducto(tipo,prd_cod,nombre,1,precio_c,ctg_id,precio_v,tnd_id,prd_id);
    }
    
    
    public String WSfn_EliminarProducto(java.lang.Integer prd_id) {

        org.tempuri.Consultas service = new org.tempuri.Consultas();
        org.tempuri.IConsultas port = service.getBasicHttpBindingIConsultas();
        return port.eliminarProducto(prd_id);
    }
}
