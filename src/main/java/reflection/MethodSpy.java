package reflection;

import java.lang.reflect.Method;
import java.lang.reflect.Type;

import static java.lang.System.out;

/**
 *
 * @author grape
 * @date 2019-07-29
 */
public class MethodSpy {
	private static final String  fmt = "%24s: %s%n";


	public static void main(String[] args){
		try {
			Class<?> c = Class.forName(args[0]);

			Method[] methods = c.getDeclaredMethods();

			for(Method method : methods){
				if(!method.getName().equals(args[1])){
					continue;
				}
				out.format("%s%n",method.toGenericString());

				out.format(fmt,"ReturnType",method.getReturnType());
				out.format(fmt,"GenericReturnType",method.getGenericReturnType());

				Class<?>[] pType = method.getParameterTypes();
				Type[] pgType = method.getGenericParameterTypes();
				for(int i=0;i<pType.length;i++){
					out.format(fmt,"ParameterType",pType[i]);
					out.format(fmt,"GenericParameterType",pgType[i]);
				}

				Class<?>[] eType = method.getExceptionTypes();
				Type[] egType = method.getGenericExceptionTypes();
				for(int i=0;i<eType.length;i++){
					out.format(fmt,"ExceptionType",eType[i]);
					out.format(fmt,"GenericExceptionType",egType[i]);
				}
			}
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
