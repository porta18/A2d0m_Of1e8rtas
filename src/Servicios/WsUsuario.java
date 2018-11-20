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
public class WsUsuario {

    public String WSfn_Login(java.lang.String usu, java.lang.String pass) {

        org.tempuri.Consultas service = new org.tempuri.Consultas();
        org.tempuri.IConsultas port = service.getBasicHttpBindingIConsultas();
        return port.loginUsuario(usu, pass);
    }

    public String WSfn_TraerUsuario(java.lang.Integer usu_id) {

        org.tempuri.Consultas service = new org.tempuri.Consultas();
        org.tempuri.IConsultas port = service.getBasicHttpBindingIConsultas();
        return port.traeUsuario(usu_id);
    }

    public String WSfn_TraerTipoSexo() {

        org.tempuri.Consultas service = new org.tempuri.Consultas();
        org.tempuri.IConsultas port = service.getBasicHttpBindingIConsultas();
        return port.traeSexos();
    }
    
     public String WSfn_TraerTipoUsuario() {

        org.tempuri.Consultas service = new org.tempuri.Consultas();
        org.tempuri.IConsultas port = service.getBasicHttpBindingIConsultas();
        return port.traeTipoUsuario();
    }
    
    public String WSfn_GuardarUsuario(java.lang.String tipo,java.lang.String usu,java.lang.String clv,
                                        java.lang.String email,java.lang.Integer tpu_id,java.lang.Integer prs_id,
                                        java.lang.Integer usu_id) {

        org.tempuri.Consultas service = new org.tempuri.Consultas();
        org.tempuri.IConsultas port = service.getBasicHttpBindingIConsultas();
        return port.guardarsuario(tipo,usu,clv,email,tpu_id,prs_id,usu_id);
    }
    
    public String WSfn_EliminarUsuario(java.lang.Integer usu_id) {

        org.tempuri.Consultas service = new org.tempuri.Consultas();
        org.tempuri.IConsultas port = service.getBasicHttpBindingIConsultas();
        return port.eliminarUsuario(usu_id);
    }

}
