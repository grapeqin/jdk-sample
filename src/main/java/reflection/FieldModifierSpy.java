package reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import static java.lang.System.out;

enum  Spy{
	BLACK,
	WHITE
}

/**
 *
 * @author grape
 * @date 2019-07-29
 */
public class FieldModifierSpy {

	volatile int share;

	int instance;

	class Inner{}

	public static void main(String[] args){
		try {
			Class<?> c = Class.forName(args[0]);
			int searchMods = 0x0;
			for(int i=1;i<args.length;i++){
				searchMods|=modifierFromString(args[i]);
			}

			Field[] fields = c.getDeclaredFields();
			out.format("Fields in Class '%s' containing modifiers:  %s%n",
					c.getName(),
					Modifier.toString(searchMods));


			boolean found = false;

			for(Field f : fields){
				int foundMods = f.getModifiers();
				if((foundMods & searchMods) == searchMods){
					out.format("%-8s [ synthetic=%-5b enum_constant=%-5b ]%n",
							f.getName(), f.isSynthetic(),
							f.isEnumConstant());
					found =true;
				}
			}

			if (!found) {
				out.format("No matching fields%n");
			}
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static int modifierFromString(String s){
		int result = 0x0;

		switch (s){
			case "public":
				result |= Modifier.PUBLIC;
				break;
			case "protected":
				result |= Modifier.PROTECTED;
				break;
			case "private":
				result |= Modifier.PRIVATE;
				break;
			case "transient":
				result|=Modifier.TRANSIENT;
				break;
			case "volatile":
				result|=Modifier.VOLATILE;
				break;
			case "static":
				result|=Modifier.STATIC;
				break;
			case "final":
				result|=Modifier.FINAL;
				break;
		}
		return result;
	}

}
