#include <bits/stdc++.h>
using namespace std;
class Solution { public: int minPathSum(vector<vector<int>>&g){for(int i=0;i<g.size();i++)for(int j=0;j<g[0].size();j++)if(i||j)g[i][j]+=min(i?g[i-1][j]:INT_MAX,j?g[i][j-1]:INT_MAX);return g.back().back();} };
