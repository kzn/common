package name.kazennikov;

import com.google.common.base.Function;

import java.util.*;

/**
 * Created by kzn on 2/14/15.
 */
public class Utils {
    private Utils() {}

    public static <K, E> Map<K, List<E>> groupBy(Collection<? extends E> c, Function<E, K> keyFunction, boolean skipNull) {
        HashMap<K, List<E>> map = new HashMap<>();

        for(E el : c) {
            K key = keyFunction.apply(el);

            if(key == null && skipNull) {
                continue;
            }

            List<E> l = map.get(key);
            if(l == null) {
                l = new ArrayList<>();
                map.put(key, l);
            }

            l.add(el);
        }

        return map;
    }


    public static <K, E> Map<K, List<E>> groupBy(Collection<? extends E> c, Function<E, K> keyFunction) {
        return groupBy(c, keyFunction, true);
    }

    public static String reverse(CharSequence s) {
        return new StringBuilder(s).reverse().toString();
    }

    public static int commonPrefix(String s1, String s2) {
        int len = Math.min(s1.length(), s2.length());

        for (int i = 0; i < len; i++) {
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);

            if (ch1 != ch2) {
                return i;
            }

        }
        return len;
    }

}
