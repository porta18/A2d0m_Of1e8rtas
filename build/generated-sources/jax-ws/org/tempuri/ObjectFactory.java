
package org.tempuri;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.tempuri package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _CrearTiendaPDescripcion_QNAME = new QName("http://tempuri.org/", "pDescripcion");
    private final static QName _CrearTiendaPDireccion_QNAME = new QName("http://tempuri.org/", "pDireccion");
    private final static QName _CrearTiendaPComuna_QNAME = new QName("http://tempuri.org/", "pComuna");
    private final static QName _GuardarOfertaResponseGuardarOfertaResult_QNAME = new QName("http://tempuri.org/", "GuardarOfertaResult");
    private final static QName _CreaUserPClave_QNAME = new QName("http://tempuri.org/", "pClave");
    private final static QName _CreaUserPCorreo_QNAME = new QName("http://tempuri.org/", "pCorreo");
    private final static QName _CreaUserPNombres_QNAME = new QName("http://tempuri.org/", "pNombres");
    private final static QName _TraeOfertaEncabezadoResponseTraeOfertaEncabezadoResult_QNAME = new QName("http://tempuri.org/", "traeOfertaEncabezadoResult");
    private final static QName _InsertPersResponseInsertPersResult_QNAME = new QName("http://tempuri.org/", "InsertPersResult");
    private final static QName _TraeUsuarioResponseTraeUsuarioResult_QNAME = new QName("http://tempuri.org/", "traeUsuarioResult");
    private final static QName _TraeOfertaDetalleResponseTraeOfertaDetalleResult_QNAME = new QName("http://tempuri.org/", "traeOfertaDetalleResult");
    private final static QName _LoginUsuarioPUsuario_QNAME = new QName("http://tempuri.org/", "pUsuario");
    private final static QName _InsertPersPAp_QNAME = new QName("http://tempuri.org/", "pAp");
    private final static QName _InsertPersPAm_QNAME = new QName("http://tempuri.org/", "pAm");
    private final static QName _LoginUsuarioResponseLoginUsuarioResult_QNAME = new QName("http://tempuri.org/", "LoginUsuarioResult");
    private final static QName _CreaUserResponseCreaUserResult_QNAME = new QName("http://tempuri.org/", "CreaUserResult");
    private final static QName _TraeProductosTiendaResponseTraeProductosTiendaResult_QNAME = new QName("http://tempuri.org/", "traeProductosTiendaResult");
    private final static QName _TraeOfertaResponseTraeOfertaResult_QNAME = new QName("http://tempuri.org/", "traeOfertaResult");
    private final static QName _CrearOfertaResponseCrearOfertaResult_QNAME = new QName("http://tempuri.org/", "CrearOfertaResult");
    private final static QName _TraeOProductosResponseTraeOProductosResult_QNAME = new QName("http://tempuri.org/", "traeOProductosResult");
    private final static QName _TraeTiendaResponseTraeTiendaResult_QNAME = new QName("http://tempuri.org/", "traeTiendaResult");
    private final static QName _GetSexoResponseGetSexoResult_QNAME = new QName("http://tempuri.org/", "getSexoResult");
    private final static QName _TraeValoracionOfertaResponseTraeValoracionOfertaResult_QNAME = new QName("http://tempuri.org/", "traeValoracionOfertaResult");
    private final static QName _CrearTiendaResponseCrearTiendaResult_QNAME = new QName("http://tempuri.org/", "CrearTiendaResult");
    private final static QName _TraeTipoOfertaResponseTraeTipoOfertaResult_QNAME = new QName("http://tempuri.org/", "traeTipoOfertaResult");
    private final static QName _GuardarOfertaPTipo_QNAME = new QName("http://tempuri.org/", "pTipo");
    private final static QName _GuardarOfertaPIdOferta_QNAME = new QName("http://tempuri.org/", "pIdOferta");
    private final static QName _TraePersonaResponseTraePersonaResult_QNAME = new QName("http://tempuri.org/", "traePersonaResult");
    private final static QName _TraeProductoResponseTraeProductoResult_QNAME = new QName("http://tempuri.org/", "traeProductoResult");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.tempuri
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link InsertPersResponse }
     * 
     */
    public InsertPersResponse createInsertPersResponse() {
        return new InsertPersResponse();
    }

    /**
     * Create an instance of {@link GetSexoResponse }
     * 
     */
    public GetSexoResponse createGetSexoResponse() {
        return new GetSexoResponse();
    }

    /**
     * Create an instance of {@link UpdateUserPass }
     * 
     */
    public UpdateUserPass createUpdateUserPass() {
        return new UpdateUserPass();
    }

    /**
     * Create an instance of {@link TraeTipoOferta }
     * 
     */
    public TraeTipoOferta createTraeTipoOferta() {
        return new TraeTipoOferta();
    }

    /**
     * Create an instance of {@link TraePersona }
     * 
     */
    public TraePersona createTraePersona() {
        return new TraePersona();
    }

    /**
     * Create an instance of {@link TraeValoracionOfertaResponse }
     * 
     */
    public TraeValoracionOfertaResponse createTraeValoracionOfertaResponse() {
        return new TraeValoracionOfertaResponse();
    }

    /**
     * Create an instance of {@link TraeProductoResponse }
     * 
     */
    public TraeProductoResponse createTraeProductoResponse() {
        return new TraeProductoResponse();
    }

    /**
     * Create an instance of {@link TraeProductosTiendaResponse }
     * 
     */
    public TraeProductosTiendaResponse createTraeProductosTiendaResponse() {
        return new TraeProductosTiendaResponse();
    }

    /**
     * Create an instance of {@link InsertPers }
     * 
     */
    public InsertPers createInsertPers() {
        return new InsertPers();
    }

    /**
     * Create an instance of {@link TraeUsuario }
     * 
     */
    public TraeUsuario createTraeUsuario() {
        return new TraeUsuario();
    }

    /**
     * Create an instance of {@link TraePersonaResponse }
     * 
     */
    public TraePersonaResponse createTraePersonaResponse() {
        return new TraePersonaResponse();
    }

    /**
     * Create an instance of {@link TraeProducto }
     * 
     */
    public TraeProducto createTraeProducto() {
        return new TraeProducto();
    }

    /**
     * Create an instance of {@link GuardarOferta }
     * 
     */
    public GuardarOferta createGuardarOferta() {
        return new GuardarOferta();
    }

    /**
     * Create an instance of {@link CrearTienda }
     * 
     */
    public CrearTienda createCrearTienda() {
        return new CrearTienda();
    }

    /**
     * Create an instance of {@link TraeOfertaDetalle }
     * 
     */
    public TraeOfertaDetalle createTraeOfertaDetalle() {
        return new TraeOfertaDetalle();
    }

    /**
     * Create an instance of {@link CrearTiendaResponse }
     * 
     */
    public CrearTiendaResponse createCrearTiendaResponse() {
        return new CrearTiendaResponse();
    }

    /**
     * Create an instance of {@link TraeValoracionOferta }
     * 
     */
    public TraeValoracionOferta createTraeValoracionOferta() {
        return new TraeValoracionOferta();
    }

    /**
     * Create an instance of {@link TraeOfertaDetalleResponse }
     * 
     */
    public TraeOfertaDetalleResponse createTraeOfertaDetalleResponse() {
        return new TraeOfertaDetalleResponse();
    }

    /**
     * Create an instance of {@link CreaUser }
     * 
     */
    public CreaUser createCreaUser() {
        return new CreaUser();
    }

    /**
     * Create an instance of {@link TraeOfertaEncabezadoResponse }
     * 
     */
    public TraeOfertaEncabezadoResponse createTraeOfertaEncabezadoResponse() {
        return new TraeOfertaEncabezadoResponse();
    }

    /**
     * Create an instance of {@link TraeTiendaResponse }
     * 
     */
    public TraeTiendaResponse createTraeTiendaResponse() {
        return new TraeTiendaResponse();
    }

    /**
     * Create an instance of {@link LoginUsuarioResponse }
     * 
     */
    public LoginUsuarioResponse createLoginUsuarioResponse() {
        return new LoginUsuarioResponse();
    }

    /**
     * Create an instance of {@link GetMaxPerona }
     * 
     */
    public GetMaxPerona createGetMaxPerona() {
        return new GetMaxPerona();
    }

    /**
     * Create an instance of {@link TraeProductosTienda }
     * 
     */
    public TraeProductosTienda createTraeProductosTienda() {
        return new TraeProductosTienda();
    }

    /**
     * Create an instance of {@link TraeOProductos }
     * 
     */
    public TraeOProductos createTraeOProductos() {
        return new TraeOProductos();
    }

    /**
     * Create an instance of {@link TraeTienda }
     * 
     */
    public TraeTienda createTraeTienda() {
        return new TraeTienda();
    }

    /**
     * Create an instance of {@link GetMaxPeronaResponse }
     * 
     */
    public GetMaxPeronaResponse createGetMaxPeronaResponse() {
        return new GetMaxPeronaResponse();
    }

    /**
     * Create an instance of {@link UpdateUserPassResponse }
     * 
     */
    public UpdateUserPassResponse createUpdateUserPassResponse() {
        return new UpdateUserPassResponse();
    }

    /**
     * Create an instance of {@link TraeOferta }
     * 
     */
    public TraeOferta createTraeOferta() {
        return new TraeOferta();
    }

    /**
     * Create an instance of {@link GuardarOfertaResponse }
     * 
     */
    public GuardarOfertaResponse createGuardarOfertaResponse() {
        return new GuardarOfertaResponse();
    }

    /**
     * Create an instance of {@link TraeTipoOfertaResponse }
     * 
     */
    public TraeTipoOfertaResponse createTraeTipoOfertaResponse() {
        return new TraeTipoOfertaResponse();
    }

    /**
     * Create an instance of {@link CreaUserResponse }
     * 
     */
    public CreaUserResponse createCreaUserResponse() {
        return new CreaUserResponse();
    }

    /**
     * Create an instance of {@link TraeOProductosResponse }
     * 
     */
    public TraeOProductosResponse createTraeOProductosResponse() {
        return new TraeOProductosResponse();
    }

    /**
     * Create an instance of {@link LoginUsuario }
     * 
     */
    public LoginUsuario createLoginUsuario() {
        return new LoginUsuario();
    }

    /**
     * Create an instance of {@link TraeOfertaEncabezado }
     * 
     */
    public TraeOfertaEncabezado createTraeOfertaEncabezado() {
        return new TraeOfertaEncabezado();
    }

    /**
     * Create an instance of {@link GetSexo }
     * 
     */
    public GetSexo createGetSexo() {
        return new GetSexo();
    }

    /**
     * Create an instance of {@link TraeOfertaResponse }
     * 
     */
    public TraeOfertaResponse createTraeOfertaResponse() {
        return new TraeOfertaResponse();
    }

    /**
     * Create an instance of {@link TraeUsuarioResponse }
     * 
     */
    public TraeUsuarioResponse createTraeUsuarioResponse() {
        return new TraeUsuarioResponse();
    }

    /**
     * Create an instance of {@link CrearOferta }
     * 
     */
    public CrearOferta createCrearOferta() {
        return new CrearOferta();
    }

    /**
     * Create an instance of {@link CrearOfertaResponse }
     * 
     */
    public CrearOfertaResponse createCrearOfertaResponse() {
        return new CrearOfertaResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "pDescripcion", scope = CrearTienda.class)
    public JAXBElement<String> createCrearTiendaPDescripcion(String value) {
        return new JAXBElement<String>(_CrearTiendaPDescripcion_QNAME, String.class, CrearTienda.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "pDireccion", scope = CrearTienda.class)
    public JAXBElement<String> createCrearTiendaPDireccion(String value) {
        return new JAXBElement<String>(_CrearTiendaPDireccion_QNAME, String.class, CrearTienda.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "pComuna", scope = CrearTienda.class)
    public JAXBElement<String> createCrearTiendaPComuna(String value) {
        return new JAXBElement<String>(_CrearTiendaPComuna_QNAME, String.class, CrearTienda.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GuardarOfertaResult", scope = GuardarOfertaResponse.class)
    public JAXBElement<String> createGuardarOfertaResponseGuardarOfertaResult(String value) {
        return new JAXBElement<String>(_GuardarOfertaResponseGuardarOfertaResult_QNAME, String.class, GuardarOfertaResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "pClave", scope = CreaUser.class)
    public JAXBElement<String> createCreaUserPClave(String value) {
        return new JAXBElement<String>(_CreaUserPClave_QNAME, String.class, CreaUser.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "pCorreo", scope = CreaUser.class)
    public JAXBElement<String> createCreaUserPCorreo(String value) {
        return new JAXBElement<String>(_CreaUserPCorreo_QNAME, String.class, CreaUser.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "pNombres", scope = CreaUser.class)
    public JAXBElement<String> createCreaUserPNombres(String value) {
        return new JAXBElement<String>(_CreaUserPNombres_QNAME, String.class, CreaUser.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "traeOfertaEncabezadoResult", scope = TraeOfertaEncabezadoResponse.class)
    public JAXBElement<String> createTraeOfertaEncabezadoResponseTraeOfertaEncabezadoResult(String value) {
        return new JAXBElement<String>(_TraeOfertaEncabezadoResponseTraeOfertaEncabezadoResult_QNAME, String.class, TraeOfertaEncabezadoResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "InsertPersResult", scope = InsertPersResponse.class)
    public JAXBElement<String> createInsertPersResponseInsertPersResult(String value) {
        return new JAXBElement<String>(_InsertPersResponseInsertPersResult_QNAME, String.class, InsertPersResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "traeUsuarioResult", scope = TraeUsuarioResponse.class)
    public JAXBElement<String> createTraeUsuarioResponseTraeUsuarioResult(String value) {
        return new JAXBElement<String>(_TraeUsuarioResponseTraeUsuarioResult_QNAME, String.class, TraeUsuarioResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "traeOfertaDetalleResult", scope = TraeOfertaDetalleResponse.class)
    public JAXBElement<String> createTraeOfertaDetalleResponseTraeOfertaDetalleResult(String value) {
        return new JAXBElement<String>(_TraeOfertaDetalleResponseTraeOfertaDetalleResult_QNAME, String.class, TraeOfertaDetalleResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "pClave", scope = LoginUsuario.class)
    public JAXBElement<String> createLoginUsuarioPClave(String value) {
        return new JAXBElement<String>(_CreaUserPClave_QNAME, String.class, LoginUsuario.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "pUsuario", scope = LoginUsuario.class)
    public JAXBElement<String> createLoginUsuarioPUsuario(String value) {
        return new JAXBElement<String>(_LoginUsuarioPUsuario_QNAME, String.class, LoginUsuario.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "pNombres", scope = InsertPers.class)
    public JAXBElement<String> createInsertPersPNombres(String value) {
        return new JAXBElement<String>(_CreaUserPNombres_QNAME, String.class, InsertPers.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "pAp", scope = InsertPers.class)
    public JAXBElement<String> createInsertPersPAp(String value) {
        return new JAXBElement<String>(_InsertPersPAp_QNAME, String.class, InsertPers.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "pAm", scope = InsertPers.class)
    public JAXBElement<String> createInsertPersPAm(String value) {
        return new JAXBElement<String>(_InsertPersPAm_QNAME, String.class, InsertPers.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "LoginUsuarioResult", scope = LoginUsuarioResponse.class)
    public JAXBElement<String> createLoginUsuarioResponseLoginUsuarioResult(String value) {
        return new JAXBElement<String>(_LoginUsuarioResponseLoginUsuarioResult_QNAME, String.class, LoginUsuarioResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "CreaUserResult", scope = CreaUserResponse.class)
    public JAXBElement<String> createCreaUserResponseCreaUserResult(String value) {
        return new JAXBElement<String>(_CreaUserResponseCreaUserResult_QNAME, String.class, CreaUserResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "traeProductosTiendaResult", scope = TraeProductosTiendaResponse.class)
    public JAXBElement<String> createTraeProductosTiendaResponseTraeProductosTiendaResult(String value) {
        return new JAXBElement<String>(_TraeProductosTiendaResponseTraeProductosTiendaResult_QNAME, String.class, TraeProductosTiendaResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "traeOfertaResult", scope = TraeOfertaResponse.class)
    public JAXBElement<String> createTraeOfertaResponseTraeOfertaResult(String value) {
        return new JAXBElement<String>(_TraeOfertaResponseTraeOfertaResult_QNAME, String.class, TraeOfertaResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "CrearOfertaResult", scope = CrearOfertaResponse.class)
    public JAXBElement<String> createCrearOfertaResponseCrearOfertaResult(String value) {
        return new JAXBElement<String>(_CrearOfertaResponseCrearOfertaResult_QNAME, String.class, CrearOfertaResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "traeOProductosResult", scope = TraeOProductosResponse.class)
    public JAXBElement<String> createTraeOProductosResponseTraeOProductosResult(String value) {
        return new JAXBElement<String>(_TraeOProductosResponseTraeOProductosResult_QNAME, String.class, TraeOProductosResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "pCorreo", scope = UpdateUserPass.class)
    public JAXBElement<String> createUpdateUserPassPCorreo(String value) {
        return new JAXBElement<String>(_CreaUserPCorreo_QNAME, String.class, UpdateUserPass.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "pClave", scope = UpdateUserPass.class)
    public JAXBElement<String> createUpdateUserPassPClave(String value) {
        return new JAXBElement<String>(_CreaUserPClave_QNAME, String.class, UpdateUserPass.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "pUsuario", scope = UpdateUserPass.class)
    public JAXBElement<String> createUpdateUserPassPUsuario(String value) {
        return new JAXBElement<String>(_LoginUsuarioPUsuario_QNAME, String.class, UpdateUserPass.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "traeTiendaResult", scope = TraeTiendaResponse.class)
    public JAXBElement<String> createTraeTiendaResponseTraeTiendaResult(String value) {
        return new JAXBElement<String>(_TraeTiendaResponseTraeTiendaResult_QNAME, String.class, TraeTiendaResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "getSexoResult", scope = GetSexoResponse.class)
    public JAXBElement<String> createGetSexoResponseGetSexoResult(String value) {
        return new JAXBElement<String>(_GetSexoResponseGetSexoResult_QNAME, String.class, GetSexoResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "traeValoracionOfertaResult", scope = TraeValoracionOfertaResponse.class)
    public JAXBElement<String> createTraeValoracionOfertaResponseTraeValoracionOfertaResult(String value) {
        return new JAXBElement<String>(_TraeValoracionOfertaResponseTraeValoracionOfertaResult_QNAME, String.class, TraeValoracionOfertaResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "CrearTiendaResult", scope = CrearTiendaResponse.class)
    public JAXBElement<String> createCrearTiendaResponseCrearTiendaResult(String value) {
        return new JAXBElement<String>(_CrearTiendaResponseCrearTiendaResult_QNAME, String.class, CrearTiendaResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "traeTipoOfertaResult", scope = TraeTipoOfertaResponse.class)
    public JAXBElement<String> createTraeTipoOfertaResponseTraeTipoOfertaResult(String value) {
        return new JAXBElement<String>(_TraeTipoOfertaResponseTraeTipoOfertaResult_QNAME, String.class, TraeTipoOfertaResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "pTipo", scope = GuardarOferta.class)
    public JAXBElement<String> createGuardarOfertaPTipo(String value) {
        return new JAXBElement<String>(_GuardarOfertaPTipo_QNAME, String.class, GuardarOferta.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "pIdOferta", scope = GuardarOferta.class)
    public JAXBElement<Integer> createGuardarOfertaPIdOferta(Integer value) {
        return new JAXBElement<Integer>(_GuardarOfertaPIdOferta_QNAME, Integer.class, GuardarOferta.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "traePersonaResult", scope = TraePersonaResponse.class)
    public JAXBElement<String> createTraePersonaResponseTraePersonaResult(String value) {
        return new JAXBElement<String>(_TraePersonaResponseTraePersonaResult_QNAME, String.class, TraePersonaResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "traeProductoResult", scope = TraeProductoResponse.class)
    public JAXBElement<String> createTraeProductoResponseTraeProductoResult(String value) {
        return new JAXBElement<String>(_TraeProductoResponseTraeProductoResult_QNAME, String.class, TraeProductoResponse.class, value);
    }

}
