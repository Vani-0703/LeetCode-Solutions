class Node:
 def __init__(self,k=0,v=0):self.k=k;self.v=v;self.p=self.n=None
class LRUCache:
 def __init__(self,capacity):self.c=capacity;self.m={};self.L=Node();self.R=Node();self.L.n=self.R;self.R.p=self.L
 def _add(self,x):x.n=self.L.n;x.p=self.L;self.L.n.p=x;self.L.n=x
 def _del(self,x):x.p.n=x.n;x.n.p=x.p
 def get(self,k):
  if k not in self.m:return -1
  x=self.m[k];self._del(x);self._add(x);return x.v
 def put(self,k,v):
  if k in self.m:self._del(self.m[k])
  self.m[k]=Node(k,v);self._add(self.m[k])
  if len(self.m)>self.c:x=self.R.p;self._del(x);del self.m[x.k]
