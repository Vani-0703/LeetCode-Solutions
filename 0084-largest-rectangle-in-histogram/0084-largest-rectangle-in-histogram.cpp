#include <bits/stdc++.h>
using namespace std;
class Solution { public: int largestRectangleArea(vector<int>&h){stack<int>s;h.push_back(0);int a=0;for(int i=0;i<h.size();i++){while(!s.empty()&&h[s.top()]>h[i]){int x=s.top();s.pop();int l=s.empty()?-1:s.top();a=max(a,h[x]*(i-l-1));}s.push(i);}return a;} };
