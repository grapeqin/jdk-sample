package reflection;

import java.io.Console;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;

import static java.lang.System.out;

/**
 *
 * @author grape
 * @date 2019-08-01
 */
public class ConsoleCharset {
	public static void main(String[] args){
	     Constructor[] constructors = Console.class.getDeclaredConstructors();

	     Constructor defaultConstructor = null;

	     // 获取默认构造函数
	     for(Constructor c : constructors){
	     	if(c.getGenericParameterTypes().length == 0){
	     		defaultConstructor = c ;
	     		break;
			}
		 }

		try {
			defaultConstructor.setAccessible(true);
			Console console = (Console) defaultConstructor.newInstance();

			Field f = console.getClass().getDeclaredField("cs");
			f.setAccessible(true);

			out.format("console.charset : %s%n",f.get(console));
			out.format("Charset defaultCharset : %s%n", Charset.defaultCharset());
		}
		catch (InstantiationException e) {
			e.printStackTrace();
		}
		catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		catch (NoSuchFieldException e) {
			e.printStackTrace();
		}

	}
}
