#include <bits/stdc++.h>
using namespace std;
class Solution { public: string addBinary(string a,string b){string r;int i=a.size()-1,j=b.size()-1,c=0;while(i>=0||j>=0||c){c+=(i>=0?a[i--]-'0':0)+(j>=0?b[j--]-'0':0);r+=char('0'+c%2);c/=2;}reverse(r.begin(),r.end());return r;} };
