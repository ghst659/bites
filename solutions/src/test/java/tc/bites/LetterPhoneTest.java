package tc.bites;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * Given a digit string, return all possible letter combinations that the number could
 * represent.A mapping of digit to letters is
 * 1:
 * 2: abc
 * 3: def
 * 4: ghi
 * 5: jkl
 * 6: mno
 * 7: pqrs
 * 8: tuv
 * 9: wxyz
 * 0: space
 * *: +
 * #:
 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class LetterPhoneTest {
    private LetterPhone sut = new LetterPhone();
    private Set<String> l2s(List<String> l) {
        Set<String> result = new HashSet();
        for (String s: l) {
            result.add(s);
        }
        return result;
    }
    @Test(dataProvider="letterPhoneGen")
    public void testLetterCombinations(String digits, String[] expected) {
        List<String> exList = Arrays.asList(expected);
        List<String> found = sut.letterCombinations(digits);
        Assert.assertEquals(l2s(found), l2s(exList));
    }
    @DataProvider(name="letterPhoneGen")
    public Object[][] letterPhoneGen() {
        Object[][] result = {
            {"23", new String[]{"ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"}},
            {"84", new String[]{"tg", "th", "ti", "ug", "uh", "ui", "vg", "vh", "vi"}}
        };
        return result;
    }
}
