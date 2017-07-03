package tc.bites;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Given two strings s and t, determine if they are isomorphic.
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * All occurrences of a character must be replaced with another character
 * while preserving the order of characters. No two characters may map to
 * the same character but a character may map to itself.
 * For example,
 * Given "egg", "add", return true.
 * Given "foo", "bar", return false.
 * Given "paper", "title", return true.
 * Note:
 * You may assume both s and t have the same length.
 */
public class IsomorphicStringsTest {
    @Test(dataProvider="genStrings")
    public void testIso(String s, String t, boolean expected) {
        IsomorphicStrings sut = new IsomorphicStrings();
        boolean actual = sut.isIsomorphic(s, t);
        Assert.assertEquals(actual, expected, String.format("%s %s", s, t));
    }
    @DataProvider(name="genStrings")
    public Object[][] genStrings() {
        Object[][] cases = {
            {"egg", "add", true},
            {"foo", "bar", false},
            {"paper", "title", true},
            {"abcdefghij", "klmnopqrst", true},
            {"ab", "xx", false},
            {"xx", "ab", false},
            {"xx", "yy", true}

        };
        return cases;
    }
}
