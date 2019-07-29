package reflection;

import java.lang.reflect.Field;

/**
 *
 * @author grape
 * @date 2019-07-29
 */
public class FieldTrouble {
	public Integer val;

	public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
	    FieldTrouble ft = new FieldTrouble();

	    Class<?> c = ft.getClass();

		Field valField = c.getDeclaredField("val");
		valField.setInt(ft,42);
	}
}
