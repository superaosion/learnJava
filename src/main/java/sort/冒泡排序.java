package sort;

import java.util.Arrays;

/**
 * 冒泡排序（Bubble Sort)就是把小的元素往前调或者把大的元素往后调从而实现从小到大的排序。
 * 依次比较相邻的两个元素大小,若前一个元素大于后一个元素，则交换两个元素，每次比较一轮将最大的一个元素归位（即放到最后）。
 *
 * 排序之前：[25, 63, 78, 45, 132, 7]
 * 第1次排序：[25, 63, 45, 78, 7, 132]
 * 第2次排序：[25, 45, 63, 7, 78, 132]
 * 第3次排序：[25, 45, 7, 63, 78, 132]
 * 第4次排序：[25, 7, 45, 63, 78, 132]
 * 第5次排序：[7, 25, 45, 63, 78, 132]
 * 排序之后：[7, 25, 45, 63, 78, 132]
 */
public class 冒泡排序 {

    public static void main(String[] args){
        int[] bubbleNums = {25,63,78,45,132,7};
        System.out.println("排序之前：" + Arrays.toString(bubbleNums));

        bubbleSort(bubbleNums);
        System.out.println("排序之后：" + Arrays.toString(bubbleNums));
    }

    public static void swap(int[] nums,int i){
        int temp = nums[i + 1];
        nums[i + 1] = nums[i];
        nums[i] = temp;
    }

    private static void bubbleSort(int[] nums){
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i; j++) {
                if (nums[j] > nums[j + 1])
                    swap(nums,j);
            }
            System.out.print("第" + i + "次排序：");
            System.out.println(Arrays.toString(nums));
        }
    }
}
