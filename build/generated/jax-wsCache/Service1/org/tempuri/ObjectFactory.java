
package org.tempuri;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import org.datacontract.schemas._2004._07.wsporta.CompositeType;


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

    private final static QName _GetDataUsingDataContractResponseGetDataUsingDataContractResult_QNAME = new QName("http://tempuri.org/", "GetDataUsingDataContractResult");
    private final static QName _CreaUserPClave_QNAME = new QName("http://tempuri.org/", "pClave");
    private final static QName _CreaUserPCorreo_QNAME = new QName("http://tempuri.org/", "pCorreo");
    private final static QName _CreaUserPNombres_QNAME = new QName("http://tempuri.org/", "pNombres");
    private final static QName _InsertPersResponseInsertPersResult_QNAME = new QName("http://tempuri.org/", "InsertPersResult");
    private final static QName _GetDataResponseGetDataResult_QNAME = new QName("http://tempuri.org/", "GetDataResult");
    private final static QName _GetSexoResponseGetSexoResult_QNAME = new QName("http://tempuri.org/", "getSexoResult");
    private final static QName _GetDataUsingDataContractComposite_QNAME = new QName("http://tempuri.org/", "composite");
    private final static QName _LoginUsuarioResponseLoginUsuarioResult_QNAME = new QName("http://tempuri.org/", "LoginUsuarioResult");
    private final static QName _LoginUsuarioPNombre_QNAME = new QName("http://tempuri.org/", "pNombre");
    private final static QName _LoginUsuarioPPassword_QNAME = new QName("http://tempuri.org/", "pPassword");
    private final static QName _CreaUserResponseCreaUserResult_QNAME = new QName("http://tempuri.org/", "CreaUserResult");
    private final static QName _UpdateUserPassPUsuario_QNAME = new QName("http://tempuri.org/", "pUsuario");
    private final static QName _InsertPersPAp_QNAME = new QName("http://tempuri.org/", "pAp");
    private final static QName _InsertPersPAm_QNAME = new QName("http://tempuri.org/", "pAm");
    private final static QName _UpdateUserPassResponseUpdateUserPassResult_QNAME = new QName("http://tempuri.org/", "UpdateUserPassResult");

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
     * Create an instance of {@link GetMaxPerona }
     * 
     */
    public GetMaxPerona createGetMaxPerona() {
        return new GetMaxPerona();
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
     * Create an instance of {@link GetDataUsingDataContractResponse }
     * 
     */
    public GetDataUsingDataContractResponse createGetDataUsingDataContractResponse() {
        return new GetDataUsingDataContractResponse();
    }

    /**
     * Create an instance of {@link InsertPers }
     * 
     */
    public InsertPers createInsertPers() {
        return new InsertPers();
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
     * Create an instance of {@link CreaUserResponse }
     * 
     */
    public CreaUserResponse createCreaUserResponse() {
        return new CreaUserResponse();
    }

    /**
     * Create an instance of {@link GetDataUsingDataContract }
     * 
     */
    public GetDataUsingDataContract createGetDataUsingDataContract() {
        return new GetDataUsingDataContract();
    }

    /**
     * Create an instance of {@link GetData }
     * 
     */
    public GetData createGetData() {
        return new GetData();
    }

    /**
     * Create an instance of {@link LoginUsuario }
     * 
     */
    public LoginUsuario createLoginUsuario() {
        return new LoginUsuario();
    }

    /**
     * Create an instance of {@link GetDataResponse }
     * 
     */
    public GetDataResponse createGetDataResponse() {
        return new GetDataResponse();
    }

    /**
     * Create an instance of {@link GetSexo }
     * 
     */
    public GetSexo createGetSexo() {
        return new GetSexo();
    }

    /**
     * Create an instance of {@link CreaUser }
     * 
     */
    public CreaUser createCreaUser() {
        return new CreaUser();
    }

    /**
     * Create an instance of {@link LoginUsuarioResponse }
     * 
     */
    public LoginUsuarioResponse createLoginUsuarioResponse() {
        return new LoginUsuarioResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CompositeType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetDataUsingDataContractResult", scope = GetDataUsingDataContractResponse.class)
    public JAXBElement<CompositeType> createGetDataUsingDataContractResponseGetDataUsingDataContractResult(CompositeType value) {
        return new JAXBElement<CompositeType>(_GetDataUsingDataContractResponseGetDataUsingDataContractResult_QNAME, CompositeType.class, GetDataUsingDataContractResponse.class, value);
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
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "InsertPersResult", scope = InsertPersResponse.class)
    public JAXBElement<String> createInsertPersResponseInsertPersResult(String value) {
        return new JAXBElement<String>(_InsertPersResponseInsertPersResult_QNAME, String.class, InsertPersResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetDataResult", scope = GetDataResponse.class)
    public JAXBElement<String> createGetDataResponseGetDataResult(String value) {
        return new JAXBElement<String>(_GetDataResponseGetDataResult_QNAME, String.class, GetDataResponse.class, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link CompositeType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "composite", scope = GetDataUsingDataContract.class)
    public JAXBElement<CompositeType> createGetDataUsingDataContractComposite(CompositeType value) {
        return new JAXBElement<CompositeType>(_GetDataUsingDataContractComposite_QNAME, CompositeType.class, GetDataUsingDataContract.class, value);
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
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "pNombre", scope = LoginUsuario.class)
    public JAXBElement<String> createLoginUsuarioPNombre(String value) {
        return new JAXBElement<String>(_LoginUsuarioPNombre_QNAME, String.class, LoginUsuario.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "pPassword", scope = LoginUsuario.class)
    public JAXBElement<String> createLoginUsuarioPPassword(String value) {
        return new JAXBElement<String>(_LoginUsuarioPPassword_QNAME, String.class, LoginUsuario.class, value);
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
        return new JAXBElement<String>(_UpdateUserPassPUsuario_QNAME, String.class, UpdateUserPass.class, value);
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
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "UpdateUserPassResult", scope = UpdateUserPassResponse.class)
    public JAXBElement<String> createUpdateUserPassResponseUpdateUserPassResult(String value) {
        return new JAXBElement<String>(_UpdateUserPassResponseUpdateUserPassResult_QNAME, String.class, UpdateUserPassResponse.class, value);
    }

}
