class Solution:
 def maxProfit(self,k,p):
  if not p:return 0
  if k>=len(p)//2:return sum(max(0,p[i]-p[i-1]) for i in range(1,len(p)))
  buy=[-10**9]*k;sell=[0]*k
  for x in p:
   for i in range(k):buy[i]=max(buy[i],(sell[i-1] if i else 0)-x);sell[i]=max(sell[i],buy[i]+x)
  return sell[-1]
