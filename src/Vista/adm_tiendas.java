/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Vista.modal.modal_tiendas;
import java.awt.event.ItemEvent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
//import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author Sony
 */
public class adm_tiendas extends javax.swing.JFrame {

    private static adm_tiendas obj = null;
    private static Home first = null;

    public adm_tiendas() {
        initComponents();
        this.setLocationRelativeTo(null);
        pnl_detalle.setVisible(false);

        //AutoCompleteDecorator.decorate(cbo_comuna);
        cbo_comuna.addItem("uno");
        cbo_comuna.addItem("dos");
        cbo_comuna.addItem("tres");

        //AutoCompleteDecorator.decorate(cbo_comuna_hide);
        cbo_comuna_hide.addItem("Visible: String :1");
        cbo_comuna_hide.addItem("Visible: String :2");
        cbo_comuna_hide.addItem("Visible: String :3");
    }

    //este codigo esta para que no se abra mas de una vez el formulario
    public static adm_tiendas getObj(Home f) {
        first = f;
        if (obj == null) {
            obj = new adm_tiendas();
        }
        return obj;
    }

    public void limpiar_form() {

        txt_direccion.setText("");
        txt_nombre.setText("");
        txt_nombre_tienda.setText("");
        lbl_codigo.setText("...");
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
        txt_nombre_tienda = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        pnl_detalle = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btn_guardar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        txt_direccion = new javax.swing.JTextField();
        cbo_comuna = new javax.swing.JComboBox<>();
        lbl_codigo = new javax.swing.JLabel();
        cbo_comuna_hide = new javax.swing.JComboBox<>();

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

        txt_nombre_tienda.setToolTipText("Ingrese codigo o nombre de la tienda");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Administracion de Tiendas");

        javax.swing.GroupLayout pnl_busquedaLayout = new javax.swing.GroupLayout(pnl_busqueda);
        pnl_busqueda.setLayout(pnl_busquedaLayout);
        pnl_busquedaLayout.setHorizontalGroup(
            pnl_busquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_busquedaLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(txt_nombre_tienda, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                    .addComponent(txt_nombre_tienda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_buscar)
                    .addComponent(btn_nuevo))
                .addGap(21, 21, 21))
        );

        jLabel1.setText("Codigo");

        btn_guardar.setText("Guardar");

        btn_eliminar.setText("Eliminar");

        jLabel3.setText("Nombre");

        jLabel4.setText("Direccion");

        jLabel5.setText("Comuna");

        cbo_comuna.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbo_comunaItemStateChanged(evt);
            }
        });

        lbl_codigo.setText("...");

        javax.swing.GroupLayout pnl_detalleLayout = new javax.swing.GroupLayout(pnl_detalle);
        pnl_detalle.setLayout(pnl_detalleLayout);
        pnl_detalleLayout.setHorizontalGroup(
            pnl_detalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_detalleLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(btn_eliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_guardar)
                .addGap(45, 45, 45))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_detalleLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_detalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel1))
                .addGap(40, 40, 40)
                .addGroup(pnl_detalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_codigo)
                    .addGroup(pnl_detalleLayout.createSequentialGroup()
                        .addGroup(pnl_detalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_nombre)
                            .addComponent(txt_direccion)
                            .addComponent(cbo_comuna, 0, 196, Short.MAX_VALUE))
                        .addGap(34, 34, 34)
                        .addComponent(cbo_comuna_hide, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(153, 153, 153))
        );
        pnl_detalleLayout.setVerticalGroup(
            pnl_detalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_detalleLayout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(pnl_detalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lbl_codigo))
                .addGap(29, 29, 29)
                .addGroup(pnl_detalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnl_detalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_direccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(pnl_detalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbo_comuna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbo_comuna_hide, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addGroup(pnl_detalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_guardar)
                    .addComponent(btn_eliminar))
                .addGap(37, 37, 37))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnl_detalle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnl_busqueda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnl_busqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(pnl_detalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed

        limpiar_form();
        modal_tiendas.getObj(this).setVisible(true);
    }//GEN-LAST:event_btn_buscarActionPerformed

    private void btn_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nuevoActionPerformed

        pnl_detalle.setVisible(true);
    }//GEN-LAST:event_btn_nuevoActionPerformed

    private void cbo_comunaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbo_comunaItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {

            Integer index = cbo_comuna.getSelectedIndex();
            if (cbo_comuna_hide.getSelectedIndex() > -1) {
                cbo_comuna_hide.setSelectedIndex(index);
            }

            //JOptionPane.showMessageDialog(null, (String) evt.getItem());
        }

    }//GEN-LAST:event_cbo_comunaItemStateChanged

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        limpiar_form();
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
            java.util.logging.Logger.getLogger(adm_tiendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(adm_tiendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(adm_tiendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(adm_tiendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                new adm_tiendas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_nuevo;
    private javax.swing.JComboBox<String> cbo_comuna;
    private javax.swing.JComboBox<String> cbo_comuna_hide;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lbl_codigo;
    private javax.swing.JPanel pnl_busqueda;
    private javax.swing.JPanel pnl_detalle;
    private javax.swing.JTextField txt_direccion;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_nombre_tienda;
    // End of variables declaration//GEN-END:variables
}
