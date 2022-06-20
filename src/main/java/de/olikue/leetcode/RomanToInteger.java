package de.olikue.leetcode;


public class RomanToInteger {
    public int romanToInt(String s) {
        int sum = 0;
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            int val1 = getValue(chars[i]);
            if (!(i == chars.length - 1)) {
                int val2 = getValue(chars[i + 1]);
                if (val1 < val2) {
                    sum -= val1;
                } else {
                    sum += val1;
                }
            }else{
                sum += val1;
            }
        }
        return sum;
    }

    public int getValue(char c) {
        int value = switch (c) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> 0;
        };
        return value;
    }

}
