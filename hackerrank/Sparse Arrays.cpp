/**
 * Sparse Arrays
 * https://www.hackerrank.com/challenges/sparse-arrays/submissions/code/43500971
 * solved: 2017-05-02
 */
#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    int n, q;
    int count;

    cin >> n;

    string input[n];

    for (int i = 0; i < n; i++) {
        cin >> input[i];
    }

    cin >> q;

    string query[q];

    for (int i = 0; i < q; i++) {
        cin >> query[i];
    }

    for (int i = 0; i < q; i++) {
        count = 0;
        for (int j = 0; j < n; j++) {
            if (query[i].compare(input[j]) == 0)
                count++;
        }
        cout << count << endl;
    }

    return 0;
}
