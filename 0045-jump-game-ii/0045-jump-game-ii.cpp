#include <bits/stdc++.h>
using namespace std;
class Solution { public: int jump(vector<int>&a){int ans=0,end=0,far=0;for(int i=0;i<a.size()-1;i++){far=max(far,i+a[i]);if(i==end)ans++,end=far;}return ans;} };
