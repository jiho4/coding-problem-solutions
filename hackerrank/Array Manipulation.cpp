/**
 * Array Manipulation
 * https://www.hackerrank.com/challenges/crush/submissions/code/43997341
 * solved: 2017-05-10
 * comment: https://www.hackerrank.com/challenges/crush/forum/comments/299909
 */
#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
#include <limits.h>
using namespace std;

// imagine the mountain tracking from left to right, and 'max'(tracker) stores the maximum height.
// each arr[x] stores the height. arr[x] draws graph which shape looks like mountain.
// starting point 'a' means go up / end point 'b+1' means go down.
int main() {
    long int N, M, a, b, k, i, j;
    long int max = 0, x = 0;
    cin >> N >> M;
    long int *arr = new long int[N+1];

    for(i = 0; i < M; i++) {
        cin >> a >> b >> k;
        arr[a] += k;
        if ((b+1) <= N)
            arr[b+1] -= k;
    }

    for(i = 1; i <= N; i++) {
        x += arr[i];
        if (max < x)
            max = x;
    }

    cout << max;

    return 0;
}

/*
// this takes too much time.
int main() {
    int M;
    long int N, a, b, k;
    cin >> N >> M;
    long int *arr = new long int[N];

    for (int i = 0; i < M; i++) {
        cin >> a >> b >> k;
        for (long int i = a; i <= b; i++) {
            arr[i-1] += k;
        }
    }

    long int max = INT_MIN;
    for (long int i = 0; i < N; i++) {
        if (max < arr[i])
            max = arr[i];
    }

    cout << max;

    return 0;
}
*/
