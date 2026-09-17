#include <bits/stdc++.h>
using namespace std;
class Solution { public: int numTrees(int n){vector<long long>dp(n+1);dp[0]=dp[1]=1;for(int x=2;x<=n;x++)for(int i=1;i<=x;i++)dp[x]+=dp[i-1]*dp[x-i];return dp[n];} };
