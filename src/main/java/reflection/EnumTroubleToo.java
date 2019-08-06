package reflection;

import java.lang.reflect.Field;

enum E0{A,B}
enum E1{A,B}


class ETest{
	private E0 fld = E0.A;
}


/**
 *
 * @author grape
 * @date 2019-08-06
 */
public class EnumTroubleToo {
	public static void main(String[] args){
	     ETest eTest = new ETest();
		try {
			Field field = eTest.getClass().getDeclaredField("fld");
			field.setAccessible(true);
			field.set(eTest,E1.A);
		}
		catch (NoSuchFieldException e) {
			e.printStackTrace();
		}
		catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}
