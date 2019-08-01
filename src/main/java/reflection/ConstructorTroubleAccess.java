package reflection;

import static java.lang.System.out;

class Deny{

	private Deny(){
		out.println("deny constructor");
	}
}

/**
 *
 * @author grape
 * @date 2019-08-01
 */
public class ConstructorTroubleAccess {

	public static void main(String[] args){
		try {
			Class c = Class.forName("reflection.Deny");

			c.newInstance();
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
