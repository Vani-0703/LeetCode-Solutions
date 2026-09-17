#include <bits/stdc++.h>
using namespace std;
class Solution { public: vector<int> plusOne(vector<int>&a){for(int i=a.size()-1;i>=0;i--)if(a[i]++<9)return a;a[0]=1;a.push_back(0);return a;} };
