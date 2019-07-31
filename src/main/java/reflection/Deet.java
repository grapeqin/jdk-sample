package reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

import static java.lang.System.err;
import static java.lang.System.out;

/**
 *
 * @author grape
 * @date 2019-07-31
 */
public class Deet<T> {

	private boolean testDeet(Locale l){
		out.format("local = %s,ISO language code = %s%n",l.getDisplayName(),
				l.getISO3Language());
		return true;
	}

	private boolean testFoo(Locale l){
		return false;
	}

	private boolean testBar(){
		return true;
	}
	
	public static void main(String[] args){
		if(args.length != 4){
			err.format("Usage: java reflection.Deet <classname> <langauge> <country> "
					+ "<varient>%n");
			return;
		}

		try {
			Class<?> c = Class.forName(args[0]);
			Object o = c.newInstance();

			Method[] methods = c.getDeclaredMethods();
			for(Method m : methods){
				String methodName = m.getName();
				if(!methodName.startsWith("test")
						|| m.getGenericReturnType()!=boolean.class){
					continue;
				}

				Class<?>[] cs = m.getParameterTypes();
				if(cs.length != 1 || cs[0] != Locale.class){
					continue;
				}

				out.format("invoke method %s%n",methodName);

				m.setAccessible(true);
				Object result = null;
				try {
					result = m.invoke(o,new Locale(args[1],args[2],args[3]));
				}
				catch (InvocationTargetException e) {
					e.printStackTrace();
					err.format("invoking of %s throw %s%n",methodName,e);
				}
				out.format("invoking of %s return %s%n",methodName,(Boolean)result);
			}
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		catch (InstantiationException e) {
			e.printStackTrace();
		}
	}
}
