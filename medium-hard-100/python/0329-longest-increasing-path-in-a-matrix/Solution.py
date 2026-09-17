from functools import lru_cache
class Solution:
 def longestIncreasingPath(self,m):
  if not m:return 0
  R,C=len(m),len(m[0])
  @lru_cache(None)
  def f(i,j):return 1+max([f(x,y) for x,y in ((i+1,j),(i-1,j),(i,j+1),(i,j-1)) if 0<=x<R and 0<=y<C and m[x][y]>m[i][j]] or [0])
  return max(f(i,j) for i in range(R) for j in range(C))
