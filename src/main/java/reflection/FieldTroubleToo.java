package reflection;

import java.lang.reflect.Field;

/**
 *
 * @author grape
 * @date 2019-07-29
 */
public class FieldTroubleToo {
	public final boolean b = true;

	public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
		FieldTroubleToo ftt = new FieldTroubleToo();

		Class<?> c = ftt.getClass();
		Field bField = c.getDeclaredField("b");
		//	通过反射修改其可访问性
		bField.setAccessible(true);
		bField.setBoolean(ftt,false);
	}
}
