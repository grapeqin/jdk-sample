package reflection;


import static java.lang.System.out;

import java.util.Arrays;

enum  Eon {HADEAN,ARCHAEAN,PROTEROZOIC,PHANEROZOIC}


/**
 *
 * @author grape
 * @date 2019-08-06
 */
public class EnumConstants {

	public static void main(String[] args){
		try {
			Class c = args.length ==0 ? Eon.class : Class.forName(args[0]);

			out.format("Enum Names %s ,Enum Constants %s%n",c.getName(), Arrays.asList(c.getEnumConstants()));

			if(c == Eon.class){
				out.format("Eon.values %s%n",Arrays.asList(Eon.values()));
			}
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
