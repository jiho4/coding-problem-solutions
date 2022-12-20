/**
 * Diagonal Difference
 * https://www.hackerrank.com/challenges/diagonal-difference/submissions/code/43278790
 * solved: 2017-04-28
 */
#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

int main(){
    int n;
    cin >> n;
    vector< vector<int> > a(n,vector<int>(n));
    for(int a_i = 0;a_i < n;a_i++){
        for(int a_j = 0;a_j < n;a_j++){
            cin >> a[a_i][a_j];
        }
    }
    int sum_a = 0;
    int sum_b = 0;
    for(int i = 0; i < n; i++){
        sum_a += a[i][i];
        sum_b += a[i][(n-1)-i];
    }
    cout << abs(sum_a-sum_b) << endl;
    return 0;
}
