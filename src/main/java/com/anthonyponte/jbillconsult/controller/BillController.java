package com.anthonyponte.jbillconsult.controller;

import ca.odell.glazedlists.BasicEventList;
import ca.odell.glazedlists.EventList;
import ca.odell.glazedlists.FilterList;
import ca.odell.glazedlists.SortedList;
import ca.odell.glazedlists.matchers.MatcherEditor;
import ca.odell.glazedlists.swing.AdvancedListSelectionModel;
import ca.odell.glazedlists.swing.AdvancedTableModel;
import ca.odell.glazedlists.swing.DefaultEventSelectionModel;
import static ca.odell.glazedlists.swing.GlazedListsSwing.eventTableModelWithThreadProxyList;
import ca.odell.glazedlists.swing.TableComparatorChooser;
import ca.odell.glazedlists.swing.TextComponentMatcherEditor;
import com.anthonyponte.jbillconsult.glazedlist.BillTableFormat;
import com.anthonyponte.jbillconsult.glazedlist.BillTextFilterator;
import com.anthonyponte.jbillconsult.glazedlist.StatusMessageSelect;
import com.anthonyponte.jbillconsult.pojo.Bill;
import com.anthonyponte.jbillconsult.impl.BillServiceImpl;
import com.anthonyponte.jbillconsult.view.BillFrame;
import com.anthonyponte.jbillconsult.view.LoadingDialog;
import com.anthonyponte.jbillconsult.view.UsuarioFrame;
import com.poiji.bind.Poiji;
import java.awt.Component;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingWorker;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import sunat.gob.pe.BillService;
import sunat.gob.pe.StatusResponse;

public class BillController {

  private final BillFrame frame;
  private LoadingDialog dialog;
  private BillService service;
  private EventList<Bill> eventList;
  private SortedList<Bill> sortedList;
  private AdvancedListSelectionModel<Bill> selectionModel;
  private AdvancedTableModel<Bill> model;

  public BillController(BillFrame frame) {
    this.frame = frame;
    initComponents();
  }

