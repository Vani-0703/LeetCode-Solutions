#include <bits/stdc++.h>
using namespace std;
class Solution { public: vector<int> grayCode(int n){vector<int>r;for(int i=0;i<(1<<n);i++)r.push_back(i^(i>>1));return r;} };
