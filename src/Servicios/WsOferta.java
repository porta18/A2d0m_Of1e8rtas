/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Negocio.Funciones;
import java.io.StringWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;

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

    public String WSfn_TraerTipoOferta(java.lang.Integer oft_id) {

        org.tempuri.Consultas service = new org.tempuri.Consultas();
        org.tempuri.IConsultas port = service.getBasicHttpBindingIConsultas();
        return port.traeTipoOferta(oft_id);
    }

    public String WSfn_GuardaEncabezadoOferta(java.lang.String tipo, java.lang.String pFechaIni, java.lang.String pFechaFin,
            java.lang.Integer isPublica, java.lang.Integer tipoOoferta, java.lang.Integer tienda, java.lang.Integer id_oferta) {

        org.tempuri.Consultas service = new org.tempuri.Consultas();
        org.tempuri.IConsultas port = service.getBasicHttpBindingIConsultas();

        Funciones fn = new Funciones();
        
        
        XMLGregorianCalendar gregDateI = fn.retornaFechaXml(pFechaIni);
        XMLGregorianCalendar gregDateF = fn.retornaFechaXml(pFechaFin);;


        //return port.crearOferta(pFechaInicio, pFechaFin, isPublica, tipoOoferta)
        return port.guardarOferta(tipo, gregDateI, gregDateF, isPublica, tipoOoferta, tienda, id_oferta);

    }

    
}
