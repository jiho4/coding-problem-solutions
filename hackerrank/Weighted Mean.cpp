/**
 * Day 0: Weighted Mean
 * https://www.hackerrank.com/challenges/s10-weighted-mean/submissions/code/44256024
 * solved: 2017-05-14
 */
#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    int n;
    int sum = 0, sum_weight = 0;
    cin >> n;

    int arr[n], weight[n];
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }
    for (int i = 0; i < n; i++) {
        cin >> weight[i];
    }
    for (int i = 0; i < n; i++) {
        sum += arr[i]*weight[i];
        sum_weight += weight[i];
    }

    cout << fixed;
    cout.precision(1);
    cout << (double)sum/sum_weight << endl;

    return 0;
}
