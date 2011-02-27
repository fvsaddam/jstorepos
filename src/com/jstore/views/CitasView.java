/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * VentasView.java
 *
 * Created on Aug 26, 2010, 3:34:40 PM
 */

package com.jstore.views;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import com.jstore.JStoreApp;
import com.jstore.components.EntityJTextField;
import com.jstore.components.EntityTableModel;
import com.jstore.domain.Cita;
import com.jstore.domain.Cliente;
import com.jstore.domain.Producto;
import com.jstore.domain.Sesion;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author phasnox
 */
public class CitasView extends javax.swing.JPanel {
    private boolean modificar=true;

    EntityManager em;
    Cita citaDAO;
    Sesion sesionDAO;
    Cliente clienteDAO;
    /** Creates new form VentasView */
    public CitasView() {
        initComponents();
        em = JStoreApp.getApplication().getEntityManager();
        citaDAO = new Cita();
        sesionDAO = new Sesion();
        clienteDAO = new Cliente();
        clienteDAO.setEm(em);
        //Init masterTable
        initMasterTable();

        filterSearch();
        masterTable.getSelectionModel().addListSelectionListener(new MasterSelectionListener());

        newLabel.setVisible(false);
        ((EntityJTextField)txtNombre).setEntity(clienteDAO);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        searchTxt = new javax.swing.JTextField();
        searchButton = new org.jdesktop.swingx.JXButton();
        newButton = new org.jdesktop.swingx.JXButton();
        deleteButton = new org.jdesktop.swingx.JXButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        masterTable = new org.jdesktop.swingx.JXTable();
        datosPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtId = new org.jdesktop.swingx.JXTextField();
        txtCosto = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        newLabel = new javax.swing.JLabel();
        txtNombre = new EntityJTextField();
        saveButton = new org.jdesktop.swingx.JXButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        sesionesTable = new javax.swing.JTable();
        addSesionButton = new javax.swing.JButton();
        removeSesionButton = new javax.swing.JButton();

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(com.jstore.JStoreApp.class).getContext().getResourceMap(CitasView.class);
        setBorder(javax.swing.BorderFactory.createTitledBorder(resourceMap.getString("Form.border.title"))); // NOI18N
        setName("Form"); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(resourceMap.getString("jPanel1.border.title"))); // NOI18N
        jPanel1.setName("jPanel1"); // NOI18N

