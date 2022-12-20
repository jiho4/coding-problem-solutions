/**
 * Red John is Back
 * https://www.hackerrank.com/challenges/red-john-is-back/submissions/code/44263549
 * solved: 2017-05-14
 */
#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
#include <set>
#include <cmath>
using namespace std;

/*
long int factorial(int x);

int main() {
	long int T, N, P, sum;
	cin >> T;
	for (int i = 0; i < T; i++) {
		sum = 0;
		cin >> N;
		int num_square = N / 4;

		for (int i = 0; i <= num_square; i++) {
			if (i == 0) {
				sum += 1;
			}
			else {
				int brick = N - 4 * i + i;
				sum += factorial(brick) / (factorial(brick - i)*factorial(i));
			}
		}

        P = 0;
        sum += 1;
        bool tmp[sum];
        for(int i = 2; i < sum; i++) {
            tmp[i] = true;
        }
        for(int i = 2; i < sum; i++) {
            if(tmp[i]){
                P++;
                for(int j = 2*i; j < sum; j += i) {
                    tmp[j]=false;
                }
            }
        }
		cout << P << endl;
	}

	return 0;
}

long int factorial(int x) {
	return (x == 1 ? x : x * factorial(x - 1));
}
*/

//check 'Sieve of Eratosthenes'

//from editorial
vector<int> sieve(int n)
{
    set<int> primes;
    vector<int> vec;

    primes.insert(2);

    for(int i=3; i<=n ; i+=2)
    {
        primes.insert(i);
    }

    int p=*primes.begin();
    vec.push_back(p);
    primes.erase(p);

    int maxRoot = sqrt(*(primes.rbegin()));

    while(primes.size() > 0)
    {
        if(p > maxRoot)
        {
            while(primes.size() > 0)
            {
                p=*primes.begin();
                vec.push_back(p);
                primes.erase(p);
            }
            break;
        }

        int i = p*p;
        int temp = (*(primes.rbegin()));

        while(i<=temp)
        {
            primes.erase(i);
            i += p;
            i += p;
        }

        p=*primes.begin();
        vec.push_back(p);
        primes.erase(p);
    }

    return vec;
}

int main()
{
    int t, N, M, P, i, count, res;
    vector<int> prime;
    vector<int>::iterator it;

    cin >> t;

    prime = sieve(217286);

    int a[41];
    for(i=0;i<4;i++)
        a[i] = 1;
    for(i=4;i<=40;i++)
        a[i] = a[i-1] + a[i-4];

    int numprime[41];
    for(i=0;i<41;i++)
    {
        count = 0;
        for(it=prime.begin();it!=prime.end();it++)
        {
            if(*it <= a[i])
                count++;
            else
                break;
        }
        numprime[i] = count;
        count = 0;
    }

    while(t--)
    {
        cin >> N;
        res = numprime[N];
        cout << res << endl;
    }

    return 0;
}
