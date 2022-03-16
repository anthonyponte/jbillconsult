package com.anthonyponte.jbillconsultservice.controller;

import ca.odell.glazedlists.BasicEventList;
import ca.odell.glazedlists.EventList;
import ca.odell.glazedlists.FilterList;
import ca.odell.glazedlists.SortedList;
import ca.odell.glazedlists.TextFilterator;
import ca.odell.glazedlists.gui.TableFormat;
import ca.odell.glazedlists.matchers.MatcherEditor;
import ca.odell.glazedlists.swing.AdvancedListSelectionModel;
import ca.odell.glazedlists.swing.AdvancedTableModel;
import ca.odell.glazedlists.swing.DefaultEventSelectionModel;
import static ca.odell.glazedlists.swing.GlazedListsSwing.eventTableModelWithThreadProxyList;
import ca.odell.glazedlists.swing.TableComparatorChooser;
import ca.odell.glazedlists.swing.TextComponentMatcherEditor;
import com.anthonyponte.jbillconsultservice.pojo.Bill;
import com.anthonyponte.jbillconsultservice.impl.BillServiceImpl;
import com.anthonyponte.jbillconsultservice.view.BillFrame;
import com.anthonyponte.jbillconsultservice.view.LoadingDialog;
import com.anthonyponte.jbillconsultservice.view.UsuarioFrame;
import com.poiji.bind.Poiji;
import java.awt.AWTException;
import java.awt.Color;
import java.awt.Component;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.TrayIcon.MessageType;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingWorker;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.kordamp.ikonli.remixicon.RemixiconMZ;
import org.kordamp.ikonli.swing.FontIcon;
import pe.gob.sunat.BillService;
import pe.gob.sunat.StatusResponse;

public class BillController {

  private final BillFrame frame;
  private LoadingDialog dialog;
  private BillService service;
  private String os;
  private EventList<Bill> eventList;
  private SortedList<Bill> sortedList;
  private AdvancedListSelectionModel<Bill> selectionModel;
  private AdvancedTableModel<Bill> model;

  public BillController(BillFrame frame) {
    this.frame = frame;
    initComponents();
  }

