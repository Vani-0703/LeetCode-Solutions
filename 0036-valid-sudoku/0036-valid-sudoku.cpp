#include <bits/stdc++.h>
using namespace std;
class Solution { public: bool isValidSudoku(vector<vector<char>>&b){bool r[9][9]={},c[9][9]={},g[9][9]={};for(int i=0;i<9;i++)for(int j=0;j<9;j++)if(b[i][j]!='.'){int x=b[i][j]-'1',k=(i/3)*3+j/3;if(r[i][x]||c[j][x]||g[k][x])return false;r[i][x]=c[j][x]=g[k][x]=1;}return true;} };
