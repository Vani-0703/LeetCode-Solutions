class Solution:
 def maxProduct(self,a):
  hi=lo=ans=a[0]
  for x in a:
   if x<0:hi,lo=lo,hi
   hi=max(x,hi*x);lo=min(x,lo*x);ans=max(ans,hi)
  return ans
