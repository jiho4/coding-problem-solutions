/**
 * Vertical Sticks
 * https://www.hackerrank.com/challenges/vertical-sticks/submissions/code/44263725
 * solved: 2017-05-14
 */
#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

int main() {
    int q;
    cin>>q;
    while(q--)
        {int t;
            cin>>t;
        int a[t],b[t];
            for(int i=0;i<t;i++)
                cin>>a[i];
            sort(a,a+t);
            float sum=0;
            for(int i=0;i<t;i++)
                {if(a[i]==a[i-1]&&i!=0)
                b[i]=b[i-1];
                else
                    b[i]=t-i;
            }
            for(int i=0;i<t;i++)
                {
                sum+=((float)(t+1))/(b[i]+1);
            }

            cout<<fixed;
            cout.precision(2);
            cout<<sum<<"\n" ;
    }
    return 0;
}
