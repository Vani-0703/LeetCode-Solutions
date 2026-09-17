class Solution:
 def minInsertions(self,s):
  n=len(s);d=[0]*n
  for i in range(n-2,-1,-1):
   p=0
   for j in range(i+1,n):
    t=d[j];d[j]=p if s[i]==s[j] else min(d[j],d[j-1])+1;p=t
  return d[-1]
