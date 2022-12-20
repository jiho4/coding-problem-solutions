/**
 * Day 9: Recursion 3
 * https://www.hackerrank.com/challenges/30-recursion/submissions/code/43567676
 * solved: 2017-05-03
 */
#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

int factorial(int k) {
    if (k == 1) {
        return 1;
    }
    else if (k < 1) {
        cout << "wrong input";
        return 0;
    }
    else {
        return k*factorial(k-1);
    }
}

int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    int n;
    cin >> n;
    cout << factorial(n) << endl;
    return 0;
}
