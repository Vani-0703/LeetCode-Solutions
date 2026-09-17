import java.util.*;
class Solution { public List<Integer> partitionLabels(String s){int[]l=new int[26];for(int i=0;i<s.length();i++)l[s.charAt(i)-'a']=i;List<Integer>r=new ArrayList<>();int e=0,st=0;for(int i=0;i<s.length();i++){e=Math.max(e,l[s.charAt(i)-'a']);if(i==e){r.add(i-st+1);st=i+1;}}return r;} }
