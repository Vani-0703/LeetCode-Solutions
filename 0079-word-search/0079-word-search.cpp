#include <bits/stdc++.h>
using namespace std;
class Solution { public: bool exist(vector<vector<char>>&b,string w){int m=b.size(),n=b[0].size();function<bool(int,int,int)>f=[&](int i,int j,int k){if(k==w.size())return true;if(i<0||j<0||i==m||j==n||b[i][j]!=w[k])return false;char x=b[i][j];b[i][j]='#';bool ok=f(i+1,j,k+1)||f(i-1,j,k+1)||f(i,j+1,k+1)||f(i,j-1,k+1);b[i][j]=x;return ok;};for(int i=0;i<m;i++)for(int j=0;j<n;j++)if(f(i,j,0))return true;return false;} };
