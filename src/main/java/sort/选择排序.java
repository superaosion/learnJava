package sort;

import java.util.Arrays;

/**
 * 选择排序(Selection Sort)是一种简单直观的排序算法。
 * 首先在未排序的数列中找到最小(or最大)元素，然后将其存放到数列的起始位置；
 * 接着，再从剩余未排序的元素中继续寻找最小(or最大)元素，然后放到已排序序列的末尾。
 *
 * 排序之前：[25, 63, 78, 45, 132, 7]
 * 第0次排序：[7, 63, 78, 45, 132, 25]
 * 第1次排序：[7, 25, 78, 63, 132, 45]
 * 第2次排序：[7, 25, 45, 78, 132, 63]
 * 第3次排序：[7, 25, 45, 63, 132, 78]
 * 第4次排序：[7, 25, 45, 63, 78, 132]
 * 排序之后：[7, 25, 45, 63, 78, 132]
 */
public class 选择排序 {
    public static void main(String[] args) {
        int[] selectNums = {25, 63, 78, 45, 132, 7};
        System.out.println("排序之前：" + Arrays.toString(selectNums));

        selectSort(selectNums);
        System.out.println("排序之后：" + Arrays.toString(selectNums));

    }
    public static void swap(int[]nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    public  static void selectSort(int[] nums){
        for(int i=0;i<nums.length-1;i++){
            int temp=i;
            for(int j=i+1;j<nums.length;j++){
                if(nums[j]<nums[temp])
                    swap(nums,j,temp);
            }
            System.out.println("第"+i+"次排序："+Arrays.toString(nums));
        }
    }

}
