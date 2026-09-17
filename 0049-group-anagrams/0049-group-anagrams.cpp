#include <bits/stdc++.h>
using namespace std;
class Solution { public: vector<vector<string>> groupAnagrams(vector<string>&a){unordered_map<string,vector<string>>m;for(auto s:a){string k=s;sort(k.begin(),k.end());m[k].push_back(s);}vector<vector<string>>r;for(auto&[k,v]:m)r.push_back(v);return r;} };
