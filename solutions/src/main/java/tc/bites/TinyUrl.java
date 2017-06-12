package tc.bites;

import java.util.HashMap;
import java.util.Map;

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
public class TinyUrl {
    private static final String PREFIX = "http://tinyurl.com/";
    private static Map<String,String> tbl = new HashMap<>();
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String key = Integer.toHexString(longUrl.hashCode());
        tbl.put(key, longUrl);
        String result = PREFIX + key;
        return result;
    }
    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String key = shortUrl.replace(PREFIX, "");
        String result = tbl.get(key);
        return result;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
