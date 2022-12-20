/**
 * Even Tree
 * https://www.hackerrank.com/challenges/even-tree/submissions/code/44259006
 * solved: 2017-05-14
 */
#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

struct Node {
    int num, root;
};

int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    int n, edge;
    int x, y;
    int count = 0;
	cin >> n >> edge;
    vector<Node> node = vector<Node>(n);
    for (int i = 0; i < n; i++) {
        node[i].num = 1;
        node[i].root = -1;
    }
    for (int i = 0; i < edge; i++) {
        cin >> x >> y;
        node[x-1].root = y-1;
    }
    for(int i = n-1; i > 0; i--) {
		if(node[i].root >= 0)
			node[node[i].root].num += node[i].num;
    }
	for(int i = 0; i < n; i++) {
		if(node[i].root >= 0 && node[i].num % 2== 0)
			count ++;
    }

    cout << count;

    return 0;
}
