import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;


public class Student {
	String Name;
	String UID;
	//ArrayList<Double> marks=new ArrayList();
	String email;
	//double Total_Marks;
	Map<Subjects,ArrayList<Double>> marks=new HashedMap<Subjects, ArrayList<Double>>();
	Student(String Name,String UID,String email)
	{
		this.Name=Name;
		this.UID=UID;
		this.email=email;
		
	}
}
