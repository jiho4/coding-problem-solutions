package leetcode;

/**
 * 97. Interleaving String
 * https://leetcode.com/problems/interleaving-string/submissions/740751153/
 * solved: 2022-07-07
 */
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();

        // remember only two rows
        boolean[][] mem = new boolean[2][len1 + 1];

        if (len3 != len1 + len2) {
            return false;
        } else if (len1 > len2) {
            // use shorter one for mem array
            return isInterleave(s2, s1, s3);
        } else {}

        for (int i = 0; i <= len2; i++) {
            for (int j = 0; j <= len1; j++) {
                if (i == 0 && j == 0) {
                    mem[0][0] = true;
                } else if (i == 0) {
                    mem[0][j]
                        = mem[0][j-1] && (s1.charAt(j-1) == s3.charAt(j-1));
                } else if (j == 0) {
                    mem[i&1][0]
                        = mem[(i-1)&1][0]  && (s2.charAt(i-1) == s3.charAt(i-1));
                } else {
                    mem[i&1][j]
                        = (mem[i&1][j-1] && (s1.charAt(j-1) == s3.charAt(i+j-1)))
                        || (mem[(i-1)&1][j] && (s2.charAt(i-1) == s3.charAt(i+j-1)));
                }
            }
        }

        return mem[len2&1][len1];
    }
}
