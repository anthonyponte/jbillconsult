package com.anthonyponte.jbillconsult.impl;

import com.anthonyponte.jbillconsult.controller.UsuarioController;
import jakarta.xml.ws.BindingProvider;
import jakarta.xml.ws.handler.Handler;
import jakarta.xml.ws.handler.soap.SOAPHandler;
import jakarta.xml.ws.handler.soap.SOAPMessageContext;
import java.util.ArrayList;
import java.util.List;
import java.util.prefs.Preferences;
import pe.gob.sunat.billvalidservice.BillValidService;
import pe.gob.sunat.billvalidservice.BillValidService_Service;
import pe.gob.sunat.billvalidservice.StatusResponse;

public class BillValidServiceImpl implements BillValidService {
  private static final Preferences PREFERENCES =
      Preferences.userRoot().node(UsuarioController.class.getPackageName());
  private final String RUC = PREFERENCES.get(UsuarioController.RUC, "");
  private final String USUARIO = PREFERENCES.get(UsuarioController.USUARIO, "");
  private final String CONTRASENA = PREFERENCES.get(UsuarioController.CONTRASENA, "");

  @Override
  public StatusResponse validaCDPcriterios(
      String rucEmisor,
      String tipoCDP,
      String serieCDP,
      String numeroCDP,
      String tipoDocIdReceptor,
      String numeroDocIdReceptor,
      String fechaEmision,
      Double importeTotal,
      String nroAutorizacion) {
    BillValidService_Service service = new BillValidService_Service();
    BillValidService port = service.getBillValidServicePort();
    BindingProvider binding = (BindingProvider) port;

    @SuppressWarnings("rawtypes")
    List<Handler> handlers = new ArrayList<>();
    SOAPHandler<SOAPMessageContext> handler = new SOAPHanlderImpl(RUC + USUARIO, CONTRASENA);
    handlers.add(handler);
    binding.getBinding().setHandlerChain(handlers);

    StatusResponse statusResponse =
        port.validaCDPcriterios(
            rucEmisor,
            tipoCDP,
            serieCDP,
            numeroCDP,
            tipoDocIdReceptor,
            numeroDocIdReceptor,
            fechaEmision,
            importeTotal,
            nroAutorizacion);

    return statusResponse;
  }

  @Override
  public StatusResponse verificaCPEarchivo(String nombre, String archivo) {
    BillValidService_Service service = new BillValidService_Service();
    BillValidService port = service.getBillValidServicePort();
    BindingProvider binding = (BindingProvider) port;

    @SuppressWarnings("rawtypes")
    List<Handler> handlers = new ArrayList<>();
    SOAPHandler<SOAPMessageContext> handler = new SOAPHanlderImpl(RUC + USUARIO, CONTRASENA);
    handlers.add(handler);
    binding.getBinding().setHandlerChain(handlers);

    StatusResponse statusResponse = port.verificaCPEarchivo(nombre, archivo);

    return statusResponse;
  }
}
