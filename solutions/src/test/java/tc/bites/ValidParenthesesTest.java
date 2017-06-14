package tc.bites;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Given a string containing just the characters
 * '(', ')', '{', '}', '[' and ']', determine
 * if the input string is valid.
 * The brackets must close in the correct order,
 * "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */
public class ValidParenthesesTest {
    @Test(dataProvider="parenGen")
    public void testParens(String text, boolean expected) {
        ValidParentheses s = new ValidParentheses();
        boolean actual = s.isValid(text);
        Assert.assertEquals(expected, actual);
    }
    @DataProvider(name="parenGen")
    public Object[][] parenGen() {
        Object[][] cases = {
            {"()", true},
            {"()[]{}", true},
            {"(]", false},
            {"([)]", false},
            {"", true},
            {"}", false},
            {"<", false}
        };
        return cases;
    }
}
