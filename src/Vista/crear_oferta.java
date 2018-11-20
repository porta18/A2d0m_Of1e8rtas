/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Clases.GoogleMail;
import Vista.modal.modal_productos;
import Vista.modal.modal_ofertas;
import Clases.Oferta;
import Clases.Producto;
import Clases.Usuario;
import Clases.UsuarioSesion;
import Servicios.WsOferta;
import Servicios.WsTienda;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

//import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

/**
 *
 * @author Sony
 */
public class crear_oferta extends javax.swing.JFrame {

    public String encabezadoTablaP[] = {"ID", "Cod Barra", "Descripcion", "Precio venta", "Precio Oferta", "id"};
    public DefaultTableModel tableModelP = new DefaultTableModel(encabezadoTablaP, 0);

    private static crear_oferta obj = null;
    private static Home first = null;

    private int tienda_id;

    public crear_oferta() {
        initComponents();

        tbl_productos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.setLocationRelativeTo(null);
        pnl_detalle.setVisible(false);

        Usuario usu = UsuarioSesion.UsuSesion;
        this.tienda_id = usu.getTienda_id();

        cargarTipoOferta(0);
        cargarTiendas(this.tienda_id);

        cmb_tienda_hide.setVisible(false);
        cmb_tipo_oferta_hide.setVisible(false);
        tableModelP.setRowCount(0);

    }

