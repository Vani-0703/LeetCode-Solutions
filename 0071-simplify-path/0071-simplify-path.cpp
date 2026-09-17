#include <bits/stdc++.h>
using namespace std;
class Solution { public: string simplifyPath(string s){vector<string>v;stringstream ss(s);string x;while(getline(ss,x,'/'))if(x==".."&&!v.empty())v.pop_back();else if(x!=""&&x!=".")v.push_back(x);string r="/";for(int i=0;i<v.size();i++)r+=v[i]+(i+1<v.size()?"/":"");return r;} };
