package com.anthonyponte.jbillconsult.pojo;

import com.poiji.annotation.ExcelCellName;

public class Bill {
  @ExcelCellName("RUC")
  private String ruc;

  @ExcelCellName("Tipo")
  private String tipo;

  @ExcelCellName("Serie")
  private String serie;

  @ExcelCellName("Numero")
  private int numero;

  private String statusCode;
  private String statusMessage;
  private byte[] content;
  private String cdrStatusCode;
  private String cdrStatusMessage;
  private byte[] cdrContent;

  public Bill() {}

  public Bill(String ruc, String tipo, String serie, int numero) {
    this.ruc = ruc;
    this.tipo = tipo;
    this.serie = serie;
    this.numero = numero;
  }

  public Bill(
      String ruc,
      String tipo,
      String serie,
      int numero,
      String statusCode,
      String statusMessage,
      byte[] content,
      String cdrStatusCode,
      String cdrStatusMessage,
      byte[] cdrContent) {
    this.ruc = ruc;
    this.tipo = tipo;
    this.serie = serie;
    this.numero = numero;
    this.statusCode = statusCode;
    this.statusMessage = statusMessage;
    this.content = content;
    this.cdrStatusCode = cdrStatusCode;
    this.cdrStatusMessage = cdrStatusMessage;
    this.cdrContent = cdrContent;
  }

  public String getRuc() {
    return ruc;
  }

  public void setRuc(String ruc) {
    this.ruc = ruc;
  }

  public String getTipo() {
    return tipo;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  public String getSerie() {
    return serie;
  }

  public void setSerie(String serie) {
    this.serie = serie;
  }

  public int getNumero() {
    return numero;
  }

  public void setNumero(int numero) {
    this.numero = numero;
  }

  public String getStatusCode() {
    return statusCode;
  }

  public void setStatusCode(String statusCode) {
    this.statusCode = statusCode;
  }

  public String getStatusMessage() {
    return statusMessage;
  }

  public void setStatusMessage(String statusMessage) {
    this.statusMessage = statusMessage;
  }

  public byte[] getContent() {
    return content;
  }

  public void setContent(byte[] content) {
    this.content = content;
  }

  public String getCdrStatusCode() {
    return cdrStatusCode;
  }

  public void setCdrStatusCode(String cdrStatusCode) {
    this.cdrStatusCode = cdrStatusCode;
  }

  public String getCdrStatusMessage() {
    return cdrStatusMessage;
  }

  public void setCdrStatusMessage(String cdrStatusMessage) {
    this.cdrStatusMessage = cdrStatusMessage;
  }

  public byte[] getCdrContent() {
    return cdrContent;
  }

  public void setCdrContent(byte[] cdrContent) {
    this.cdrContent = cdrContent;
  }

  @Override
  public String toString() {
    return "Bill{"
        + "ruc="
        + ruc
        + ", tipo="
        + tipo
        + ", serie="
        + serie
        + ", numero="
        + numero
        + ", statusCode="
        + statusCode
        + ", statusMessage="
        + statusMessage
        + ", content="
        + content
        + ", cdrStatusCode="
        + cdrStatusCode
        + ", cdrStatusMessage="
        + cdrStatusMessage
        + ", cdrContent="
        + cdrContent
        + '}';
  }
}
