class Solution:
 def largestRectangleArea(self,h):
  st=[]; ans=0
  for i,x in enumerate(h+[0]):
   while st and h[st[-1]]>x:
    j=st.pop(); left=st[-1]+1 if st else 0; ans=max(ans,h[j]*(i-left))
   st.append(i)
  return ans
