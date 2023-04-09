package third;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        int n = sc.nextInt();
        int res = 0;
        HashMap<String, Integer> map = new HashMap<>();
        HashSet<Character>[] bArray = new HashSet[n];
        HashSet<Character> aSet = new HashSet<>();
        for (char c : a.toCharArray()) {
            aSet.add(c);
        }
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            bArray[i] = new HashSet<>();
            String str = sc.nextLine();
            for (char c : str.toCharArray()) {
                bArray[i].add(c);
            }
            String code = encode(bArray[i]);
            map.put(code, map.getOrDefault(code, 0) + 1);
        }

        for (HashSet<Character> bSet : bArray) {
            HashSet<Character> cSet = new HashSet<>(aSet);
            cSet.addAll(bSet);
            String code = encode(cSet);
            if (cSet.equals(bSet)) {
                res--;
            }
            res += map.getOrDefault(code, 0);
        }

        System.out.println(res);
    }

    private static String encode(HashSet<Character> set) {
        char[] chars = new char[62];
        for (char c : set) {
            if (Character.isUpperCase(c)) {
                chars[c - 'A']++;
            } else if (Character.isLowerCase(c)) {
                chars[26 + c - 'a']++;
            } else {
                chars[52 + c - '0']++;
            }
        }
        return new String(chars);
    }
}