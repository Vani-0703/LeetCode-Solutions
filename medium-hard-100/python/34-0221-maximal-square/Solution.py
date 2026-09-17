class Solution:
 def maximalSquare(self,m):
  if not m:return 0
  n=len(m[0]);d=[0]*(n+1);ans=0;prev=0
  for i in range(1,len(m)+1):
   for j in range(1,n+1):old=d[j];d[j]=min(d[j],d[j-1],prev)+1 if m[i-1][j-1]=='1' else 0;ans=max(ans,d[j]);prev=old
  return ans*ans
