#include <bits/stdc++.h>
using namespace std;
class Solution { public: void solveSudoku(vector<vector<char>>&b){function<bool()>f=[&](){for(int i=0;i<9;i++)for(int j=0;j<9;j++)if(b[i][j]=='.'){for(char x='1';x<='9';x++){bool ok=1;for(int k=0;k<9;k++)if(b[i][k]==x||b[k][j]==x||b[i/3*3+k/3][j/3*3+k%3]==x)ok=0;if(ok){b[i][j]=x;if(f())return true;b[i][j]='.';}}return false;}return true;};f();} };
