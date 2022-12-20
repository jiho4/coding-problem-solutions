/**
 * Day 0: Mean, Median, and Mode
 * https://www.hackerrank.com/challenges/s10-basic-statistics/submissions/code/44247572
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
    double mean = 0, median;
    int n, input;
    int mode, mode_counter = 0, counter = 1;
    cin >> n;
    vector<int> x;
    for (int i = 0; i < n; i++) {
        cin >> input;
        x.push_back(input);
        mean += x[i];
    }
    mean /= n;
    sort(x.begin(), x.end());

    if (x.size() % 2 == 0)
        median = (double)(x[x.size()/2 - 1] + x[x.size() / 2]) / 2;
    else
        median = (double)x[x.size()/2];

    mode = x[0];
    for (int i = 0; i < n-1; i++) {
        if (x[i] == x[i+1]) {
            counter++;
            if (counter == mode_counter) {
                if (mode > x[i])
                    mode = x[i];
            }
            else if (counter > mode_counter) {
                mode_counter = counter;
                mode = x[i];
            }
        }
        else {
            counter = 1;
            if (counter == mode_counter) {
                if (mode > x[i])
                    mode = x[i];
            }
        }
    }

    cout << fixed;
    cout.precision(1);
    cout << mean << endl << median << endl << mode << endl;

    return 0;
}
