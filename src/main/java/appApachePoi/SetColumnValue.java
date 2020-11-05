package appApachePoi;

import model.Client;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

import java.io.*;

import org.apache.poi.xwpf.usermodel.*;

import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRow;

import java.util.ArrayList;

public class SetColumnValue {




        static XWPFTableRow insertNewTableRow (XWPFTableRow sourceTableRow,int pos) throws Exception {
            XWPFTable table = sourceTableRow.getTable();
            CTRow newCTRrow = CTRow.Factory.parse(sourceTableRow.getCtRow().newInputStream());
            XWPFTableRow tableRow = new XWPFTableRow(newCTRrow, table);
            table.addRow(tableRow, pos);
            return tableRow;
        }

        static void commitTableRows (XWPFTable table){
            int rowNr = 0;
            for (XWPFTableRow tableRow : table.getRows()) {
                table.getCTTbl().setTrArray(rowNr++, tableRow.getCtRow());
            }
        }

    public void setMCHSColumnValue(File source, File output,String date, Client teamleader, String companyName, String companyAddress, String companyPhoneNumber) throws IOException {

            XWPFDocument doc = new XWPFDocument(new FileInputStream(source));
            for (XWPFTable tbl : doc.getTables()) {
                for (XWPFTableRow row : tbl.getRows()) {
                    for (XWPFTableCell cell : row.getTableCells()) {
                        for (XWPFParagraph p : cell.getParagraphs()) {
                            for (XWPFRun r : p.getRuns()) {
                                String text = r.getText(0);
                                if (text != null && text.contains("$companyName")) {
                                    text = text.replace("$companyName", String.valueOf(companyName));
                                    r.setText(text, 0);
                                }
                                if (text != null && text.contains("$companyAddress")) {
                                    text = text.replace("$companyAddress", String.valueOf(companyAddress));
                                    r.setText(text, 0);
                                }
                                if (text != null && text.contains("$companyPhoneNumber")) {
                                    text = text.replace("$companyPhoneNumber", String.valueOf(companyPhoneNumber));
                                    r.setText(text, 0);
                                }
                                if (text != null && text.contains("$lastName")) {
                                    text = text.replace("$lastName", String.valueOf(teamleader.getSurname()));
                                    r.setText(text, 0);
                                }
                                if (text != null && text.contains("$firstName")) {
                                    text = text.replace("$firstName", String.valueOf(teamleader.getName()));
                                    r.setText(text, 0);
                                }
                                if (text != null && text.contains("$patronymic")) {
                                    text = text.replace("$patronymic", String.valueOf(teamleader.getPatronimic()));
                                    r.setText(text, 0);
                                }
                                if (text != null && text.contains("$age")) {
                                    text = text.replace("$age", String.valueOf(teamleader.getAge()));
                                    r.setText(text, 0);
                                }
                                if (text != null && text.contains("$phone")) {
                                    text = text.replace("$phone", String.valueOf(teamleader.getPhone()));
                                    r.setText(text, 0);
                                }
                                if (text != null && text.contains("$date")) {
                                    text = text.replace("$date", date);
                                    r.setText(text, 0);
                                }

                            }
                        }
                    }
                }
            }// now it is changed

            FileOutputStream out = new FileOutputStream(output);
            doc.write(out);
            out.close();
            doc.close();


        }

    }





