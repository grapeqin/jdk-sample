package reflection;

import java.lang.reflect.Field;

import static java.lang.System.out;

enum TraceLevel {
	OFF,
	LOW,
	MEDIUM,
	HIGH,
	DEBUG
}

class MyServer{
	private TraceLevel level = TraceLevel.OFF;
}

/**
 *
 * @author grape
 * @date 2019-08-06
 */
public class SetTrace {
	
	public static void main(String[] args){
	     TraceLevel newLevel = TraceLevel.valueOf(args[0]);

	     MyServer myServer = new MyServer();
	     Class c =  myServer.getClass();
		try {
			Field f = c.getDeclaredField("level");
			f.setAccessible(true);
			TraceLevel oldLevel = (TraceLevel) f.get(myServer);

			out.format("Original tracelevel is %s%n",oldLevel);

			if(newLevel != oldLevel){
				f.set(myServer,newLevel);
				out.format("New tracelevel is %s%n",f.get(myServer));
			}
		}
		catch (NoSuchFieldException e) {
			e.printStackTrace();
		}
		catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}