  public void init() {
    frame.setVisible(true);

    frame.miImport.addActionListener(
        (ActionEvent arg0) -> {
          JFileChooser chooser = new JFileChooser();
          chooser.setDialogTitle("Importar Excel");
          chooser.setApproveButtonText("Importar");
          chooser.setAcceptAllFileFilterUsed(false);
          chooser.addChoosableFileFilter(
              new FileNameExtensionFilter("Archivo Excel", "xls", "xlsx"));
          chooser.setCurrentDirectory(new File("."));

          int result = chooser.showOpenDialog(frame);
          if (result == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            setToTable(file);
          }
        });

    frame.miExport.addActionListener(
        (ActionEvent arg0) -> {
          SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
          String dateString = format.format(new Date());

          JFileChooser chooser = new JFileChooser();
          chooser.setDialogTitle("Exportar Excel");
          chooser.setApproveButtonText("Exportar");
          chooser.setAcceptAllFileFilterUsed(false);
          chooser.addChoosableFileFilter(new FileNameExtensionFilter("Archivo Excel file", "xlsx"));
          chooser.setSelectedFile(new File(dateString.concat(".xlsx")));
          chooser.setCurrentDirectory(new File("."));

          int result = chooser.showSaveDialog(frame);
          if (result == JFileChooser.APPROVE_OPTION) {

            SwingWorker worker =
                new SwingWorker<XSSFWorkbook, Integer>() {
                  @Override
                  protected XSSFWorkbook doInBackground() throws Exception {

                    dialog.setVisible(true);
                    dialog.setLocationRelativeTo(frame);
                    dialog.progressBar.setMinimum(0);
                    dialog.progressBar.setMaximum(model.getRowCount());

                    XSSFWorkbook workbook = new XSSFWorkbook();
                    XSSFSheet sheet = workbook.createSheet("Comprobantes");

                    for (int r = 0; r < model.getRowCount(); r++) {
                      XSSFRow row = sheet.createRow(r);
                      for (int c = 0; c < model.getColumnCount(); c++) {
                        XSSFCell cell = row.createCell(c);
                        if (r == 0) {
                          cell.setCellValue(model.getColumnName(c));
                        }
                      }
                    }

                    for (int r = 0; r < model.getRowCount(); r++) {
                      XSSFRow row = sheet.createRow(r + 1);
                      Bill bill = model.getElementAt(r);
                      publish(r);

                      for (int c = 0; c < model.getColumnCount(); c++) {
                        XSSFCell cell = row.createCell(c);
                        sheet.autoSizeColumn(c);

                        switch (cell.getColumnIndex()) {
                          case 0:
                            cell.setCellValue(bill.getRuc());
                            break;
                          case 1:
                            cell.setCellValue(bill.getTipo());
                            break;
                          case 2:
                            cell.setCellValue(bill.getSerie());
                            break;
                          case 3:
                            cell.setCellValue(bill.getNumero());
                            break;
                          case 4:
                            cell.setCellValue(bill.getCdrStatusCode());
                            break;
                          case 5:
                            cell.setCellValue(bill.getStatusMessage());
                            break;
                          default:
                            break;
                        }
                      }
                    }

                    return workbook;
                  }

                  @Override
                  protected void process(List<Integer> chunks) {
                    dialog.progressBar.setValue(chunks.get(0));
                  }

                  @Override
                  protected void done() {
                    try {
                      XSSFWorkbook workbook = get();
                      File file = chooser.getSelectedFile();

                      try (FileOutputStream out = new FileOutputStream(file)) {
                        workbook.write(out);
                      }

                      dialog.dispose();

                      if (os.compareToIgnoreCase("linux") < 0) {
                        showNotification(
                            "Se exporto correctamente el archivo en la ruta "
                                + file.getAbsolutePath(),
                            MessageType.INFO);
                      }
                    } catch (InterruptedException | ExecutionException | IOException ex) {
                      Logger.getLogger(BillController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                  }
                };

            worker.execute();
          }
        });

    frame.miSignOut.addActionListener(
        (ActionEvent arg0) -> {
          System.exit(0);
        });

    frame.scroll.setDropTarget(
        new DropTarget() {
          @Override
          public synchronized void drop(DropTargetDropEvent dtde) {
            if (dtde.isDataFlavorSupported(DataFlavor.javaFileListFlavor)) {
              try {
                dtde.acceptDrop(DnDConstants.ACTION_COPY_OR_MOVE);
                Transferable t = dtde.getTransferable();
                List fileList = (List) t.getTransferData(DataFlavor.javaFileListFlavor);

                if (fileList != null && !fileList.isEmpty()) {
                  for (Object value : fileList) {
                    if (value instanceof File) {
                      File file = (File) value;
                      setToTable(file);
                    }
                  }
                }
              } catch (UnsupportedFlavorException | IOException ex) {
                Logger.getLogger(BillController.class.getName()).log(Level.SEVERE, null, ex);

                JOptionPane.showMessageDialog(
                    frame, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
              }
            } else {
              dtde.rejectDrop();
            }
          }
        });

    frame.table.addMouseListener(
        new MouseAdapter() {
          @Override
          public void mouseClicked(MouseEvent e) {
            if (e.getClickCount() == 2) {
              Bill selected = selectionModel.getSelected().get(0);

              if (selected.getStatusCode().equals("0001")
                  || selected.getStatusCode().equals("0002")
                  || selected.getStatusCode().equals("0003")) {

                SwingWorker worker =
                    new SwingWorker<Bill, Integer>() {
                      @Override
                      protected Bill doInBackground() throws Exception {
                        dialog.setVisible(true);
                        dialog.setLocationRelativeTo(frame);

                        dialog.progressBar.setMinimum(0);
                        dialog.progressBar.setMaximum(100);

                        publish(0);
                        StatusResponse statusResponse =
                            service.getStatusCdr(
                                selected.getRuc(),
                                selected.getTipo(),
                                selected.getSerie(),
                                selected.getNumero());

                        selected.setCdrStatusCode(statusResponse.getStatusCode());
                        selected.setCdrStatusMessage(statusResponse.getStatusMessage());
                        selected.setCdrContent(statusResponse.getContent());
                        publish(100);

                        return selected;
                      }

                      @Override
                      protected void process(List<Integer> chunks) {
                        dialog.progressBar.setValue(chunks.get(0));
                      }

                      @Override
                      protected void done() {
                        try {
                          dialog.dispose();

                          Bill bill = get();

                          if (os.compareToIgnoreCase("linux") < 0) {
                            showNotification(
                                bill.getCdrStatusCode() + " - " + bill.getCdrStatusMessage(),
                                MessageType.INFO);
                          }

                          if (bill.getCdrStatusCode().equals("0004")) {
                            JFileChooser chooser = new JFileChooser();
                            chooser.setCurrentDirectory(new File("."));
                            chooser.setSelectedFile(
                                new File(
                                    "R-"
                                        + bill.getRuc()
                                        + "-"
                                        + bill.getNumero()
                                        + "-"
                                        + bill.getSerie()
                                        + "-"
                                        + bill.getNumero()
                                        + ".zip"));

                            int result = chooser.showSaveDialog(frame);
                            if (result == JFileChooser.APPROVE_OPTION) {
                              File file = chooser.getSelectedFile().getAbsoluteFile();
                              try (FileOutputStream fout =
                                  new FileOutputStream(file.getParent() + "//" + file.getName())) {
                                fout.write(bill.getCdrContent());
                                fout.flush();
                                fout.close();
                              } catch (FileNotFoundException ex) {
                                Logger.getLogger(BillController.class.getName())
                                    .log(Level.SEVERE, null, ex);
                              } catch (IOException ex) {
                                Logger.getLogger(BillController.class.getName())
                                    .log(Level.SEVERE, null, ex);
                              }
                            }
                          }
                        } catch (InterruptedException | ExecutionException ex) {
                          Logger.getLogger(BillController.class.getName())
                              .log(Level.SEVERE, null, ex);
                        }
                      }
                    };

                worker.execute();
              }
            }
          }
        });
  }

  private void initComponents() {
    dialog = new LoadingDialog(frame, false);
    service = new BillServiceImpl();
    os = System.getProperty("os.name");

    eventList = new BasicEventList<>();

    Comparator comparator =
        (Comparator<Bill>) (Bill o1, Bill o2) -> o1.getNumero() - o2.getNumero();

    sortedList = new SortedList<>(eventList, comparator);

    TextFilterator<Bill> textFilterator =
        (List<String> baseList, Bill element) -> {
          baseList.add(element.getRuc());
          baseList.add(element.getTipo());
          baseList.add(element.getSerie());
          baseList.add(String.valueOf(element.getNumero()));
          baseList.add(element.getStatusCode());
          baseList.add(element.getStatusMessage());
        };

    MatcherEditor<Bill> matcherEditor =
        new TextComponentMatcherEditor<>(this.frame.tfFiltrar, textFilterator);

    FilterList<Bill> filterList = new FilterList<>(sortedList, matcherEditor);

    TableFormat<Bill> tableFormat =
        new TableFormat<Bill>() {
          @Override
          public int getColumnCount() {
            return 6;
          }

          @Override
          public String getColumnName(int column) {
            switch (column) {
              case 0:
                return "RUC";
              case 1:
                return "Tipo";
              case 2:
                return "Serie";
              case 3:
                return "Numero";
              case 4:
                return "Codigo";
              case 5:
                return "Estado";
              default:
                break;
            }
            throw new IllegalStateException("Unexpected column: " + column);
          }

          @Override
          public Object getColumnValue(Bill baseObject, int column) {
            switch (column) {
              case 0:
                return baseObject.getRuc();
              case 1:
                return baseObject.getTipo();
              case 2:
                return baseObject.getSerie();
              case 3:
                return baseObject.getNumero();
              case 4:
                return baseObject.getStatusCode();
              case 5:
                return baseObject.getStatusMessage();
              default:
                break;
            }
            throw new IllegalStateException("Unexpected column: " + column);
          }
        };

    model = eventTableModelWithThreadProxyList(filterList, tableFormat);

    selectionModel = new DefaultEventSelectionModel<>(filterList);

    frame.table.setModel(model);

    frame.table.setSelectionModel(selectionModel);

    TableComparatorChooser.install(
        frame.table, sortedList, TableComparatorChooser.MULTIPLE_COLUMN_MOUSE);

    frame.table.requestFocus();
  }

  private void setToTable(File file) {
    dialog.setVisible(true);
    dialog.setLocationRelativeTo(frame);

    SwingWorker worker =
        new SwingWorker<List<Bill>, Void>() {
          @Override
          protected List<Bill> doInBackground() throws Exception {
            List<Bill> list = Poiji.fromExcel(file, Bill.class);
            for (int i = 0; i < list.size(); i++) {
              Bill bill = (Bill) list.get(i);

              StatusResponse statusResponse =
                  service.getStatus(
                      bill.getRuc(), bill.getTipo(), bill.getSerie(), bill.getNumero());

              list.get(i).setStatusCode(statusResponse.getStatusCode());
              list.get(i).setCdrStatusMessage(statusResponse.getStatusMessage());
            }
            return list;
          }

          @Override
          protected void done() {
            try {
              dialog.dispose();

              List<Bill> bills = get();

              eventList.clear();
              eventList.addAll(bills);

              if (os.compareToIgnoreCase("linux") < 0) {
                showNotification(
                    "Se consultaron " + bills.size() + " comprobantes", MessageType.INFO);
              }

              TableCellRenderer renderer =
                  new DefaultTableCellRenderer() {
                    @Override
                    public Component getTableCellRendererComponent(
                        JTable table,
                        Object value,
                        boolean isSelected,
                        boolean hasFocus,
                        int row,
                        int column) {

                      JLabel label =
                          (JLabel)
                              super.getTableCellRendererComponent(
                                  table, value, isSelected, hasFocus, row, column);

                      Bill bill = model.getElementAt(row);

                      switch (bill.getStatusCode()) {
                        case "0001":
                          label.setForeground(Color.decode("#AED581"));
                          break;
                        case "0002":
                          label.setForeground(Color.decode("#FFF176"));
                          break;
                        case "0003":
                          label.setForeground(Color.decode("#E57373"));
                          break;
                        case "0004":
                        case "0005":
                        case "0006":
                        case "0007":
                        case "0008":
                        case "0009":
                        case "0010":
                        case "0011":
                        case "0012":
                          label.setForeground(Color.decode("#BBBBBB"));
                          break;
                      }

                      return label;
                    }
                  };

              frame.table.getColumnModel().getColumn(5).setCellRenderer(renderer);

              TableColumnModel tcm = frame.table.getColumnModel();
              tcm.getColumn(0).setPreferredWidth(100);
              tcm.getColumn(1).setPreferredWidth(50);
              tcm.getColumn(2).setPreferredWidth(50);
              tcm.getColumn(3).setPreferredWidth(100);
              tcm.getColumn(4).setPreferredWidth(50);
              tcm.getColumn(5).setPreferredWidth(350);
            } catch (InterruptedException | ExecutionException ex) {
              Logger.getLogger(BillController.class.getName()).log(Level.SEVERE, null, ex);

              dialog.dispose();

              if (os.compareToIgnoreCase("linux") < 0) {
                showNotification("Error en clave SOL", MessageType.ERROR);
              }

              int input =
                  JOptionPane.showOptionDialog(
                      frame,
                      ex.getMessage(),
                      "Error",
                      JOptionPane.DEFAULT_OPTION,
                      JOptionPane.ERROR_MESSAGE,
                      null,
                      null,
                      null);

              if (input == JOptionPane.OK_OPTION) {
                frame.dispose();
                UsuarioFrame userFrame = new UsuarioFrame();
                new UsuarioController(userFrame).init();
              }
            }
          }
        };

    worker.execute();
  }

  private void showNotification(String message, MessageType type) {
    try {
      SystemTray tray = SystemTray.getSystemTray();
      TrayIcon icon =
          new TrayIcon(
              FontIcon.of(RemixiconMZ.NOTIFICATION_LINE, 16, Color.decode("#FFFFFF"))
                  .toImageIcon()
                  .getImage(),
              "JBillConsultService");
      icon.setImageAutoSize(true);
      icon.displayMessage("JBillStatus", message, type);
      tray.add(icon);
    } catch (AWTException ex) {
      Logger.getLogger(BillController.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
}
