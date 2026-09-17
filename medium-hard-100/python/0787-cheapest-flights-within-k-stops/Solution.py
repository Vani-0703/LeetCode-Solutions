class Solution:
 def findCheapestPrice(self,n,flights,src,dst,k):
  d=[10**9]*n;d[src]=0
  for _ in range(k+1):
   nd=d[:]
   for u,v,w in flights:nd[v]=min(nd[v],d[u]+w)
   d=nd
  return -1 if d[dst]>=10**9 else d[dst]
