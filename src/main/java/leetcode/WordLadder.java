package leetcode;

import java.util.ArrayList;
import java.util.List;

public class WordLadder {
    public static void main(String[] args) {
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("cig");
        wordList.add("big");
        wordList.add("cog");
        boolean result = containsString("cog", wordList);
        System.out.println(result);
    }

    public static boolean containsString(String target, List<String> wordList) {
        for (String word : wordList) {
            if (word.equals(target)) {
                return true;
            }
        }
        return false;
    }


    public int wordLadder(String beginWord, String endWord, List<String> wordList){
        if (containsString(endWord, wordList)){
            
        }
        System.out.println("The endWord cog is not in wordList, therefore there is no valid transformation sequence.");
        return 0;
    }
}
