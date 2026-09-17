#include <bits/stdc++.h>
using namespace std;
class Solution { public: bool isMatch(string s,string p){vector<vector<int>>m(s.size()+1,vector<int>(p.size()+1,-1));function<int(int,int)>f=[&](int i,int j){if(j==p.size())return i==s.size();int&z=m[i][j];if(z!=-1)return z;bool ok=i<s.size()&&(p[j]=='?'||p[j]=='*'||p[j]==s[i]);if(p[j]=='*')return z=f(i,j+1)||(i<s.size()&&f(i+1,j));return z=ok&&f(i+1,j+1);};return f(0,0);} };
