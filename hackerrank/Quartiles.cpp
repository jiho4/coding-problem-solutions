/**
 * Day 1: Quartiles
 * https://www.hackerrank.com/challenges/s10-quartiles/submissions/code/44258266
 * solved: 2017-05-14
 */
#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

double findMedian(int start, int end, vector<int>& arr);

int main() {
	/* Enter your code here. Read input from STDIN. Print output to STDOUT */
	int n, input;
	double q1, median, q3;
	vector<int> arr;
	cin >> n;

	for (int i = 0; i < n; i++) {
		cin >> input;
		arr.push_back(input);
	}
	sort(arr.begin(), arr.end());

	q1 = findMedian(0, n / 2, arr);
	median = findMedian(0, n, arr);
	q3 = findMedian((n+1) / 2, n, arr);

	cout << q1 << endl << median << endl << q3 << endl;

	return 0;
}

double findMedian(int start, int end, vector<int>& arr) {
    int index = (start+end)/2;
    if ((end - start) % 2 == 0){
        return (double)(arr[index - 1] + arr[index]) / 2;
    }
	else{
		return (double)arr[index];
    }
}
