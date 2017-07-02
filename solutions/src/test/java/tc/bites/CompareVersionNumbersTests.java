package tc.bites;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Compare two version numbers version1 and version2.
 * If version1 > version2 return 1,
 * if version1 < version2 return -1,
 * otherwise return 0.
 * You may assume that the version strings are non-empty and
 * contain only digits and the . character.
 * The . character does not represent a decimal point and is
 * used to separate number sequences.
 * For instance, 2.5 is not
 * "two and a half" or "half way to version three",
 * it is the fifth second-level revision of the second first-level revision.
 * Here is an example of version numbers ordering:
 * 0.1 < 1.1 < 1.2 < 13.37
 */
public class CompareVersionNumbersTests {
    @Test(dataProvider="vGen")
    public void testVersionComparator(String version1, String version2, int expected) {
        CompareVersionNumbers sut = new CompareVersionNumbers();
        int actual = sut.compareVersion(version1, version2);
        Assert.assertEquals(actual, expected, String.format("%s ? %s", version1, version2));
    }
    @DataProvider(name="vGen")
    public Object[][] vGen() {
        Object[][] cases = {
            {"0.1", "1.1", -1},
            {"1.1", "0.1", 1},
            {"1.0", "1.0", 0},
            {"1.1", "1.2", -1},
            {"13.37", "1.2", 1},
            {".1", "0.1", 0},
            {"1", "1.0", 0},
            {"1.0.1", "1.1", -1},
            {"3.0.0", "3", 0},
            {"3..5.0","3.0.5", 0},
            {"4..", "4", 0},
            {"0.15.0", "0.1.9", 1}
        };
        return cases;
    }
}

