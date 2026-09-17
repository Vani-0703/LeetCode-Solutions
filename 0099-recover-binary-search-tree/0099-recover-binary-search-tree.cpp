#include <bits/stdc++.h>
using namespace std;
class Solution { public: void recoverTree(TreeNode*root){TreeNode*a=nullptr,*b=nullptr,*p=nullptr;function<void(TreeNode*)>f=[&](TreeNode*n){if(!n)return;f(n->left);if(p&&p->val>n->val){if(!a)a=p;b=n;}p=n;f(n->right);};f(root);swap(a->val,b->val);} };
