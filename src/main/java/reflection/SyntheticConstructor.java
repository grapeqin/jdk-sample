package reflection;

/**
 *
 * @author grape
 * @date 2019-08-01
 */
public class SyntheticConstructor {
	private SyntheticConstructor() {}

	class  Inner{
		Inner (){
			new SyntheticConstructor();
		}
	}
}
