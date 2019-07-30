package reflection;

import java.util.Collection;
import java.util.List;

import static java.lang.System.out;

/**
 *
 * @author grape
 * @date 2019-07-30
 */
public class ExampleMethods<T> {

	public boolean simpleMethod(String stringParam,Integer intParam){
		out.println("StringParam= " + stringParam +",intParam= " + intParam );
		return true;
	}

	public int varArgsMethod(String ...manyStrings){
		return manyStrings.length;
	}

	public boolean methodWithList(List<String> list){
		return list.isEmpty();
	}

	public <T> void genericMethod(T[] t, Collection<T> c){
		out.println("Length of Array : " + t.length);
		out.println("Size of Collection : " + c.size());
	}
}
