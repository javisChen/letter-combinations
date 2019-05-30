import java.util.*;

/*
 * @author JavisChen
 * @desc Combinate
 * @date 2019/5/30 10:39 PM
 */
public class Combinate {

    public static Map<Integer, List<String>> map = new HashMap<>();

    static {
        map.put(0, new ArrayList<>());
        map.put(1, new ArrayList<>());
        map.put(2, Arrays.asList("a", "b", "c"));
        map.put(3, Arrays.asList("d", "e", "f"));
        map.put(4, Arrays.asList("g", "h", "i"));
        map.put(5, Arrays.asList("j", "k", "l"));
        map.put(6, Arrays.asList("m", "n", "o"));
        map.put(7, Arrays.asList("p", "q", "r", "s"));
        map.put(8, Arrays.asList("t", "u", "v"));
        map.put(9, Arrays.asList("w", "x", "y", "z"));
    }

    public static List<String> combine(String inputs) {
        if (inputs.length() == 0) {
            return Collections.emptyList();
        }
        if (inputs.length() == 1) {
            // if only have 1 digit,go back
            return map.get(Integer.valueOf(inputs));
        }
        String next = inputs.substring(1, inputs.length());
        List<String> letters = combine(next);
        List<String> list = map.get(inputs.charAt(0) - '0');
        List<String> returnList = new ArrayList<>();
        list.forEach(item -> letters.forEach(letter -> returnList.add(item + letter)));
        return returnList;
    }
}
