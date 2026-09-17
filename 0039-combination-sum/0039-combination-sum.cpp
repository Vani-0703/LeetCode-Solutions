#include <bits/stdc++.h>
using namespace std;
class Solution { public: vector<vector<int>> combinationSum(vector<int>&a,int t){vector<vector<int>>r;vector<int>c;function<void(int,int)>f=[&](int i,int x){if(x==0){r.push_back(c);return;}for(int j=i;j<a.size()&&a[j]<=x;j++){c.push_back(a[j]);f(j,x-a[j]);c.pop_back();}};sort(a.begin(),a.end());f(0,t);return r;} };
