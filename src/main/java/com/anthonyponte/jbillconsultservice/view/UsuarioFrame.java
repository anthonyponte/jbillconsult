package com.anthonyponte.jbillconsultservice.view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

public class UsuarioFrame extends javax.swing.JFrame {

    public UsuarioFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tfUsuario = new JTextField();
        tfContrasena = new JPasswordField();
        btnEntrar = new JButton();
        cbRecordar = new JCheckBox();
        tfRuc = new JFormattedTextField();
        lblRuc = new JLabel();
        lblUsername = new JLabel();
        lblPassword = new JLabel();
        jSeparator1 = new JSeparator();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Clave SOL");
        setResizable(false);

        tfUsuario.setMaximumSize(null);
        tfUsuario.setMinimumSize(null);
        tfUsuario.setPreferredSize(new Dimension(300, 30));
        tfUsuario.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                tfUsuarioKeyTyped(evt);
            }
        });

        tfContrasena.setMaximumSize(null);
        tfContrasena.setMinimumSize(null);
        tfContrasena.setPreferredSize(new Dimension(300, 30));

        btnEntrar.setText("Entrar");
        btnEntrar.setEnabled(false);
        btnEntrar.setMaximumSize(null);
        btnEntrar.setMinimumSize(null);
        btnEntrar.setPreferredSize(new Dimension(300, 30));

        cbRecordar.setText("Recordar");

        try {
            tfRuc.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("###########")));
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        tfRuc.setMaximumSize(null);
        tfRuc.setMinimumSize(null);
        tfRuc.setPreferredSize(new Dimension(300, 30));

        lblRuc.setFont(lblRuc.getFont().deriveFont(lblRuc.getFont().getStyle() | Font.BOLD, lblRuc.getFont().getSize()-2));
        lblRuc.setText("RUC");
        lblRuc.setRequestFocusEnabled(false);

        lblUsername.setFont(lblUsername.getFont().deriveFont(lblUsername.getFont().getStyle() | Font.BOLD, lblUsername.getFont().getSize()-2));
        lblUsername.setText("Usuario");
        lblUsername.setRequestFocusEnabled(false);

        lblPassword.setFont(lblPassword.getFont().deriveFont(lblPassword.getFont().getStyle() | Font.BOLD, lblPassword.getFont().getSize()-2));
        lblPassword.setText("Contraseña");
        lblPassword.setRequestFocusEnabled(false);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(tfContrasena, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfUsuario, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfRuc, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblRuc)
                    .addComponent(lblUsername)
                    .addComponent(lblPassword)
                    .addComponent(cbRecordar)
                    .addComponent(btnEntrar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1, GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblRuc)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfRuc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblUsername)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblPassword)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfContrasena, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbRecordar)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEntrar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tfUsuarioKeyTyped(KeyEvent evt) {//GEN-FIRST:event_tfUsuarioKeyTyped
        char keyChar = evt.getKeyChar();
        if (Character.isLowerCase(keyChar)) {
            evt.setKeyChar(Character.toUpperCase(keyChar));
        }
    }//GEN-LAST:event_tfUsuarioKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public JButton btnEntrar;
    public JCheckBox cbRecordar;
    public JSeparator jSeparator1;
    public JLabel lblPassword;
    public JLabel lblRuc;
    public JLabel lblUsername;
    public JPasswordField tfContrasena;
    public JFormattedTextField tfRuc;
    public JTextField tfUsuario;
    // End of variables declaration//GEN-END:variables
}
