/**
 * Dynamic Array
 * https://www.hackerrank.com/challenges/dynamic-array/submissions/code/43948806
 * solved: 2017-05-09
 */
#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    int N, Q;
    int query_num;
    int x,y;
    int lastAns = 0;
    cin >> N >> Q;
    vector<int> seq[N];

    for (int i = 0; i < Q; i++) {
        cin >> query_num >> x >> y;
        if (query_num == 1) {
            seq[(x^lastAns)%N].push_back(y);
        }
        else if (query_num == 2) {
            int size = seq[(x^lastAns)%N].size();
            lastAns = seq[(x^lastAns)%N][y%size];
            cout << lastAns << endl;
        }
    }
    return 0;
}
