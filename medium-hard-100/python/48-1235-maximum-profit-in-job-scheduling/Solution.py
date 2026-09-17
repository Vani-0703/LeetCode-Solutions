import bisect
class Solution:
 def jobScheduling(self,s,e,p):
  a=sorted(zip(s,e,p));ends=[];dp=[]
  for st,en,pr in a:
   i=bisect.bisect_right(ends,st)-1;val=(dp[i] if i>=0 else 0)+pr
   if dp and dp[-1]>=val:continue
   ends.append(en);dp.append(val)
  return dp[-1]
