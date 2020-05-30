import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;


public class Write_Pdf {

	
	
		 
		public void createPdf(String filename)
		        throws IOException, DocumentException {
		    	// step 1
		        Document document = new Document();
		        // step 2
		        PdfWriter.getInstance(document, new FileOutputStream(filename));
		        // step 3
		        document.open();
		        // step 4
		     //   document.add(createFirstTable());
		        // step 5
		        document.close();
		    }
		 
		    /**
		     * Creates our first table
		     * @return our first table
		     */
		    public static PdfPTable createFirstTable(String Subject) {
		    	// a table with three columns
		        PdfPTable table = new PdfPTable(2);
		        // the cell object
		        PdfPCell cell;
		        // we add a cell with colspan 3
		       // cell = new PdfPCell(new Phrase("Cell with colspan 3"));
		      //  cell.setColspan(3);
		       // table.addCell(cell);
		        // now we add a cell with rowspan 2
		       // cell = new PdfPCell(new Phrase("Cell with rowspan 2"));
		       // cell.setRowspan(2);
		       // table.addCell(cell);
		        // we add the four remaining cells with addCell()
		        table.addCell("Subject");
		        table.addCell("Student Name");
		        table.addCell(""+Subject);
		        table.addCell("Puneet");
		        return table;
		    }
	}
