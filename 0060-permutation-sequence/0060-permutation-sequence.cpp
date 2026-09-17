#include <bits/stdc++.h>
using namespace std;
class Solution { public: string getPermutation(int n,int k){vector<int>a;for(int i=1;i<=n;i++)a.push_back(i);string r;while(n){int f=1;for(int i=1;i<n;i++)f*=i;int x=(k-1)/f;k=(k-1)%f+1;r+=to_string(a[x]);a.erase(a.begin()+x);n--;}return r;} };
