package leetcode;

import java.util.*;

/**
 * 13. Roman to Integer
 * https://leetcode.com/problems/roman-to-integer/submissions/559265030/
 * solved: 2021-09-22
 */
class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int convertedNum = 0;
        int prevNum = 1000; // set as a maximum value so that first iteration works correctly
        int currentNum;

        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        for(int i = 0; i < s.length(); i++) {
            currentNum = map.get(s.charAt(i));

            if(prevNum >= currentNum) {
                convertedNum += currentNum;
            } else {
                // cancel the previous addition and then add the current value
                convertedNum -= prevNum;
                convertedNum += (currentNum - prevNum);
            }

            prevNum = currentNum;
        }

        return convertedNum;
    }
}

// first try
// class Solution {
//     static final int I = 1;
//     static final int V = 5;
//     static final int X = 10;
//     static final int L = 50;
//     static final int C = 100;
//     static final int D = 500;
//     static final int M = 1000;

//     static final int IV = 4;
//     static final int IX = 9;
//     static final int XL = 40;
//     static final int XC = 90;
//     static final int CD = 400;
//     static final int CM = 900;

//     static final List<String> CHECKER = Arrays.asList("IV", "IX", "XL", "XC", "CD", "CM");

//     public int romanToInt(String s) {
//         char prevChar = 'x';
//         char currentChar;
//         int convertedNumber = 0;

//         for(int i = 0; i < s.length(); i++) {
//             currentChar = s.charAt(i);

//             if (CHECKER.contains(new String(new char[]{prevChar, currentChar}))) {
//                 switch(currentChar) {
//                     case 'V':
//                         convertedNumber += (IV - I);
//                         break;
//                     case 'X':
//                         convertedNumber += (IX - I);
//                         break;
//                     case 'L':
//                         convertedNumber += (XL - X);
//                         break;
//                     case 'C':
//                         convertedNumber += (XC - X);
//                         break;
//                     case 'D':
//                         convertedNumber += (CD - C);
//                         break;
//                     case 'M':
//                         convertedNumber += (CM - C);
//                         break;
//                     default:
//                         return -1;
//                 }
//             } else {
//                 switch(currentChar) {
//                     case 'I':
//                         convertedNumber += I;
//                         break;
//                     case 'V':
//                         convertedNumber += V;
//                         break;
//                     case 'X':
//                         convertedNumber += X;
//                         break;
//                     case 'L':
//                         convertedNumber += L;
//                         break;
//                     case 'C':
//                         convertedNumber += C;
//                         break;
//                     case 'D':
//                         convertedNumber += D;
//                         break;
//                     case 'M':
//                         convertedNumber += M;
//                         break;
//                     default:
//                         return -1;
//                 }
//             }

//             prevChar = currentChar;
//         }

//         return convertedNumber;
//     }
// }
