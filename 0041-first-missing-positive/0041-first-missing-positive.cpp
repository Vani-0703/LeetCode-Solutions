#include <bits/stdc++.h>
using namespace std;
class Solution { public: int firstMissingPositive(vector<int>&a){int n=a.size();for(int&i:a)if(i<1||i>n)i=n+1;for(int x:a){x=abs(x);if(x<=n&&a[x-1]>0)a[x-1]=-a[x-1];}for(int i=0;i<n;i++)if(a[i]>0)return i+1;return n+1;} };
