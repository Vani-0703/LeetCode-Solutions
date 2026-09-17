class Solution {
 public TreeNode lowestCommonAncestor(TreeNode r,TreeNode p,TreeNode q){if(r==null||r==p||r==q)return r;TreeNode a=lowestCommonAncestor(r.left,p,q),b=lowestCommonAncestor(r.right,p,q);return a==null?b:b==null?a:r;}
}