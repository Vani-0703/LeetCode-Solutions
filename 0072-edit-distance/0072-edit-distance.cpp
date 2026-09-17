#include <bits/stdc++.h>
using namespace std;
class Solution { public: int minDistance(string a,string b){vector<int>d(b.size()+1);iota(d.begin(),d.end(),0);for(int i=1;i<=a.size();i++){int p=d[0]++;for(int j=1;j<=b.size();j++){int t=d[j];d[j]=a[i-1]==b[j-1]?p+0:1+min({d[j],d[j-1],p});p=t;}}return d.back();} };
