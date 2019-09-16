package com.test;

public class Palindrome {
    /**
     *
     * Have the function Palindrome(str) take the str parameter being passed and return the string true if the parameter is a palindrome,
     * (the string is the same forward as it is backward) otherwise return the string false. For example: "racecar" is also "racecar" backwards.
     * Punctuation and numbers will not be part of the string.
     *
     * Sample Test Cases
     *
     * Input:"never odd or even"
     *
     * Output:true
     *
     * Input:"eye"
     *
     * Output:true
     *
     * @param str
     * @return
     */
    public String isPalindrome(String str) {
        char[] original = str.replace(" ", "").toCharArray();
        StringBuilder reverse = new StringBuilder(str.length());
        for (int i = original.length-1; i >= 0; i--) {
            reverse.append(original[i]);
        }
        return new String(original).equalsIgnoreCase(reverse.toString()) + "";
    }
}
