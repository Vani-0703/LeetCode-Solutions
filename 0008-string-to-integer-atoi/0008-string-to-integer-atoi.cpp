#include <bits/stdc++.h>
using namespace std;
class Solution { public:
 int myAtoi(string s){long long x=0;int i=0,sg=1;while(i<s.size()&&s[i]==' ')i++;if(i<s.size()&&(s[i]=='+'||s[i]=='-')){if(s[i]=='-')sg=-1;i++;}while(i<s.size()&&isdigit(s[i])){x=x*10+s[i++]-'0';if(sg*x>INT_MAX)return INT_MAX;if(sg*x<INT_MIN)return INT_MIN;}return sg*x;}
};
