package reflection;

import java.lang.reflect.Array;

/**
 * @author grape
 * @date 2019-08-05
 */
public class ArrayTroubleToo {
  public static void main(String[] args) {
    Object o = new int[2];

    Array.setShort(o, 0, (short) 2);
    Array.setLong(o, 1, 2L);
  }
}
