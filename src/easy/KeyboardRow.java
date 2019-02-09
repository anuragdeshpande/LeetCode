package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/*
    Given a List of words, return the words that can be typed using letters of alphabet on only one
    row's of American keyboard (QWERTY layout).

    Example:

    Input: ["Hello", "Alaska", "Dad", "Peace"]
    Output: ["Alaska", "Dad"]
 */

public class KeyboardRow {
    public static void main(String[] args) {
        KeyboardRow tester = new KeyboardRow();
        System.out.println(Arrays.toString(tester.findWords(new String[]{"Hello", "Alaska", "Dad", "Peace"})));
        System.out.println(Arrays.toString(tester.findWords(new String[]{"asdfghjkl","qwertyuiop","zxcvbnm"})));
    }

    /*
        Algorithm:
            1. Initiate HashSets with letters of each row
            2. For each word, convert to lower case to even out the letters for scanning
            3. Find the row in which the first letter of the lower case word is in
            4. in the given row make sure all the letters in the word are present
            5. if so, add to the final list of words
            6. once all the words are processed, transform the list to array and return the final array
     */
    private String[] findWords(String[] words) {
        HashSet<Character> topRow = new HashSet<>(Arrays.asList('q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'));
        HashSet<Character> homeRow = new HashSet<>(Arrays.asList('a','s','d','f','g','h','j','k','l'));
        HashSet<Character> bottomRow = new HashSet<>(Arrays.asList('z','x','c','v','b','n','m'));
        ArrayList<String> finalWords = new ArrayList<>();
        for(String word: words){
            String lowerWord = word.toLowerCase();
            char firstChar = lowerWord.charAt(0);
            if(topRow.contains(firstChar) && canBuildWord(lowerWord, topRow)){
                finalWords.add(word);
            } else if(homeRow.contains(firstChar) && canBuildWord(lowerWord, homeRow)){
                finalWords.add(word);
            } else if(bottomRow.contains(firstChar) && canBuildWord(lowerWord, bottomRow)){
                finalWords.add(word);
            }
        }
        String[] finalArray = new String[finalWords.size()];
        return finalWords.toArray(finalArray);
    }

    private boolean canBuildWord(String word, HashSet rowValues){
        for(char character: word.toCharArray()){
            if(!rowValues.contains(character)){
                return false;
            }
        }

        return true;
    }
}
