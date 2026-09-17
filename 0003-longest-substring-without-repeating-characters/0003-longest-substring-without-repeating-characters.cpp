#include <bits/stdc++.h>
using namespace std;
class Solution {
public:
    int lengthOfLongestSubstring(string s) { int last[128]={}, ans=0,l=0; for(int r=0;r<s.size();r++){ l=max(l,last[(unsigned char)s[r]]); last[(unsigned char)s[r]]=r+1; ans=max(ans,r-l+1); } return ans; }
};
