package hackerrank;

import java.io.*;
import java.util.*;

/**
 * Minimum Time Required
 * https://www.hackerrank.com/challenges/minimum-time-required/submissions/code/86632061
 * solved: 2018-10-03
 */
class Solution {

    // Complete the minTime function below.
    static long minTime(long[] machines, long goal)
    {
        Arrays.sort(machines);

        long maxDays = machines[machines.length - 1] * goal / machines.length;
        long mindays = machines[0] * goal / machines.length;

        return findRequiredDays(machines, goal, maxDays, mindays);
    }

    static long findRequiredDays(long[] machines, long goal, long maxDays, long minDays)
    {
        long medium;
        long producedItems;

        while(minDays < maxDays) {
            producedItems = 0;
            medium = minDays + ((maxDays - minDays) / 2);

            for (long machine : machines) {
                producedItems += (medium / machine);
            }

            if(producedItems < goal) {
                minDays = medium + 1;
            } else {
                maxDays = medium;
            }
        }

        return maxDays;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nGoal = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nGoal[0]);

        long goal = Long.parseLong(nGoal[1]);

        long[] machines = new long[n];

        String[] machinesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            long machinesItem = Long.parseLong(machinesItems[i]);
            machines[i] = machinesItem;
        }

        long ans = minTime(machines, goal);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
