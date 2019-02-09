package easy;

import java.util.*;

/*
    We are given two sentences A and B.  (A sentence is a string of space separated words.
    Each word consists only of lowercase letters.)
    A word is uncommon if it appears exactly once in one of the sentences,
    and does not appear in the other sentence.
    Return a list of all uncommon words. You may return the list in any order.

    Example 1:
    Input: A = "this apple is sweet", B = "this apple is sour"
    Output: ["sweet","sour"]

    Example 2:
    Input: A = "apple apple", B = "banana"
    Output: ["banana"]

    Note:
    0 <= A.length <= 200
    0 <= B.length <= 200
    A and B both contain only spaces and lowercase letters.
 */
public class UnCommonWordsFromTwoSentences {
    public static void main(String[] args) {
        UnCommonWordsFromTwoSentences tester = new UnCommonWordsFromTwoSentences();
        System.out.println(Arrays.toString(tester.uncommonFromSentences("this apple is sweet", "this apple is sour")));
        System.out.println(Arrays.toString(tester.uncommonFromSentences("s z z z s", "s z ejt")));
    }

    /*
        Algorithm:
        1. Combine 2 strings to one and split by space
        2. create HashMap to store the word as the key and its count as value
        3. run through the map get the keys whose value is 1
        4. convert to array and return
     */
    @SuppressWarnings("Duplicates")
    private String[] uncommonFromSentences(String A, String B) {
        HashMap<String, Integer> words = new HashMap<>();
        ArrayList<String> uncommonWords = new ArrayList<>();
        for(String word : (A+" "+B).split(" ")){
            if(words.containsKey(word)){
                int count = words.get(word);
                count++;
                words.put(word, count);
            } else {
                words.put(word, 1);
            }
        }

        for (Map.Entry<String, Integer> entry : words.entrySet()) {
            if (entry.getValue() == 1) uncommonWords.add(entry.getKey());
        }
        return uncommonWords.toArray(new String[0]);
    }
}
