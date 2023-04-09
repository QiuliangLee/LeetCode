package seconde;

import com.lql.TreeNode;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    static LinkedList<String> list = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        TreeNode root = decode(str, new int[]{0});
        int res = traverse(root, root);
        System.out.println(res);
    }

    private static int traverse(TreeNode root1, TreeNode root2) {
        return 0;
    }

    private static TreeNode decode(String str, int[] nums) {
        ++nums[0];
        TreeNode root = parse(str, nums);
        ++nums[0];
        return root;
    }

    private static TreeNode parse(String str, int[] nums) {
        if (str.charAt(nums[0]) == 'X') {
            ++nums[0];
            return null;
        }
        TreeNode root = new TreeNode(0);
        root.left = decode(str, nums);
        root.val = parseInt(str, nums);
        root.right = decode(str, nums);
        return root;
    }

    private static int parseInt(String str, int[] nums) {
        int x = 0, sign = 1;
        if (!Character.isDigit(str.charAt(nums[0]))) {
            sign = -1;
            ++nums[0];
        }
        while (Character.isDigit(str.charAt(nums[0]))) {
            x = x * 10 + str.charAt(nums[0]++) - '0';
        }
        return x * sign;
    }

}