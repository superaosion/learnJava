package sort;

import java.util.Arrays;

/**
 *
 * 插入排序(Insert Sort)就是每一步都将一个待排数据按其大小插入到已经排序的数据中的适当位置，直到全部插入完毕。
 *
 * 排序之前：[5, 3, 18, 15, 32, 7]
 * 第1次排序：[3, 5, 18, 15, 32, 7]
 * 第2次排序：[3, 5, 18, 15, 32, 7]
 * 第3次排序：[3, 5, 15, 18, 32, 7]
 * 第4次排序：[3, 5, 15, 18, 32, 7]
 * 第5次排序：[3, 5, 7, 15, 18, 32]
 * 排序之后：[3, 5, 7, 15, 18, 32]
 */
public class 插入排序 {
    public static void main(String[] args) {
        int[] insertNums = {5, 3, 18, 15, 32, 7};
        System.out.println("排序之前：" + Arrays.toString(insertNums));

        insertSort(insertNums);
        System.out.println("排序之后：" + Arrays.toString(insertNums));

    }
    public static void insertSort(int[] nums){
        for (int i = 1; i < nums.length; i++) {
            int k = nums[i];
            int j = i - 1;
            while (j >= 0 && nums[j] > k) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = k;
            System.out.println("第" + i + "次排序：" + Arrays.toString(nums));
        }
    }
}
