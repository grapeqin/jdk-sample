package reflection;

import java.lang.reflect.InvocationTargetException;

/**
 *
 * @author grape
 * @date 2019-08-01
 */
public class ConstructorTroubleToo {

	public ConstructorTroubleToo(){
		throw new RuntimeException("throw a runtimeException");
	}

	public static void main(String[] args){
		try {
			Class c = Class.forName("reflection.ConstructorTroubleToo");

			if(args.length > 0 && args[0].equals("class")){
				c.newInstance();
			}else{
				c.getConstructor().newInstance();
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
