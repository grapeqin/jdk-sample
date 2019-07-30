package reflection;

import java.lang.reflect.Method;

import static java.lang.System.out;

/**
 *
 * @author grape
 * @date 2019-07-30
 */
public class MethodParameterExamples {

	public class InnerClass{}

	enum Colors{
		RED,
		WHITE
	}

	public static void main(String[] args){
		out.println("Inner class : " );
		MethodParameterSpy.printConstructors(InnerClass.class);

		out.println("enum class Colors: ");
		MethodParameterSpy.printConstructors(Colors.class);
		MethodParameterSpy.printMethods(Colors.class);
	}
}
