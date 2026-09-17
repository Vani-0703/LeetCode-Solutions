#include <bits/stdc++.h>
using namespace std;
class Solution { public: string minWindow(string s,string t){vector<int>c(128);for(char x:t)c[x]++;int need=t.size(),l=0,st=0,len=INT_MAX;for(int r=0;r<s.size();r++){if(c[s[r]]>0)need--;c[s[r]]--;while(!need){if(r-l+1<len)len=r-l+1,st=l;c[s[l]]++;if(c[s[l++]]>0)need++;} }return len==INT_MAX?"":s.substr(st,len);} };
