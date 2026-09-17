from collections import deque
class Solution:
 def snakesAndLadders(self,b):
  n=len(b);q=deque([(1,0)]);v={1}
  def pos(x):
   x-=1;r,c=divmod(x,n);return n-1-r,(n-1-c if r%2 else c)
  while q:
   x,d=q.popleft()
   if x==n*n:return d
   for y in range(x+1,min(x+6,n*n)+1):
    r,c=pos(y);z=b[r][c] if b[r][c]>0 else y
    if z not in v:v.add(z);q.append((z,d+1))
  return -1
