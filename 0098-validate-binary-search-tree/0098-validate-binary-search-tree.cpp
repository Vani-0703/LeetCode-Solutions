#include <bits/stdc++.h>
using namespace std;
class Solution { public: bool isValidBST(TreeNode*root){long long lo=LLONG_MIN,hi=LLONG_MAX;function<bool(TreeNode*,long long,long long)>f=[&](TreeNode*n,long long l,long long r){return !n||(n->val>l&&n->val<r&&f(n->left,l,n->val)&&f(n->right,n->val,r));};return f(root,lo,hi);} };
