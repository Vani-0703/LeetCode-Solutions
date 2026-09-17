import java.util.*;
class Solution { public int longestConsecutive(int[]a){Set<Integer>s=new HashSet<>();for(int x:a)s.add(x);int z=0;for(int x:s)if(!s.contains(x-1)){int y=x;while(s.contains(y+1))y++;z=Math.max(z,y-x+1);}return z;} }
