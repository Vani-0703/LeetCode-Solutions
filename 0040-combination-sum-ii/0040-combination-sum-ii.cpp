#include <bits/stdc++.h>
using namespace std;
class Solution { public: vector<vector<int>> combinationSum2(vector<int>&a,int t){sort(a.begin(),a.end());vector<vector<int>>r;vector<int>c;function<void(int,int)>f=[&](int i,int x){if(!x){r.push_back(c);return;}for(int j=i;j<a.size()&&a[j]<=x;j++){if(j>i&&a[j]==a[j-1])continue;c.push_back(a[j]);f(j+1,x-a[j]);c.pop_back();}};f(0,t);return r;} };
