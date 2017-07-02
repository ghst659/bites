package tc.bites;

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
public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        int result = 0;
        String[] parts1 = version1.split("\\.");
        String[] parts2 = version2.split("\\.");
        int i = 0;
        for (i = 0; i < Math.min(parts1.length, parts2.length) && result == 0; ++i) {
            int n1 = nValue(parts1[i]);
            int n2 = nValue(parts2[i]);
            if (n1 < n2) {
                result = -1;
            } else if (n1 > n2) {
                result = 1;
            } else {
                result = 0;
            }
        }
        for (; i < parts1.length && result == 0; ++i) {
            if (nValue(parts1[i]) > 0) {
                result = 1;
            }
        }
        for (; i < parts2.length && result == 0; ++i) {
            if (nValue(parts2[i]) > 0) {
                result = -1;
            }
        }
        return result;
    }
    private int nValue(String e) {
        return (e == null || e.equals("") ? 0 : Integer.parseInt(e));
    }
}
