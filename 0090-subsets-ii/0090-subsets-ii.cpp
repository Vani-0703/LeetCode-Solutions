#include <bits/stdc++.h>
using namespace std;
class Solution { public: vector<vector<int>> subsetsWithDup(vector<int>&a){sort(a.begin(),a.end());vector<vector<int>>r(1);int start=0;for(int i=0;i<a.size();i++){int n=r.size();start=(i&&a[i]==a[i-1])?start:0;for(int j=start;j<n;j++){auto v=r[j];v.push_back(a[i]);r.push_back(v);}start=n;}return r;} };
