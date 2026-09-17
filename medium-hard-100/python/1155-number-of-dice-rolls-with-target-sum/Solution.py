class Solution:
 def numRollsToTarget(self,n,k,t):
  M=10**9+7;d=[0]*(t+1);d[0]=1
  for _ in range(n):
   nd=[0]*(t+1)
   for s in range(t+1):
    if d[s]:
     for x in range(1,k+1):
      if s+x<=t:nd[s+x]=(nd[s+x]+d[s])%M
   d=nd
  return d[t]
