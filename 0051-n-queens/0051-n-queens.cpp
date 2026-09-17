#include <bits/stdc++.h>
using namespace std;
class Solution { public: vector<vector<string>> solveNQueens(int n){vector<vector<string>>r;vector<string>b(n,string(n,'.'));bool c[10]={},d1[20]={},d2[20]={};function<void(int)>f=[&](int x){if(x==n){r.push_back(b);return;}for(int y=0;y<n;y++)if(!c[y]&&!d1[x-y+n]&&!d2[x+y]){c[y]=d1[x-y+n]=d2[x+y]=1;b[x][y]='Q';f(x+1);b[x][y]='.';c[y]=d1[x-y+n]=d2[x+y]=0;}};f(0);return r;} };
