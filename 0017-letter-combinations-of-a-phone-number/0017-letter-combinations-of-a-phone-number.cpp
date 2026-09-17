#include <bits/stdc++.h>
using namespace std;
class Solution { public:
 vector<string> letterCombinations(string s){if(s.empty())return {};vector<string>d={"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"},r;string cur;function<void(int)>f=[&](int i){if(i==s.size()){r.push_back(cur);return;}for(char c:d[s[i]-'2'])cur+=c,f(i+1),cur.pop_back();};f(0);return r;}
};
