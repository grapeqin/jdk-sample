package reflection;

import java.lang.reflect.Array;

/**
 *
 * @author grape
 * @date 2019-08-05
 */
public class ArrayTroubleAgain {

	public static void main(String[] args){
		Integer[] ary = new Integer[2];

    	Array.setInt(ary,0,1);
    	// we need change to
//		 Array.set(ary,0,1);

	}
}