        searchTxt.setName("searchTxt"); // NOI18N
        searchTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchTxtActionPerformed(evt);
            }
        });

        searchButton.setIcon(resourceMap.getIcon("searchButton.icon")); // NOI18N
        searchButton.setText(resourceMap.getString("searchButton.text")); // NOI18N
        searchButton.setName("searchButton"); // NOI18N
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(searchTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(6, Short.MAX_VALUE))
        );

        newButton.setIcon(resourceMap.getIcon("newButton.icon")); // NOI18N
        newButton.setText(resourceMap.getString("newButton.text")); // NOI18N
        newButton.setName("newButton"); // NOI18N
        newButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newButtonActionPerformed(evt);
            }
        });

        deleteButton.setIcon(resourceMap.getIcon("deleteButton.icon")); // NOI18N
        deleteButton.setText(resourceMap.getString("deleteButton.text")); // NOI18N
        deleteButton.setName("deleteButton"); // NOI18N
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        masterTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Descripcion", "Minutos Maquina", "Costo"
            }
        ));
        masterTable.setName("masterTable"); // NOI18N
        jScrollPane1.setViewportView(masterTable);
        masterTable.getColumnModel().getColumn(0).setHeaderValue(resourceMap.getString("masterTable.columnModel.title0")); // NOI18N
        masterTable.getColumnModel().getColumn(1).setHeaderValue(resourceMap.getString("masterTable.columnModel.title1")); // NOI18N
        masterTable.getColumnModel().getColumn(2).setHeaderValue(resourceMap.getString("masterTable.columnModel.title2")); // NOI18N
        masterTable.getColumnModel().getColumn(3).setHeaderValue(resourceMap.getString("masterTable.columnModel.title3")); // NOI18N
        masterTable.getColumnModel().getColumn(4).setHeaderValue(resourceMap.getString("masterTable.columnModel.title4")); // NOI18N

        datosPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(resourceMap.getString("datosPanel.border.title"))); // NOI18N
        datosPanel.setName("datosPanel"); // NOI18N

        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        txtId.setEditable(false);
        txtId.setName("txtId"); // NOI18N

        txtCosto.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        txtCosto.setText(resourceMap.getString("txtCosto.text")); // NOI18N
        txtCosto.setName("txtCosto"); // NOI18N

        jLabel3.setText(resourceMap.getString("jLabel3.text")); // NOI18N
        jLabel3.setName("jLabel3"); // NOI18N

        jLabel5.setText(resourceMap.getString("jLabel5.text")); // NOI18N
        jLabel5.setName("jLabel5"); // NOI18N

        jLabel7.setText(resourceMap.getString("jLabel7.text")); // NOI18N
        jLabel7.setName("jLabel7"); // NOI18N

        txtDescripcion.setText(resourceMap.getString("txtDescripcion.text")); // NOI18N
        txtDescripcion.setName("txtDescripcion"); // NOI18N

        newLabel.setBackground(resourceMap.getColor("newLabel.background")); // NOI18N
        newLabel.setForeground(resourceMap.getColor("newLabel.foreground")); // NOI18N
        newLabel.setText(resourceMap.getString("newLabel.text")); // NOI18N
        newLabel.setName("newLabel"); // NOI18N
        newLabel.setOpaque(true);

        txtNombre.setText(resourceMap.getString("txtNombre.text")); // NOI18N
        txtNombre.setName("txtNombre"); // NOI18N

        javax.swing.GroupLayout datosPanelLayout = new javax.swing.GroupLayout(datosPanel);
        datosPanel.setLayout(datosPanelLayout);
        datosPanelLayout.setHorizontalGroup(
            datosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(datosPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(datosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1)
                    .addComponent(jLabel7)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(datosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(datosPanelLayout.createSequentialGroup()
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(newLabel))
                    .addComponent(txtDescripcion)
                    .addComponent(txtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        datosPanelLayout.setVerticalGroup(
            datosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(datosPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(datosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(datosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(datosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(datosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(txtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        saveButton.setIcon(resourceMap.getIcon("saveButton.icon")); // NOI18N
        saveButton.setText(resourceMap.getString("saveButton.text")); // NOI18N
        saveButton.setName("saveButton"); // NOI18N
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(resourceMap.getString("jPanel2.border.title"))); // NOI18N
        jPanel2.setName("jPanel2"); // NOI18N

        jScrollPane2.setName("jScrollPane2"); // NOI18N

        sesionesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null}
            },
            new String [] {
                "Sesion", "# de Sesiones"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        sesionesTable.setName("sesionesTable"); // NOI18N
        jScrollPane2.setViewportView(sesionesTable);

        addSesionButton.setIcon(resourceMap.getIcon("addSesionButton.icon")); // NOI18N
        addSesionButton.setText(resourceMap.getString("addSesionButton.text")); // NOI18N
        addSesionButton.setName("addSesionButton"); // NOI18N

        removeSesionButton.setIcon(resourceMap.getIcon("removeSesionButton.icon")); // NOI18N
        removeSesionButton.setName("removeSesionButton"); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(addSesionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(removeSesionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 451, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addSesionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(removeSesionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(saveButton, 0, 0, Short.MAX_VALUE)
                            .addComponent(newButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(datosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(newButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(datosPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void searchTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTxtActionPerformed
        filterSearch();
}//GEN-LAST:event_searchTxtActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        filterSearch();
    }//GEN-LAST:event_searchButtonActionPerformed

    private void newButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newButtonActionPerformed
        newLabel.setVisible(true);
        modificar=false;
        blankFields();
}//GEN-LAST:event_newButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(com.jstore.JStoreApp.class).getContext().getResourceMap(CitasView.class);
        int answer = JOptionPane.showConfirmDialog(this, "Seguro que desea borrar?", "Eliminar", JOptionPane.YES_NO_OPTION, 0, resourceMap.getIcon("questionIcon"));
        if(answer==JOptionPane.YES_OPTION){
            deleteCitaSelected();
        }

}//GEN-LAST:event_deleteButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
    saveCita();
    newLabel.setVisible(false);
}//GEN-LAST:event_saveButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addSesionButton;
    private javax.swing.JPanel datosPanel;
    private org.jdesktop.swingx.JXButton deleteButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private org.jdesktop.swingx.JXTable masterTable;
    private org.jdesktop.swingx.JXButton newButton;
    private javax.swing.JLabel newLabel;
    private javax.swing.JButton removeSesionButton;
    private org.jdesktop.swingx.JXButton saveButton;
    private org.jdesktop.swingx.JXButton searchButton;
    private javax.swing.JTextField searchTxt;
    private javax.swing.JTable sesionesTable;
    private javax.swing.JFormattedTextField txtCosto;
    private javax.swing.JTextField txtDescripcion;
    private org.jdesktop.swingx.JXTextField txtId;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables

    private int getSelected(JTable table) {
        //Get the selected index
        int selected=0;
        int index=0;
        selected = table.getSelectionModel().getMinSelectionIndex();
        if(selected>=0){
            index = table.convertRowIndexToModel(selected);
        }

        return index;
    }

    private void deleteCitaSelected() {
        int index = getSelected(masterTable);
        EntityTableModel etm = (EntityTableModel) masterTable.getModel();
        Cita c = (Cita)etm.getBeanAt(index);
        em.getTransaction().begin();
        em.remove(c);
        em.getTransaction().commit();
        filterSearch();
    }
    // End of variables declaration

    class MasterSelectionListener implements ListSelectionListener {
    public void valueChanged(ListSelectionEvent e) {
        ListSelectionModel lsm = (ListSelectionModel)e.getSource();

        int firstIndex = e.getFirstIndex();
        int lastIndex = e.getLastIndex();
        boolean isAdjusting = e.getValueIsAdjusting();

        if (lsm.isSelectionEmpty()) {

        } else {
            // Find out which indexes are selected.
            int selected = lsm.getMinSelectionIndex();
            int index = masterTable.convertRowIndexToModel(selected);
            EntityTableModel etm = (EntityTableModel) masterTable.getModel();
            Cita c  = (Cita)etm.getBeanAt(index);
            
            Integer id = c.getIdCita();
            String nombreCliente = c.getCliente().getNombre() + " " + c.getCliente().getApellido();
            String nombreSesion = c.getSesion().getDescripcion();
            Date fechaCita = c.getFechaCita();
            Integer minutosMaquina = c.getDuracion();
            


            txtId.setText(id.toString());
//            txtNombre.setText(nombre);
//            txtDescripcion.setText(descripcion);
//            txtCosto.setValue(costo);
                try {
                    txtCosto.commitEdit();
                } catch (ParseException ex) {
                    Logger.getLogger(CitasView.class.getName()).log(Level.SEVERE, null, ex);
                }

            modificar=true;
            }
        }
    }


    private void initMasterTable(){
        EntityTableModel etm = new EntityTableModel();
        etm.addColumn("Nombre", "nombre");
        etm.addColumn("Descripcion", "descripcion");
        etm.addColumn("Costo", "costo");
        masterTable.setModel(etm);

    }

    private void filterSearch() {
//        Map criterias = new HashMap();
//        //criterias.put("id", searchIdTxt.getText() + "%");
//        criterias.put("nombre", searchTxt.getText() + "%");
//        EntityTableModel etm = (EntityTableModel) masterTable.getModel();
//        etm.setBeans(citaDAO.findLikeCriteria(criterias));
//        masterTable.setModel(etm);
    }

    private void blankFields() {
        txtId.setText("");
        txtNombre.setText("");
        txtDescripcion.setText("");
        txtCosto.setText("");
    }

    public void saveCita(){
//        Cita c;
//        String nombre;
//        String descripcion;
//        Double costo;
//        Integer minutosMaquina;
//        int selected;
//        int index=0;
//        EntityTableModel etm=null;
//
//        nombre = txtNombre.getText();
//        descripcion = txtDescripcion.getText();
//        costo = ((Number)txtCosto.getValue()).doubleValue();
//
//        index=getSelected(masterTable);
//
//
//        if(modificar){
//           etm = (EntityTableModel) masterTable.getModel();
//           p = (Producto)etm.getBeanAt(index);
//        }else{
//            p = new Producto();
//        }
//
//        p.setNombre(nombre);
//        p.setDescripcion(descripcion);
//        p.setCosto(costo);
//
//
//        try {
//            citaDAO.saveOrUpdate(p);
//            em.getTransaction().commit();
//        } catch (Exception e) {
//            e.printStackTrace();
//            em.getTransaction().rollback();
//        }
//
//        filterSearch();
//        modificar=true;
    }
}