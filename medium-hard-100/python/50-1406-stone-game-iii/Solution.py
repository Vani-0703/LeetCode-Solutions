class Solution:
 def stoneGameIII(self,a):
  n=len(a);d=[0]*(n+1)
  for i in range(n-1,-1,-1):
   s=0;d[i]=-10**9
   for j in range(i,min(n,i+3)):s+=a[j];d[i]=max(d[i],s-d[j+1])
  return "Alice" if d[0]>0 else "Bob" if d[0]<0 else "Tie"
