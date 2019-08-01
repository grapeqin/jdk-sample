package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Type;

import static java.lang.System.out;

/**
 *
 * @author grape
 * @date 2019-08-01
 */
public class ConstructorSift {

	public static void main(String[] args){
		try {
			Class<?> c = Class.forName(args[0]);
			Class<?> cArg = Class.forName(args[1]);

			Constructor<?>[] constructors  = c.getDeclaredConstructors();
			for(Constructor constructor : constructors){
				Class<?>[] cParam = constructor.getParameterTypes();
				for (int i = 0;i<cParam.length;i++){
					if(cParam[i] == cArg){
						out.format("%s%n",constructor.toGenericString());

						Type[] gType = constructor.getGenericParameterTypes();
						for(int j=0;j<gType.length;j++){
							char ch = cParam[j].equals(cArg) ? '*' : ' ';
							out.format("%7c%s[%d]: %s%n",ch,"GenericParameterType",j,gType[j]);
						}
						break;
					}
				}
			}
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
