import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.*;

import javax.swing.JTable;
import javax.swing.JTextArea;



public class cloudController extends ClientGui {

	public static void main(String args[]) {
		
		

	}

	
	
	public static String sum(PriorityQueue<Integer> q) {
		int sum =0;
		q.poll();
		
		
		String c ="";
		while (!q.isEmpty()) {
		
		int n = q.remove();
		sum += n;
		 c = "sum:" + sum+c;
		
		}
		return c;
		
		}
	public static String ID (PriorityQueue<String> r) {
		String ID ="";
		while (!r.isEmpty()) {
			String n = r.remove();
			 ID = "ID: "+ID+n;
		
			
		}
		return ID;
		
	}
	
	public static ArrayList<Integer> computeResult(ArrayList<Integer>input){
		int sum=0;
		ArrayList<Integer> resultArray = new ArrayList<Integer>() ;
		for(int i=0;i<input.size();i++)
		{
			sum += input.get(i);
			resultArray.add(sum);
			
		}
		return resultArray;
	}



	public static  Map results() {
		
		return idTime;
		
	}
	

	
		
	


}


