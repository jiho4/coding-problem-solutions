/**
 * Chief Hopper
 * https://www.hackerrank.com/challenges/chief-hopper/submissions/code/44221591
 * solved: 2017-05-13
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
    int energy = 0;
    cin >> n;
    int a[n];
    for(int i = 0; i < n; i++) {
        cin >> a[i];
    }
    for(int i = 0; i < n; i++) {
        energy = (energy + a[n-1-i] + 1)/2;
    }
    cout << energy;
    return 0;
}
