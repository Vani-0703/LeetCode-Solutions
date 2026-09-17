#include <bits/stdc++.h>
using namespace std;
class Solution { public: int uniquePathsWithObstacles(vector<vector<int>>&g){int n=g[0].size();vector<int>d(n);d[0]=1;for(auto&r:g)for(int j=0;j<n;j++)d[j]=r[j]?0:d[j]+(j?d[j-1]:0);return d[n-1];} };
