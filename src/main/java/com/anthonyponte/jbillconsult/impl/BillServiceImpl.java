package com.anthonyponte.jbillconsult.impl;

import com.anthonyponte.jbillconsult.controller.UsuarioController;
import jakarta.xml.ws.BindingProvider;
import jakarta.xml.ws.handler.Handler;
import jakarta.xml.ws.handler.soap.SOAPHandler;
import jakarta.xml.ws.handler.soap.SOAPMessageContext;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.prefs.Preferences;
import javax.swing.JOptionPane;
import sunat.gob.pe.BillConsultService;
import sunat.gob.pe.BillService;
import sunat.gob.pe.StatusResponse;

public class BillServiceImpl implements BillService {

  private static final Preferences PREFERENCES =
      Preferences.userRoot().node(UsuarioController.class.getPackageName());
  private final String RUC = PREFERENCES.get(UsuarioController.RUC, "");
  private final String USUARIO = PREFERENCES.get(UsuarioController.USUARIO, "");
  private final String CONTRASENA = PREFERENCES.get(UsuarioController.CONTRASENA, "");

  @Override
  public StatusResponse getStatus(
      String rucComprobante,
      String tipoComprobante,
      String serieComprobante,
      Integer numeroComprobante) {

    BillConsultService service = new BillConsultService();
    BillService port = service.getBillConsultServicePort();
    BindingProvider binding = (BindingProvider) port;

    @SuppressWarnings("rawtypes")
    List<Handler> handlers = new ArrayList<>();
    SOAPHandler<SOAPMessageContext> handler = new SOAPHanlderImpl(RUC + USUARIO, CONTRASENA);
    handlers.add(handler);
    binding.getBinding().setHandlerChain(handlers);

    StatusResponse statusResponse =
        port.getStatus(rucComprobante, tipoComprobante, serieComprobante, numeroComprobante);

    return statusResponse;
  }

  @Override
  public StatusResponse getStatusCdr(
      String rucComprobante,
      String tipoComprobante,
      String serieComprobante,
      Integer numeroComprobante) {

    BillConsultService service = new BillConsultService();
    BillService port = service.getBillConsultServicePort();
    BindingProvider binding = (BindingProvider) port;

    @SuppressWarnings("rawtypes")
    List<Handler> handlers = new ArrayList<>();
    SOAPHandler<SOAPMessageContext> handler = new SOAPHanlderImpl(RUC + USUARIO, CONTRASENA);
    handlers.add(handler);
    binding.getBinding().setHandlerChain(handlers);

    StatusResponse statusResponse =
        port.getStatusCdr(rucComprobante, tipoComprobante, serieComprobante, numeroComprobante);

    return statusResponse;
  }
}
