package reflection;

import java.io.BufferedReader;
import java.io.CharArrayReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;

import static java.lang.System.out;

/**
 *
 * @author grape
 * @date 2019-08-05
 */
public class GrowBufferedReader {

	private static final int srcBufSize = 10 * 1024;

	private static char[] src = new char[srcBufSize];

	static {
		src[srcBufSize-1] = 'x';
	}

	private static CharArrayReader car = new CharArrayReader(src);
	
	public static void main(String[] args){
		BufferedReader br = new BufferedReader(car);

		Class c = br.getClass();
		try {
			Field cbField = c.getDeclaredField("cb");
			cbField.setAccessible(true);
			char[] oVal = char[].class.cast(cbField.get(br));

			char[] nVal = Arrays.copyOf(oVal,oVal.length*2);

			if(args.length > 0  && "grow".equals(args[0])){
				cbField.set(br,nVal);
			}

			for(int i=0;i<srcBufSize;i++){
				br.read();
			}

			if(nVal[srcBufSize-1] == src[srcBufSize-1]){
				out.format("Using new backing array, size = %d%n",nVal.length);
			}else{
				out.format("Using original backing array , size = %d%n",oVal.length);
			}
		}
		catch (NoSuchFieldException e) {
			e.printStackTrace();
		}
		catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
