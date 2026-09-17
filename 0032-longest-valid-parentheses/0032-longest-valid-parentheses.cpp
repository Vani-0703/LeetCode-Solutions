#include <bits/stdc++.h>
using namespace std;
class Solution { public: int longestValidParentheses(string s){stack<int>q;q.push(-1);int a=0;for(int i=0;i<s.size();i++){if(s[i]=='(')q.push(i);else{q.pop();if(q.empty())q.push(i);else a=max(a,i-q.top());}}return a;} };
