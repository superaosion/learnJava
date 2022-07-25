package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 */
public class 两数之和 {

    public static void main(String[] args){
        int[] nums = {3,2,4};
        int[] ints = twoSum(nums,6);
        int[] ints2 = twoSum2(nums,6);
        System.out.println(Arrays.toString(ints));
        System.out.println(Arrays.toString(ints2));
    }


    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> hashMap = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.get(target - nums[i]) != null) {
                result[0] = hashMap.get(target - nums[i]);
                // 如果返回第几个
                // result[1] = i + 1;
                result[1] = i;
            }
            // hashMap.put(nums[i], i);
            hashMap.put(nums[i], i);
        }
        return result;
    }

    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        /*
        以 3 2 4，6 为例
        第一趟 i=0 map为空 将 6-3=3 放到map{3,0}
        第二趟 i=1 map{3,0} 含3 将6-2=4 放到map {3,0},{4,1}
        第三趟 i=2 map{3,0},{4,1} 含4 返回[1,2]
         */
        for(int i = 0 ; i < nums.length; i ++) {
            if(map.containsKey(nums[i])) {
                return new int[]{ map.get(nums[i]),i};
            }
            map.put(target - nums[i], i);
        }
        return null;
    }
}
