package com.test;

/**
 *
 */
public class LongestWord {


    /**
     * Have the function LongestWord(sen) take the sen parameter being passed and return the largest word in the string.
     * If there are two or more words that are the same length, return the first word from the string with that length.
     * Ignore punctuation and assume sen will not be empty.
     *
     *
     * Sample Test Cases
     *
     * Input:"fun&!! time"
     * Output:"time"
     *
     * Input:"I love dogs"
     * Output:"love"
     *
     * Hint
     * It might be easier to first convert the string into an array of words, and then loop through the array searching for the word with the most characters.
     *
     * @param sen
     * @return
     */
    public String solution(String sen){
        char senArr[] = sen.toCharArray();
        String longestWord = "";
        StringBuilder temp = new StringBuilder();
        boolean isWord;
        for (int i = 0; i < senArr.length; i++) {
            if (Character.isLetterOrDigit(senArr[i])){
                isWord = true;
                temp.append(senArr[i]);
            } else {
                isWord = false;
            }

            if ((!isWord || i+1 == senArr.length) && temp.toString().length() > longestWord.length()) {
                longestWord = temp.toString();
                temp = new StringBuilder();
            } else if (!isWord) {
                temp = new StringBuilder();
            }
        }
        return longestWord;
    }
}
