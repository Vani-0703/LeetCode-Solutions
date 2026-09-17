class Solution:
 def findCircleNum(self,g):
  n=len(g);v=set();ans=0
  def f(i):
   v.add(i)
   for j in range(n):
    if g[i][j] and j not in v:f(j)
  for i in range(n):
   if i not in v:ans+=1;f(i)
  return ans
