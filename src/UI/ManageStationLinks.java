/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.sql.SQLException;
import java.util.Map;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import trainalgo.stations.Dataset;

/**
 *
 * @author Hishara
 */
public class ManageStationLinks extends javax.swing.JFrame {

    private int[][] stationPaths;
    Dataset ds;
    DefaultTableModel defaultTableModel;
    DefaultListModel<String> defaultListModel;
    private static Map<Integer, String> stationDataTreeMap;
    int selectedTextIndex = 0;

    /**
     * Creates new form ManageStationLinks
     */
    public ManageStationLinks() {
        initComponents();
        initStationLinkDataStruct();
    }

    private void initStationLinkDataStruct() {
        System.out.println("Initializing Data Structures");
        ds = new Dataset();
        try {
            ds.initStationInfoDatastruct();
            stationDataTreeMap = ds.getStationDataTreeMap();
            ds.initStationPathDatastruct();
            stationPaths = ds.getStationPaths();
            if (stationPaths == null && stationPaths.length == 0) {
                JOptionPane.showMessageDialog(this, "Data set is empty", "Exception", JOptionPane.WARNING_MESSAGE);
                return;
            }
            defaultTableModel = new DefaultTableModel();
            defaultTableModel.addColumn("Station A");
            defaultTableModel.addColumn("Station B");
            defaultTableModel.addColumn("Distance (Km)");
            tblStationLinks.setModel(defaultTableModel);

            defaultListModel = new DefaultListModel<>();
            lstStationNames.setModel(defaultListModel);

            for (Map.Entry<Integer, String> entry : stationDataTreeMap.entrySet()) {
                defaultListModel.addElement(entry.getValue());
            }

            txtExecutionTime.setText(String.valueOf(ds.getExecutionTime()));

            refreshData();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "SQL Error : " + e.getMessage(), "Exception", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error : " + e.getMessage(), "Exception", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void refreshData() {
        if (ds != null) {
            stationPaths = ds.getStationPaths();
            if (stationPaths == null && stationPaths.length == 0) {
                JOptionPane.showMessageDialog(this, "Data set is empty", "Exception", JOptionPane.WARNING_MESSAGE);
                return;
            }

            defaultTableModel.setRowCount(0);

            for (int row = 0; row < stationPaths.length; row++) {
                for (int col = 0; col < stationPaths[row].length; col++) {
                    if (stationPaths[row][col] > 0) {
                        defaultTableModel.insertRow(tblStationLinks.getRowCount(), new Object[]{stationDataTreeMap.get(row), stationDataTreeMap.get(col), stationPaths[row][col]});
                    }
                }
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

        jPanel53 = new javax.swing.JPanel();
        txtStationB = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtStationA = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblStationLinks = new javax.swing.JTable();
        btnRemoveLink = new javax.swing.JButton();
        btnAddLink = new javax.swing.JButton();
        btnUpdateLink = new javax.swing.JButton();
        btnLoadData = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtDistance = new javax.swing.JTextField();
        jPanel55 = new javax.swing.JPanel();
        jPanel54 = new javax.swing.JPanel();
        btnClose26 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtExecutionTime = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstStationNames = new javax.swing.JList<>();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel53.setBackground(new java.awt.Color(255, 255, 255));
        jPanel53.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 153, 255)));

        txtStationB.setEditable(false);
        txtStationB.setBackground(new java.awt.Color(255, 255, 255));
        txtStationB.setForeground(new java.awt.Color(102, 102, 102));
        txtStationB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtStationBMouseClicked(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Station A");

        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Station B");

        txtStationA.setEditable(false);
        txtStationA.setBackground(new java.awt.Color(255, 255, 255));
        txtStationA.setForeground(new java.awt.Color(102, 102, 102));
        txtStationA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtStationAMouseClicked(evt);
            }
        });

        tblStationLinks.setBackground(new java.awt.Color(255, 255, 255));
        tblStationLinks.setModel(new javax.swing.table.DefaultTableModel(
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
        tblStationLinks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblStationLinksMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblStationLinks);

        btnRemoveLink.setBackground(new java.awt.Color(102, 153, 255));
        btnRemoveLink.setForeground(new java.awt.Color(255, 255, 255));
        btnRemoveLink.setText("Remove Link");
        btnRemoveLink.setBorder(null);
        btnRemoveLink.setBorderPainted(false);
        btnRemoveLink.setOpaque(true);
        btnRemoveLink.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveLinkActionPerformed(evt);
            }
        });

        btnAddLink.setBackground(new java.awt.Color(102, 153, 255));
        btnAddLink.setForeground(new java.awt.Color(255, 255, 255));
        btnAddLink.setText("Add Link");
        btnAddLink.setBorder(null);
        btnAddLink.setBorderPainted(false);
        btnAddLink.setOpaque(true);
        btnAddLink.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddLinkActionPerformed(evt);
            }
        });

        btnUpdateLink.setBackground(new java.awt.Color(102, 153, 255));
        btnUpdateLink.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdateLink.setText("Update Link");
        btnUpdateLink.setBorder(null);
        btnUpdateLink.setBorderPainted(false);
        btnUpdateLink.setOpaque(true);
        btnUpdateLink.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateLinkActionPerformed(evt);
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
        jLabel4.setText("Station Links");

        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Distance");

        txtDistance.setBackground(new java.awt.Color(255, 255, 255));
        txtDistance.setForeground(new java.awt.Color(102, 102, 102));

        jPanel55.setBackground(new java.awt.Color(102, 153, 255));

        jPanel54.setBackground(new java.awt.Color(255, 102, 102));
        jPanel54.setPreferredSize(new java.awt.Dimension(25, 25));

        btnClose26.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnClose26.setForeground(new java.awt.Color(0, 0, 0));
        btnClose26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnClose26.setText("X");
        btnClose26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnClose26MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel54Layout = new javax.swing.GroupLayout(jPanel54);
        jPanel54.setLayout(jPanel54Layout);
        jPanel54Layout.setHorizontalGroup(
            jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnClose26, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
        );
        jPanel54Layout.setVerticalGroup(
            jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel54Layout.createSequentialGroup()
                .addComponent(btnClose26)
                .addGap(0, 3, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Manage Station Links");

        javax.swing.GroupLayout jPanel55Layout = new javax.swing.GroupLayout(jPanel55);
        jPanel55.setLayout(jPanel55Layout);
        jPanel55Layout.setHorizontalGroup(
            jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel55Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel54, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel55Layout.setVerticalGroup(
            jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel55Layout.createSequentialGroup()
                .addComponent(jPanel54, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel55Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(19, 19, 19))
        );

        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Execution Time (nanoseconds)");

        txtExecutionTime.setForeground(new java.awt.Color(102, 102, 102));
        txtExecutionTime.setText("0000000");

        lstStationNames.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstStationNamesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(lstStationNames);

        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Station Names");

        javax.swing.GroupLayout jPanel53Layout = new javax.swing.GroupLayout(jPanel53);
        jPanel53.setLayout(jPanel53Layout);
        jPanel53Layout.setHorizontalGroup(
            jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel53Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(txtExecutionTime)
                    .addGroup(jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel53Layout.createSequentialGroup()
                            .addGroup(jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2))
                            .addGap(60, 60, 60)
                            .addGroup(jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtStationA)
                                .addComponent(txtStationB, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)))
                        .addGroup(jPanel53Layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addGap(60, 60, 60)
                            .addComponent(txtDistance))
                        .addGroup(jPanel53Layout.createSequentialGroup()
                            .addComponent(btnAddLink, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                            .addComponent(btnUpdateLink, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(29, 29, 29)
                            .addComponent(btnRemoveLink, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(45, 45, 45)
                .addGroup(jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel53Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addGroup(jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLoadData, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel53Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)))
                .addGap(15, 15, 15))
            .addComponent(jPanel55, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel53Layout.setVerticalGroup(
            jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel53Layout.createSequentialGroup()
                .addComponent(jPanel55, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel53Layout.createSequentialGroup()
                        .addGroup(jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel53Layout.createSequentialGroup()
                                .addGroup(jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(txtStationA, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(23, 23, 23)
                                .addGroup(jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(txtStationB, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)
                                .addGroup(jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(txtDistance, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(44, 44, 44)
                                .addGroup(jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnAddLink, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnUpdateLink, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnRemoveLink, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtExecutionTime)
                                .addGap(6, 6, 6))
                            .addComponent(jScrollPane2))
                        .addGap(14, 14, 14))
                    .addGroup(jPanel53Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnLoadData, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 9, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel53, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel53, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1007, 585));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnClose26MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClose26MouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnClose26MouseClicked

    private void tblStationLinksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblStationLinksMouseClicked
        // TODO add your handling code here:
        txtStationA.setText(tblStationLinks.getModel().getValueAt(tblStationLinks.getSelectedRow(), 0).toString());
        txtStationB.setText(tblStationLinks.getModel().getValueAt(tblStationLinks.getSelectedRow(), 1).toString());
        txtDistance.setText(tblStationLinks.getModel().getValueAt(tblStationLinks.getSelectedRow(), 2).toString());
    }//GEN-LAST:event_tblStationLinksMouseClicked

    private void txtStationAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtStationAMouseClicked
        // TODO add your handling code here:
        txtStationA.setText("Select Station from Station Names");
        selectedTextIndex = 0;
    }//GEN-LAST:event_txtStationAMouseClicked

    private void txtStationBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtStationBMouseClicked
        // TODO add your handling code here:
        txtStationB.setText("Select Station from Station Names");
        selectedTextIndex = 1;
    }//GEN-LAST:event_txtStationBMouseClicked

    private void lstStationNamesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstStationNamesMouseClicked
        // TODO add your handling code here:
        if (selectedTextIndex == 0)
            txtStationA.setText(lstStationNames.getSelectedValue());
        else
            txtStationB.setText(lstStationNames.getSelectedValue());
    }//GEN-LAST:event_lstStationNamesMouseClicked

    private void btnLoadDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadDataActionPerformed
        // TODO add your handling code here:
        refreshData();
    }//GEN-LAST:event_btnLoadDataActionPerformed

    private void btnAddLinkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddLinkActionPerformed
        // TODO add your handling code here:
        if (txtStationA.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Please select a Station from the List to Station A", "Input Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (txtStationB.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Please select a Station from the List to Station B", "Input Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (txtDistance.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Please enter a valid distance", "Input Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (!txtDistance.getText().matches("[0-9]+")) {
            JOptionPane.showMessageDialog(this, "Please enter a valid distance", "Input Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (txtStationA.getText().equals(txtStationB.getText())) {
            JOptionPane.showMessageDialog(this, "Can't generate links with same station", "Input Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (stationPaths[ds.retrieveStationID(txtStationA.getText())][ds.retrieveStationID(txtStationB.getText())] > 0) {
            JOptionPane.showMessageDialog(this, "StationA and StationB are already linked.", "Input Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            if (ds.addStationPathToDataStruct(txtStationA.getText(), txtStationB.getText(), Integer.parseInt(txtDistance.getText()))) {
                JOptionPane.showMessageDialog(this, "Station links added", "Success", JOptionPane.INFORMATION_MESSAGE);
                refreshData();
                txtExecutionTime.setText(String.valueOf(ds.getExecutionTime()));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "SQL Error : " + e.getMessage(), "Exception", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error : " + e.getMessage(), "Exception", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAddLinkActionPerformed

    private void btnUpdateLinkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateLinkActionPerformed
        // TODO add your handling code here:
        if (txtStationA.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Please select a Station from the List to Station A", "Input Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (txtStationB.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Please select a Station from the List to Station B", "Input Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (txtDistance.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Please enter a valid distance", "Input Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (!txtDistance.getText().matches("[0-9]+")) {
            JOptionPane.showMessageDialog(this, "Please enter a valid distance", "Input Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (txtStationA.getText().equals(txtStationB.getText())) {
            JOptionPane.showMessageDialog(this, "StationA and StationB both consists same station.", "Input Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (stationPaths[ds.retrieveStationID(txtStationA.getText())][ds.retrieveStationID(txtStationB.getText())] == 0) {
            JOptionPane.showMessageDialog(this, "StationA and StationB does not contain a link to update.", "Input Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            if (ds.updateStationPathInDataStructure(txtStationA.getText(),txtStationB.getText(),Integer.parseInt(txtDistance.getText()))) {
                JOptionPane.showMessageDialog(this, "Station links upadted", "Success", JOptionPane.INFORMATION_MESSAGE);
                refreshData();
                txtExecutionTime.setText(String.valueOf(ds.getExecutionTime()));
            }
        }catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error : " + e.getMessage(), "Exception", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnUpdateLinkActionPerformed

    private void btnRemoveLinkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveLinkActionPerformed
        // TODO add your handling code here:
        if (txtStationA.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Please select a Station from the List to Station A", "Input Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (txtStationB.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Please select a Station from the List to Station B", "Input Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (txtStationA.getText().equals(txtStationB.getText())) {
            JOptionPane.showMessageDialog(this, "StationA and StationB both consists same station.", "Input Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (stationPaths[ds.retrieveStationID(txtStationA.getText())][ds.retrieveStationID(txtStationB.getText())] == 0) {
            JOptionPane.showMessageDialog(this, "StationA and StationB does not contain a link to remove.", "Input Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            if (ds.removeStationPathInDatastructure(txtStationA.getText(), txtStationB.getText())) {
                JOptionPane.showMessageDialog(this, "Station links upadted", "Success", JOptionPane.INFORMATION_MESSAGE);
                refreshData();
                txtExecutionTime.setText(String.valueOf(ds.getExecutionTime()));
            }
        }catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error : " + e.getMessage(), "Exception", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnRemoveLinkActionPerformed

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
            java.util.logging.Logger.getLogger(ManageStationLinks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageStationLinks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageStationLinks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageStationLinks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageStationLinks().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddLink;
    private javax.swing.JLabel btnClose26;
    private javax.swing.JButton btnLoadData;
    private javax.swing.JButton btnRemoveLink;
    private javax.swing.JButton btnUpdateLink;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel53;
    private javax.swing.JPanel jPanel54;
    private javax.swing.JPanel jPanel55;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> lstStationNames;
    private javax.swing.JTable tblStationLinks;
    private javax.swing.JTextField txtDistance;
    private javax.swing.JLabel txtExecutionTime;
    private javax.swing.JTextField txtStationA;
    private javax.swing.JTextField txtStationB;
    // End of variables declaration//GEN-END:variables
}
