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
		cloudController x = new cloudController();

		System.out.println(x.computeTime(stringID,jobTime));
		

	}

	public static  Map computeTime(ArrayList<String> id, ArrayList<Integer> list) { //map method
		int sum = 0;
		for (int i = 0; i < list.size(); i++) {
			sum += list.get(i);
			String idPlace= id.get(i);
			idTime.put(idPlace, sum);
		}
		return idTime ;
	}
	
	
	public static int sum(PriorityQueue<Integer> q) {
		int sum = 0;
		while (!q.isEmpty()) {
		int n = q.remove();
		sum += n;
		}
		return sum;
		}



	public static  Map results() {
		
		return idTime;
		
	}
	

	
		
	


}


