package Four;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

class Solution {
    List<String> res = new LinkedList<>();

    @Test
    public void test() {
        System.out.println(removeInvalidParentheses("))(()"));
    }

    public List<String> removeInvalidParentheses(String s) {
        int[] removeNums = findRemoveNums(s);
        int lremove = removeNums[0], rremove = removeNums[1];
        System.out.print(lremove + " " + rremove);
        traverse(s, 0, lremove, rremove);
        return res;
    }

    public int[] findRemoveNums(String str) {
        int lremove = 0, rremove = 0;
        for (char c : str.toCharArray()) {
            if (c == '(') {
                lremove++;
            } else if (c == ')') {
                if (lremove > 0) {
                    lremove--;
                } else {
                    rremove++;
                }
            }
        }
        return new int[]{lremove, rremove};
    }

    public void traverse(String str, int cur, int lremove, int rremove) {
        if (lremove == 0 && rremove == 0) {
            if (isValid(str)) {
                res.add(str);
            }
            return;
        }
        for (int i = cur; i < str.length(); i++) {
            if (i != cur && str.charAt(i) == str.charAt(i - 1)) {
                continue;
            }
            if (str.length() - i < lremove + rremove) {
                return;
            }
            if (lremove > 0 && str.charAt(i) == '(') {
                traverse(str.substring(0, i) + str.substring(i + 1), i, lremove - 1, rremove);
            } else if (rremove > 0 && str.charAt(i) == ')') {
                traverse(str.substring(0, i) + str.substring(i + 1), i, lremove, rremove - 1);
            }
        }
    }

    public boolean isValid(String str) {
        int cnt = 0;
        for (char c : str.toCharArray()) {
            if (c == '(') {
                cnt++;
            } else if (c == ')') {
                cnt--;
                if (cnt < 0) {
                    return false;
                }
            }
        }
        return cnt == 0;
    }
}