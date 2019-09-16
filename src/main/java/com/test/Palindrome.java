package com.test;

public class Palindrome {
    public String isPalindrome(String str) {
        char[] original = str.replace(" ", "").toCharArray();
        StringBuilder reverse = new StringBuilder(str.length());
        for (int i = original.length-1; i >= 0; i--) {
            reverse.append(original[i]);
        }
        return new String(original).equalsIgnoreCase(reverse.toString()) + "";
    }
}
