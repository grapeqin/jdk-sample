package reflection;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class AnotherClass{
	private void m(){}
}

/**
 *
 * @author grape
 * @date 2019-07-31
 */
public class MethodTroubleAgain {

	public static void main(String[] args){
		AnotherClass ac  = new AnotherClass();

		Class<?> c = ac.getClass();
		try {
			Method m = c.getDeclaredMethod("m");
			m.invoke(ac);
		}
		catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
}
