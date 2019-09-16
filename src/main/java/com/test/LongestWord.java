package com.test;

import javax.xml.stream.events.Characters;

public class LongestWord {
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
