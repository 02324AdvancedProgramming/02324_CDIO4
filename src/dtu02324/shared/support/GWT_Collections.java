package dtu02324.shared.support;

import java.util.List;
import java.util.Random;

public class GWT_Collections {
	
	public static void shuffle(List<?> l){
		@SuppressWarnings("unchecked")
		List<Object> list = (List<Object>) l;
		Random rand = new Random();
		Object[] array = list.toArray(new Object[list.size()]);
		
		for(int i = 0; i < array.length -1; i++){
			int j = rand.nextInt(array.length-i)+i;
			Object itmp = array[i];
			Object jtmp = array[j];
			array[i] = jtmp;
			array[j] = itmp;
		}
		
		list.clear();
		for(Object o : array){
			list.add(o);
		}	
	}
}
