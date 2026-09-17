#include <bits/stdc++.h>
using namespace std;
class Solution { public: vector<vector<int>> permute(vector<int>&a){vector<vector<int>>r;sort(a.begin(),a.end());do{r.push_back(a);}while(next_permutation(a.begin(),a.end()));return r;} };
