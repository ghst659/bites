package tc.bites;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Given a string, find the length of the longest substring without
 * repeating characters.
 * Examples:
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * Given "bbbbb", the answer is "b", with the length of 1.
 * Given "pwwkew", the answer is "wke", with the length of 3.
 * Note that the answer must be a substring, "pwke" is a subsequence
 * and not a substring.
 */
public class LongestSubstringNoRepeatTest {
    @Test(dataProvider="genString")
    public void testStrings(String text, int expectedLen) {
        System.err.println(text);
        LongestSubstringNoRepeat s = new LongestSubstringNoRepeat();
        int actualLen = s.lengthOfLongestSubstring(text);
        Assert.assertEquals(actualLen, expectedLen, text);
    }
    @DataProvider(name="genString")
    public Object[][] genString() {
        Object[][] cases = {
            {"abcabcbb", 3},
            {"bbbbb", 1},
            {"pwwkew", 3},
            {"0123456789", 10},
            {"00123456789", 10},
            {"0123012341234", 5},
            {"0123012341abc", 7},
            {"012340abcdefghijklmnopqrstuvwxyzlab", 31}

        };
        return cases;
    }
}
