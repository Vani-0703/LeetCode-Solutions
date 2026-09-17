import java.util.*;
class Solution { public int[] topKFrequent(int[]a,int k){Map<Integer,Integer>m=new HashMap<>();for(int x:a)m.put(x,m.getOrDefault(x,0)+1);PriorityQueue<int[]>q=new PriorityQueue<>((x,y)->x[1]-y[1]);for(var e:m.entrySet()){q.offer(new int[]{e.getKey(),e.getValue()});if(q.size()>k)q.poll();}int[]r=new int[k];for(int i=k-1;i>=0;i--)r[i]=q.poll()[0];return r;} }
