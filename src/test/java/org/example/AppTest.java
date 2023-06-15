package org.example;

import com.sun.xml.internal.fastinfoset.tools.XML_SAX_StAX_FI;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AppTest {
    public static void main(String[] args) throws Exception
    {
        readPDF();
        readExcel();
    }

            public static void readPDF() throws Exception
            {
                File f = new File("C:\\Users\\DELL\\Downloads\\AnkitHR.pdf");
                try (PDDocument document = PDDocument.load(f)) {

                    document.getClass();

                    if (!document.isEncrypted()) {

                        PDFTextStripperByArea stripper = new PDFTextStripperByArea();
                        stripper.setSortByPosition(true);

                        PDFTextStripper tStripper = new PDFTextStripper();

                        String pdfFileInText = tStripper.getText(document);
                        System.out.println(pdfFileInText );
                        //System.out.println("Text:" + st);

                        // split by whitespace
                        ArrayList<String> l=new ArrayList<String>();
                        String lines[] = pdfFileInText.split("\\r?\\n");
                        for (String line : lines) {
                           // System.out.println(line);
                            l.add(line);
                            
                        }
                       // System.out.println(l);

                    }

            }
}

public static void readExcel() throws IOException {
        File f= new File("C:\\Users\\DELL\\Desktop\\AnkitHR.xlsx");
        FileInputStream fis=new FileInputStream(f);
    XSSFWorkbook wb= new XSSFWorkbook(fis);
    String s = null;
    XSSFSheet ws=wb.getSheet("Sheet1");
    int rows=ws.getPhysicalNumberOfRows();


    ArrayList<String> l=new ArrayList<String>();

  for(int i=0;i<rows;i++)
  {
     s=ws.getRow(i).getCell(0).getStringCellValue();
     l.add(s);

  }
    //System.out.println("Hello from Excel "+l);
    StringBuffer sb = new StringBuffer();
    for (String s2 : l) {
        sb.append(s2);
        sb.append(" ");
    }
    String str = sb.toString();
    System.out.println(str);
    
    }


}


