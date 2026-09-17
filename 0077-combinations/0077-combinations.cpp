#include <bits/stdc++.h>
using namespace std;
class Solution { public: vector<vector<int>> combine(int n,int k){vector<vector<int>>r;vector<int>c;function<void(int)>f=[&](int x){if(c.size()==k){r.push_back(c);return;}for(int i=x;i<=n;i++){c.push_back(i);f(i+1);c.pop_back();}};f(1);return r;} };
