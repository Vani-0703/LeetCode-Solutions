#include <bits/stdc++.h>
using namespace std;
class Solution { public: vector<TreeNode*> generateTrees(int n){if(!n)return {};function<vector<TreeNode*>(int,int)>f=[&](int l,int r){if(l>r)return vector<TreeNode*>{nullptr};vector<TreeNode*>z;for(int x=l;x<=r;x++)for(auto a:f(l,x-1))for(auto b:f(x+1,r)){auto q=new TreeNode(x);q->left=a;q->right=b;z.push_back(q);}return z;};return f(1,n);} };
