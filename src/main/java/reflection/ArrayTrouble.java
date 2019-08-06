package reflection;

import java.lang.reflect.Array;

/**
 *
 * @author grape
 * @date 2019-08-05
 */
public class ArrayTrouble {
	public static void main(String[] args){
	     Object o = Array.newInstance(int.class,0);

	     int[] i = (int[])o;
	     int[] j = new int[0];

	     Array.get(o,0);

	}
}
