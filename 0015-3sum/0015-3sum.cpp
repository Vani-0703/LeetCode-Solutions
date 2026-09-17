#include <bits/stdc++.h>
using namespace std;
class Solution { public:
 vector<vector<int>> threeSum(vector<int>&a){sort(a.begin(),a.end());vector<vector<int>>r;for(int i=0;i<a.size();i++){if(i&&a[i]==a[i-1])continue;int l=i+1,h=a.size()-1;while(l<h){long s=(long)a[i]+a[l]+a[h];if(s==0){r.push_back({a[i],a[l],a[h]});while(l<h&&a[l]==a[l+1])l++;while(l<h&&a[h]==a[h-1])h--;l++;h--;}else s<0?l++:h--;}}return r;}
};
