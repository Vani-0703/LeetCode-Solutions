#include <bits/stdc++.h>
using namespace std;
class Solution { public: int removeDuplicates(vector<int>&a){int k=0;for(int x:a)if(k<2||a[k-2]!=x)a[k++]=x;return k;} };
