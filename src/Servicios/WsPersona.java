/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Negocio.Funciones;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 *
 * @author Sony
 */
public class WsPersona {
     public String WSfn_GuardarPersona(java.lang.String tipo,java.lang.Integer rut,java.lang.String nombres,
                                       java.lang.String ape_p, java.lang.String ape_m,java.lang.String pFecha,
                                       java.lang.Integer sxo_id,java.lang.Integer prs_id) {

        org.tempuri.Consultas service = new org.tempuri.Consultas();
        org.tempuri.IConsultas port = service.getBasicHttpBindingIConsultas();
        
         Funciones fn = new Funciones();

        XMLGregorianCalendar gregDate = fn.retornaFechaXml(pFecha);
        
        
        return port.guardarPersona(tipo,rut,nombres,ape_p,ape_m,gregDate,sxo_id,prs_id);
    }
     
       public String WSfn_EliminarPersona(java.lang.Integer prs_id) {

        org.tempuri.Consultas service = new org.tempuri.Consultas();
        org.tempuri.IConsultas port = service.getBasicHttpBindingIConsultas();
        return port.eliminarPersona(prs_id);
    }
}
