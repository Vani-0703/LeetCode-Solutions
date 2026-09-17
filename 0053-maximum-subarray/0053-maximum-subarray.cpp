#include <bits/stdc++.h>
using namespace std;
class Solution { public: int maxSubArray(vector<int>&a){int cur=0,ans=a[0];for(int x:a)cur=max(x,cur+x),ans=max(ans,cur);return ans;} };
