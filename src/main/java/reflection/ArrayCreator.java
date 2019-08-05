package reflection;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.System.out;

/**
 *
 * @author grape
 * @date 2019-08-05
 */
public class ArrayCreator {

	private static String s = "java.math.BigInteger bi[] = { 123, 234, 345 }";

	private static Pattern p = Pattern.compile("^\\s*(\\S+)\\s*\\w+\\[\\].*\\{\\s*([^}]+)\\s*\\}");

	public static void main(String[] args){
		Matcher m = p.matcher(s);

		if (m.find()){
			String cName = m.group(1);
			String[] cVals = m.group(2).split("[\\s,]+");
			int valLength = cVals.length;

			try {
				Class c = Class.forName(cName);

				Object o = Array.newInstance(c,valLength);

				int index =0;
				for(String val : cVals){
					Constructor constructor = c.getDeclaredConstructor(String.class);
					Array.set(o,index++,constructor.newInstance(val));
				}

				Object[] oo = (Object[])o;
        		out.format("%s[] = %s%n", cName, Arrays.toString(oo));
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			catch (NoSuchMethodException e) {
				e.printStackTrace();
			}
			catch (IllegalAccessException e) {
				e.printStackTrace();
			}
			catch (InstantiationException e) {
				e.printStackTrace();
			}
			catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}
	}
}
