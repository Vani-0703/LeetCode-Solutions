class Solution:
 def change(self,a,c):
  d=[0]*(a+1);d[0]=1
  for x in c:
   for j in range(x,a+1):d[j]+=d[j-x]
  return d[a]
