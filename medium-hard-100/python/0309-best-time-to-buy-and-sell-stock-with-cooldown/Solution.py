class Solution:
 def maxProfit(self,p):
  hold=-10**9;sold=rest=0
  for x in p:hold,sold,rest=max(hold,rest-x),hold+x,max(rest,sold)
  return max(sold,rest)
