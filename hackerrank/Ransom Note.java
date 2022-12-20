package hackerrank;

import java.util.*;

/**
 * Hash Tables: ansom Note
 * https://www.hackerrank.com/challenges/ctci-ransom-note/submissions/code/81733672
 * solved: 2018-08-17
 */
class Solution {

    private static final String YES = "Yes";
    private static final String NO = "No";

    // Complete the checkMagazine function below.
    static String checkMagazine(String[] magazine, String[] note) {

        Hashtable<String, Integer> hash = new Hashtable<String, Integer>();

        // put magazine's word into hash
        for (String key : magazine) {
            if (hash.containsKey(key)) {
                // if there is already one in hash, then increment value by 1
                hash.put(key, hash.get(key) + 1);
            } else {
                hash.put(key, 1);
            }
        }

        for (String word : note) {
            if (hash.containsKey(word) && hash.get(word) != 0) {
                // decrement value because note's word used one of magazine's word
                hash.put(word, hash.get(word) - 1);
            } else {
                // else means that there are no applicable word left in hashTable
                return NO;
            }
        }

        return YES;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }

        String[] note = new String[n];

        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            note[i] = noteItem;
        }

        System.out.println(checkMagazine(magazine, note));

        scanner.close();
    }
}
