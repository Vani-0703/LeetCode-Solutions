from collections import deque
class Solution:
 def ladderLength(self,b,e,wl):
  s=set(wl)
  if e not in s:return 0
  q=deque([(b,1)])
  while q:
   w,d=q.popleft()
   for i in range(len(w)):
    for c in "abcdefghijklmnopqrstuvwxyz":
     v=w[:i]+c+w[i+1:]
     if v==e:return d+1
     if v in s:s.remove(v);q.append((v,d+1))
  return 0
