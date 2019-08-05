package reflection;

import java.lang.reflect.Field;

import static java.lang.System.out;
/**
 *
 * @author grape
 * @date 2019-08-05
 */
public class ArrayFind {

	public static void main(String[] args){
	     boolean  found = false;

		try {
			Class c = Class.forName(args[0]);

			Field[] fields = c.getDeclaredFields();

			for(Field f  : fields){
				Class fType = f.getType();
				if(fType.isArray()){
					out.format("%s%n" + "Field: %s%n" + "Class: %s%n" + "Component Type : %s%n",f,f.getName(),fType,fType.getComponentType());
					found = true;
				}
			}

			if(!found){
				out.println("no array fields!");
			}
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
