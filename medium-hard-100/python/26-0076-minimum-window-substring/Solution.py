from collections import Counter
class Solution:
 def minWindow(self,s,t):
  need=Counter(t); miss=len(t); l=0; best=""
  for r,c in enumerate(s):
   if need[c]>0: miss-=1
   need[c]-=1
   while miss==0:
    if not best or r-l+1<len(best): best=s[l:r+1]
    need[s[l]]+=1
    if need[s[l]]>0: miss+=1
    l+=1
  return best
