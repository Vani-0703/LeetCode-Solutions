#include <bits/stdc++.h>
using namespace std;
class Solution { public: int maximalRectangle(vector<vector<char>>&m){if(m.empty())return 0;int n=m[0].size(),ans=0;vector<int>h(n);for(auto&r:m){for(int j=0;j<n;j++)h[j]=r[j]=='1'?h[j]+1:0;stack<int>s;for(int i=0;i<=n;i++){int x=i<n?h[i]:0;while(!s.empty()&&h[s.top()]>x){int k=s.top();s.pop();ans=max(ans,h[k]*(i-(s.empty()?-1:s.top())-1));}s.push(i);}}return ans;} };
