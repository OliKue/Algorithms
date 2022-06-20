package de.olikue.leetcode;

import java.util.*;

public class LongestSubString {
    /**
     * Given a string s, find the length of the longest substring without repeating characters.
     */
    public int lengthOfLongestSubstring(String s) {
        int max=0;
        int p1=0,p2=0;

        Set<Character> window = new HashSet<>();

        while (p2<s.length()){
            if(!window.contains(s.charAt(p2))){
                window.add(s.charAt(p2));
                p2++;
                max=Math.max(max,window.size());
            }else{
                window.remove(s.charAt(p1));
                p1++;
            }

        }

        return max;
    }
}
