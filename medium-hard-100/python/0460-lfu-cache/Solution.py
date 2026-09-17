from collections import defaultdict,OrderedDict
class LFUCache:
 def __init__(self,capacity):self.c=capacity;self.minf=0;self.v={};self.f=defaultdict(OrderedDict)
 def _touch(self,k):
  z=self.v[k];f=z[1];del self.f[f][k]
  if not self.f[f] and self.minf==f:self.minf+=1
  z[1]+=1;self.f[f+1][k]=None
 def get(self,k):
  if k not in self.v:return -1
  self._touch(k);return self.v[k][0]
 def put(self,k,v):
  if not self.c:return
  if k in self.v:self.v[k][0]=v;self._touch(k);return
  if len(self.v)>=self.c:k2,_=self.f[self.minf].popitem(last=False);del self.v[k2]
  self.v[k]=[v,1];self.f[1][k]=None;self.minf=1
