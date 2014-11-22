/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.polsl.Szymon.Bartnik.views;

/**
 *
 * @author Szymon
 */
public class MainDialog extends javax.swing.JFrame {

    /**
     * Creates new form MainDialog
     */
    public MainDialog() {
        initComponents();
        executeMyInit();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane2 = new javax.swing.JSplitPane();
        upperMainPanel = new javax.swing.JPanel();
        panelInputNumeralSystem = new javax.swing.JPanel();
        labelInputNumeralSystem = new javax.swing.JLabel();
        inputNumeralSystem = new javax.swing.JComboBox();
        panelOutpuNumeralSystem = new javax.swing.JPanel();
        labelOutputNumeralSystem = new javax.swing.JLabel();
        outputNumeralSystem = new javax.swing.JComboBox();
        panelInputNumberToConvert = new javax.swing.JPanel();
        labelInputNumberToConvert = new javax.swing.JLabel();
        inputNumberToConvert = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        resultsHistoryTable = new javax.swing.JTable();
        mainToolbar = new javax.swing.JToolBar();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        exitMenuItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        aboutMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jSplitPane2.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        upperMainPanel.setMaximumSize(new java.awt.Dimension(32767, 180));
        upperMainPanel.setMinimumSize(new java.awt.Dimension(0, 180));
        upperMainPanel.setPreferredSize(new java.awt.Dimension(645, 180));

        panelInputNumeralSystem.setMaximumSize(new java.awt.Dimension(32767, 70));
        panelInputNumeralSystem.setMinimumSize(new java.awt.Dimension(100, 70));
        panelInputNumeralSystem.setPreferredSize(new java.awt.Dimension(267, 70));

        labelInputNumeralSystem.setText("Input numeral system:");

        inputNumeralSystem.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout panelInputNumeralSystemLayout = new javax.swing.GroupLayout(panelInputNumeralSystem);
        panelInputNumeralSystem.setLayout(panelInputNumeralSystemLayout);
        panelInputNumeralSystemLayout.setHorizontalGroup(
            panelInputNumeralSystemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInputNumeralSystemLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelInputNumeralSystem)
                .addGap(18, 18, 18)
                .addComponent(inputNumeralSystem, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelInputNumeralSystemLayout.setVerticalGroup(
            panelInputNumeralSystemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInputNumeralSystemLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelInputNumeralSystemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelInputNumeralSystem)
                    .addComponent(inputNumeralSystem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        panelOutpuNumeralSystem.setMaximumSize(new java.awt.Dimension(32767, 70));
        panelOutpuNumeralSystem.setMinimumSize(new java.awt.Dimension(0, 70));
        panelOutpuNumeralSystem.setPreferredSize(new java.awt.Dimension(192, 70));

        labelOutputNumeralSystem.setText("Output numeral system:");

        outputNumeralSystem.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout panelOutpuNumeralSystemLayout = new javax.swing.GroupLayout(panelOutpuNumeralSystem);
        panelOutpuNumeralSystem.setLayout(panelOutpuNumeralSystemLayout);
        panelOutpuNumeralSystemLayout.setHorizontalGroup(
            panelOutpuNumeralSystemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelOutpuNumeralSystemLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelOutputNumeralSystem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(outputNumeralSystem, 0, 131, Short.MAX_VALUE))
        );
        panelOutpuNumeralSystemLayout.setVerticalGroup(
            panelOutpuNumeralSystemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelOutpuNumeralSystemLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelOutpuNumeralSystemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelOutputNumeralSystem)
                    .addComponent(outputNumeralSystem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        panelInputNumberToConvert.setMaximumSize(new java.awt.Dimension(32767, 140));
        panelInputNumberToConvert.setMinimumSize(new java.awt.Dimension(100, 140));
        panelInputNumberToConvert.setPreferredSize(new java.awt.Dimension(366, 140));

        labelInputNumberToConvert.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelInputNumberToConvert.setText("Number to convert:");

        inputNumberToConvert.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        inputNumberToConvert.setText("Type here...");

        javax.swing.GroupLayout panelInputNumberToConvertLayout = new javax.swing.GroupLayout(panelInputNumberToConvert);
        panelInputNumberToConvert.setLayout(panelInputNumberToConvertLayout);
        panelInputNumberToConvertLayout.setHorizontalGroup(
            panelInputNumberToConvertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInputNumberToConvertLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelInputNumberToConvert)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputNumberToConvert, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelInputNumberToConvertLayout.setVerticalGroup(
            panelInputNumberToConvertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInputNumberToConvertLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(labelInputNumberToConvert, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                .addGap(40, 40, 40))
            .addGroup(panelInputNumberToConvertLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(inputNumberToConvert)
                .addContainerGap())
        );

        javax.swing.GroupLayout upperMainPanelLayout = new javax.swing.GroupLayout(upperMainPanel);
        upperMainPanel.setLayout(upperMainPanelLayout);
        upperMainPanelLayout.setHorizontalGroup(
            upperMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(upperMainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(upperMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelOutpuNumeralSystem, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
                    .addComponent(panelInputNumeralSystem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelInputNumberToConvert, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        upperMainPanelLayout.setVerticalGroup(
            upperMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(upperMainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(upperMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelInputNumberToConvert, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(upperMainPanelLayout.createSequentialGroup()
                        .addComponent(panelInputNumeralSystem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panelOutpuNumeralSystem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jSplitPane2.setTopComponent(upperMainPanel);
        upperMainPanel.getAccessibleContext().setAccessibleName("");

        jScrollPane2.setPreferredSize(new java.awt.Dimension(452, 300));

        resultsHistoryTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(resultsHistoryTable);

        jSplitPane2.setBottomComponent(jScrollPane2);

        mainToolbar.setFloatable(false);
        mainToolbar.setRollover(true);

        fileMenu.setMnemonic('f');
        fileMenu.setText("File");

        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        helpMenu.setMnemonic('h');
        helpMenu.setText("Help");

        aboutMenuItem.setMnemonic('a');
        aboutMenuItem.setText("About");
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSplitPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 665, Short.MAX_VALUE)
                    .addComponent(mainToolbar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(mainToolbar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSplitPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

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
            java.util.logging.Logger.getLogger(MainDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainDialog().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JTextField inputNumberToConvert;
    private javax.swing.JComboBox inputNumeralSystem;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JLabel labelInputNumberToConvert;
    private javax.swing.JLabel labelInputNumeralSystem;
    private javax.swing.JLabel labelOutputNumeralSystem;
    private javax.swing.JToolBar mainToolbar;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JComboBox outputNumeralSystem;
    private javax.swing.JPanel panelInputNumberToConvert;
    private javax.swing.JPanel panelInputNumeralSystem;
    private javax.swing.JPanel panelOutpuNumeralSystem;
    private javax.swing.JTable resultsHistoryTable;
    private javax.swing.JPanel upperMainPanel;
    // End of variables declaration//GEN-END:variables

    private void executeMyInit() {
        
    }
}
