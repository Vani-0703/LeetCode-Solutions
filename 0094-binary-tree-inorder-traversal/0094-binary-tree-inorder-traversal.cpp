#include <bits/stdc++.h>
using namespace std;
class Solution { public: vector<int> inorderTraversal(TreeNode*root){vector<int>r;stack<TreeNode*>s;while(root||!s.empty()){while(root)s.push(root),root=root->left;root=s.top();s.pop();r.push_back(root->val);root=root->right;}return r;} };
