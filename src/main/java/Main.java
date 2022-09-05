import org.junit.Test;

import java.util.Random;

/**
 * @author liqiuliang
 * @create 2022-09-05 12:01
 */
public class Main {
    static int[] temp;

    public static void main(String[] args) {
        Random r=new Random();
        int[] nums = new int[10];
        for (int i = 0; i < nums.length; i++) {
            nums[i]=r.nextInt();
        }
        temp = new int[nums.length];
        sort(nums, 0, nums.length - 1);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static void sort(int[] nums, int left, int right) {
        if (left == right) {
            return;
        }
        int mid = left + (right - left) / 2;
        sort(nums, left, mid);
        sort(nums, mid + 1, right);
        merge(nums, left, mid, mid + 1, right);
    }

    private static void merge(int[] nums, int leftS, int leftE, int rightS, int rightE) {
        int k = leftS, i = leftS, j = rightS;
        for (; i <= leftE && j <= rightE; ) {
            if (nums[i] < nums[j]) {
                temp[k] = nums[i];
                i++;
            } else {
                temp[k] = nums[j];
                j++;
            }
            k++;
        }
        while (i <= leftE) {
            temp[k] = nums[i];
            k++;
            i++;
        }
        while (j <= rightE) {
            temp[k] = nums[j];
            k++;
            j++;
        }
        for (int index = leftS; index <= rightE; index++) {
            nums[index] = temp[index];
        }
    }
}