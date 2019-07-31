package reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static java.lang.System.out;

/**
 *
 * @author grape
 * @date 2019-07-31
 */
public class MethodTroubleToo {

	public void ping(){
		out.format("PONG!%n");
	}

	public static void main(String[] args){
	     MethodTroubleToo mtt = new MethodTroubleToo();
		try {
			Method m = MethodTroubleToo.class.getMethod("ping");
			int numOfArgs = Integer.parseInt(args[0]);
			switch (numOfArgs){
				case 0:
					m.invoke(mtt);
					break;
				case 1:
					m.invoke(mtt,null);
					break;
				case 2:
					Object arg2 = null;
					m.invoke(mtt,arg2);
					break;
				case 3:
					m.invoke(mtt,new Object[0]);
					break;
				case 4:
					Object arg4 = new Object[0];
					m.invoke(mtt,arg4);
					break;
					default:
						out.format("Test not found %n");
			}
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
