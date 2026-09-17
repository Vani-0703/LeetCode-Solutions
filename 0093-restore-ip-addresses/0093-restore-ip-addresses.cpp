#include <bits/stdc++.h>
using namespace std;
class Solution { public: vector<string> restoreIpAddresses(string s){vector<string>r;string cur;function<void(int,int)>f=[&](int i,int p){if(p==4){if(i==s.size())r.push_back(cur.substr(0,cur.size()-1));return;}for(int len=1;len<=3&&i+len<=s.size();len++){string x=s.substr(i,len);if((x.size()>1&&x[0]=='0')||stoi(x)>255)continue;cur+=x+'.';f(i+len,p+1);cur.resize(cur.size()-len-1);}};f(0,0);return r;} };
