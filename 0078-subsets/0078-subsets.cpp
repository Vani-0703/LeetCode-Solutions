#include <bits/stdc++.h>
using namespace std;
class Solution { public: vector<vector<int>> subsets(vector<int>&a){vector<vector<int>>r(1);for(int x:a){int n=r.size();for(int i=0;i<n;i++){auto v=r[i];v.push_back(x);r.push_back(v);}}return r;} };
