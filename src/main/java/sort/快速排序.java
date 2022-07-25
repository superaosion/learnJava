package sort;

import java.util.Arrays;

/**
 * 快速排序(Quick Sort)的基本思想：通过一次排序将待排序元素分割成两个独立的部分，其中一部分元素都要比另一部分小，之后对两部分分别排序，最终得到一个有序数列。
 * 算法描述：
 * 1.从数列中选择一个元素作为“基准”，即分割数列
 * 2.排列数列，将所有小于“基准”的元素全都放到左边，将大于“基准”的元素全部放到右边
 * 3.将分割的部分分别递归的排序
 *
 */
public class 快速排序 {

    public static void main(String[] args) {
        int[] quickNums = {25, 63, 18, 29, 26, 78, 45, 132, 7};
        System.out.println("排序之前：" + Arrays.toString(quickNums));

        quickSort(quickNums);
        System.out.println("排序之后：" + Arrays.toString(quickNums));

    }

    public static int position(int[] nums, int low, int high) {
        int i = low;
        int j = high;
        int x = nums[low];
        while (i < j) {
            while (nums[j] >= x && i < j) {
                j--;
            }
            if (i < j) {
                nums[i] = nums[j];
                i++;
            }
            while (nums[i] < x && i < j) {
                i++;
            }
            if (i < j) {
                nums[j] = nums[i];
                j--;
            }

        }
        nums[i] = x;
        return i;
    }

    public static void quickSort(int[] nums, int low, int high) {
        int k = 1;
        if (low < high) {
            int index = position(nums, low, high);
            quickSort(nums, low, index - 1);
            quickSort(nums, index + 1, high);
        }
    }
    public static void quickSort(int[] nums){
        int low=0;
        int high=nums.length-1;
        quickSort(nums,low,high);
    }
}
