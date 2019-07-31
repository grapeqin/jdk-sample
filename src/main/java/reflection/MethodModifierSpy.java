package reflection;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static java.lang.System.out;

/**
 *
 * @author grape
 * @date 2019-07-30
 */
public class MethodModifierSpy {
	private static int count;

	private static synchronized void incr(){ count++;}

	private static synchronized int cnt(){
		return count;
	}

	public static void main(String[] args){
		try {
			Class<?> c = Class.forName(args[0]);

			Method[] methods = c.getDeclaredMethods();

			for(Method method : methods){
				if(!method.getName().equals(args[1])){
					continue;
				}

				out.format("%s%n",method.toGenericString());
				out.format("  Modifiers:  %s%n", Modifier.toString(method.getModifiers()));
				out.format("  [ synthetic=%-5b var_args=%-5b bridge=%-5b ]%n",method.isSynthetic(),method.isVarArgs(),method.isBridge());

				incr();
			}

			out.format("matching %d overload%s method%n",cnt(),(cnt()==1?"":"s"));
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
