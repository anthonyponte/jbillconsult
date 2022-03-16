package com.anthonyponte.jbillconsultservice.controller;

import com.anthonyponte.jbillconsultservice.view.BillFrame;
import com.anthonyponte.jbillconsultservice.view.UsuarioFrame;
import java.awt.event.ActionEvent;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class UsuarioController {

  private final UsuarioFrame frame;
  private Preferences prefs;
  public static final String RUC = "RUC";
  public static final String USUARIO = "USUARIO";
  public static final String CONTRASENA = "CONTRASENA";

  public UsuarioController(UsuarioFrame frame) {
    this.frame = frame;
    initComponents();
  }

  public void start() {
    frame.btnEntrar.addActionListener(
        (ActionEvent arg0) -> {
          try {
            if (frame.cbRecordar.isSelected()) {
              prefs.put(RUC, frame.tfRuc.getText());
              prefs.put(USUARIO, frame.tfUsuario.getText());
              prefs.put(CONTRASENA, String.valueOf(frame.tfContrasena.getPassword()));
            } else {
              prefs.clear();
            }

            frame.dispose();

            SwingUtilities.invokeLater(
                () -> {
                  BillFrame billFrame = new BillFrame();
                  new BillController(billFrame).start();
                });
          } catch (BackingStoreException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
          }
        });

    frame.tfRuc.getDocument().addDocumentListener(dl);
    frame.tfUsuario.getDocument().addDocumentListener(dl);
    frame.tfContrasena.getDocument().addDocumentListener(dl);
  }

  private void initComponents() {
    prefs = Preferences.userRoot().node(UsuarioController.class.getPackageName());

    frame.setVisible(true);

    String ruc = prefs.get(RUC, "");
    String username = prefs.get(USUARIO, "");
    String contrasena = prefs.get(CONTRASENA, "");
    if (!ruc.isEmpty() && !username.isEmpty() && !contrasena.isEmpty()) {
      frame.btnEntrar.requestFocus();
      frame.tfRuc.setText(ruc);
      frame.tfUsuario.setText(username);
      frame.tfContrasena.setText(contrasena);
      frame.cbRecordar.setSelected(true);
    } else {
      frame.tfRuc.requestFocus();
      frame.cbRecordar.setSelected(false);
    }
  }

  private final DocumentListener dl =
      new DocumentListener() {
        @Override
        public void insertUpdate(DocumentEvent arg0) {
          enable();
        }

        @Override
        public void removeUpdate(DocumentEvent arg0) {
          enable();
        }

        @Override
        public void changedUpdate(DocumentEvent arg0) {
          enable();
        }
      };

  private void enable() {
    if (frame.tfRuc.getText().length() < 11
        || frame.tfUsuario.getText().length() < 7
        || frame.tfContrasena.getPassword().length < 7) {
      frame.btnEntrar.setEnabled(false);
    } else {
      frame.btnEntrar.setEnabled(true);
    }
  }
}
