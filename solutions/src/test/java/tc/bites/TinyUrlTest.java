package tc.bites;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * TinyURL is a URL shortening service where you enter a URL
 * such as https://leetcode.com/problems/design-tinyurl and
 * it returns a short URL such as http://tinyurl.com/4e9iAk.
 * Design the encode and decode methods for the TinyURL service.
 * There is no restriction on how your encode/decode algorithm
 * should work. You just need to ensure that a URL can be encoded
 * to a tiny URL and the tiny URL can be decoded to the original URL.
 * Subscribe to see which companies asked this question.
 */
public class TinyUrlTest {
    @DataProvider(name="urlProvider")
    public Object[][] urlProvider() {
        Object[][] result = {
            {"http://www.google.com"},
            {"http://www.google.com/"},
            {"http://www.yahoo.com/"},
        };
        return result;
    }
    @Test(dataProvider="urlProvider")
    public void testUrlCodec(String longUrl) {
        // Your Codec object will be instantiated and called as such:
        TinyUrl codec = new TinyUrl();
        String shortUrl = codec.encode(longUrl);
        System.err.format("%s -> %s\n", longUrl, shortUrl);
        Assert.assertNotEquals(longUrl, shortUrl);
        String actual = codec.decode(shortUrl);
        Assert.assertEquals(longUrl, actual);
    }
}
