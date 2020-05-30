import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.data.statistics.DefaultMultiValueCategoryDataset;

import javax.annotation.Generated;
import javax.swing.JFrame;

		public class Chart extends JFrame {

		   private static final long serialVersionUID = 1L;

		   public Chart(String applicationTitle) {
		        super(applicationTitle);

		   }
		   
		   
		   
		   
		   public static JFreeChart generateBarChart(String chartTitle,String subjects,Double marks,Double Topper,Double avg)
		   {
			   // based on the dataset we create the chart
		        JFreeChart pieChart = ChartFactory.createBarChart(chartTitle, "Category", "Score", createDataset(subjects,marks,Topper,avg),PlotOrientation.VERTICAL, true, true, false);

		        // Adding chart into a chart panel
		        ChartPanel chartPanel = new ChartPanel(pieChart);
		      
		        // settind default size
		        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
		      
		        // add to contentPane
		      
		        return pieChart;
		    }
		   
		   
		   
		   
		   
		   public static JFreeChart generateBarChart(String chartTitle,ArrayList<Double> diff,double top_easy,double top_medium,double top_tough,double avg_easy,double avg_medium,double avg_tough)
		   {
			   // based on the dataset we create the chart
		        JFreeChart pieChart = ChartFactory.createBarChart(chartTitle, "Category", "Score", createDataset(diff,top_easy,top_medium,top_tough,avg_easy,avg_medium,avg_tough),PlotOrientation.VERTICAL, true, true, false);

		        // Adding chart into a chart panel
		        ChartPanel chartPanel = new ChartPanel(pieChart);
		      
		        // settind default size
		        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
		      
		        // add to contentPane
		      
		        return pieChart;
		    }
		   
		   
		   
		  
		   
		   public static JFreeChart generateBarChart(String chartTitle,String subjects,Double marks,ArrayList<Double> Topper)
		   {
			   // based on the dataset we create the chart
		        JFreeChart pieChart = ChartFactory.createBarChart(chartTitle, "Category", "Score", createDataset(subjects,marks,Topper),PlotOrientation.VERTICAL, true, true, false);

		        // Adding chart into a chart panel
		        ChartPanel chartPanel = new ChartPanel(pieChart);
		      
		        // settind default size
		        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
		      
		        // add to contentPane
		      
		        return pieChart;
		    }
		   
		   
		   
		   
		   
		   
		   
		   
		  
		   private static CategoryDataset createDataset(String subjects,Double marks,Double Topper,Double avg) {
		     
		    
			   ArrayList<Double> sub=new ArrayList<>();
			   // row keys...
		      final String you = "You";
		      final String topper = "Topper";
		

		      // column keys...
		    //  final String SE = "SE";
		     // final String OOP = "OOP";
		      //final String MATHS = "MATHS";
		 

		      // create the dataset...
		      final DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		    
		     
		        dataset.addValue(marks, you, "");
		      

		     
			        dataset.addValue(Topper, topper, "");

		   
		     
    
			        dataset.addValue(avg, "Average", "");
		      return dataset;
		     
		  }
		   
		   
		   
		   
		   
		   
		   
		   
		   private static CategoryDataset createDataset(String subjects,Double marks,ArrayList<Double> Topper) {
			     
			    
			   // row keys...
		      final String you = "You";
		

		      // column keys...
		    //  final String SE = "SE";
		     // final String OOP = "OOP";
		      //final String MATHS = "MATHS";
		 

		      // create the dataset...
		      final DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		    
		     
		        dataset.addValue(marks, you, "");
		      
int size=Topper.size();

		     for(int i=0;i<size;i++)
		     {
		    	
		    	 dataset.addValue(Topper.get(i), "Rank "+(i+1), "");
		     }
		   
		     
    

		      return dataset;
		     
		  }
		   
		   
		   
		   
		   
		   
		   private static CategoryDataset createDataset(ArrayList<Double> diff,double top_easy,double top_medium,double top_tough,double avg_easy,double avg_medium,double avg_tough) {
			     
			    
			   // row keys...
		      final String you = "You";
		

		      // column keys...
		    //  final String SE = "SE";
		     // final String OOP = "OOP";
		      //final String MATHS = "MATHS";
		 

		      // create the dataset...
		      final DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		    
		     
		        dataset.addValue(diff.get(2), you, "Tough");
		        dataset.addValue(top_tough, "Topper", "Tough");
		        dataset.addValue(avg_tough, "Average", "Tough");
		        
		        dataset.addValue(diff.get(1), you, "Medium");
		        dataset.addValue(top_medium, "Topper", "Medium");
		        dataset.addValue(avg_medium, "Average", "Medium");
		        
		        dataset.addValue(diff.get(0), you, "Easy");
		        dataset.addValue(top_easy, "Topper", "Easy");
		        dataset.addValue(avg_easy, "Average", "Easy");
    

		      return dataset;
		     
		  }
		   

		   
		   
		   
		   
		   public JFreeChart createChart(double easy,double medium,double tough) {
		        DefaultPieDataset result = new DefaultPieDataset();
		        result.setValue("Easy", easy);
		        result.setValue("Medium", medium);
		        result.setValue("Tough", tough);
		        JFreeChart chart = ChartFactory.createPieChart(
			            "Distribution",                  // chart title
			            result,                // data
			            true,                   // include legend
			            true,
			            false
			        );
		        
		        return chart;
		    }

		    /**
		     * Creates a chart
		     */

	
		}
