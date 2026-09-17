class Solution:
 def wordBreak(self,s,wd):
  w=set(wd);dp=[False]*(len(s)+1);dp[0]=True
  for i in range(1,len(s)+1):dp[i]=any(dp[j] and s[j:i] in w for j in range(i))
  return dp[-1]
