package reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static java.lang.System.err;
import static java.lang.System.out;

/**
 *
 * @author grape
 * @date 2019-07-31
 */
public class MethodTroubleReturns {

	private void drinkMe(int liters){
		if(liters < 0){
			throw new IllegalArgumentException("I can't drink a negative amount of liquid");
		}
		
	}
	
	public static void main(String[] args){
		MethodTroubleReturns mtr = new MethodTroubleReturns();

	    Class<?> c = mtr.getClass();

		try {
			Method m = c.getDeclaredMethod("drinkMe",int.class);

			m.invoke(mtr,-1);
		}
		catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		catch (InvocationTargetException e) {
			Throwable t = e.getCause();
			err.format("drinkMe failed：%s%n",t.getMessage());
		}
	}


}
