package leetcode;

/**
 * 5. Longest Palindromic Substring
 * https://leetcode.com/problems/longest-palindromic-substring/submissions/873573701/
 * solved: 2023-01-07
 */
class Solution {
    public String longestPalindrome(String s) {
        String longS = "";

        for (int i = 0; i < s.length(); i++) {
            String oddS = extendPalindrome(s, i, i);
            String evenS = extendPalindrome(s, i, i + 1);

            if (oddS.length() > longS.length()) longS = oddS;
            if (evenS.length() > longS.length()) longS = evenS;
        }

        return longS;
    }

    private String extendPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) != s.charAt(right)) {
                break;
            }

            left--;
            right++;
        }

        // since final left & right is not valid, so substring from left+1
        return s.substring(left + 1, right);
    }
}

// *first try: brute force from the longest String
// class Solution {
//     public String longestPalindrome(String s) {

//         int length = s.length() - 1;

//         while (length > 0) {
//             int start = 0;
//             int end = length + 1;

//             while (end < s.length() + 1) {
//                 if (isPalindrome(s.substring(start, end))) {
//                     return s.substring(start, end);
//                 }

//                 start++;
//                 end++;
//             }

//             length--;
//         }

//         return s.substring(0, 1);
//     }

//     private boolean isPalindrome(String sub) {
//         int start = 0;
//         int end = sub.length() - 1;

//         while (start < end) {
//             if (sub.charAt(start) != sub.charAt(end)) {
//                 return false;
//             }

//             start++;
//             end--;
//         }

//         return true;
//     }
// }