#include <bits/stdc++.h>
using namespace std;
class Solution { public:
 vector<string> generateParenthesis(int n){vector<string>r;string s;function<void(int,int)>f=[&](int o,int c){if(s.size()==2*n){r.push_back(s);return;}if(o<n)s+='(',f(o+1,c),s.pop_back();if(c<o)s+=')',f(o,c+1),s.pop_back();};f(0,0);return r;}
};
