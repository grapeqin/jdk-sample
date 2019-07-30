package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

import static java.lang.System.out;

/**
 *
 * @author grape
 * @date 2019-07-30
 */
public class MethodParameterSpy {
	private static final String  fmt = "%24s: %s%n";

	public static void main(String[] args) throws ClassNotFoundException {
	    // 打印构造器参数
		printConstructors(Class.forName(args[0]));
		printMethods(Class.forName(args[0]));
	}

	public static void printConstructors(Class c){
		out.format("%s%n",c.toGenericString());
		Constructor<?>[] constructors = c.getConstructors();
		out.format(fmt,"constructors count",constructors.length);
		for(Constructor constructor : constructors){
			printConstructor(constructor);
		}

		constructors = c.getDeclaredConstructors();
		out.format(fmt,"declare constructors count",constructors.length);
		for (Constructor constructor : constructors){
			printConstructor(constructor);
		}
	}

	private static void printConstructor(Constructor constructor){
		out.format("%s%n",constructor.toGenericString());
		Parameter[] parameters = constructor.getParameters();
		out.format(fmt,"parameters count " ,parameters.length);
		for(Parameter parameter : parameters){
			printParameter(parameter);
		}
	}

	public static void printMethods(Class c){
		Method[] methods = c.getDeclaredMethods();
		out.format(fmt,"methods count",methods.length);
		for(Method method : methods){
			printMethod(method);
		}
	}

	private static void printMethod(Method method){
		out.format("%s%n",method.toGenericString());
		out.format(fmt,"method return type",method.getReturnType().toGenericString());
		out.format(fmt,"method return generic type",method.getGenericReturnType().getTypeName());
		Parameter[] parameters = method.getParameters();
		for(Parameter parameter : parameters){
			printParameter(parameter);
		}
	}

	private static void printParameter(Parameter parameter){
		out.format(fmt,"parameter type",parameter.getType().toGenericString());
		out.format(fmt,"parameter name",parameter.getName());
		out.format(fmt,"parameter modifiers",parameter.getModifiers());
		out.format(fmt,"parameter isImplicit?",parameter.isImplicit());
		out.format(fmt,"parameter isNamePresent?",parameter.isNamePresent());
		out.format(fmt,"parameter isSynthetic?",parameter.isSynthetic());
	}
}
