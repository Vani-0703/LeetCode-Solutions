import java.util.*;
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> m=new HashMap<>();
        for(String s:strs){ char[] a=s.toCharArray(); Arrays.sort(a); m.computeIfAbsent(new String(a),k->new ArrayList<>()).add(s); }
        return new ArrayList<>(m.values());
    }
}