package hackerrank;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

/**
 * Meeting Profit Target
 * https://www.hackerrank.com/contests/moodys-analytics-2018-university-codesprint/challenges/meeting-profit-target/submissions/code/1309702404
 * solved: 2018-08-18
 */
// one test case was failed due to timeout
class Solution {

    // Complete the solve function below.
    static int solve(List<List<Integer>> profits) {

        int actual, target;
        long stored = 0;

        for (List<Integer> profit : profits) {
            actual = profit.get(0);
            target = profit.get(1);

            if (actual < target + stored) {
                stored += target - actual;
            } else {
                stored = 0;
            }
        }

        return stored == 0 ? 0 : 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<List<Integer>> profits = new ArrayList<>();

                IntStream.range(0, n).forEach(i -> {
                    try {
                        profits.add(
                            Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                        );
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                int res = solve(profits);

                bufferedWriter.write(String.valueOf(res));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
