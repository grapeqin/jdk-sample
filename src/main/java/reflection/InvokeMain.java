package reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

import static java.lang.System.out;

/**
 *
 * @author grape
 * @date 2019-07-31
 */
public class InvokeMain {

	public static void main(String[] args){
		try {
			Class<?> c = Class.forName(args[0]);
			Class[] argTypes = new Class[]{String[].class};

			Method m = c.getDeclaredMethod("main",argTypes);
			String[] argsParam = Arrays.copyOfRange(args,1,args.length);
			out.format("invoking %s.main() %n",c.getName());
			m.invoke(null,(Object) argsParam);
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
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
