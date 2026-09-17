#include <bits/stdc++.h>
using namespace std;
class Solution { public: int numDecodings(string s){if(s.empty()||s[0]=='0')return 0;int a=1,b=1;for(int i=1;i<s.size();i++){int c=s[i]!='0'?b:0;if(s.substr(i-1,2)>="10"&&s.substr(i-1,2)<="26")c+=a;a=b;b=c;}return b;} };
