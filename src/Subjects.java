import java.util.ArrayList;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;


public class Subjects {
String Name;
double tough=0, easy=0, medium=0, avg,avg_tough=0,avg_medium=0,avg_easy=0,top_easy=0,top_medium=0,top_tough=0;
Subjects(String Name,int total)
{
	this.Name=Name;
}


public void getTopAndAvg(ArrayList<Student> students)
{
	int len=students.size();
	for(int i=0;i<len;i++)
	{
		
	double temp_easy=students.get(i).marks.get(this).get(0);
	if(temp_easy>top_easy)
		top_easy=temp_easy;
	avg_easy+=temp_easy;

	double temp_medium=students.get(i).marks.get(this).get(1);
			if(temp_medium>top_medium)
				top_medium=temp_medium;
			avg_medium+=temp_medium;

			double temp_tough=students.get(i).marks.get(this).get(2);
			if(temp_tough>top_tough)
				top_tough=temp_tough;
			avg_tough+=temp_tough;	
     
	}
	
	
	
	avg_easy=avg_easy/len;
	avg_medium=avg_medium/len;
	avg_tough=avg_tough/len;
}



}
