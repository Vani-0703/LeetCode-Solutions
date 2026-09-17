#include <bits/stdc++.h>
using namespace std;
class Solution { public: string fullJustify(vector<string>&w,int m){vector<string>r;for(int i=0;i<w.size();){int j=i,len=0;while(j<w.size()&&len+w[j].size()+j-i<=m)len+=w[j++].size();int gaps=j-i-1;string s=w[i];if(j==w.size()||gaps==0){for(int k=i+1;k<j;k++)s+=' ',s+=w[k];s+=string(m-s.size(),' ');}else{int q=(m-len)/gaps,e=(m-len)%gaps;for(int k=i+1;k<j;k++)s+=string(q+(k-i<=e),' ')+w[k];}r.push_back(s);i=j;}return r;} };
