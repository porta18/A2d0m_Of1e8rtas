
package org.tempuri;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element name="pNombres" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pClave" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pVigencia" type="{http://schemas.microsoft.com/2003/10/Serialization/}char" minOccurs="0"/>
 *         &lt;element name="pCorreo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pTusuario" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="pPersona" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
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
    "pNombres",
    "pClave",
    "pVigencia",
    "pCorreo",
    "pTusuario",
    "pPersona"
})
@XmlRootElement(name = "CreaUser")
public class CreaUser {

    @XmlElementRef(name = "pNombres", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> pNombres;
    @XmlElementRef(name = "pClave", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> pClave;
    protected Integer pVigencia;
    @XmlElementRef(name = "pCorreo", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> pCorreo;
    protected Integer pTusuario;
    protected Integer pPersona;

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
     * Obtiene el valor de la propiedad pClave.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPClave() {
        return pClave;
    }

    /**
     * Define el valor de la propiedad pClave.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPClave(JAXBElement<String> value) {
        this.pClave = value;
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
     * Obtiene el valor de la propiedad pCorreo.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPCorreo() {
        return pCorreo;
    }

    /**
     * Define el valor de la propiedad pCorreo.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPCorreo(JAXBElement<String> value) {
        this.pCorreo = value;
    }

    /**
     * Obtiene el valor de la propiedad pTusuario.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPTusuario() {
        return pTusuario;
    }

    /**
     * Define el valor de la propiedad pTusuario.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPTusuario(Integer value) {
        this.pTusuario = value;
    }

    /**
     * Obtiene el valor de la propiedad pPersona.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPPersona() {
        return pPersona;
    }

    /**
     * Define el valor de la propiedad pPersona.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPPersona(Integer value) {
        this.pPersona = value;
    }

}
