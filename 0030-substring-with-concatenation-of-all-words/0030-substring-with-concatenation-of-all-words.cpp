#include <bits/stdc++.h>
using namespace std;
class Solution { public: vector<int> findSubstring(string s,vector<string>&w){vector<int>r;if(w.empty())return r;int L=w[0].size(),N=w.size();unordered_map<string,int>need;for(auto&x:w)need[x]++;for(int st=0;st<L;st++){unordered_map<string,int>m;int l=st,c=0;for(int j=st;j+L<=s.size();j+=L){string x=s.substr(j,L);if(!need.count(x)){m.clear();c=0;l=j+L;continue;}m[x]++;c++;while(m[x]>need[x]){m[s.substr(l,L)]--;l+=L;c--;}if(c==N){r.push_back(l);m[s.substr(l,L)]--;l+=L;c--;}}}return r;} };
