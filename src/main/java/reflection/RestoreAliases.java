package reflection;


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static java.lang.System.out;

class EmailAliases{
	private Set<String> aliaes;

	private EmailAliases(Map<String,String> aliases){
		this.aliaes = aliases.keySet();
	}

	public void printAliases(){
		out.format("emailAliases : %n");
		for(String ali : aliaes){
			out.format("  %s%n",ali);
		}
	}
}

/**
 *
 * @author grape
 * @date 2019-08-01
 */
public class RestoreAliases {

	private static final Map<String,String> defaultAliases = new HashMap<>();

	static {
		defaultAliases.put("Duke","duke@i-love-java");
		defaultAliases.put("Fang","fang-evil-jealous-twin");
	}

	public static void main(String[] args){
		try {
			Constructor c = EmailAliases.class.getDeclaredConstructor(Map.class);
			c.setAccessible(true);

			EmailAliases ea  = (EmailAliases) c.newInstance(defaultAliases);

			ea.printAliases();
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
