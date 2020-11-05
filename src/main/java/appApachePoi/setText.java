package appApachePoi;

import model.Client;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class setText {

    public void setMCHSText(String filepath, String outpath,String companyName, String companyAddress, String companyPhoneNumber, Client teamLeader) {

        XWPFDocument doc = null;
        try {
            doc = new XWPFDocument(new FileInputStream(filepath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert doc != null;
        for (XWPFParagraph p : doc.getParagraphs()){

                int numberOfRuns = p.getRuns().size();

                // Collate text of all runs
                StringBuilder sb = new StringBuilder();
                for (XWPFRun r : p.getRuns()){
                    int pos = r.getTextPosition();
                    if(r.getText(pos) != null) {
                        sb.append(r.getText(pos));
                    }
                }

                // Continue if there is text and contains "test"
                if(sb.length() > 0 && sb.toString().contains("$companyName")) {
                    // Remove all existing runs
                    for(int i = 0; i < numberOfRuns; i++) {
                        p.removeRun(i);
                    }
                    String text = sb.toString().replace("$companyName", teamLeader.getName());
                    // Add new run with updated text
                    XWPFRun run = p.createRun();
                    run.setText(text);
                    p.addRun(run);
                }
            }
        try {
            doc.write(new FileOutputStream(outpath));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    }
