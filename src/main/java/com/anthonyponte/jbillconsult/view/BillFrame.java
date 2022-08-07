package com.anthonyponte.jbillconsult.view;

import com.anthonyponte.jbillconsult.filter.LetterNumberFilter;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AbstractDocument;
import org.kordamp.ikonli.remixicon.RemixiconAL;
import org.kordamp.ikonli.swing.FontIcon;

public class BillFrame extends javax.swing.JFrame {

    public BillFrame() {
        images = new ArrayList<>();
        images.add(new ImageIcon(getClass().getResource("/com/anthonyponte/jbillconsult/img/16x16.png")).getImage());
        images.add(new ImageIcon(getClass().getResource("/com/anthonyponte/jbillconsult/img/32x32.png")).getImage());
        images.add(new ImageIcon(getClass().getResource("/com/anthonyponte/jbillconsult/img/64x64.png")).getImage());
        images.add(new ImageIcon(getClass().getResource("/com/anthonyponte/jbillconsult/img/128x128.png")).getImage());
        images.add(new ImageIcon(getClass().getResource("/com/anthonyponte/jbillconsult/img/256x256.png")).getImage());
        images.add(new ImageIcon(getClass().getResource("/com/anthonyponte/jbillconsult/img/512x512.png")).getImage());
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tfFiltrar = new JTextField();
        scrllTable = new JScrollPane();
        table = new JTable();
        btnExportar = new JButton();
        btnImportar = new JButton();
        scrollList = new JScrollPane();
        list = new JList<>();
        menuBar = new JMenuBar();

        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("JBillConsult");
        setIconImages(images);
        setMinimumSize(new Dimension(800, 600));

        tfFiltrar.setMaximumSize(null);
        tfFiltrar.setMinimumSize(null);
        tfFiltrar.setPreferredSize(new Dimension(150, 30));
        AbstractDocument document = (AbstractDocument) tfFiltrar.getDocument();
        document.setDocumentFilter(new LetterNumberFilter());
        tfFiltrar.putClientProperty("JTextField.leadingIcon", FontIcon.of(RemixiconAL.FILTER_LINE, 16, Color.decode("#FFFFFF")));
        tfFiltrar.putClientProperty("JTextField.placeholderText", "Filtrar");
        tfFiltrar.putClientProperty("JTextField.showClearButton", true);

        table.setModel(new DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        table.getTableHeader().setReorderingAllowed(false);
        scrllTable.setViewportView(table);

        btnExportar.setIcon(FontIcon.of(RemixiconAL.FILE_EXCEL_LINE, 16, Color.decode("#FFFFFF")));
        btnExportar.setText("Exportar");
        btnExportar.setEnabled(false);
        btnExportar.setPreferredSize(new Dimension(100, 30));

        btnImportar.setIcon(FontIcon.of(RemixiconAL.FILE_SEARCH_LINE, 16, Color.decode("#FFFFFF")));
        btnImportar.setText("Importar");
        btnImportar.setMaximumSize(null);
        btnImportar.setMinimumSize(null);
        btnImportar.setPreferredSize(new Dimension(100, 30));

        list.setVisibleRowCount(6);
        scrollList.setViewportView(list);

        setJMenuBar(menuBar);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(tfFiltrar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scrllTable, GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnImportar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExportar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(scrollList))
                .addContainerGap())
        );
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(btnImportar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExportar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfFiltrar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrllTable, GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollList, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private List<Image> images;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public JButton btnExportar;
    public JButton btnImportar;
    public JList<String> list;
    public JMenuBar menuBar;
    public JScrollPane scrllTable;
    public JScrollPane scrollList;
    public JTable table;
    public JTextField tfFiltrar;
    // End of variables declaration//GEN-END:variables
}
