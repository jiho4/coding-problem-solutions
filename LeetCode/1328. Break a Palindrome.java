package leetcode;

/**
 * 1328. Break a Palindrome
 * https://leetcode.com/problems/break-a-palindrome/submissions/559726899/
 * solved: 2021-09-23
 */
class Solution {
    public String breakPalindrome(String palindrome) {
        // convert String to char array to speed up the process
        char[] arr = palindrome.toCharArray();

        if (arr.length == 1) {
            return "";
        } else {
            // replace the first non 'a' character to 'a' till the first-half of the string
            for (int i = 0; i < arr.length / 2; i++) {
                if (arr[i] != 'a') {
                    // replace the char at i to 'a' character
                    arr[i] = 'a';
                    return String.valueOf(arr);
                } else {}
            }

            // if all characters of first half is 'a', then replace the final 'a' to 'b'
            arr[arr.length - 1] = 'b';
            return String.valueOf(arr);
        }
    }
}

// *first solution (was a little bit slow due to calling to many charAt() function)
// class Solution {
//     public String breakPalindrome(String palindrome) {
//         if (palindrome.length() == 1) {
//             return "";
//         } else {
//             // replace the first non 'a' character to 'a' till the first-half of the string
//             for (int i = 0; i < palindrome.length() / 2; i++) {
//                 if (palindrome.charAt(i) != 'a') {
//                     // replace the char at i to 'a' character
//                     return palindrome.substring(0, i) + 'a' + palindrome.substring(i + 1);
//                 } else {}
//             }

//             // if all characters of first half is 'a', then replace the final 'a' to 'b'
//             return palindrome.substring(0, palindrome.length() - 1) + 'b';
//         }
//     }
// }
