import java.util.*;

/*
 * @author JavisChen
 * @desc Combinate
 * @date 2019/5/30 10:39 PM
 */
public class Combinate {

    public static Map<Integer, List<String>> map = new HashMap<>();

    static {
        map.put(0, Collections.emptyList());
        map.put(1, Collections.emptyList());
        map.put(2, Arrays.asList("a", "b", "c"));
        map.put(3, Arrays.asList("d", "e", "f"));
        map.put(4, Arrays.asList("g", "h", "i"));
        map.put(5, Arrays.asList("j", "k", "l"));
        map.put(6, Arrays.asList("m", "n", "o"));
        map.put(7, Arrays.asList("p", "q", "r", "s"));
        map.put(8, Arrays.asList("t", "u", "v"));
        map.put(9, Arrays.asList("w", "x", "y", "z"));
    }

    public static List<String> letterCombinations(String digits) {
        digits = digits.replace("0", "").replace("1", "");
        List<String> result = new ArrayList<>();
        if(digits.length() == 0) {
            return result;
        }
        if(digits.length() == 1) {
            return map.get(digits.charAt(0) - '0');
        }
        List<String> intermediate = letterCombinations(digits.substring(1, digits.length()));
        for(String first : map.get(digits.charAt(0) - '0')) {
            for(String rest : intermediate) {
                result.add(first + rest);
            }
        }
        return result;
    }
}
