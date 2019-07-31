package reflection;

import java.lang.reflect.Method;

import static java.lang.System.out;

/**
 *
 * @author grape
 * @date 2019-07-31
 */
public class MethodTrouble<T> {
	public void lookup(T t){}

	public void find(Integer i){}

	public static void main(String[] args){
		String mName = args[0];
		try {
			Class cArg = Class.forName(args[1]);
			Class<?> c = (new MethodTrouble<Integer>()).getClass();
			Method m = c.getMethod(mName,cArg);
			out.format("found%n %s%n",m.toGenericString());
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
	}
}
