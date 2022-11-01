import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.swing.JTable;
import javax.swing.JTextArea;

public class cloudController extends ClientGui {

	public static void main(String args[]) {
		cloudController x = new cloudController();

		System.out.println(x.computeTime(jobTime));

	}

	public static Map computeTime(ArrayList<Integer> list) {
		int sum = 0;
		for (int i = 0; i < list.size(); i++) {
			sum += list.get(i);
			id = clientIDBox.getText();
			idTime.put(id, sum);
		}
		return idTime;
	}

	public static Map results() {
		return idTime;
	
		
	}


}