  public void init() {
    frame.btnImportar.addActionListener(
        (ActionEvent arg0) -> {
          JFileChooser chooser = new JFileChooser();
          chooser.setDialogTitle("Importar");
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

    frame.btnExportar.addActionListener(
        (ActionEvent arg0) -> {
          SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
          String dateString = format.format(new Date());

          JFileChooser chooser = new JFileChooser();
          chooser.setDialogTitle("Exportar");
          chooser.setApproveButtonText("Exportar");
          chooser.setAcceptAllFileFilterUsed(false);
          chooser.addChoosableFileFilter(new FileNameExtensionFilter("Archivo Excel", "xlsx"));
          chooser.setSelectedFile(new File(dateString.concat(".xlsx")));
          chooser.setCurrentDirectory(new File("."));

          int result = chooser.showSaveDialog(frame);
          if (result == JFileChooser.APPROVE_OPTION) {
            dialog.setVisible(true);
            dialog.setLocationRelativeTo(frame);

            SwingWorker worker =
                new SwingWorker<XSSFWorkbook, Integer>() {
                  @Override
                  protected XSSFWorkbook doInBackground() throws Exception {
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
                            cell.setCellValue(bill.getCorrelativo());
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

                      publish(r);
                    }

                    return workbook;
                  }

                  @Override
                  protected void process(List<Integer> chunks) {
                    dialog.progressBar.setValue(chunks.get(0));
                  }

                  @Override
                  protected void done() {
                    dialog.dispose();

                    try {
                      XSSFWorkbook get = get();
                      File file = chooser.getSelectedFile();

                      try (FileOutputStream out = new FileOutputStream(file)) {
                        get.write(out);
                      }
                    } catch (InterruptedException | ExecutionException | IOException ex) {
                      JOptionPane.showMessageDialog(
                          frame,
                          ex.getMessage(),
                          BillController.class.getSimpleName(),
                          JOptionPane.ERROR_MESSAGE);
                    }
                  }
                };

            worker.execute();
          }
        });

    frame.scrllTable.setDropTarget(
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
                JOptionPane.showMessageDialog(
                    frame,
                    ex.getMessage(),
                    BillController.class.getSimpleName(),
                    JOptionPane.ERROR_MESSAGE);
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
                dialog.setVisible(true);
                dialog.setLocationRelativeTo(frame);

                SwingWorker worker =
                    new SwingWorker<Bill, Integer>() {
                      @Override
                      protected Bill doInBackground() throws Exception {
                        try {
                          dialog.progressBar.setMinimum(0);
                          dialog.progressBar.setMaximum(100);

                          publish(0);

                          StatusResponse statusResponse =
                              service.getStatusCdr(
                                  selected.getRuc(),
                                  selected.getTipo(),
                                  selected.getSerie(),
                                  selected.getCorrelativo());

                          selected.setCdrStatusCode(statusResponse.getStatusCode());
                          selected.setCdrStatusMessage(statusResponse.getStatusMessage());
                          selected.setCdrContent(statusResponse.getContent());

                          publish(100);
                        } catch (Exception ex) {
                          cancel(true);

                          JOptionPane.showMessageDialog(
                              frame,
                              ex.getMessage(),
                              BillController.class.getSimpleName(),
                              JOptionPane.ERROR_MESSAGE);
                        }

                        return selected;
                      }

                      @Override
                      protected void process(List<Integer> chunks) {
                        dialog.progressBar.setValue(chunks.get(0));
                      }

                      @Override
                      protected void done() {
                        dialog.dispose();

                        if (!isCancelled()) {
                          try {
                            Bill get = get();

                            if (get.getCdrStatusCode().equals("0004")) {

                              String[] options = {"Guardar CDR"};
                              int input =
                                  JOptionPane.showOptionDialog(
                                      frame,
                                      get.getCdrStatusCode() + " - " + get.getCdrStatusMessage(),
                                      BillController.class.getSimpleName(),
                                      JOptionPane.DEFAULT_OPTION,
                                      JOptionPane.INFORMATION_MESSAGE,
                                      null,
                                      options,
                                      null);

                              if (input == 0) {
                                JFileChooser chooser = new JFileChooser();
                                chooser.setDialogTitle("Guardar");
                                chooser.setApproveButtonText("Guardar");
                                chooser.setAcceptAllFileFilterUsed(false);
                                chooser.addChoosableFileFilter(
                                    new FileNameExtensionFilter("Archivo Zip", "zip"));
                                chooser.setCurrentDirectory(new File("."));
                                chooser.setSelectedFile(
                                    new File(
                                        "R-"
                                            + get.getRuc()
                                            + "-"
                                            + get.getCorrelativo()
                                            + "-"
                                            + get.getSerie()
                                            + "-"
                                            + get.getCorrelativo()
                                            + ".zip"));

                                int result = chooser.showSaveDialog(frame);
                                if (result == JFileChooser.APPROVE_OPTION) {
                                  File file = chooser.getSelectedFile().getAbsoluteFile();
                                  try (FileOutputStream fout =
                                      new FileOutputStream(
                                          file.getParent() + "//" + file.getName())) {
                                    fout.write(get.getCdrContent());
                                    fout.flush();
                                    fout.close();
                                  } catch (FileNotFoundException ex) {
                                    JOptionPane.showMessageDialog(
                                        frame,
                                        ex.getMessage(),
                                        BillController.class.getSimpleName(),
                                        JOptionPane.ERROR_MESSAGE);
                                  } catch (IOException ex) {
                                    JOptionPane.showMessageDialog(
                                        frame,
                                        ex.getMessage(),
                                        BillController.class.getSimpleName(),
                                        JOptionPane.ERROR_MESSAGE);
                                  }
                                }
                              }
                            } else {
                              JOptionPane.showMessageDialog(
                                  frame,
                                  get.getCdrStatusCode() + " - " + get.getCdrStatusMessage(),
                                  BillController.class.getSimpleName(),
                                  JOptionPane.WARNING_MESSAGE);
                            }
                          } catch (InterruptedException | ExecutionException ex) {
                            JOptionPane.showMessageDialog(
                                frame,
                                ex.getMessage(),
                                BillController.class.getSimpleName(),
                                JOptionPane.ERROR_MESSAGE);
                          }
                        }
                      }
                    };

                worker.execute();
              }
            }
          }
        });

    frame.addWindowListener(
        new WindowListener() {
          @Override
          public void windowOpened(WindowEvent e) {}

          @Override
          public void windowClosing(WindowEvent e) {
            int input =
                JOptionPane.showConfirmDialog(
                    frame,
                    "Seguro que desea salir?",
                    BillController.class.getSimpleName(),
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);

            if (input == JOptionPane.YES_OPTION) {
              frame.dispose();
            }
          }

          @Override
          public void windowClosed(WindowEvent e) {}

          @Override
          public void windowIconified(WindowEvent e) {}

          @Override
          public void windowDeiconified(WindowEvent e) {}

          @Override
          public void windowActivated(WindowEvent e) {}

          @Override
          public void windowDeactivated(WindowEvent e) {}
        });
  }

  private void initComponents() {
    dialog = new LoadingDialog(frame, false);
    service = new BillServiceImpl();
    eventList = new BasicEventList<>();

    Comparator<Bill> comparator = Comparator.comparing(Bill::getCorrelativo);

    sortedList = new SortedList<>(eventList, comparator);

    StatusMessageSelect messageSelect = new StatusMessageSelect(frame.list, sortedList);
    messageSelect.confJList();
    
    FilterList<Bill> slStatusMessage = new FilterList<>(sortedList, messageSelect);

    MatcherEditor<Bill> matcherEditor =
        new TextComponentMatcherEditor<>(this.frame.tfFiltrar, new BillTextFilterator());

    FilterList<Bill> flBills = new FilterList<>(slStatusMessage, matcherEditor);

    model = eventTableModelWithThreadProxyList(flBills, new BillTableFormat());

    selectionModel = new DefaultEventSelectionModel<>(flBills);

    frame.table.setModel(model);

    frame.table.setSelectionModel(selectionModel);

    TableComparatorChooser.install(
        frame.table, sortedList, TableComparatorChooser.MULTIPLE_COLUMN_MOUSE);

    frame.setVisible(true);

    frame.table.requestFocus();
  }

  private void setToTable(File file) {
    dialog.setVisible(true);
    dialog.setLocationRelativeTo(frame);

    SwingWorker worker =
        new SwingWorker<List<Bill>, Integer>() {
          @Override
          protected List<Bill> doInBackground() throws Exception {
            List<Bill> list = null;

            try {
              list = Poiji.fromExcel(file, Bill.class);
              int size = list.size();

              dialog.progressBar.setMinimum(0);
              dialog.progressBar.setMaximum(size);

              for (int i = 0; i < list.size(); i++) {
                Bill bill = (Bill) list.get(i);

                StatusResponse statusResponse =
                    service.getStatus(
                        bill.getRuc(), bill.getTipo(), bill.getSerie(), bill.getCorrelativo());

                list.get(i).setStatusCode(statusResponse.getStatusCode());
                list.get(i).setStatusMessage(statusResponse.getStatusMessage());

                publish(i);
              }
            } catch (Exception ex) {
              cancel(true);

              JOptionPane.showMessageDialog(
                  frame,
                  ex.getMessage(),
                  BillController.class.getSimpleName(),
                  JOptionPane.ERROR_MESSAGE);
            }

            return list;
          }

          @Override
          protected void process(List<Integer> chunks) {
            dialog.progressBar.setValue(chunks.get(0));
          }

          @Override
          protected void done() {
            dialog.dispose();

            if (!isCancelled()) {
              try {
                List<Bill> get = get();

                eventList.clear();
                eventList.addAll(get);

                resize(frame.table);

                frame.btnExportar.setEnabled(true);

                frame.tfFiltrar.requestFocus();
              } catch (InterruptedException | ExecutionException ex) {
                int input =
                    JOptionPane.showOptionDialog(
                        frame,
                        ex.getMessage(),
                        BillController.class.getSimpleName(),
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
          }
        };

    worker.execute();
  }

  public void resize(JTable table) {
    TableColumnModel columnModel = table.getColumnModel();
    for (int column = 0; column < table.getColumnCount(); column++) {
      int width = 100;
      for (int row = 0; row < table.getRowCount(); row++) {
        TableCellRenderer renderer = table.getCellRenderer(row, column);
        Component comp = table.prepareRenderer(renderer, row, column);
        width = Math.max(comp.getPreferredSize().width + 1, width);
      }
      if (width > 300) {
        width = 300;
      }
      columnModel.getColumn(column).setPreferredWidth(width);
    }
  }
}
