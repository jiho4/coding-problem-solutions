/**
 * Arrays: Left Rotation
 * https://www.hackerrank.com/challenges/ctci-array-left-rotation/submissions/code/44247934
 * solved: 2017-05-14
 */
#include <cstdio>
#include <vector>
#include <iostream>

using namespace std;

vector<int> array_left_rotation(vector<int> a, int n, int k) {
    vector<int> rotated;
    for (int i = 0; i < a.size(); i++) {
        if (i + k >= n)
            rotated.push_back(a[i + k - a.size()]);
        else
            rotated.push_back(a[i+k]);
    }
    return rotated;
}

int main(){
    int n;
    int k;
    cin >> n >> k;
    vector<int> a(n);
    for(int a_i = 0;a_i < n;a_i++){
        cin >> a[a_i];
    }
    vector<int> output = array_left_rotation(a, n, k);
    for(int i = 0; i < n;i++)
        cout << output[i] << " ";
    cout << endl;
    return 0;
}
