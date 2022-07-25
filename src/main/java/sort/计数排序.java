package sort;

import java.util.Arrays;

/**
 * 算法的步骤如下：
 *
 * 找出待排序的数组array中最大的元素max
 * 统计数组中每个值为 i 的元素出现的次数，存入数组 count 的第 i 项
 * 对所有的计数累加（从 count中的第一个元素开始，每一项和前一项相加）
 * 反向填充目标数组：将每个元素 i 放在新数组的第 count [i] 项，每放一个元素就将 count [i] 减去
 */
public class 计数排序 {

    public static void main(String[] args) {
        int[] array = { 4, 2, 2, 8, 3, 3, 1 };
        // 找到数组中最大的值 ---> max:8
        int max = findMaxElement(array);
        int[] sortedArr = countingSort(array, max + 1);
        System.out.println("计数排序后的数组： " + Arrays.toString(sortedArr));
    }
    private static int findMaxElement(int[] array) {
        int max = array[0];
        for (int val : array) {
            if (val > max)
                max = val;
        }
        return max;
    }
    private static int[] countingSort(int[] array, int range) { //range:8+1
        int[] output = new int[array.length];
        int[] count = new int[range];
        //初始化： count1数组
        for (int i = 0; i < array.length; i++) {
            count[array[i]]++;
        }
        //计数： count2数组，累加次数后的，这里用count2区分
        for (int i = 1; i < range; i++) {
            count[i] = count[i] + count[i - 1];
        }
        //排序：最后数组
        for (int i = 0; i < array.length; i++) {
            output[count[array[i]] - 1] = array[i];
            count[array[i]]--;
        }
        return output;
    }
}
