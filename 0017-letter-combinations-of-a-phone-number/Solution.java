import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits.isEmpty()) return ans;
        String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backtrack(digits, 0, new StringBuilder(), map, ans);
        return ans;
    }

    private void backtrack(String d, int i, StringBuilder cur, String[] map, List<String> ans) {
        if (i == d.length()) { ans.add(cur.toString()); return; }
        for (char c : map[d.charAt(i) - '0'].toCharArray()) {
            cur.append(c);
            backtrack(d, i + 1, cur, map, ans);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}
