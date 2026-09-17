#include <bits/stdc++.h>
using namespace std;
class Solution { public:
 string longestPalindrome(string s){int st=0,len=0;auto ex=[&](int l,int r){while(l>=0&&r<s.size()&&s[l]==s[r]){l--;r++;}return r-l-1;};for(int i=0;i<s.size();i++){int x=max(ex(i,i),ex(i,i+1));if(x>len){len=x;st=i-(x-1)/2;}}return s.substr(st,len);}
};
