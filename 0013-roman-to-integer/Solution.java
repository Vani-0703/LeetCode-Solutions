import java.util.HashMap;
import java.util.Map;

class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> v = new HashMap<>();
        v.put('I',1); v.put('V',5); v.put('X',10); v.put('L',50);
        v.put('C',100); v.put('D',500); v.put('M',1000);
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            int cur = v.get(s.charAt(i));
            if (i + 1 < s.length() && cur < v.get(s.charAt(i + 1))) ans -= cur;
            else ans += cur;
        }
        return ans;
    }
}
