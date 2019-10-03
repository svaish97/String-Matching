#include <bits/stdc++.h>
using namespace std;
void coinage(int a[],int n, int v)
{
    int x,y,c;
    vector<int> coin;
    for(int i=n-1; i>=0; i--)
    {
        if(v==0)
        {
            break;
        }
        else if(a[i] <= v)
        {
            x = v%a[i];
            y = a[i]*x;
            v = v - y;
            c++;
        }
    }
    cout << c;


}
int main()
{
    int a[] = {1,2,5,10,20,50,100,500,1000};
    coinage(a,9,70);

    return 0;
}
/*
Given a set of coins and amount, Write an algorithm to find out how many ways we can make the change of the amount using the coins given.
*/
