#include <bits/stdc++.h>
using namespace std;
class Solution { public:
 string longestCommonPrefix(vector<string>&s){if(s.empty())return "";string p=s[0];for(int i=1;i<s.size();i++)while(s[i].find(p)!=0)p.pop_back();return p;}
};
