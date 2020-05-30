import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class Excel {

	   ArrayList<Subjects> subjects=new ArrayList();
	   ArrayList<Student> student=new ArrayList();
	   ArrayList<Double> Marks=new ArrayList();
	   ArrayList<String> complexity=new ArrayList();
	   
	   Toppers topper;
	   int counter=0;

	      public void read() throws IOException {
	        String excelFilePath = "E:/Copy of FY_MCA testing.xlsx";
	        
	       
	        FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
	         
	        Workbook workbook = new XSSFWorkbook(inputStream);
	        Sheet sheet=null;
	        int i=0;
	        Cell cell=null;
	        
	        while(i<workbook.getNumberOfSheets())
	        {
	        	sheet=workbook.getSheetAt(0);
	        	Row row = sheet.getRow(4);
	        	cell=row.getCell(5);
	        	String cell_value=cell.getStringCellValue();
	        	row = sheet.getRow(5);
	        	cell=row.getCell(1);
	        	int total=Integer.parseInt(cell.getStringCellValue().substring(14));
	        	subjects.add(new Subjects(cell_value,total));
	        	
	        	row=sheet.getRow(8);
	        	
	        	
	        	int no_of_questions=0;
	        	int x=5;
	        	while(true)
	        	{
	        	 cell=row.getCell(x);   
	        	 if(!cell.getStringCellValue().startsWith("Q"))
	        		 break;
	        	 
	        	 
	        	 
	        
	        	 
	        	 no_of_questions++;
	        	 x++;
	        	
	        	
	        	}
	        	
	  
	        	
	        	
	        	
	        	int l=10;
	        	Row row1=sheet.getRow(l);
	        	

	        	while(row1.getCell(0).getCellTypeEnum() == CellType.NUMERIC)
	        	{
	        		String Name="";
	        	   Name=row1.getCell(3).getStringCellValue();
	        	   Name=Name+" "+row1.getCell(4).getStringCellValue();
	        	   Name=Name+" "+row1.getCell(2).getStringCellValue();
	               
	        	   
	        	   String UID=String.valueOf(row1.getCell(1).getNumericCellValue());
	        	  
	        	   String email=row1.getCell(row1.getLastCellNum()-1).getStringCellValue();
	        	   
	        	   int last_que_id=no_of_questions+4;  //5-1
	        	   
	        	   
	        	   double easy=0,tough=0,medium=0;
	        	   for(int t=5;t<=last_que_id;t++)
	        	   {
	        		   Row row2=sheet.getRow(8);
	        		
	        		   String difficulty=row2.getCell(t).getStringCellValue().substring(3, 4);
	        		 
	        		   
	        		   double marks;
	        		   if(row1.getCell(t).getCellTypeEnum() == CellType.NUMERIC)   
	        		   marks=row1.getCell(t).getNumericCellValue();
	        	   
	        		   else
	        			   marks=0;
	        		   
	        		   
	        		   row2=sheet.getRow(9);
	        	   if(difficulty.toUpperCase().equals("E"))
	        	   {
	        		   easy=easy+marks;

	        		   subjects.get(i).easy+=row2.getCell(t).getNumericCellValue();
	        	   }
	        		 
	        	   
	        	   else if(difficulty.toUpperCase().equals("T"))
	        	   {
	        		   tough=tough+marks;
	        		   
	        		 
	        		   subjects.get(i).tough+=row2.getCell(t).getNumericCellValue();
	        	   }
	        	   
	        	   
	        	   
	        	   else if(difficulty.toUpperCase().equals("M"))
	        	   {
	        		   medium=medium+marks;
	        		   
	        		   
	        		   subjects.get(i).medium+=row2.getCell(t).getNumericCellValue();
	        	   }
        		   complexity.add(difficulty);
	        }
	        	   if(student.size()<=(l-10))
	        	   {
	        	   student.add(new Student(Name, UID, email));
	        	   }
	        	  
	        	   
	        	   ArrayList<Double> diff = new ArrayList<>();
	        	  
	        	   diff.add(easy);
	        	   diff.add(medium);
	        	   diff.add(tough);
	        	   diff.add(easy+medium+tough);
	        	   student.get(l-10).marks.put(subjects.get(i), diff);
	        	   
	        	  	        		   
	        	l++;
	        	row1=sheet.getRow(l);
	        	}
	        	
	        	Row temp_row=sheet.getRow(l);
	        	Cell temp_cell=temp_row.getCell(temp_row.getLastCellNum()-1);
	        	subjects.get(i).avg=temp_cell.getNumericCellValue();
	        	
	        	
	        
	        	i++;
	        }
	        
	        int len=student.size()-1;
	        for(int s=10;s<len+10;s++)
	        {
	        Row rowl=sheet.getRow(s);
	        
	        Cell c=rowl.getCell(rowl.getLastCellNum()-2);
	       double mark;
	        if(c.getCellTypeEnum() == CellType.NUMERIC)   
	        	 mark=c.getNumericCellValue();
     	   
     		   else
     			   mark=0;
	        
	        
	       
	        Marks.add(mark);
	        }
	        
	        Collections.sort(Marks);
	
	   topper= new Toppers();
	   topper.marks1.addAll(Marks);
	   topper.getTop5();
	   
	   
 
	   
	   
	   
}
}
