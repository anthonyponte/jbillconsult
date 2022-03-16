package com.anthonyponte.jbillconsultservice.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;
import org.kordamp.ikonli.remixicon.RemixiconAL;
import org.kordamp.ikonli.swing.FontIcon;

public class UsuarioFrame extends javax.swing.JFrame {

    public UsuarioFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblRuc = new JLabel();
        lblUsuario = new JLabel();
        tfUsuario = new JTextField();
        lblContasena = new JLabel();
        tfContrasena = new JPasswordField();
        separator = new JSeparator();
        cbRecordar = new JCheckBox();
        btnEntrar = new JButton();
        tfRuc = new JTextField();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Clave SOL");
        setResizable(false);

        lblRuc.setFont(lblRuc.getFont().deriveFont(lblRuc.getFont().getStyle() | Font.BOLD, lblRuc.getFont().getSize()-2));
        lblRuc.setText("RUC");
        lblRuc.setRequestFocusEnabled(false);

        lblUsuario.setFont(lblUsuario.getFont().deriveFont(lblUsuario.getFont().getStyle() | Font.BOLD, lblUsuario.getFont().getSize()-2));
        lblUsuario.setText("Usuario");
        lblUsuario.setRequestFocusEnabled(false);

        tfUsuario.setMaximumSize(null);
        tfUsuario.setMinimumSize(null);
        tfUsuario.setPreferredSize(new Dimension(300, 30));

        lblContasena.setFont(lblContasena.getFont().deriveFont(lblContasena.getFont().getStyle() | Font.BOLD, lblContasena.getFont().getSize()-2));
        lblContasena.setText("Contraseña");
        lblContasena.setRequestFocusEnabled(false);

        tfContrasena.setMaximumSize(null);
        tfContrasena.setMinimumSize(null);
        tfContrasena.setPreferredSize(new Dimension(300, 30));

        cbRecordar.setText("Recordar");

        btnEntrar.setIcon(FontIcon.of(RemixiconAL.LOGIN_BOX_LINE, 16, Color.decode("#FFFFFF")));
        btnEntrar.setText("Entrar");
        btnEntrar.setEnabled(false);
        btnEntrar.setMaximumSize(null);
        btnEntrar.setMinimumSize(null);
        btnEntrar.setPreferredSize(new Dimension(300, 30));

        tfRuc.setMaximumSize(null);
        tfRuc.setMinimumSize(null);
        tfRuc.setPreferredSize(new Dimension(300, 30));

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(lblRuc)
                    .addComponent(lblUsuario)
                    .addComponent(lblContasena)
                    .addComponent(cbRecordar)
                    .addComponent(tfContrasena, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfUsuario, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEntrar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(separator, GroupLayout.Alignment.TRAILING)
                    .addComponent(tfRuc, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblRuc)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfRuc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblUsuario)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblContasena)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfContrasena, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbRecordar)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEntrar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public JButton btnEntrar;
    public JCheckBox cbRecordar;
    public JLabel lblContasena;
    public JLabel lblRuc;
    public JLabel lblUsuario;
    public JSeparator separator;
    public JPasswordField tfContrasena;
    public JTextField tfRuc;
    public JTextField tfUsuario;
    // End of variables declaration//GEN-END:variables
}
