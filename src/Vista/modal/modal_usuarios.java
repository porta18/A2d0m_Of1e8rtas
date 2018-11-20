/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.modal;

import Clases.Oferta;
import Clases.Persona;
import Clases.Usuario;
import Servicios.WsOferta;
import Servicios.WsUsuario;
import Vista.Login;
import Vista.adm_usuarios;
import Vista.crear_oferta;
import java.awt.event.MouseEvent;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class modal_usuarios extends javax.swing.JFrame {

    /**
     * Creates new form modal_usuarios
     */
    private static modal_usuarios obj = null;
    private static adm_usuarios first = null;

    public modal_usuarios() {
        initComponents();
        this.setLocationRelativeTo(null);
        tbl_usuario.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lbl_mensaje2.setVisible(false);
        cargarTablaUsuarios(0);
    }

    public static modal_usuarios getObj(adm_usuarios f) {
        first = f;
        if (obj == null) {
            obj = new modal_usuarios();
        }
        return obj;
    }

    public void cargarTablaUsuarios(Integer usu_id) {

        WsUsuario ws = new WsUsuario();
        String retorno = "";
        retorno = ws.WSfn_TraerUsuario(usu_id);

        if (!retorno.equals("<NewDataSet />")) {
            try {
                SAXBuilder builder = new SAXBuilder();

                InputStream stream = new ByteArrayInputStream(retorno.getBytes("UTF-8"));
                Document document = builder.build(stream);

                //Document document = (Document) builder.build(retorno);
                Element rootNode = document.getRootElement();
                java.util.List<Element> list = rootNode.getChildren("Table");

                String encabezadoTabla[] = {"ID", "usuario", "nombre", "cargo", "clave", "correo", "tipo usu", "persona id", "rut", "nombres", "apellido p", "apellido m", "genero", "nacimiento"};
                DefaultTableModel tableModel = new DefaultTableModel(encabezadoTabla, 0);

                for (int i = 0; i < list.size(); i++) {

                    Element node = (Element) list.get(i);

                    String id = node.getChildText("USU_ID");
                    String usuario = node.getChildText("USU_NOMBRE");
                    String nombre = node.getChildText("NOMBRE");
                    String cargo = node.getChildText("T_USU_DESCRIPCION");
                    String clave = node.getChildText("USU_CLAVE");
                    String correo = node.getChildText("USU_EMAIL");
                    String tipoUsu = node.getChildText("T_USU_ID");
                    String personaId = node.getChildText("PRS_ID");
                    String rut = node.getChildText("PRS_RUT");
                    String nombres = node.getChildText("PRS_NOMBRES");
                    String apellido_p = node.getChildText("PRS_APELLIDO_PATERNO");
                    String apellido_m = node.getChildText("PRS_APELLIDO_MATERNO");
                    String genero = node.getChildText("TIPO_SEXO_T_SXO_ID");
                    String nacimiento = node.getChildText("PRS_FECHA_NACIMIENTO");

                    Object[] objs = {id, usuario, nombre, cargo, clave, correo, tipoUsu, personaId, rut, nombres, apellido_p, apellido_m, genero, nacimiento};
                    tableModel.addRow(objs);
                }
                tbl_usuario.setModel(tableModel);
                /*bloqueo la tabla para no ser editada*/
                tbl_usuario.setDefaultEditor(Object.class, null);

                tbl_usuario.removeColumn(tbl_usuario.getColumnModel().getColumn(4));
                tbl_usuario.removeColumn(tbl_usuario.getColumnModel().getColumn(4));
                tbl_usuario.removeColumn(tbl_usuario.getColumnModel().getColumn(4));
                tbl_usuario.removeColumn(tbl_usuario.getColumnModel().getColumn(4));
                tbl_usuario.removeColumn(tbl_usuario.getColumnModel().getColumn(4));
                tbl_usuario.removeColumn(tbl_usuario.getColumnModel().getColumn(4));
                tbl_usuario.removeColumn(tbl_usuario.getColumnModel().getColumn(4));
                tbl_usuario.removeColumn(tbl_usuario.getColumnModel().getColumn(4));
                tbl_usuario.removeColumn(tbl_usuario.getColumnModel().getColumn(4));
                tbl_usuario.removeColumn(tbl_usuario.getColumnModel().getColumn(4));

            } catch (JDOMException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            lbl_mensaje2.setText("No se encontraron ofertas creadas para esta tienda");
            pnl_info2.setVisible(true);
        }

    }

    public void seleccionar_usuario() {
        String auxId = tbl_usuario.getValueAt(tbl_usuario.getSelectedRow(), 0).toString();

        if (auxId.trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Seleccione un usuario");
        } else {

            Integer idUsuario = Integer.parseInt(auxId);
            String usuario = tbl_usuario.getValueAt(tbl_usuario.getSelectedRow(), 1).toString();
            String clave = tbl_usuario.getModel().getValueAt(tbl_usuario.getSelectedRow(), 3).toString();
            String correo = tbl_usuario.getModel().getValueAt(tbl_usuario.getSelectedRow(), 5).toString();
            String tipoUsu = tbl_usuario.getModel().getValueAt(tbl_usuario.getSelectedRow(), 6).toString();
            String personaId = tbl_usuario.getModel().getValueAt(tbl_usuario.getSelectedRow(), 7).toString();
            String Auxrut = tbl_usuario.getModel().getValueAt(tbl_usuario.getSelectedRow(), 8).toString();
            String nombres = tbl_usuario.getModel().getValueAt(tbl_usuario.getSelectedRow(), 9).toString();
            String ape_p = tbl_usuario.getModel().getValueAt(tbl_usuario.getSelectedRow(), 10).toString();
            String ape_m = tbl_usuario.getModel().getValueAt(tbl_usuario.getSelectedRow(), 11).toString();
            String auxGenero = tbl_usuario.getModel().getValueAt(tbl_usuario.getSelectedRow(), 12).toString();
            String nacimiento = tbl_usuario.getModel().getValueAt(tbl_usuario.getSelectedRow(), 13).toString();

            Integer rut = Integer.parseInt(Auxrut);
            Integer genero = Integer.parseInt(auxGenero);

            /*prueba de campos ocultos */
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            String dateNacimiento = nacimiento;

            try {

                Date dateNaci = formatter.parse(dateNacimiento);

                Usuario usu = new Usuario();
                Persona per = new Persona();

                usu.setId(idUsuario);
                usu.setNombre(usuario);
                usu.setClave(clave);
                usu.setEmail(correo);
                usu.setTipo_usuario(Integer.parseInt(tipoUsu));

                per.setId(Integer.parseInt(personaId));
                per.setRut(rut);
                per.setNombres(nombres);
                per.setApellido_p(ape_p);
                per.setApellido_m(ape_m);
                per.setFecha_nacimiento(dateNaci);
                per.setT_sexo(genero);
                usu.setPersona(per);

                first.cargarUsuario(usu);
                obj = null;
                this.dispose();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_usuario = new javax.swing.JTable();
        btn_seleccionar2 = new javax.swing.JButton();
        btn_cancelar2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        pnl_info2 = new javax.swing.JPanel();
        lbl_mensaje2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        tbl_usuario.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_usuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbl_usuarioMousePressed(evt);
            }
        });
        jScrollPane3.setViewportView(tbl_usuario);

        btn_seleccionar2.setText("Seleccionar");
        btn_seleccionar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_seleccionar2ActionPerformed(evt);
            }
        });

        btn_cancelar2.setText("Cancelar");
        btn_cancelar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelar2ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Seleccione un Usuario");
        jLabel3.setToolTipText("");
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lbl_mensaje2.setText("[label mensaje]");

        javax.swing.GroupLayout pnl_info2Layout = new javax.swing.GroupLayout(pnl_info2);
        pnl_info2.setLayout(pnl_info2Layout);
        pnl_info2Layout.setHorizontalGroup(
            pnl_info2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_info2Layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addComponent(lbl_mensaje2)
                .addGap(21, 21, 21))
        );
        pnl_info2Layout.setVerticalGroup(
            pnl_info2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_info2Layout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addComponent(lbl_mensaje2))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(pnl_info2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(btn_cancelar2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_seleccionar2))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(153, 153, 153)
                .addComponent(jLabel3)
                .addContainerGap(216, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(pnl_info2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_seleccionar2)
                    .addComponent(btn_cancelar2))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_usuarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_usuarioMousePressed
        if (evt.getButton() == MouseEvent.BUTTON1 && evt.getClickCount() == 2) {
            seleccionar_usuario();
        }
    }//GEN-LAST:event_tbl_usuarioMousePressed

    private void btn_seleccionar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_seleccionar2ActionPerformed
        seleccionar_usuario();
    }//GEN-LAST:event_btn_seleccionar2ActionPerformed

    private void btn_cancelar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelar2ActionPerformed
        obj = null;
        this.dispose();
    }//GEN-LAST:event_btn_cancelar2ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        obj = null;
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(modal_usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(modal_usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(modal_usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(modal_usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new modal_usuarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancelar2;
    private javax.swing.JButton btn_seleccionar2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbl_mensaje2;
    private javax.swing.JPanel pnl_info2;
    private javax.swing.JTable tbl_usuario;
    // End of variables declaration//GEN-END:variables
}
