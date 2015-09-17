package com.yishen;
/**
 * Created by yishen on 15/9/2.
 */
public class ImplementStrStr {
    public static void main(String[] args) {
        System.out.println(new ImplementStrStr().strStr("", ""));
    }

    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return -1;
        }

        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            int j = 0;
            while (j < needle.length() && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }

            if (j == needle.length()) {
                return i;
            }
        }
        return -1;
    }
}
