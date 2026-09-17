#include <bits/stdc++.h>
using namespace std;
class Solution { public:
 int maxArea(vector<int>&h){int l=0,r=h.size()-1,a=0;while(l<r){a=max(a,min(h[l],h[r])*(r-l));h[l]<h[r]?l++:r--;}return a;}
};
