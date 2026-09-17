import bisect
class Solution:
 def lengthOfLIS(self,a):
  d=[]
  for x in a:
   i=bisect.bisect_left(d,x)
   if i==len(d):d.append(x)
   else:d[i]=x
  return len(d)
