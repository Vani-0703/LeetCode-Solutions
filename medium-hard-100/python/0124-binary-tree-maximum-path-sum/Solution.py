class Solution:
 def maxPathSum(self,root):
  self.ans=-10**9
  def dfs(n):
   if not n:return 0
   a=max(0,dfs(n.left));b=max(0,dfs(n.right));self.ans=max(self.ans,n.val+a+b);return n.val+max(a,b)
  dfs(root);return self.ans
