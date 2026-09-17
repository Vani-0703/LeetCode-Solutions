#include <bits/stdc++.h>
using namespace std;
class Solution { public: int totalNQueens(int n){int ans=0;bool c[10]={},d1[20]={},d2[20]={};function<void(int)>f=[&](int x){if(x==n){ans++;return;}for(int y=0;y<n;y++)if(!c[y]&&!d1[x-y+n]&&!d2[x+y]){c[y]=d1[x-y+n]=d2[x+y]=1;f(x+1);c[y]=d1[x-y+n]=d2[x+y]=0;}};f(0);return ans;} };
