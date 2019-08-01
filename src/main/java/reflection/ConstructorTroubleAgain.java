package reflection;

import java.lang.reflect.InvocationTargetException;

import static java.lang.System.out;

/**
 *
 * @author grape
 * @date 2019-08-01
 */
public class ConstructorTroubleAgain {

	public ConstructorTroubleAgain(){}

	public ConstructorTroubleAgain(Integer i ){}

	public ConstructorTroubleAgain(Object o){
		out.format("passed object parameter%n");
	}

	public ConstructorTroubleAgain(String str){
		out.format("passed string parameter%n");
	}

	public static void main(String[] args){
		String argType = args.length > 0 ? args[0] : "";
		try {
			Class c = Class.forName("reflection.ConstructorTroubleAgain");

			if("".equals(argType)){
				c.getConstructor().newInstance("foo");
			}else if("int".equals(argType)){
				c.getConstructor(int.class);
			}else if("Object".equals(argType)){
				c.getConstructor(Object.class).newInstance("foo");
			}else{
				assert false;

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
		catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
}
