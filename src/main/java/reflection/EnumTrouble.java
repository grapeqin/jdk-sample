package reflection;

import static java.lang.System.out;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

enum Charge{
	POSITIVE,
	NEGATIVE,
	NEUTRAL;

	Charge(){
		out.format("under construction%n");
	}
}

/**
 *
 * @author grape
 * @date 2019-08-06
 */
public class EnumTrouble {

	public static void main(String[] args){
		Class c = Charge.class;

		Constructor[] constructors = c.getDeclaredConstructors();
		for(Constructor constructor : constructors){
			try {
				out.format("Constructor : %s%n",constructor.toGenericString());
				constructor.setAccessible(true);
				constructor.newInstance();
			}
			catch (InstantiationException e) {
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
}
