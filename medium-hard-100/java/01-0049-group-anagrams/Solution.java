import java.util.*;
class Solution { public List<List<String>> groupAnagrams(String[] a){Map<String,List<String>>m=new HashMap<>();for(String s:a){char[]c=s.toCharArray();Arrays.sort(c);m.computeIfAbsent(new String(c),k->new ArrayList<>()).add(s);}return new ArrayList<>(m.values());} }
