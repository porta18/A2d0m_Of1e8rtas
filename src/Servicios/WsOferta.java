/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 *
 * @author Sony
 */
public class WsOferta {

    public String WSfn_TraerProductosTienda(java.lang.Integer tnd_id) {

        org.tempuri.Consultas service = new org.tempuri.Consultas();
        org.tempuri.IConsultas port = service.getBasicHttpBindingIConsultas();
        return port.traeProductosTienda(tnd_id);
    }

    public String WSfn_TraerEncabezadoOfertas(java.lang.Integer tnd_id) {

        org.tempuri.Consultas service = new org.tempuri.Consultas();
        org.tempuri.IConsultas port = service.getBasicHttpBindingIConsultas();
        return port.traeOfertaEncabezado(tnd_id);
    }

    public String WSfn_TraerDetalleOfertas(java.lang.Integer oft_id) {

        org.tempuri.Consultas service = new org.tempuri.Consultas();
        org.tempuri.IConsultas port = service.getBasicHttpBindingIConsultas();
        return port.traeOfertaDetalle(oft_id);
    }

    public String WSfn_GuardaEncabezadoOferta(java.lang.String pFechaIni, java.lang.String pFechaFin,
            java.lang.Integer isPublica, java.lang.Integer tipoOoferta) {

        org.tempuri.Mantenedores service = new org.tempuri.Mantenedores();
        org.tempuri.IMantenedores port = service.getBasicHttpBindingIMantenedores();

        XMLGregorianCalendar gregDate = null;
        try {
            gregDate = DatatypeFactory.newInstance().newXMLGregorianCalendar();
        } catch (DatatypeConfigurationException ex) {
            Logger.getLogger(WsOferta.class.getName()).log(Level.SEVERE, null, ex);
        }
        gregDate.setYear(2019);
        gregDate.setMonth(10);
        gregDate.setDay(28);

        //return port.crearOferta(pFechaInicio, pFechaFin, isPublica, tipoOoferta)
        return port.guardarOferta("do", gregDate, gregDate, isPublica, tipoOoferta,1,9);
    }
}
