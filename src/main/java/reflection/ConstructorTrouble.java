package reflection;

/**
 *
 * @author grape
 * @date 2019-08-01
 */
public class ConstructorTrouble {

	private ConstructorTrouble(int i){}

	public static void main(String[] args){
		try {
			Class c = Class.forName("reflection.ConstructorTrouble");

			ConstructorTrouble ct = (ConstructorTrouble) c.newInstance();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		catch (InstantiationException e) {
			e.printStackTrace();
		}
	}
}
