import java.util.ArrayList;


public class Toppers {

	
	
	ArrayList<Double>marks1=new ArrayList<>();
ArrayList<Double> Top5=new ArrayList<>();


public void getTop5()
{
	int size=marks1.size();
	for(int i=0;i<5;i++)
	{
		if(i<size)
		Top5.add(marks1.get(size-(i+1)));
		
		else
			break;
	}
	
	
}
}
