class Solution:
 def pacificAtlantic(self,h):
  R,C=len(h),len(h[0]);A=set();B=set()
  def dfs(i,j,s):
   if (i,j) in s:return
   s.add((i,j))
   for x,y in ((i+1,j),(i-1,j),(i,j+1),(i,j-1)):
    if 0<=x<R and 0<=y<C and h[x][y]>=h[i][j]:dfs(x,y,s)
  for i in range(R):dfs(i,0,A);dfs(i,C-1,B)
  for j in range(C):dfs(0,j,A);dfs(R-1,j,B)
  return [[i,j] for i,j in A&B]
