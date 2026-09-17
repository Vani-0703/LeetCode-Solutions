#include <bits/stdc++.h>
using namespace std;
class Solution { public:
 string convert(string s,int n){if(n==1||n>=s.size())return s;vector<string>v(n);int r=0,d=1;for(char c:s){v[r]+=c;if(r==0)d=1;if(r==n-1)d=-1;r+=d;}string a;for(auto&x:v)a+=x;return a;}
};
