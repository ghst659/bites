package tc.bites;

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
public class WordLadder {
    private static Map<String, List<String>> buckets = new HashMap<>();
    private static Map<String, Set<String>> wordToKeys = new HashMap<>();
    public static void bucketise(List<String> wordList) {
        wordToKeys.clear();
        buckets.clear();
        for (String word: wordList) {
            if (! wordToKeys.containsKey(word)) {
                wordToKeys.put(word, new HashSet<>());
            }
            for (int i = 0; i < word.length(); ++i) {
                String prefix = word.substring(0, i);
                String suffix = word.substring(i+1);
                String key = prefix + '_' + suffix;
                if (! buckets.containsKey(key)) {
                    buckets.put(key, new LinkedList<>());
                }
                buckets.get(key).add(word);
                wordToKeys.get(word).add(key);
            }
        }
    }
    public static Set<String> neighbours(String word) {
        Set<String> result = new HashSet<>();
        if (wordToKeys.containsKey(word)) {
            for (String key: wordToKeys.get(word)) {
                for (String otherWord: buckets.get(key)) {
                    if (! otherWord.equals(word)) {
                        result.add(otherWord);
                    }
                }
            }
        }
        // System.err.println(word + "-> " + result.toString());
        return result;
    }
    private static class TrailNode {
        public String word;
        public int depth = 0;
        public TrailNode(String w, int d) {
            word = w;
            depth = d;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int result = 0;
        wordList.add(beginWord);
        bucketise(wordList);
        Set<String> visited = new HashSet<>();
        Queue<TrailNode> queue = new LinkedList<>();
        queue.add(new TrailNode(beginWord, 0));
        for (boolean atEnd = false; queue.size() > 0 && ! atEnd; ) {
            TrailNode current = queue.remove();
            // System.err.format("(%s, %d)\n", current.word, current.depth);
            visited.add(current.word);
            if (current.word.equals(endWord)) {
                atEnd = true;
                result = current.depth + 1;
            } else {
                for (String n: neighbours(current.word)) {
                    if (! visited.contains(n)) {
                        queue.add(new TrailNode(n, current.depth + 1));
                    }
                }
            }
        }
        return result;
    }
}
