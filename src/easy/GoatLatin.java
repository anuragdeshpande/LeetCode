package easy;

/*
    A sentence S is given, composed of words separated by spaces.
    Each word consists of lowercase and uppercase letters only.

    We would like to convert the sentence to "Goat Latin" (a made-up language similar to Pig Latin.)

    The rules of Goat Latin are as follows:

    If a word begins with a vowel (a, e, i, o, or u), append "ma" to the end of the word.
    For example, the word 'apple' becomes 'applema'.

    If a word begins with a consonant (i.e. not a vowel), remove the first letter and append it to the end, then add "ma".
    For example, the word "goat" becomes "oatgma".

    Add one letter 'a' to the end of each word per its word index in the sentence, starting with 1.
    For example, the first word gets "a" added to the end, the second word gets "aa" added to the end and so on.
    Return the final sentence representing the conversion from S to Goat Latin.

    Example 1:
    Input: "I speak Goat Latin"
    Output: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"

    Example 2:
    Input: "The quick brown fox jumped over the lazy dog"
    Output: "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"

    Notes:
    S contains only uppercase, lowercase and spaces. Exactly one space between each word.
    1 <= S.length <= 150.
 */

public class GoatLatin {
    public static void main(String[] args) {
        GoatLatin tester = new GoatLatin();
        System.out.println(tester.toGoatLatin("I speak Goat Latin"));
        System.out.println(tester.toGoatLatin("The quick brown fox jumped over the lazy dog"));
    }

    /*
        Algorithm:
        init a string builder to store the word progress
        1. Split the string on spaces
        2. for each word in the split with index i
            2.a if the first letter is not vowel split string at 1
            2.b add "ma" and add "a" repeated i+1 times
            2.c add the word to string builder.
            2.d append a space.
        3. return trimmed toString for string builder
     */
    private String toGoatLatin(String S) {
        StringBuilder resultString = new StringBuilder();
        String[] words = S.split(" ");
        for (int i=0; i< words.length; i++) {
            String currentWord = words[i];
            char firstChar = currentWord.charAt(0);

            if(!("aAeEiIoOuU".contains(String.valueOf(firstChar)))){
                currentWord = currentWord.substring(1).concat(String.valueOf(currentWord.charAt(0)));
            }

            resultString.append(currentWord.concat("ma").concat(new String(new char[i+1]).replace("\0", "a"))).append(" ");
        }

        return resultString.toString();
    }
}
