import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.jfree.chart.JFreeChart;

import com.itextpdf.awt.DefaultFontMapper;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;


public class Result_Analysis {
public static void main(String args[])
{
	
	Excel e=new Excel();
	try {
		e.read();
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	int stud_len=e.student.size();
	
	Thread t;
	for(int i=0;i<stud_len;i++)
	{
	 	
		t=new Student_Thread(e.student.get(i), e);	 
		t.start();	 
			 
	 }
			
			
		}
		
		
		
		
}