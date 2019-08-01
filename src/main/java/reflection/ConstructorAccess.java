package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import static java.lang.System.out;

/**
 *
 * @author grape
 * @date 2019-08-01
 */
public class ConstructorAccess {
	public static void main(String[] args){
		try {
			Class c = Class.forName(args[0]);

			Constructor[] constructors = c.getDeclaredConstructors();

			int modifierParam = getModifier(args[1]);

			for(Constructor constructor : constructors){
				int cModifier = constructor.getModifiers();
				if(modifierParam == accessModifier(cModifier)){
					out.format("%s%n",constructor.toGenericString());

					out.format(" [isSynthetic = %b , var_args = %b]%n",constructor.isSynthetic(),constructor.isVarArgs());
				}
			}
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static int accessModifier(int modifier){
		return modifier & (Modifier.PUBLIC | Modifier.PROTECTED | Modifier.PRIVATE);
	}

	private static int getModifier(String modifier){
		switch (modifier){
			case "public":
				return Modifier.PUBLIC;
			case "protected":
				return Modifier.PROTECTED;
			case "private":
				return Modifier.PRIVATE;
			case "package-private":
				return 0;
		}
		return -1;
	}
}
