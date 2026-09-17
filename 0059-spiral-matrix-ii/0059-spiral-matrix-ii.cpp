#include <bits/stdc++.h>
using namespace std;
class Solution { public: vector<vector<int>> generateMatrix(int n){vector<vector<int>>a(n,vector<int>(n));int x=1,t=0,b=n-1,l=0,r=n-1;while(t<=b){for(int j=l;j<=r;j++)a[t][j]=x++;t++;for(int i=t;i<=b;i++)a[i][r]=x++;r--;if(t<=b)for(int j=r;j>=l;j--)a[b][j]=x++;b--;for(int i=b;i>=t;i--)a[i][l]=x++;l++;}return a;} };
