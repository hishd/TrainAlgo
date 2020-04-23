/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.sql.SQLException;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import trainalgo.Codes;
import trainalgo.stations.Dataset;

/**
 *
 * @author Hishara
 */
public class ManageStations extends javax.swing.JFrame {

    private static Map<Integer, String> stationDataTreeMap;
    Dataset ds;
    DefaultTableModel defaultTableModel;
    String selectedStation;

    /**
     * Creates new form ManageStations
     */
    public ManageStations() {
        initComponents();
        initTrainInfoDataStruct();
    }

    private void initTrainInfoDataStruct() {
        System.out.println("Initializing Data Structures");
        ds = new Dataset();
        try {
            ds.initStationInfoDatastruct();
            stationDataTreeMap = ds.getStationDataTreeMap();
            if (stationDataTreeMap == null || stationDataTreeMap.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Data set is empty", "Exception", JOptionPane.WARNING_MESSAGE);
                return;
            }

            defaultTableModel = new DefaultTableModel();
            defaultTableModel.addColumn("Station ID");
            defaultTableModel.addColumn("Station Name");
            tblStationInfo.setModel(defaultTableModel);

            for (Map.Entry<Integer, String> entry : stationDataTreeMap.entrySet()) {
                defaultTableModel.insertRow(tblStationInfo.getRowCount(), new Object[]{entry.getKey(), entry.getValue()});
            }
            
            txtExecutionTime.setText(String.valueOf(ds.getExecutionTime()));

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "SQL Error : " + e.getMessage(), "Exception", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error : " + e.getMessage(), "Exception", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void refreshData() {
        stationDataTreeMap = ds.getStationDataTreeMap();
        defaultTableModel.setRowCount(0);
        for (Map.Entry<Integer, String> entry : stationDataTreeMap.entrySet()) {
            defaultTableModel.insertRow(tblStationInfo.getRowCount(), new Object[]{entry.getKey(), entry.getValue()});
        }
        txtExecutionTime.setText(String.valueOf(ds.getExecutionTime()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtStationName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtStationID = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblStationInfo = new javax.swing.JTable();
        btnRemoveStation = new javax.swing.JButton();
        btnAddStation = new javax.swing.JButton();
        btnUpdateStation = new javax.swing.JButton();
        btnLoadData = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btnClose = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtExecutionTime = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 153, 255)));

        txtStationName.setBackground(new java.awt.Color(255, 255, 255));
        txtStationName.setForeground(new java.awt.Color(102, 102, 102));

        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Station ID");

        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Station Name");

        txtStationID.setEditable(false);
        txtStationID.setBackground(new java.awt.Color(255, 255, 255));
        txtStationID.setForeground(new java.awt.Color(102, 102, 102));

        tblStationInfo.setBackground(new java.awt.Color(255, 255, 255));
        tblStationInfo.setModel(new javax.swing.table.DefaultTableModel(
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
        tblStationInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblStationInfoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblStationInfo);

        btnRemoveStation.setBackground(new java.awt.Color(102, 153, 255));
        btnRemoveStation.setForeground(new java.awt.Color(255, 255, 255));
        btnRemoveStation.setText("Remove Station");
        btnRemoveStation.setBorder(null);
        btnRemoveStation.setBorderPainted(false);
        btnRemoveStation.setOpaque(true);
        btnRemoveStation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveStationActionPerformed(evt);
            }
        });

        btnAddStation.setBackground(new java.awt.Color(102, 153, 255));
        btnAddStation.setForeground(new java.awt.Color(255, 255, 255));
        btnAddStation.setText("Add Station");
        btnAddStation.setBorder(null);
        btnAddStation.setBorderPainted(false);
        btnAddStation.setOpaque(true);
        btnAddStation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddStationActionPerformed(evt);
            }
        });

        btnUpdateStation.setBackground(new java.awt.Color(102, 153, 255));
        btnUpdateStation.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdateStation.setText("Update Station");
        btnUpdateStation.setBorder(null);
        btnUpdateStation.setBorderPainted(false);
        btnUpdateStation.setOpaque(true);
        btnUpdateStation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateStationActionPerformed(evt);
            }
        });

        btnLoadData.setBackground(new java.awt.Color(102, 153, 255));
        btnLoadData.setForeground(new java.awt.Color(255, 255, 255));
        btnLoadData.setText("Load Data");
        btnLoadData.setBorder(null);
        btnLoadData.setBorderPainted(false);
        btnLoadData.setOpaque(true);
        btnLoadData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadDataActionPerformed(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Station Information");

        jPanel2.setBackground(new java.awt.Color(102, 153, 255));

        jPanel3.setBackground(new java.awt.Color(255, 102, 102));
        jPanel3.setPreferredSize(new java.awt.Dimension(25, 25));

        btnClose.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnClose.setForeground(new java.awt.Color(0, 0, 0));
        btnClose.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnClose.setText("X");
        btnClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCloseMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnClose, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(btnClose)
                .addGap(0, 3, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Manage Station Data");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel3)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Execution Time (nanoseconds)");

        txtExecutionTime.setForeground(new java.awt.Color(102, 102, 102));
        txtExecutionTime.setText("0000000");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(27, 27, 27)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtStationName)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtStationID, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnAddStation, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnUpdateStation, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(txtExecutionTime))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnRemoveStation, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                                    .addComponent(btnLoadData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(28, 28, 28)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtStationID, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtStationName, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAddStation, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnUpdateStation, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRemoveStation, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(163, 163, 163)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtExecutionTime)
                                .addGap(6, 6, 6))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnLoadData, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(792, 512));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCloseMouseClicked

    private void tblStationInfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblStationInfoMouseClicked
        // TODO add your handling code here:
        txtStationID.setText(tblStationInfo.getModel().getValueAt(tblStationInfo.getSelectedRow(), 0).toString());
        txtStationName.setText(tblStationInfo.getModel().getValueAt(tblStationInfo.getSelectedRow(), 1).toString());
        selectedStation = tblStationInfo.getModel().getValueAt(tblStationInfo.getSelectedRow(), 1).toString();
    }//GEN-LAST:event_tblStationInfoMouseClicked

    private void btnAddStationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddStationActionPerformed
        // TODO add your handling code here:
        if (txtStationName.getText().length() < 1) {
            JOptionPane.showMessageDialog(this, "Please enter a valid station name", "Input Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (ds.retrieveStationID(txtStationName.getText()) != 0) {
            JOptionPane.showMessageDialog(this, "The Station " + txtStationName.getText() + " already exists.", "Duplicate Entry", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {

            if (ds.addStationToStationInfoDatastruct(txtStationName.getText())==Codes.STATION_ADDED) {
                JOptionPane.showMessageDialog(this, "Station data added", "Success", JOptionPane.INFORMATION_MESSAGE);
                refreshData();
                txtExecutionTime.setText(String.valueOf(ds.getExecutionTime()));
                return;
            }else{
                JOptionPane.showMessageDialog(this, "An error occured while processing request", "Error", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "SQL Error : " + e.getMessage(), "Exception", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error : " + e.getMessage(), "Exception", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_btnAddStationActionPerformed

    private void btnLoadDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadDataActionPerformed
        // TODO add your handling code here:
        if (ds != null && defaultTableModel != null)
            refreshData();
        else
            JOptionPane.showMessageDialog(this, "Failed to load data", "Error", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_btnLoadDataActionPerformed

    private void btnUpdateStationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateStationActionPerformed
        // TODO add your handling code here:
        if (txtStationName.getText().length() < 1) {
            JOptionPane.showMessageDialog(this, "Please enter a valid station name", "Input Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (ds.retrieveStationID(txtStationName.getText()) != 0) {
            JOptionPane.showMessageDialog(this, "The Station " + txtStationName.getText() + " already exists.", "Duplicate Entry", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {

            if (ds.updateStationInStationInfoDatastruct(selectedStation, txtStationName.getText())==Codes.STATION_UPDATED) {
                JOptionPane.showMessageDialog(this, "Station data updated", "Success", JOptionPane.INFORMATION_MESSAGE);
                refreshData();
                txtExecutionTime.setText(String.valueOf(ds.getExecutionTime()));
            }else{
                JOptionPane.showMessageDialog(this, "An error occured while processing request", "Error", JOptionPane.WARNING_MESSAGE);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error : " + e.getMessage(), "Exception", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnUpdateStationActionPerformed

    private void btnRemoveStationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveStationActionPerformed
        // TODO add your handling code here:
        if (txtStationName.getText().length() < 1) {
            JOptionPane.showMessageDialog(this, "Please select a station name", "Input Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        if (ds.retrieveStationID(txtStationName.getText()) == 0) {
            JOptionPane.showMessageDialog(this, "The Station " + txtStationName.getText() + " does not exists.", "Invalid Entry", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        try {

            if (ds.removeStationInStationInfoDatastructure(txtStationName.getText())==Codes.STATION_REMOVED) {
                JOptionPane.showMessageDialog(this, "Station data updated", "Success", JOptionPane.INFORMATION_MESSAGE);
                refreshData();
                txtExecutionTime.setText(String.valueOf(ds.getExecutionTime()));
            }else{
                JOptionPane.showMessageDialog(this, "An error occured while processing request", "Error", JOptionPane.WARNING_MESSAGE);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error : " + e.getMessage(), "Exception", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnRemoveStationActionPerformed

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
            java.util.logging.Logger.getLogger(ManageStations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageStations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageStations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageStations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageStations().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddStation;
    private javax.swing.JLabel btnClose;
    private javax.swing.JButton btnLoadData;
    private javax.swing.JButton btnRemoveStation;
    private javax.swing.JButton btnUpdateStation;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblStationInfo;
    private javax.swing.JLabel txtExecutionTime;
    private javax.swing.JTextField txtStationID;
    private javax.swing.JTextField txtStationName;
    // End of variables declaration//GEN-END:variables

}
