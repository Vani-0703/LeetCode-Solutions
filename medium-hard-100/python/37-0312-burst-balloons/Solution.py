class Solution:
 def maxCoins(self,a):
  a=[1]+[x for x in a if x>0]+[1];n=len(a);d=[[0]*n for _ in a]
  for gap in range(2,n):
   for l in range(n-gap):
    r=l+gap
    d[l][r]=max(d[l][k]+d[k][r]+a[l]*a[k]*a[r] for k in range(l+1,r))
  return d[0][-1]
