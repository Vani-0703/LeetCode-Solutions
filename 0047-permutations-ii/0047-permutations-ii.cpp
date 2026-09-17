#include <bits/stdc++.h>
using namespace std;
class Solution { public: vector<vector<int>> permuteUnique(vector<int>&a){sort(a.begin(),a.end());vector<vector<int>>r;do{r.push_back(a);}while(next_permutation(a.begin(),a.end()));return r;} };
