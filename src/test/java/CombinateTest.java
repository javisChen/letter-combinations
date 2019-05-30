import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

/*
 * @author JavisChen
 * @desc CombinateTest
 * @date 2019/5/30 10:39 PM
 */
public class CombinateTest {

    @Test
    public void test() {
        String digits = "234";
        int total = calTotal(digits);
        Combinate.letterCombinations(digits);
        List<String> result = Combinate.letterCombinations(digits);
        System.out.println("total combinations:" + total);
        System.out.println("combinations:" + result.stream().collect(Collectors.joining(" ")));
        Assert.assertEquals(result.size(), total);
    }

    /**
     * calculate combinations totals
     */
    private int calTotal(String digits) {
        int total = 1;
        for (int i = 0; i < digits.length(); i++) {
            int key = digits.charAt(i) - '0';
            if (key == 0 || key == 1) {
                continue;
            }
            List<String> strings = Combinate.map.get(key);
            total *= strings.size();
        }
        return total;
    }
}
