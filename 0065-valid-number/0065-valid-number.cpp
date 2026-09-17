#include <bits/stdc++.h>
using namespace std;
class Solution { public: bool isNumber(string s){int i=0,n=s.size();while(i<n&&s[i]==' ')i++;if(i<n&&(s[i]=='+'||s[i]=='-'))i++;bool dig=0,dot=0;while(i<n&&((s[i]>='0'&&s[i]<='9')||s[i]=='.')){if(s[i]=='.'){if(dot)return false;dot=1;}else dig=1;i++;}if(!dig)return false;if(i<n&&(s[i]=='e'||s[i]=='E')){i++;if(i<n&&(s[i]=='+'||s[i]=='-'))i++;bool e=0;while(i<n&&isdigit(s[i]))e=1,i++;if(!e)return false;}return i==n;} };
