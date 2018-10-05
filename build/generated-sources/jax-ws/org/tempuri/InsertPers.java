
package org.tempuri;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="pRut" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="pNombres" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pAp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pAm" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pFechaN" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="pVigencia" type="{http://schemas.microsoft.com/2003/10/Serialization/}char" minOccurs="0"/>
 *         &lt;element name="pSexo" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "pRut",
    "pNombres",
    "pAp",
    "pAm",
    "pFechaN",
    "pVigencia",
    "pSexo"
})
@XmlRootElement(name = "InsertPers")
public class InsertPers {

    protected Integer pRut;
    @XmlElementRef(name = "pNombres", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> pNombres;
    @XmlElementRef(name = "pAp", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> pAp;
    @XmlElementRef(name = "pAm", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> pAm;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar pFechaN;
    protected Integer pVigencia;
    protected Integer pSexo;

    /**
     * Obtiene el valor de la propiedad pRut.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPRut() {
        return pRut;
    }

    /**
     * Define el valor de la propiedad pRut.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPRut(Integer value) {
        this.pRut = value;
    }

    /**
     * Obtiene el valor de la propiedad pNombres.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPNombres() {
        return pNombres;
    }

    /**
     * Define el valor de la propiedad pNombres.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPNombres(JAXBElement<String> value) {
        this.pNombres = value;
    }

    /**
     * Obtiene el valor de la propiedad pAp.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPAp() {
        return pAp;
    }

    /**
     * Define el valor de la propiedad pAp.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPAp(JAXBElement<String> value) {
        this.pAp = value;
    }

    /**
     * Obtiene el valor de la propiedad pAm.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPAm() {
        return pAm;
    }

    /**
     * Define el valor de la propiedad pAm.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPAm(JAXBElement<String> value) {
        this.pAm = value;
    }

    /**
     * Obtiene el valor de la propiedad pFechaN.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getPFechaN() {
        return pFechaN;
    }

    /**
     * Define el valor de la propiedad pFechaN.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setPFechaN(XMLGregorianCalendar value) {
        this.pFechaN = value;
    }

    /**
     * Obtiene el valor de la propiedad pVigencia.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPVigencia() {
        return pVigencia;
    }

    /**
     * Define el valor de la propiedad pVigencia.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPVigencia(Integer value) {
        this.pVigencia = value;
    }

    /**
     * Obtiene el valor de la propiedad pSexo.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPSexo() {
        return pSexo;
    }

    /**
     * Define el valor de la propiedad pSexo.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPSexo(Integer value) {
        this.pSexo = value;
    }

}
