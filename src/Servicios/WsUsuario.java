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

   
}
