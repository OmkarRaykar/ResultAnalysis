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


public class Student_Thread extends Thread
{
	

	Document document;
	PdfWriter writer=null;	
	
Student student;
Excel e;
    public Student_Thread(Student student,Excel e)
    {
        this.student=student;
        this.e=e;

    }
	 
	    public void run()
	    {
	    	
	    	
	    	JFreeChart BarChart,BarChart1,PieChart,BarChart2;
	    	Chart c=new Chart("Result Declaration");
	    	
	    	
	    
	    	int sub_len=e.subjects.size();
	    	document = new Document();
			
			try {
				writer = PdfWriter.getInstance(document, new FileOutputStream(
						""+student.UID+".pdf"));
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (DocumentException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			document.open();
			float width1 = document.getPageSize().getWidth() - document.leftMargin() - document.rightMargin();
			
			for(int j=0;j<sub_len;j++)
			{
				
				Double avg=e.subjects.get(j).avg;
				
				Double total=student.marks.get(e.subjects.get(j)).get(3);// 3rd index store total of that subject
				
				Double Topper=e.topper.marks1.get(e.topper.marks1.size()-1);  //Retrieving topper marks in the subject
				
				BarChart=c.generateBarChart("Result Declaration",e.subjects.get(j).Name,total,Topper,avg);
				BarChart1=c.generateBarChart("Comparison with Toppers",e.subjects.get(j).Name,total,e.topper.Top5);
				
				
				PieChart=c.createChart(e.subjects.get(j).easy, e.subjects.get(j).medium, e.subjects.get(j).tough);
				
				double top_easy,top_medium,top_tough,avg_easy,avg_medium,avg_tough;
				
				e.subjects.get(j).getTopAndAvg(e.student);
				
				top_easy=e.subjects.get(j).top_easy;
				top_medium=e.subjects.get(j).top_medium;
				top_tough=e.subjects.get(j).top_tough;
				avg_easy=e.subjects.get(j).avg_easy;
				avg_medium=e.subjects.get(j).avg_medium;
				avg_tough=e.subjects.get(j).avg_tough;
				
				
				ArrayList<Double> diff=new ArrayList<>();
				
				diff.addAll(student.marks.get(e.subjects.get(j)));
				
				BarChart2=c.generateBarChart("Comparison with Toppers",diff,top_easy,top_medium,top_tough,avg_easy,avg_medium,avg_tough);
				
				try {
			    document.add(new Write_Pdf().createFirstTable(e.subjects.get(j).Name));
				
				document.add(writeChartToPDF(BarChart, 450, 450, writer,e.subjects.get(j).Name,width1));
				
				document.add(writeChartToPDF(BarChart1, 450, 450, writer,e.subjects.get(j).Name,width1));
				document.add(writeChartToPDF(PieChart, 450, 450, writer,e.subjects.get(j).Name,width1));
				document.add(writeChartToPDF(BarChart2, 450, 450, writer,e.subjects.get(j).Name,width1));
				 document.newPage();
				 document.newPage();
			       }
				
				
				catch (DocumentException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		}
			
				
				document.close();
				  
			 
				 Email_PDF email=new Email_PDF();
				try {
					
					//email.sendEmail(""+student.UID+".pdf", "puneetpichholia@gmail.com");
					 email.sendEmail(""+student.UID+".pdf", student.email);
				} catch (Exception e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				 
				
				 
				 
				 
				 
				 
				 
				 
				 
				 System.out.println("Done!");	       
	    	 
	    }
	    
	    
	    
	    
	    

		public static Image writeChartToPDF(JFreeChart chart, int width, int height, PdfWriter writer,String Subject,float width1) {
			

			Image image=null;

			try {
				
				//PdfStamper stamp;
				//PdfReader reader = new PdfReader(fileName);
	           //reader.close();
		      //  stamp = new PdfStamper(reader, new FileOutputStream(fileName));
		       
		    //    PdfContentByte pcb;
		      //  pcb = stamp.getOverContent(1);

				
				
				
				
				PdfContentByte contentByte = writer.getDirectContent();
				PdfTemplate template = contentByte.createTemplate(width, height);
				Graphics2D graphics2d = template.createGraphics(width, height,new DefaultFontMapper());
				Rectangle2D rectangle2d = new Rectangle2D.Double(0, 0, width,
						height);
	//Panel panel=new Panel();
				chart.draw(graphics2d,rectangle2d);
				
				graphics2d.dispose();
				//contentByte.addTemplate(template, 0, 0);

				
				 image = Image.getInstance(template);
				
				image.scaleToFit(width1, 500);
				
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}

			return image;
			
		}
		
		
		
		public static void file_delete(String fileName)
		{
			File file = new File("\\".concat(fileName));
			if(file.exists())
			file.delete();
		
		}
	    
}
