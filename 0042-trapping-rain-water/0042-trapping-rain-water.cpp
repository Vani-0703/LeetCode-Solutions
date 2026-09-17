#include <bits/stdc++.h>
using namespace std;
class Solution { public: int trap(vector<int>&h){int l=0,r=h.size()-1,L=0,R=0,a=0;while(l<r){if(h[l]<h[r]){L=max(L,h[l]);a+=L-h[l++];}else{R=max(R,h[r]);a+=R-h[r--];}}return a;} };
