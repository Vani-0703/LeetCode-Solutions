import heapq
class Solution:
 def networkDelayTime(self,e,n,k):
  g=[[] for _ in range(n+1)]
  for u,v,w in e:g[u].append((v,w))
  d=[10**9]*(n+1);d[k]=0;q=[(0,k)]
  while q:
   du,u=heapq.heappop(q)
   if du!=d[u]:continue
   for v,w in g[u]:
    if du+w<d[v]:d[v]=du+w;heapq.heappush(q,(d[v],v))
  return -1 if max(d[1:])==10**9 else max(d[1:])
