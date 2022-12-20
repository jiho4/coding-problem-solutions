package leetcode;

import java.util.*;

/**
 * 12. Integer to Roman
 * https://leetcode.com/problems/integer-to-roman/submissions/708352585/
 * solved: 2022-05-27
 */
class Solution {
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        Map<Integer, String> map = new LinkedHashMap<Integer, String>();

        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");

        for(Map.Entry<Integer, String> e: map.entrySet()) {
            while(num > 0) {
                if(num >= e.getKey()) {
                    sb.append(e.getValue());
                    num = num - e.getKey();
                } else {
                    break;
                }
            }
        }

        return sb.toString();
    }
}
