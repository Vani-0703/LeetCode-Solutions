#include <bits/stdc++.h>
using namespace std;
class Solution { public:
 bool isValid(string s){stack<char>q;for(char c:s){if(c=='('||c=='['||c=='{')q.push(c);else{if(q.empty())return false;char x=q.top();q.pop();if(c==')'&&x!='('||c==']'&&x!='['||c=='}'&&x!='{')return false;}}return q.empty();}
};
