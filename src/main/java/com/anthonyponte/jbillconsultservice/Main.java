package com.anthonyponte.jbillconsultservice;

import com.anthonyponte.jbillconsultservice.controller.UsuarioController;
import com.anthonyponte.jbillconsultservice.view.UsuarioFrame;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLaf;
import javax.swing.SwingUtilities;

public class Main {

  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        () -> {
          FlatLaf.registerCustomDefaultsSource("com.anthonyponte.jbillconsultservice.theme");
          FlatDarkLaf.setup();
          UsuarioFrame userFrame = new UsuarioFrame();
          new UsuarioController(userFrame).start();
        });
  }
}
