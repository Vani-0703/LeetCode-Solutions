import java.util.*;
class Solution { public int leastInterval(char[]tasks,int n){int[]c=new int[26];for(char t:tasks)c[t-'A']++;Arrays.sort(c);int f=c[25]-1,g=f*n;for(int i=24;i>=0;i--)g-=Math.min(f,c[i]);return g<0?tasks.length:tasks.length+g;} }
