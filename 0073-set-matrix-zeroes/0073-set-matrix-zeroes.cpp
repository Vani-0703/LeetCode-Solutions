#include <bits/stdc++.h>
using namespace std;
class Solution { public: void setZeroes(vector<vector<int>>&a){int m=a.size(),n=a[0].size();bool R=0,C=0;for(int i=0;i<m;i++)for(int j=0;j<n;j++)if(!a[i][j]){if(i==0)R=1;if(j==0)C=1;a[i][0]=a[0][j]=0;}for(int i=1;i<m;i++)for(int j=1;j<n;j++)if(!a[i][0]||!a[0][j])a[i][j]=0;if(R)fill(a[0].begin(),a[0].end(),0);if(C)for(auto&r:a)r[0]=0;} };
