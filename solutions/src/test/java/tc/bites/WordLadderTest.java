package tc.bites;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.*;

/*
 *  Given two words (beginWord and endWord), and a dictionary's word list,
 *  find the length of shortest transformation sequence from beginWord to endWord, such that:
 *  Only one letter can be changed at a time.
 *  Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 * For example,
 * Given:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * Note:
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 */
public class WordLadderTest {
    private WordLadder sut = new WordLadder();

    @Test(dataProvider = "wordLadderGen")
    public void testWordLadder(String beginWord, String endWord, String[] wordAry, int expected) {
        List<String> wordList = new LinkedList<>();
        wordList.addAll(Arrays.asList(wordAry));
        int ladderLen = sut.ladderLength(beginWord, endWord, wordList);
        Assert.assertEquals(ladderLen, expected);
    }

    @DataProvider(name = "wordLadderGen")
    public Object[][] wordLadderGen() {
        Object[][] result = {
            {"hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"}, 5}
        };
        return result;
    }

    // @Test(dataProvider = "neighbourGen")
    public void testNeighbours(String[]wordList, String word, String[]neighbours) {
        WordLadder.bucketise(Arrays.asList(wordList));
        Set<String> expected = new HashSet<>();
        expected.addAll(Arrays.asList(neighbours));
        Set<String> found = WordLadder.neighbours(word);
        Assert.assertEquals(found, expected);
    }
    @DataProvider(name="neighbourGen")
    public Object[][] neighbourGen() {
        Object[][] result = {
            {
                new String[]{"hit", "hot", "dot", "dog", "lot", "log", "cog"},
                "hit",
                new String[]{"hot"}
            },
            {
                new String[]{"hit", "hot", "dot", "dog", "lot", "log", "cog"},
                "dog",
                new String[]{"dot", "log", "cog"}
            },
        };
        return result;
    }
}
