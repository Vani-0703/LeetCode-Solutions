#include <bits/stdc++.h>
using namespace std;
class Solution { public: void sortColors(vector<int>&a){int l=0,m=0,r=a.size()-1;while(m<=r){if(a[m]==0)swap(a[l++],a[m++]);else if(a[m]==2)swap(a[m],a[r--]);else m++;} } };
