/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Clases.Persona;
import Clases.Usuario;
import Negocio.Funciones;
import Servicios.WsOferta;
import Servicios.WsPersona;
import Servicios.WsTienda;
import Servicios.WsUsuario;
import Vista.modal.modal_usuarios;
import java.awt.event.ItemEvent;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

/**
 *
 * @author Sony
 */
public class adm_usuarios extends javax.swing.JFrame {

    /**
     * Creates new form adm_usuarios
     */
    private static adm_usuarios obj = null;
    private static Home first = null;

    public adm_usuarios() {
        initComponents();
        this.setLocationRelativeTo(null);
        lbl_rut.setVisible(false);
        txt_dv.setEditable(false);
        pnl_detalle.setVisible(false);

        cbo_genero_hide.setVisible(false);
        cbo_perfil_hide.setVisible(false);
        cbo_tienda.setVisible(false);
        cbo_tienda_hiden.setVisible(false);

        cargarTipoSexo();
        cargarTipoUsuario();
        cargarTiendas(0);
    }

    public static adm_usuarios getObj(Home f) {
        first = f;
        if (obj == null) {
            obj = new adm_usuarios();
        }
        return obj;
    }

    public void cargarTiendas(Integer tnd_id) {

        WsTienda ws = new WsTienda();
        String retorno = "";
        retorno = ws.WSfn_TraerTienda(tnd_id);

        if (!retorno.equals("<NewDataSet />")) {
            try {
                SAXBuilder builder = new SAXBuilder();

                InputStream stream = new ByteArrayInputStream(retorno.getBytes("UTF-8"));
                Document document = builder.build(stream);

                //Document document = (Document) builder.build(retorno);
                Element rootNode = document.getRootElement();
                java.util.List<Element> list = rootNode.getChildren("Table");

                cbo_tienda.addItem("Seleccione");
                cbo_tienda_hiden.addItem("-1" + ':' + "Seleccione");

                for (int i = 0; i < list.size(); i++) {

                    Element node = (Element) list.get(i);

                    String id = node.getChildText("TND_ID");
                    String descripcion = node.getChildText("TND_DESCRIPCION");

                    cbo_tienda.addItem(descripcion);
                    cbo_tienda_hiden.addItem(id + ':' + descripcion);

                }

            } catch (JDOMException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    public void cargarTipoSexo() {

        WsUsuario ws = new WsUsuario();
        String retorno = "";
        retorno = ws.WSfn_TraerTipoSexo();

        if (!retorno.equals("<NewDataSet />")) {
            try {
                SAXBuilder builder = new SAXBuilder();

                InputStream stream = new ByteArrayInputStream(retorno.getBytes("UTF-8"));
                Document document = builder.build(stream);

                //Document document = (Document) builder.build(retorno);
                Element rootNode = document.getRootElement();
                java.util.List<Element> list = rootNode.getChildren("Table");

                cbo_genero.addItem("Seleccione");
                cbo_genero_hide.addItem("-1" + ':' + "Seleccione");
                for (int i = 0; i < list.size(); i++) {

                    Element node = (Element) list.get(i);

                    String id = node.getChildText("T_SXO_ID");
                    String descripcion = node.getChildText("T_SXO_DESCRIPCION");

                    cbo_genero.addItem(descripcion);
                    cbo_genero_hide.addItem(id + ':' + descripcion);

                }

            } catch (JDOMException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    public void cargarTipoUsuario() {

        WsUsuario ws = new WsUsuario();
        String retorno = "";
        retorno = ws.WSfn_TraerTipoUsuario();

        if (!retorno.equals("<NewDataSet />")) {
            try {
                SAXBuilder builder = new SAXBuilder();

                InputStream stream = new ByteArrayInputStream(retorno.getBytes("UTF-8"));
                Document document = builder.build(stream);

                //Document document = (Document) builder.build(retorno);
                Element rootNode = document.getRootElement();
                java.util.List<Element> list = rootNode.getChildren("Table");

                cbo_perfil.addItem("Seleccione");
                cbo_perfil_hide.addItem("-1" + ':' + "Seleccione");

                for (int i = 0; i < list.size(); i++) {

                    Element node = (Element) list.get(i);

                    String id = node.getChildText("T_USU_ID");
                    String descripcion = node.getChildText("T_USU_DESCRIPCION");

                    cbo_perfil.addItem(descripcion);
                    cbo_perfil_hide.addItem(id + ':' + descripcion);

                }

            } catch (JDOMException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    public void cargarUsuario(Usuario usu) {
        pnl_detalle.setVisible(true);
        Integer id = usu.getId();

        Persona per = usu.getPersona();
        Funciones fn = new Funciones();

        lbl_codigo.setText(id.toString());
        txt_nombre.setText(usu.getNombre());
        txt_clave.setText(usu.getClave());
        txt_correo.setText(usu.getEmail());

        Integer idPersona = per.getId();

        lbl_codigo_per.setText(idPersona.toString());
        txt_rut.setText(per.getRut().toString());
        txt_nombres.setText(per.getNombres());
        txt_apellido_p.setText(per.getApellido_p());
        txt_apellido_m.setText(per.getApellido_m());

        if (fn.validarRut(per.getRut().toString())) {

            Integer dv = fn.retornaDV(per.getRut());
            txt_dv.setText(dv.toString());
        }

        Format formatter = new SimpleDateFormat("dd-MM-YYYY");
        String sFecha = formatter.format(per.getFecha_nacimiento());

        Integer tipoSexo = per.getT_sexo();

        int size = cbo_genero_hide.getItemCount();
        for (int i = 0; i < size; i++) {
            String item = cbo_genero_hide.getItemAt(i);
            String[] parts = item.split(":");
            int idS = Integer.parseInt(parts[0]);
            if (idS == tipoSexo) {
                cbo_genero_hide.setSelectedIndex(i);
                cbo_genero.setSelectedIndex(i);
                i = size;
            }
        }

        Integer tipoUsu = usu.getTipo_usuario();
        int sizes = cbo_perfil_hide.getItemCount();
        for (int i = 0; i < sizes; i++) {
            String item = cbo_perfil_hide.getItemAt(i);
            String[] parts = item.split(":");
            int idS = Integer.parseInt(parts[0]);
            if (idS == tipoUsu) {
                cbo_perfil_hide.setSelectedIndex(i);
                cbo_perfil.setSelectedIndex(i);
                i = sizes;
            }
        }

        txt_nacimiento.setText(sFecha);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_busqueda = new javax.swing.JPanel();
        btn_nuevo = new javax.swing.JButton();
        btn_buscar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        pnl_detalle = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btn_guardar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        cbo_genero = new javax.swing.JComboBox<>();
        lbl_codigo = new javax.swing.JLabel();
        txt_correo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_nombres = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txt_apellido_p = new javax.swing.JTextField();
        txt_apellido_m = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lbl_codigo_per = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        cbo_perfil = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        lbl_rut = new javax.swing.JLabel();
        txt_clave = new javax.swing.JPasswordField();
        txt_rut = new javax.swing.JTextField();
        txt_dv = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_nacimiento = new javax.swing.JFormattedTextField();
        cbo_tienda = new javax.swing.JComboBox<>();
        cbo_perfil_hide = new javax.swing.JComboBox<>();
        cbo_tienda_hiden = new javax.swing.JComboBox<>();
        cbo_genero_hide = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        btn_nuevo.setText("Nuevo");
        btn_nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nuevoActionPerformed(evt);
            }
        });

        btn_buscar.setText("Buscar");
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Administracion de Usuarios");

        javax.swing.GroupLayout pnl_busquedaLayout = new javax.swing.GroupLayout(pnl_busqueda);
        pnl_busqueda.setLayout(pnl_busquedaLayout);
        pnl_busquedaLayout.setHorizontalGroup(
            pnl_busquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_busquedaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_buscar)
                .addGap(27, 27, 27)
                .addComponent(btn_nuevo)
                .addGap(131, 131, 131))
            .addGroup(pnl_busquedaLayout.createSequentialGroup()
                .addGap(172, 172, 172)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl_busquedaLayout.setVerticalGroup(
            pnl_busquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_busquedaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(pnl_busquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_buscar)
                    .addComponent(btn_nuevo))
                .addGap(21, 21, 21))
        );

        jLabel1.setText("Codigo");

        btn_guardar.setText("Guardar");
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });

        btn_eliminar.setText("Eliminar");
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });

        jLabel3.setText("Nombre");

        jLabel4.setText("Contraseña");

        jLabel5.setText("Perfil");

        cbo_genero.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbo_generoItemStateChanged(evt);
            }
        });

        lbl_codigo.setText("...");

        jLabel6.setText("Correo");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Datos Personales");

        jLabel8.setText("Nombres");

        jLabel9.setText("Apellido Paterno");

        jLabel11.setText("Rut");

        jLabel12.setText("Codigo");

        lbl_codigo_per.setText("...");

        jLabel13.setText("Fecha nacimiento");

        jLabel14.setText("Apellido Materno");

        cbo_perfil.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbo_perfilItemStateChanged(evt);
            }
        });

        jLabel15.setText("Genero");

        lbl_rut.setForeground(new java.awt.Color(255, 0, 0));
        lbl_rut.setText("Rut no valido");
        lbl_rut.setToolTipText("");

        txt_rut.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_rutFocusLost(evt);
            }
        });

        jLabel10.setText("-");

        txt_nacimiento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd-MM-yyyy"))));
        txt_nacimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nacimientoActionPerformed(evt);
            }
        });

        cbo_tienda.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbo_tiendaItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout pnl_detalleLayout = new javax.swing.GroupLayout(pnl_detalle);
        pnl_detalle.setLayout(pnl_detalleLayout);
        pnl_detalleLayout.setHorizontalGroup(
            pnl_detalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_detalleLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(btn_eliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_guardar)
                .addGap(45, 45, 45))
            .addGroup(pnl_detalleLayout.createSequentialGroup()
                .addGroup(pnl_detalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_detalleLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(pnl_detalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13))
                        .addGroup(pnl_detalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnl_detalleLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(pnl_detalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnl_detalleLayout.createSequentialGroup()
                                        .addGroup(pnl_detalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txt_correo)
                                            .addComponent(txt_nombre, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE))
                                        .addGap(60, 60, 60)
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(txt_clave, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lbl_codigo, javax.swing.GroupLayout.Alignment.LEADING)))
                            .addGroup(pnl_detalleLayout.createSequentialGroup()
                                .addGroup(pnl_detalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_codigo_per)
                                    .addGroup(pnl_detalleLayout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addGroup(pnl_detalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txt_nombres)
                                            .addComponent(txt_apellido_p, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txt_nacimiento))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                                .addGroup(pnl_detalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(pnl_detalleLayout.createSequentialGroup()
                                        .addGroup(pnl_detalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel14)
                                            .addComponent(jLabel15))
                                        .addGap(18, 18, 18)
                                        .addGroup(pnl_detalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txt_apellido_m, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cbo_genero, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(pnl_detalleLayout.createSequentialGroup()
                                                .addComponent(txt_rut, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txt_dv, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(10, 10, 10)
                                                .addComponent(lbl_rut))))
                                    .addGroup(pnl_detalleLayout.createSequentialGroup()
                                        .addGroup(pnl_detalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel11)
                                            .addGroup(pnl_detalleLayout.createSequentialGroup()
                                                .addGap(35, 35, 35)
                                                .addComponent(jLabel5)))
                                        .addGap(50, 50, 50)
                                        .addGroup(pnl_detalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cbo_tienda, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cbo_perfil, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                    .addGroup(pnl_detalleLayout.createSequentialGroup()
                        .addGap(283, 283, 283)
                        .addComponent(jLabel7)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl_detalleLayout.setVerticalGroup(
            pnl_detalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_detalleLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_detalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lbl_codigo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnl_detalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txt_clave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnl_detalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_correo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(cbo_perfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbo_tienda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(13, 13, 13)
                .addGroup(pnl_detalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel11)
                    .addComponent(lbl_codigo_per)
                    .addComponent(lbl_rut)
                    .addComponent(txt_rut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_dv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnl_detalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txt_nombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnl_detalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txt_apellido_p, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(txt_apellido_m, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnl_detalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel15)
                    .addComponent(cbo_genero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_nacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(96, 96, 96)
                .addGroup(pnl_detalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_eliminar)
                    .addComponent(btn_guardar))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnl_busqueda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnl_detalle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cbo_genero_hide, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbo_perfil_hide, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbo_tienda_hiden, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnl_busqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbo_perfil_hide, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbo_tienda_hiden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbo_genero_hide, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addComponent(pnl_detalle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nuevoActionPerformed
        limpiar_form();
        pnl_detalle.setVisible(true);
    }//GEN-LAST:event_btn_nuevoActionPerformed

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
        limpiar_form();

        modal_usuarios.getObj(this).setVisible(true);
    }//GEN-LAST:event_btn_buscarActionPerformed

    public void cargarPerfiles(Integer tnd_id) {

        WsOferta ws = new WsOferta();
        String retorno = "";
        retorno = ws.WSfn_TraerTipoOferta(tnd_id);

        if (!retorno.equals("<NewDataSet />")) {
            try {
                SAXBuilder builder = new SAXBuilder();

                InputStream stream = new ByteArrayInputStream(retorno.getBytes("UTF-8"));
                Document document = builder.build(stream);

                //Document document = (Document) builder.build(retorno);
                Element rootNode = document.getRootElement();
                java.util.List<Element> list = rootNode.getChildren("Table");

                cbo_perfil.addItem("Seleccione");
                cbo_perfil_hide.addItem("-1" + ':' + "Seleccione");
                for (int i = 0; i < list.size(); i++) {

                    Element node = (Element) list.get(i);

                    String id = node.getChildText("T_OFT_ID");
                    String descripcion = node.getChildText("T_OFT_DESCRIPCION");
                    String compra_min = node.getChildText("T_OFT_COMPRA_MIN");
                    String compra_max = node.getChildText("T_OFT_COMPRA_MAX");

                    //AutoCompleteDecorator.decorate(cmb_tipo_oferta);
                    cbo_perfil.addItem(descripcion);
                    cbo_perfil_hide.addItem(id + ':' + descripcion + ':' + compra_min + ':' + compra_max);

                }

            } catch (JDOMException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    public void limpiar_form() {
        lbl_codigo.setText("...");
        lbl_codigo_per.setText("...");

        txt_nombre.setText("");
        txt_clave.setText("");
        txt_correo.setText("");
        txt_rut.setText("");
        txt_dv.setText("");
        txt_nombres.setText("");
        txt_apellido_p.setText("");
        txt_apellido_m.setText("");
        txt_nacimiento.setText("");
        cbo_tienda.setVisible(false);
        cbo_tienda.setSelectedIndex(0);
        cbo_tienda_hiden.setSelectedIndex(0);
        cbo_genero.setSelectedIndex(0);
        cbo_genero_hide.setSelectedIndex(0);
        cbo_perfil.setSelectedIndex(0);
        cbo_perfil_hide.setSelectedIndex(0);

    }
    private void cbo_perfilItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbo_perfilItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {

            Integer index = cbo_perfil.getSelectedIndex();
            if (cbo_perfil_hide.getSelectedIndex() > -1) {
                cbo_perfil_hide.setSelectedIndex(index);

                String item = cbo_perfil_hide.getSelectedItem().toString();
                String[] parts = item.split(":");
                int idS = Integer.parseInt(parts[0]);
                if (idS == 1) {
                    cbo_tienda.setVisible(true);
                } else {
                    cbo_tienda.setVisible(false);
                }

            }

        }
    }//GEN-LAST:event_cbo_perfilItemStateChanged

    private void cbo_generoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbo_generoItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {

            Integer index = cbo_genero.getSelectedIndex();
            if (cbo_genero_hide.getSelectedIndex() > -1) {
                cbo_genero_hide.setSelectedIndex(index);
            }

            //JOptionPane.showMessageDialog(null, (String) evt.getItem());
        }
    }//GEN-LAST:event_cbo_generoItemStateChanged

    private void txt_rutFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_rutFocusLost
        Funciones fn = new Funciones();

        String rut = txt_rut.getText().toString().trim();
        if (rut.length() >= 1) {
            try {
                Integer.parseInt(rut);

                if (!fn.validarRut(rut)) {
                    lbl_rut.setVisible(true);
                    txt_dv.setText("");
                } else {
                    lbl_rut.setVisible(false);
                    Integer dv = fn.retornaDV(Integer.parseInt(rut));
                    txt_dv.setText(dv.toString());
                }

            } catch (NumberFormatException e) {
                lbl_rut.setVisible(true);
                txt_dv.setText("");
            }

        }
    }//GEN-LAST:event_txt_rutFocusLost

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        obj = null;
    }//GEN-LAST:event_formWindowClosing

    private void txt_nacimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nacimientoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nacimientoActionPerformed

    public boolean validarUsuario() {

        Funciones fn = new Funciones();
        String mensaje = "";
        boolean valida = true;

        if (txt_nombre.getText().toString().trim().equals("")) {
            mensaje = "Ingrese nombre de usuario";
            valida = false;
        }
        if (valida == true & String.valueOf(txt_clave.getPassword()).toString().trim().equals("")) {
            mensaje = "Ingrese una Contraseña";
            valida = false;
        }
        if (valida == true & txt_correo.getText().toString().trim().equals("")) {
            mensaje = "ingrese un correo";
            valida = false;
        } else if (valida == true) {
            if (!fn.isValidEmailAddress(txt_correo.getText())) {
                mensaje = "ingrese un correo valido";
                valida = false;
            }
        }
        if (valida == true & cbo_perfil.getSelectedIndex() == -1) {
            mensaje = "Seleccione un perfil";
            valida = false;
        } else if (valida == true & cbo_perfil_hide.getSelectedIndex() != -1) {

            String item = cbo_perfil_hide.getSelectedItem().toString();
            String[] parts = item.split(":");
            if (parts[0].toString().equals("-1")) {
                mensaje = "Seleccione un perfil";
                valida = false;
            }

        }

        if (valida == true & txt_rut.getText().toString().trim().equals("")) {
            mensaje = "ingrese un Rut";
            valida = false;
        } else if (valida == true) {
            try {
                String rut = txt_rut.getText().toString().trim();
                Integer.parseInt(rut.replace(".", ""));
                if (!fn.validarRut(rut)) {
                    mensaje = "Rut no valido";
                    valida = false;
                }
            } catch (Exception ex) {
                mensaje = "Rut no valido";
                valida = false;
            }
        }
        if (valida == true & txt_nombres.getText().toString().trim().equals("")) {
            mensaje = "ingrese nombres";
            valida = false;
        }
        if (valida == true & txt_apellido_p.getText().toString().trim().equals("")) {
            mensaje = "ingrese apellido paterno";
            valida = false;
        }
        if (valida == true & txt_apellido_m.getText().toString().trim().equals("")) {
            mensaje = "ingrese apellido materno";
            valida = false;
        }
        if (valida == true & txt_nacimiento.getText().toString().trim().equals("")) {
            mensaje = "ingrese fecha de nacimiento";
            valida = false;
        }
        if (valida == true & cbo_genero.getSelectedIndex() == -1) {
            mensaje = "Seleccione Genero";
            valida = false;
        } else if (valida == true & cbo_genero_hide.getSelectedIndex() != -1) {

            String item = cbo_genero_hide.getSelectedItem().toString();
            String[] parts = item.split(":");
            if (parts[0].toString().equals("-1")) {
                mensaje = "Seleccione Genero";
                valida = false;
            }

        }

        if (valida == true & lbl_codigo_per.getText().equals("...")) {
            String[] partU = cbo_perfil_hide.getSelectedItem().toString().split(":");
            Integer t_usu_id = Integer.parseInt(partU[0]);
            if (t_usu_id == 4) {
                mensaje = "No puede registrar a un consumidor, solo puede modificar o eliminar";
                valida = false;
            }
        }

        if (valida == true & cbo_tienda.isVisible()) {
            String[] partU = cbo_tienda_hiden.getSelectedItem().toString().split(":");
            if (partU[0].equals("-1")) {
                mensaje = "Seleccione una tienda";
                valida = false;

            }
        }

        if (valida == false) {
            JOptionPane.showMessageDialog(this, mensaje);
        }

        return valida;
    }

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        WsUsuario ws = new WsUsuario();
        WsPersona wsP = new WsPersona();

        if (validarUsuario()) {
            String rut = txt_rut.getText().toString().trim();
            String nombres = txt_nombres.getText().toString().trim();
            String ape_p = txt_apellido_p.getText().toString().trim();
            String ape_m = txt_apellido_m.getText().toString().trim();
            String fecha = txt_nacimiento.getText().toString().trim();

            String[] parts = cbo_genero_hide.getSelectedItem().toString().split(":");
            Integer sxo_id = Integer.parseInt(parts[0]);

            String[] partU = cbo_perfil_hide.getSelectedItem().toString().split(":");
            Integer t_usu_id = Integer.parseInt(partU[0]);

            String usuario = txt_nombre.getText().toString().trim();
            String clave = String.valueOf(txt_clave.getPassword());
            String email = txt_correo.getText().toString().trim();
            Integer Tusuario = t_usu_id;

            String tipo = "";
            if (lbl_codigo_per.getText().equals("...")) {

                tipo = "do";
                String respuesta = wsP.WSfn_GuardarPersona(tipo, Integer.parseInt(rut), nombres, ape_p, ape_m, fecha, sxo_id, 0);
                if (MensajeGuardar(respuesta)) {
                    int prsId = Integer.parseInt(respuesta);

                    String resp = ws.WSfn_GuardarUsuario(tipo, usuario, clave, email, Tusuario, prsId, 0);

                }

            } else {
                tipo = "set";
                Integer prsId = Integer.parseInt(lbl_codigo_per.getText());
                String respuesta = wsP.WSfn_GuardarPersona(tipo, Integer.parseInt(rut), nombres, ape_p, ape_m, fecha, sxo_id, prsId);

                Integer usu_id = Integer.parseInt(lbl_codigo.getText());

                String resp = ws.WSfn_GuardarUsuario(tipo, usuario, clave, email, Tusuario, prsId, usu_id);
                MensajeActualiza(respuesta);

            }
        }

    }//GEN-LAST:event_btn_guardarActionPerformed

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
        if (!lbl_codigo.getText().equals("...")) {

            Integer respuesta = JOptionPane.showConfirmDialog(this, "¿Esta Seguro que desea Eliminar?", "Usuario", JOptionPane.YES_NO_OPTION);
            if (respuesta == JOptionPane.YES_OPTION) {
                WsPersona wsp = new WsPersona();
                WsUsuario ws = new WsUsuario();

                String retorno = "";
                String rettorno = "";
                int id_usu = Integer.parseInt(lbl_codigo.getText().toString());

                int id_prs = Integer.parseInt(lbl_codigo_per.getText().toString());

                retorno = ws.WSfn_EliminarUsuario(id_usu);
                rettorno = wsp.WSfn_EliminarPersona(id_prs);
                JOptionPane.showMessageDialog(this, retorno);
                limpiar_form();
            }

        }
    }//GEN-LAST:event_btn_eliminarActionPerformed

    private void cbo_tiendaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbo_tiendaItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {

            Integer index = cbo_tienda.getSelectedIndex();
            if (cbo_tienda_hiden.getSelectedIndex() > -1) {
                cbo_tienda_hiden.setSelectedIndex(index);
            }

            //JOptionPane.showMessageDialog(null, (String) evt.getItem());
        }
    }//GEN-LAST:event_cbo_tiendaItemStateChanged

    public boolean MensajeGuardar(String respuesta) {

        String mensaje = "";
        boolean retorno = false;
        if (!respuesta.equals("")) {
            try {
                Integer.parseInt(respuesta);
                mensaje = "Usuario registrado Correctamente";
                retorno = true;
                limpiar_form();
            } catch (Exception ex) {
                mensaje = respuesta;
            }

        } else {
            mensaje = "Error de comunicacion, no se pudo guardar";

        }
        JOptionPane.showMessageDialog(this, mensaje);
        return retorno;
    }

    public void MensajeActualiza(String respuesta) {

        String mensaje = "";
        if (!respuesta.equals("")) {

            mensaje = respuesta;
            //limpiar_form();

        } else {
            mensaje = "Error de comunicacion, no se pudo actualizar";

        }
        JOptionPane.showMessageDialog(this, mensaje);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(adm_usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(adm_usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(adm_usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(adm_usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new adm_usuarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_nuevo;
    private javax.swing.JComboBox<String> cbo_genero;
    private javax.swing.JComboBox<String> cbo_genero_hide;
    private javax.swing.JComboBox<String> cbo_perfil;
    private javax.swing.JComboBox<String> cbo_perfil_hide;
    private javax.swing.JComboBox<String> cbo_tienda;
    private javax.swing.JComboBox<String> cbo_tienda_hiden;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lbl_codigo;
    private javax.swing.JLabel lbl_codigo_per;
    private javax.swing.JLabel lbl_rut;
    private javax.swing.JPanel pnl_busqueda;
    private javax.swing.JPanel pnl_detalle;
    private javax.swing.JTextField txt_apellido_m;
    private javax.swing.JTextField txt_apellido_p;
    private javax.swing.JPasswordField txt_clave;
    private javax.swing.JTextField txt_correo;
    private javax.swing.JTextField txt_dv;
    private javax.swing.JFormattedTextField txt_nacimiento;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_nombres;
    private javax.swing.JTextField txt_rut;
    // End of variables declaration//GEN-END:variables
}
