package com.anthonyponte.jbillconsult.view;

import com.anthonyponte.jbillconsult.filter.LetterNumberFilter;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AbstractDocument;
import org.kordamp.ikonli.remixicon.RemixiconAL;
import org.kordamp.ikonli.remixicon.RemixiconMZ;
import org.kordamp.ikonli.swing.FontIcon;

public class BillFrame extends javax.swing.JFrame {

    public BillFrame() {
        list = new ArrayList<>();
        list.add(new ImageIcon(getClass().getResource("/com/anthonyponte/jbillconsult/img/16x16.png")).getImage());
        list.add(new ImageIcon(getClass().getResource("/com/anthonyponte/jbillconsult/img/32x32.png")).getImage());
        list.add(new ImageIcon(getClass().getResource("/com/anthonyponte/jbillconsult/img/64x64.png")).getImage());
        list.add(new ImageIcon(getClass().getResource("/com/anthonyponte/jbillconsult/img/128x128.png")).getImage());
        list.add(new ImageIcon(getClass().getResource("/com/anthonyponte/jbillconsult/img/256x256.png")).getImage());
        list.add(new ImageIcon(getClass().getResource("/com/anthonyponte/jbillconsult/img/512x512.png")).getImage());
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tfFiltrar = new javax.swing.JTextField();
        scroll = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        menuBar = new javax.swing.JMenuBar();
        menu = new javax.swing.JMenu();
        miImportar = new javax.swing.JMenuItem();
        miExportar = new javax.swing.JMenuItem();
        miSalir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("JBillConsult");
        setIconImages(list);
        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));

        tfFiltrar.setMaximumSize(null);
        tfFiltrar.setMinimumSize(null);
        tfFiltrar.setPreferredSize(new java.awt.Dimension(150, 30));
        AbstractDocument document = (AbstractDocument) tfFiltrar.getDocument();
        document.setDocumentFilter(new LetterNumberFilter());
        tfFiltrar.putClientProperty("JTextField.leadingIcon", FontIcon.of(RemixiconAL.FILTER_LINE, 16, Color.decode("#FFFFFF")));
        tfFiltrar.putClientProperty("JTextField.placeholderText", "Filtrar");
        tfFiltrar.putClientProperty("JTextField.showClearButton", true);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        table.getTableHeader().setReorderingAllowed(false);
        scroll.setViewportView(table);

        menu.setIcon( FontIcon.of(RemixiconMZ.MENU_LINE, 16, Color.decode("#FFFFFF")));
        menu.setText("Menu");

        miImportar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        miImportar.setIcon(FontIcon.of(RemixiconAL.FILE_UPLOAD_LINE, 16, Color.decode("#FFFFFF")));
        miImportar.setText("Importar");
        menu.add(miImportar);

        miExportar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        miExportar.setIcon(FontIcon.of(RemixiconAL.FILE_DOWNLOAD_LINE, 16, Color.decode("#FFFFFF")));
        miExportar.setText("Exportar");
        menu.add(miExportar);

        miSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        miSalir.setIcon(FontIcon.of(RemixiconAL.LOGOUT_BOX_LINE, 16, Color.decode("#FFFFFF")));
        miSalir.setText("Salir");
        menu.add(miSalir);

        menuBar.add(menu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfFiltrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scroll))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tfFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scroll)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private List<Image> list;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JMenu menu;
    public javax.swing.JMenuBar menuBar;
    public javax.swing.JMenuItem miExportar;
    public javax.swing.JMenuItem miImportar;
    public javax.swing.JMenuItem miSalir;
    public javax.swing.JScrollPane scroll;
    public javax.swing.JTable table;
    public javax.swing.JTextField tfFiltrar;
    // End of variables declaration//GEN-END:variables
}
