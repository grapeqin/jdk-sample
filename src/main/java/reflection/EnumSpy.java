package reflection;

import static java.lang.System.out;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author grape
 * @date 2019-08-06
 */
public class EnumSpy {

	private static final String fmt = "   %11s:  %s   %s%n";

	public static void main(String[] args){
		try {
			Class c = Class.forName(args[0]);

			if(!c.isEnum()){
				out.format("%s is not Enum Type.%n",c);
				return;
			}

			out.format("Class :  %s%n",c);

			Field[] fields = c.getDeclaredFields();
			// enum constants
			List<Field> cst = new ArrayList<>();
			// member field
			List<Field> mbr = new ArrayList<>();

			for(Field f : fields){
				if(f.isEnumConstant()){
					cst.add(f);
				}else{
					mbr.add(f);
				}
			}

			if(!cst.isEmpty()){
				print(cst,"Constant");
			}
			if(!mbr.isEmpty()){
				print(mbr,"Field");
			}


			Constructor[] constructors = c.getDeclaredConstructors();
			for(Constructor constructor : constructors){
				out.format(fmt,"Constructor",constructor.toGenericString(),senthetic(constructor));
			}

			Method[] methods = c.getDeclaredMethods();
			for(Method method : methods){
				out.format(fmt,"Method",method.toGenericString(),senthetic(method));
			}

		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static void print(List<Field> lst, String s){
		for(Field f : lst){
			out.format(fmt,s,f.toGenericString(),senthetic(f));
		}
	}


	private static String senthetic(Member m){
		return m.isSynthetic() ? "[ senthetic ]" : "";
	}
}
