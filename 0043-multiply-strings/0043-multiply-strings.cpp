#include <bits/stdc++.h>
using namespace std;
class Solution { public: string multiply(string a,string b){if(a=="0"||b=="0")return "0";vector<int>v(a.size()+b.size());for(int i=a.size()-1;i>=0;i--)for(int j=b.size()-1;j>=0;j--){int p=i+j+1,x=(a[i]-'0')*(b[j]-'0')+v[p];v[p]=x%10;v[p-1]+=x/10;}string r;for(int x:v)if(!r.empty()||x)r+=char('0'+x);return r;} };
