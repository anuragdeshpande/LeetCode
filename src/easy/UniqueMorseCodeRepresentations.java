package easy;

import java.util.HashMap;
import java.util.HashSet;

public class UniqueMorseCodeRepresentations {
    private static HashMap<String, String> morseMap = new HashMap<>();
    static{
        morseMap.put("a", ".-");
        morseMap.put("b", "-...");
        morseMap.put("c", "-.-.");
        morseMap.put("d", "-..");
        morseMap.put("e", ".");
        morseMap.put("f", "..-.");
        morseMap.put("g", "--.");
        morseMap.put("h", "....");
        morseMap.put("i", "..");
        morseMap.put("j", ".---");
        morseMap.put("k", "-.-");
        morseMap.put("l", ".-..");
        morseMap.put("m", "--");
        morseMap.put("n", "-.");
        morseMap.put("o", "---");
        morseMap.put("p", ".--.");
        morseMap.put("q", "--.-");
        morseMap.put("r", ".-.");
        morseMap.put("s", "...");
        morseMap.put("t", "-");
        morseMap.put("u", "..-");
        morseMap.put("v", "...-");
        morseMap.put("w", ".--");
        morseMap.put("x", "-..-");
        morseMap.put("y", "-.--");
        morseMap.put("z", "--..");
    }

    public static void main(String[] args) {
        UniqueMorseCodeRepresentations tester = new UniqueMorseCodeRepresentations();
        System.out.println(tester.uniqueMorseRepresentations(new String[]{"gin", "zen", "gig", "msg"}));
    }


    /*
        Algorithm:
            1. Initiate a Map that has alphabet as key and morse code as value.
                Initiate Set to store each morse representation for the word (return the count of this set as solution)
            2. For each given word
                Initiate a StringBuilder to store the morse representation of word by appending each character.
                2.a split by each character
                2.b For Each Character
                    2.b.a get corresponding morse code from the map
                    2.b.b append the representation to the builder
                2.c add morse representation in the builder to the set
            3. Return the size of the set as solution.
     */
    private int uniqueMorseRepresentations(String[] words) {
        HashSet<String> morseWordMap = new HashSet<>();
        for(String word: words){
            String[] chars = word.split("");
            StringBuilder builder = new StringBuilder();
            for(String character: chars){
                builder.append(UniqueMorseCodeRepresentations.morseMap.get(character));
            }

            morseWordMap.add(builder.toString());
        }

        return morseWordMap.size();
    }

    // Uses array itself as the morse map - but I feel this is not readable and not easy to maintain/ debug.
    private int alternateSolution(String[] words){
        String[] MORSE = new String[]{".-","-...","-.-.","-..",".","..-.","--.",
                "....","..",".---","-.-",".-..","--","-.",
                "---",".--.","--.-",".-.","...","-","..-",
                "...-",".--","-..-","-.--","--.."};

        HashSet<String> seen = new HashSet<>();
        for (String word: words) {
            StringBuilder code = new StringBuilder();
            for (char c: word.toCharArray())
                code.append(MORSE[c - 'a']);
            seen.add(code.toString());
        }

        return seen.size();
    }


}
