package com.anthonyponte.jbillconsult.glazedlist;

import ca.odell.glazedlists.gui.TableFormat;
import com.anthonyponte.jbillconsult.pojo.Bill;

public class BillTableFormat implements TableFormat<Bill> {

  @Override
  public int getColumnCount() {
    return 6;
  }

  @Override
  public String getColumnName(int i) {
    switch (i) {
      case 0:
        return "RUC";
      case 1:
        return "Tipo";
      case 2:
        return "Serie";
      case 3:
        return "Correlativo";
      case 4:
        return "Codigo";
      case 5:
        return "Estado";
      default:
        break;
    }
    throw new IllegalStateException("Unexpected column: " + i);
  }

  @Override
  public Object getColumnValue(Bill e, int i) {
    switch (i) {
      case 0:
        return e.getRuc();
      case 1:
        return e.getTipo();
      case 2:
        return e.getSerie();
      case 3:
        return e.getCorrelativo();
      case 4:
        return e.getStatusCode();
      case 5:
        return e.getStatusMessage();
      default:
        break;
    }
    throw new IllegalStateException("Unexpected column: " + i);
  }
}
