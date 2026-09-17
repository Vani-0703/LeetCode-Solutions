import java.util.*;
class Solution { public boolean isBipartite(int[][]g){int[]c=new int[g.length];for(int i=0;i<g.length;i++)if(c[i]==0){Queue<Integer>q=new ArrayDeque<>();q.add(i);c[i]=1;while(!q.isEmpty()){int u=q.poll();for(int v:g[u]){if(c[v]==c[u])return false;if(c[v]==0){c[v]=-c[u];q.add(v);}}}}return true;} }