    public void cargarTipoOferta(Integer tnd_id) {

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

                for (int i = 0; i < list.size(); i++) {

                    Element node = (Element) list.get(i);

                    String id = node.getChildText("T_OFT_ID");
                    String descripcion = node.getChildText("T_OFT_DESCRIPCION");
                    String compra_min = node.getChildText("T_OFT_COMPRA_MIN");
                    String compra_max = node.getChildText("T_OFT_COMPRA_MAX");

                    //AutoCompleteDecorator.decorate(cmb_tipo_oferta);
                    cmb_tipo_oferta.addItem(descripcion);
                    cmb_tipo_oferta_hide.addItem(id + ':' + descripcion + ':' + compra_min + ':' + compra_max);

                }

            } catch (JDOMException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

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

                for (int i = 0; i < list.size(); i++) {

                    Element node = (Element) list.get(i);

                    String id = node.getChildText("TND_ID");
                    String descripcion = node.getChildText("TND_DESCRIPCION");

                    cmb_tienda.addItem(descripcion);
                    cmb_tienda_hide.addItem(id + ':' + descripcion);

                }

            } catch (JDOMException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    public void cargar_tabla(Integer oft_id) {

        WsOferta ws = new WsOferta();
        String retorno = "";
        retorno = ws.WSfn_TraerDetalleOfertas(oft_id);

        if (!retorno.equals("<NewDataSet />")) {
            try {
                SAXBuilder builder = new SAXBuilder();

                InputStream stream = new ByteArrayInputStream(retorno.getBytes("UTF-8"));
                Document document = builder.build(stream);

                //Document document = (Document) builder.build(retorno);
                Element rootNode = document.getRootElement();
                java.util.List<Element> list = rootNode.getChildren("Table");

                String encabezadoTabla[] = {"ID", "Cod Barra", "Descripcion", "Precio venta", "Precio Oferta", "Detalle ID"};
                tableModelP = new DefaultTableModel(encabezadoTabla, 0);
                tableModelP.setRowCount(0);

                for (int i = 0; i < list.size(); i++) {

                    Element node = (Element) list.get(i);

                    String prd_id = node.getChildText("PRODUCTO_PRD_ID");
                    String cod_barra = node.getChildText("CODIGO_BARRA");
                    String descripcion = node.getChildText("PRD_DESCRIPCION");
                    String pVenta = node.getChildText("PRD_PRECIO_VENTA");
                    String pOferta = node.getChildText("DTO_PRECIO_OFERTA");
                    String detalleId = node.getChildText("DTO_ID");

                    Object[] objs = {prd_id, cod_barra, descripcion, pVenta, pOferta, detalleId};
                    tableModelP.addRow(objs);
                }
                tbl_productos.setModel(tableModelP);
                /*bloqueo la tabla para no ser editada*/
                tbl_productos.setDefaultEditor(Object.class, null);

                tbl_productos.removeColumn(tbl_productos.getColumnModel().getColumn(5));

            } catch (JDOMException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            /*
            lbl_mensaje.setText("No se encontraron ofertas creadas para esta tienda");
            pnl_info.setVisible(true);
             */
        }

    }

    public static crear_oferta getObj(Home f) {
        first = f;
        if (obj == null) {
            obj = new crear_oferta();
        }
        return obj;
    }

    public void cargar_oferta(Oferta oft) {
        pnl_detalle.setVisible(true);
        if (oft.getPublica() == 1) {
            chk_publicar.setSelected(true);
        }

        Format formatter = new SimpleDateFormat("dd-MM-YYYY");
        String sFechaIni = formatter.format(oft.getFechaInicio());
        String sFechaFin = formatter.format(oft.getFechaTermino());
        Integer idOferta = oft.getId();

        Integer tipoOferta = oft.getTipoOferta();

        int size = cmb_tipo_oferta_hide.getItemCount();
        for (int i = 0; i < size; i++) {
            String item = cmb_tipo_oferta_hide.getItemAt(i);
            String[] parts = item.split(":");
            int id = Integer.parseInt(parts[0]);
            if (id == tipoOferta) {
                cmb_tipo_oferta_hide.setSelectedIndex(i);
                cmb_tipo_oferta.setSelectedIndex(i);
                i = size;
            }
        }

        txt_desde.setText(sFechaIni);
        txt_hasta.setText(sFechaFin);
        cargar_tabla(idOferta);
        lbl_oferta.setText(idOferta.toString());

    }

    public void agregar_producto(Producto pro) {

        Integer id = pro.getId();
        Integer pVenta = pro.getPrecioVenta();
        String cod_barra = pro.getCodBarra();
        String descripcion = pro.getDescripcion();
        Integer pOferta = 0;
        String tipo_oferta = cmb_tipo_oferta.getSelectedItem().toString();

        if (tipo_oferta.contains("%")) {
            String[] parts = tipo_oferta.split("%");
            int porcentaje = Integer.parseInt(parts[0]);
            pOferta = (pVenta - (pVenta * porcentaje / 100));
        } else {
            if (tipo_oferta.contains("x")) {
                String[] parts = tipo_oferta.split("x");
                int divisor = Integer.parseInt(parts[0]);
                pOferta = (pVenta / divisor);
            }
        }

        Object[] objs = {id, cod_barra, descripcion, pVenta, pOferta, -1};
        tableModelP.addRow(objs);

        tbl_productos.setModel(tableModelP);
        /*bloqueo la tabla para no ser editada*/
        tbl_productos.setDefaultEditor(Object.class, null);

        try {
            tbl_productos.removeColumn(tbl_productos.getColumnModel().getColumn(5));
        } catch (Exception ex) {

        }

    }

    public void limpiar_form() {
        chk_publicar.setSelected(false);
        txt_desde.setText("");
        txt_hasta.setText("");

        String encabezadoTabla[] = {"ID", "Cod Barra", "Descripcion", "Precio venta", "Precio Oferta"};
        DefaultTableModel tableModel = new DefaultTableModel(encabezadoTabla, 0);
        tableModel.setRowCount(0);
        tbl_productos.setModel(tableModel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        jInternalFrame2 = new javax.swing.JInternalFrame();
        jDialog1 = new javax.swing.JDialog();
        jDialog2 = new javax.swing.JDialog();
        jDialog3 = new javax.swing.JDialog();
        jDialog4 = new javax.swing.JDialog();
        jFrame1 = new javax.swing.JFrame();
        pnl_detalle = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_productos = new javax.swing.JTable();
        cmb_tipo_oferta = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        btn_guardar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btn_buscar_producto = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        chk_publicar = new javax.swing.JCheckBox();
        txt_hasta = new javax.swing.JFormattedTextField();
        txt_desde = new javax.swing.JFormattedTextField();
        cmb_tipo_oferta_hide = new javax.swing.JComboBox<>();
        Codigo = new javax.swing.JLabel();
        lbl_oferta = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btn_buscar = new javax.swing.JButton();
        btn_nuevo = new javax.swing.JButton();
        cmb_tienda = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        cmb_tienda_hide = new javax.swing.JComboBox<>();

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jInternalFrame2.setVisible(true);

        javax.swing.GroupLayout jInternalFrame2Layout = new javax.swing.GroupLayout(jInternalFrame2.getContentPane());
        jInternalFrame2.getContentPane().setLayout(jInternalFrame2Layout);
        jInternalFrame2Layout.setHorizontalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame2Layout.setVerticalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog2Layout = new javax.swing.GroupLayout(jDialog2.getContentPane());
        jDialog2.getContentPane().setLayout(jDialog2Layout);
        jDialog2Layout.setHorizontalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog2Layout.setVerticalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog3Layout = new javax.swing.GroupLayout(jDialog3.getContentPane());
        jDialog3.getContentPane().setLayout(jDialog3Layout);
        jDialog3Layout.setHorizontalGroup(
            jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog3Layout.setVerticalGroup(
            jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog4Layout = new javax.swing.GroupLayout(jDialog4.getContentPane());
        jDialog4.getContentPane().setLayout(jDialog4Layout);
        jDialog4Layout.setHorizontalGroup(
            jDialog4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog4Layout.setVerticalGroup(
            jDialog4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        tbl_productos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_productos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbl_productosKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_productos);

        cmb_tipo_oferta.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmb_tipo_ofertaItemStateChanged(evt);
            }
        });
        cmb_tipo_oferta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_tipo_ofertaActionPerformed(evt);
            }
        });

        jLabel1.setText("Tipo Oferta");

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

        jLabel2.setText("Agregar producto");

        btn_buscar_producto.setText("Buscar");
        btn_buscar_producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscar_productoActionPerformed(evt);
            }
        });

        jLabel4.setText("Desde");

        jLabel5.setText("Hasta");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Fecha Campaña");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Lista productos ");

        chk_publicar.setText("Publicar");
        chk_publicar.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        txt_hasta.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd-MM-yyyy"))));
        txt_hasta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_hastaActionPerformed(evt);
            }
        });

        txt_desde.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd-MM-yyyy"))));
        txt_desde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_desdeActionPerformed(evt);
            }
        });

        Codigo.setText("Codigo");

        lbl_oferta.setText("...");

        jLabel9.setText("Para Eliminar un producto presione la tecla supr");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Nota:");

        jLabel11.setText("Cada vez que se guarde una oferta publica con fecha de campaña");

        jLabel12.setText(" vigente se notificara a los consumidores via email");

        javax.swing.GroupLayout pnl_detalleLayout = new javax.swing.GroupLayout(pnl_detalle);
        pnl_detalle.setLayout(pnl_detalleLayout);
        pnl_detalleLayout.setHorizontalGroup(
            pnl_detalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_detalleLayout.createSequentialGroup()
                .addGroup(pnl_detalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_detalleLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(pnl_detalleLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(pnl_detalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(Codigo)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(pnl_detalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_oferta)
                            .addGroup(pnl_detalleLayout.createSequentialGroup()
                                .addGroup(pnl_detalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(cmb_tipo_oferta_hide, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cmb_tipo_oferta, javax.swing.GroupLayout.Alignment.LEADING, 0, 180, Short.MAX_VALUE))
                                .addGap(75, 75, 75)
                                .addGroup(pnl_detalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(chk_publicar)
                                    .addGroup(pnl_detalleLayout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(pnl_detalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel12)
                                            .addComponent(jLabel11))))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(pnl_detalleLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(btn_eliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_guardar)
                .addGap(51, 51, 51))
            .addGroup(pnl_detalleLayout.createSequentialGroup()
                .addGroup(pnl_detalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_detalleLayout.createSequentialGroup()
                        .addGap(186, 186, 186)
                        .addComponent(jLabel6))
                    .addGroup(pnl_detalleLayout.createSequentialGroup()
                        .addGap(274, 274, 274)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_hasta, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnl_detalleLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_detalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_desde, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(106, 106, 106)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(btn_buscar_producto)
                .addGap(19, 19, 19))
        );
        pnl_detalleLayout.setVerticalGroup(
            pnl_detalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_detalleLayout.createSequentialGroup()
                .addGroup(pnl_detalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_detalleLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Codigo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_detalleLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbl_oferta)
                        .addGap(18, 18, 18)))
                .addGroup(pnl_detalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chk_publicar)
                    .addGroup(pnl_detalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmb_tipo_oferta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_detalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addGroup(pnl_detalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmb_tipo_oferta_hide, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11)))
                .addGap(3, 3, 3)
                .addComponent(jLabel12)
                .addGap(1, 1, 1)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnl_detalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(txt_hasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_desde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(pnl_detalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_detalleLayout.createSequentialGroup()
                        .addGroup(pnl_detalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel2)
                            .addComponent(btn_buscar_producto))
                        .addGap(13, 13, 13))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_detalleLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnl_detalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_guardar)
                    .addComponent(btn_eliminar))
                .addContainerGap())
        );

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Administrar Ofertas");

        btn_buscar.setLabel("Buscar");
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });

        btn_nuevo.setText("Nuevo");
        btn_nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nuevoActionPerformed(evt);
            }
        });

        cmb_tienda.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmb_tiendaItemStateChanged(evt);
            }
        });

        jLabel8.setText("Tienda");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(189, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(198, 198, 198))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(56, 56, 56)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmb_tienda_hide, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmb_tienda, 0, 141, Short.MAX_VALUE))
                        .addGap(77, 77, 77)
                        .addComponent(btn_buscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_nuevo)
                        .addGap(85, 85, 85))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmb_tienda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(btn_buscar)
                    .addComponent(btn_nuevo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmb_tienda_hide, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnl_detalle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnl_detalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
        pnl_detalle.setVisible(false);
        limpiar_form();
        modal_ofertas.getObj(this).setVisible(true);
    }//GEN-LAST:event_btn_buscarActionPerformed

    private void btn_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nuevoActionPerformed
        pnl_detalle.setVisible(true);
        limpiar_form();

    }//GEN-LAST:event_btn_nuevoActionPerformed

    private void txt_hastaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_hastaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_hastaActionPerformed

    private void txt_desdeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_desdeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_desdeActionPerformed

    private void btn_buscar_productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscar_productoActionPerformed
        if (cmb_tipo_oferta.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un tipo de oferta");
        } else {
            modal_productos.getObj(this).setVisible(true);
        }

    }//GEN-LAST:event_btn_buscar_productoActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        limpiar_form();
        obj = null;
    }//GEN-LAST:event_formWindowClosing

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        WsOferta ws = new WsOferta();
        if (validarOferta()) {

            String tipo = "";
            String fechaI = txt_desde.getText().toString().trim();
            String fechaF = txt_hasta.getText().toString().trim();
            Integer isPublica = 0;
            Integer tipoOferta = 0;
            Integer tienda = 0;
            Integer ofertaId = 0;

            String[] parts = cmb_tipo_oferta_hide.getSelectedItem().toString().split(":");
            tipoOferta = Integer.parseInt(parts[0]);

            String[] partsTienda = cmb_tienda_hide.getSelectedItem().toString().split(":");
            tienda = Integer.parseInt(partsTienda[0]);

            if (chk_publicar.isSelected()) {
                isPublica = 1;
            }

            if (lbl_oferta.getText().equals("...")) {
                tipo = "do";
                String respuesta = ws.WSfn_GuardaEncabezadoOferta(tipo, fechaI, fechaF, isPublica, tipoOferta, tienda, 0);
                if (MensajeGuardar(respuesta)) {
                    int IdOferta = Integer.parseInt(respuesta);
                    ActualizarDetalle(IdOferta);
                }

            } else {
                tipo = "set";
                ofertaId = Integer.parseInt(lbl_oferta.getText());
                String respuesta = ws.WSfn_GuardaEncabezadoOferta(tipo, fechaI, fechaF, isPublica, tipoOferta, tienda, ofertaId);
                ActualizarDetalle(ofertaId);
                MensajeActualiza(respuesta);
            }
            GoogleMail email = new GoogleMail();
            
            try{
                email.Html();
                email.Send("misofertas18", "misofertas123", "joseeqb2@gmail.com","", "ofertas retail", "String mensaje");
            }catch(Exception ex){
                 JOptionPane.showMessageDialog(this, "Error al enviar correo: " + ex);
            }
            

        }

    }//GEN-LAST:event_btn_guardarActionPerformed

    public void ActualizaPrecio() {
        WsOferta ws = new WsOferta();
        for (int row = 0; row < tableModelP.getRowCount(); row++) {

            Integer pOferta = 0;
            Integer precio = Integer.parseInt(tableModelP.getValueAt(row, 3).toString());
            String tipo_oferta = cmb_tipo_oferta.getSelectedItem().toString();

            if (tipo_oferta.contains("%")) {
                String[] parts = tipo_oferta.split("%");
                int porcentaje = Integer.parseInt(parts[0]);
                pOferta = (precio - (precio * porcentaje / 100));
            } else {
                if (tipo_oferta.contains("x")) {
                    String[] parts = tipo_oferta.split("x");
                    int divisor = Integer.parseInt(parts[0]);
                    pOferta = (precio / divisor);
                }
            }

            tableModelP.setValueAt(pOferta, row, 4);
        }

    }

    public void ActualizarDetalle(Integer oft_id) {
        WsOferta ws = new WsOferta();
        for (int row = 0; row < tableModelP.getRowCount(); row++) {

            String tipo = "";

            Integer prd_id = Integer.parseInt(tableModelP.getValueAt(row, 0).toString());
            Integer precio = Integer.parseInt(tableModelP.getValueAt(row, 4).toString());

            Integer dto_id = Integer.parseInt(tableModelP.getValueAt(row, 5).toString());
            if (dto_id == -1) {
                tipo = "do";

            } else {
                tipo = "set";
            }
            String resDetalle = resDetalle = ws.WSfn_GuardarDetalle(tipo, oft_id, prd_id, precio, dto_id);
            //JOptionPane.showMessageDialog(this, resDetalle);
        }

    }

    public boolean MensajeGuardar(String respuesta) {

        String mensaje = "";
        boolean retorno = false;
        if (!respuesta.equals("")) {
            try {
                Integer.parseInt(respuesta);
                mensaje = "Oferta registrada Correctamente";
                retorno = true;
                limpiar_form();
            } catch (Exception ex) {
                mensaje = "Error WS: " + respuesta;
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
            limpiar_form();

        } else {
            mensaje = "Error de comunicacion, no se pudo actualizar";

        }
        JOptionPane.showMessageDialog(this, mensaje);
    }

    public boolean validarOferta() {

        String mensaje = "";
        boolean valida = true;

        if (cmb_tienda.getSelectedIndex() == -1) {
            mensaje = "Seleccione una tienda";
            valida = false;
        }
        if (valida == true & cmb_tipo_oferta.getSelectedIndex() == -1) {
            mensaje = "Seleccione un tipo de oferta";
            valida = false;
        }
        if (valida == true & txt_desde.getText().toString().trim().equals("")) {
            mensaje = "ingrese fecha de inicio para campaña";
            valida = false;
        }
        if (valida == true & txt_hasta.getText().toString().trim().equals("")) {
            mensaje = "ingrese fecha de termino para campaña";
            valida = false;
        }
        if (valida == true & tableModelP.getRowCount() == 0) {
            mensaje = "ingrese al menos un producto";
            valida = false;
        }

        if (valida == false) {
            JOptionPane.showMessageDialog(this, mensaje);
        }

        return valida;
    }
    private void cmb_tipo_ofertaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmb_tipo_ofertaItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {

            Integer index = cmb_tipo_oferta.getSelectedIndex();
            if (cmb_tipo_oferta_hide.getSelectedIndex() > -1) {
                cmb_tipo_oferta_hide.setSelectedIndex(index);
                ActualizaPrecio();
            }

            //JOptionPane.showMessageDialog(null, (String) evt.getItem());
        }
    }//GEN-LAST:event_cmb_tipo_ofertaItemStateChanged

    private void cmb_tipo_ofertaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_tipo_ofertaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_tipo_ofertaActionPerformed

    private void cmb_tiendaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmb_tiendaItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {

            Integer index = cmb_tienda.getSelectedIndex();
            if (cmb_tienda_hide.getSelectedIndex() > -1) {
                cmb_tienda_hide.setSelectedIndex(index);
            }

            //JOptionPane.showMessageDialog(null, (String) evt.getItem());
        }
    }//GEN-LAST:event_cmb_tiendaItemStateChanged

    private void tbl_productosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbl_productosKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
            Integer respuesta = JOptionPane.showConfirmDialog(this, "¿Esta Seguro que desea Eliminar?", "Productos", JOptionPane.YES_NO_OPTION);
            if (respuesta == JOptionPane.YES_OPTION) {

                try {
                    int selectedRow = tbl_productos.getSelectedRow();

                    if (!lbl_oferta.getText().toString().equals("...")) {
                        String retorno = "";
                        WsOferta ws = new WsOferta();

                        String sId = tbl_productos.getModel().getValueAt(tbl_productos.getSelectedRow(), 5).toString();

                        ((DefaultTableModel) tbl_productos.getModel()).removeRow(selectedRow);
                        Integer detalleId = Integer.parseInt(sId);
                        retorno = ws.WSfn_EliminarDetalleOferta(detalleId);
                        MensajeGuardar(retorno);
                        limpiar_form();

                    }

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Error al eliminar producto :" + ex.getMessage().toString());
                }

            }
        }
    }//GEN-LAST:event_tbl_productosKeyPressed

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
        if (!lbl_oferta.getText().equals("...")) {

            Integer respuesta = JOptionPane.showConfirmDialog(this, "¿Esta Seguro que desea Eliminar?", "Productos", JOptionPane.YES_NO_OPTION);
            if (respuesta == JOptionPane.YES_OPTION) {
                WsOferta ws = new WsOferta();

                String retorno = "";
                int id_oferta = Integer.parseInt(lbl_oferta.getText().toString());

                retorno = ws.WSfn_EliminarOferta(id_oferta);
                JOptionPane.showMessageDialog(this, retorno);
                limpiar_form();
            }

        }
    }//GEN-LAST:event_btn_eliminarActionPerformed

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
            java.util.logging.Logger.getLogger(crear_oferta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(crear_oferta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(crear_oferta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(crear_oferta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new crear_oferta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Codigo;
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_buscar_producto;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_nuevo;
    private javax.swing.JCheckBox chk_publicar;
    private javax.swing.JComboBox<String> cmb_tienda;
    private javax.swing.JComboBox<String> cmb_tienda_hide;
    private javax.swing.JComboBox<String> cmb_tipo_oferta;
    private javax.swing.JComboBox<String> cmb_tipo_oferta_hide;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JDialog jDialog3;
    private javax.swing.JDialog jDialog4;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JInternalFrame jInternalFrame2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_oferta;
    private javax.swing.JPanel pnl_detalle;
    private javax.swing.JTable tbl_productos;
    private javax.swing.JFormattedTextField txt_desde;
    private javax.swing.JFormattedTextField txt_hasta;
    // End of variables declaration//GEN-END:variables
}
