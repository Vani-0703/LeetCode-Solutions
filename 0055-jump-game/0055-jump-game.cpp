#include <bits/stdc++.h>
using namespace std;
class Solution { public: bool canJump(vector<int>&a){int reach=0;for(int i=0;i<a.size()&&i<=reach;i++)reach=max(reach,i+a[i]);return reach>=a.size()-1;} };
