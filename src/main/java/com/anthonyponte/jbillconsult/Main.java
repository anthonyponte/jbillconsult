package com.anthonyponte.jbillconsult;

import com.anthonyponte.jbillconsult.controller.UsuarioController;
import com.anthonyponte.jbillconsult.view.UsuarioFrame;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLaf;
import javax.swing.SwingUtilities;

public class Main {

  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        () -> {
          FlatLaf.registerCustomDefaultsSource("com.anthonyponte.F.theme");
          FlatDarkLaf.setup();
          UsuarioFrame userFrame = new UsuarioFrame();
          new UsuarioController(userFrame).init();
        });
  }
}
