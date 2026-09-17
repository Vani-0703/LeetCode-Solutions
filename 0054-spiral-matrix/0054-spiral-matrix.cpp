#include <bits/stdc++.h>
using namespace std;
class Solution { public: vector<int> spiralOrder(vector<vector<int>>&a){vector<int>r;if(a.empty())return r;int t=0,b=a.size()-1,l=0,h=a[0].size()-1;while(t<=b&&l<=h){for(int j=l;j<=h;j++)r.push_back(a[t][j]);t++;for(int i=t;i<=b;i++)r.push_back(a[i][h]);h--;if(t<=b)for(int j=h;j>=l;j--)r.push_back(a[b][j]);b--;if(l<=h)for(int i=b;i>=t;i--)r.push_back(a[i][l]);l++;}return r;} };
