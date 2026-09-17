class Solution:
 def rob(self,root):
  def f(n):
   if not n:return (0,0)
   l=f(n.left);r=f(n.right);return (n.val+l[1]+r[1],max(l)+max(r))
  return max(f(root))
