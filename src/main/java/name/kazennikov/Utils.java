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
}
