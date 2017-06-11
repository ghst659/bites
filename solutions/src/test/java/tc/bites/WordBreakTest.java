package tc.bites;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by tsc on 4/17/17.
 */
public class WordBreakTest {
    public final static String DICTPATH = "/usr/share/dict/american-english";
    public final static Set<String> DICT = new HashSet<>();
    public final static Set<String> SHORT = new HashSet<>();
    public final static String[] SMALL = {
        "i", "like", "sam", "sung", "samsung", "mobile", "ice",
        "cream", "icecream", "man", "go", "mango", "sun"
    };
    static {
        try (BufferedReader brin = new BufferedReader(new FileReader(DICTPATH))) {
            for (String buf = brin.readLine(); buf != null; buf = brin.readLine()) {
                String word = buf.trim();
                if (word.length() > 0) {
                    DICT.add(word);
                }
            }
            System.out.format("Dictionary size: %d\n", DICT.size());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        final String[] shorts = {
            "in", "up", "if", "he", "a", "i", "at", "ad", "it", "on", "of", "is", "go"
        };
        for (String word: shorts) {
            SHORT.add(word);
        }
    }
    private WordBreak cracker = null;
    @BeforeMethod
    public void setUp() {
        this.cracker = new WordBreak();
        this.cracker.learn(SMALL);
        for (String word : DICT) {
            if (word.length() > 2 || SHORT.contains(word)) {
                this.cracker.learn(word);
            }
        }
        System.out.format("dict size: %d\n", this.cracker.size());
    }
    @AfterMethod
    public void tearDown() {
        this.cracker = null;
    }
    @Test
    public void testStartup() {
        Assert.assertTrue(this.cracker.know("like"));
    }
    @Test
    public void testBasic() {
        // String input = "ilikesamsung";
        String[] inputs = {
            "bedroomsandbathtubscanmaybecausesoftheresendmayoralcatshearsoften",
            "i",
            "can",
            "bath",
            "catfood",
            "iscreaminthebathroom",
            "mayoralcatshearsoften",
            "bedroomsandbathtubscanmaybecausesoftheresend"
        };
        String[][] expected = {
            {"i","scream","in","the","bath","room"},
            {"is", "cream", "in", "the", "bath", "room"},
            {"i", "scream", "in", "the", "bathroom"},
            {"is", "cream", "in", "the", "bathroom"},
            {"mayoral", "cat", "shears", "often"},
            {"mayoral", "cat", "shears", "of", "ten"}
        };
        for (String input: inputs) {
            this.cracker.reset();
            List<List<String>> actual = this.cracker.wordBreaks(input, 0);
            System.err.format("%d -> %d calls\n", input.length(), this.cracker.calls());
            // Assert.assertEquals(expected.length, actual.size());
            int i = 0;
            for (List<String> answer: actual) {
                System.err.format("%d: %s\n", i++, String.join(" ", answer));
            }
        }
    }
}
