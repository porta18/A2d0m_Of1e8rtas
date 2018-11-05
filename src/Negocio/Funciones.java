/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Servicios.WsOferta;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 *
 * @author Sony
 */
public class Funciones {
    
        public boolean validarRut(String Full) {
        int dv1 = retornaDV(Integer.parseInt(Full));
        String digito;
        if(dv1 == 10){
            digito = "k";
        }else if(dv1 == 11){
            digito = "0";
        }else{
            digito = String.valueOf(dv1);
        }    
        String rut = Full+digito;
        boolean validacion = false;
        try {
            rut =  rut.toUpperCase();
            rut = rut.replace(".", "");
            rut = rut.replace("-", "");
            int rutAux = Integer.parseInt(rut.substring(0, rut.length() - 1));
            char dv = rut.charAt(rut.length() - 1);
            int m = 0, s = 1;
            for (; rutAux != 0; rutAux /= 10) {
                s = (s + rutAux % 10 * (9 - m++ % 6)) % 11;
            }
            if (dv == (char) (s != 0 ? s + 47 : 75)) {
                validacion = true;
            }   
        } catch (java.lang.NumberFormatException e) {
            
        } catch (Exception e) {
        
        }
        return validacion;
    }
    
    public int retornaDV(int rut) {
        int n,b,c,d,e,f,g,h,i;
        //descomponer el cuerpo del rut, para luego contener cada numero en una va&lt;riable.
        int A=rut/10000000; //se guarda el primer numero
        n=rut%10000000;
        int B=n/1000000;
        n=n%1000000;
        int C=n/100000;
        n=n%100000;
        int D=n/10000;
        n=n%10000;
        int E=n/1000;
        n=n%1000;
        int F=n/100;
        n=n%100;
        int G=n/10;
         n=n%10;
        // Multiplicar cada digito,
         b=A*3; c=B*2; d=C*7; e=D*6; f=E*5; g=F*4; h=G*3; i=n*2;
         //sumar las multiplicaciones
         int suma=b+c+d+e+f+g+h+i;
         //dividir el total de la suma en 11
         int division= suma/11;
         //sacar el resto ya que con eso se trabaja
         int resto=suma%11;
         //a 11 se le quita el resto
         int total=11-resto;
            return total;
    }
    
    public XMLGregorianCalendar retornaFechaXml(String fecha) {
        XMLGregorianCalendar gregDate = null;
        try {
            try {
                gregDate = DatatypeFactory.newInstance().newXMLGregorianCalendar();
            } catch (DatatypeConfigurationException ex) {
                Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
            }
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            Date date = formatter.parse(fecha);
            

            Calendar calendarI = new GregorianCalendar();
            calendarI.setTime(date);

            gregDate.setYear(calendarI.get(Calendar.YEAR));
            int mes = calendarI.get(Calendar.MONTH);
            int mesCorrecto = (mes + 1);
            
            gregDate.setMonth(mesCorrecto);
            gregDate.setDay(calendarI.get(Calendar.DAY_OF_MONTH));
            gregDate.setHour(0);
            gregDate.setMinute(0);
            gregDate.setSecond(0);
            gregDate.setMillisecond(0);

        } catch (ParseException ex) {
            Logger.getLogger(WsOferta.class.getName()).log(Level.SEVERE, null, ex);
        }
        return gregDate;
    }
    
    
}
