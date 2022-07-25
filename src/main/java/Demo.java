package main.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.*;

public class Demo {


    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return val + " -> " + next ;
        }
    }


    // 反转列表
    public static ListNode ReverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode newListNode = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = newListNode;
            newListNode = head;
            head = temp;
        }
        return newListNode;
    }

    public static ListNode ReverseList2(ListNode head) {
        if (head == null | head.next == null) {
            return head;
        }
        ListNode listNode = ReverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return listNode;
    }

        public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        System.out.println(listNode1.toString());

        ListNode listNode = ReverseList(listNode1);
        System.out.println(listNode.toString());
    }


    // 寻找k个最小数
    public static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if (input.length >= k && k > 0) {
            Arrays.sort(input);
            for (int i = 0; i < k; i++) {
                result.add(new Integer(input[i]));
            }

        }
        return result;
    }

    // 寻找k个最小数2
    public static ArrayList<Integer> GetLeastNumbers_Solution2(int[] input, int k) {
        ArrayList<Integer> al = new ArrayList<Integer>();
        if (k > input.length) {
            return al;
        }
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < input.length - i - 1; j++) {
                if (input[j] < input[j + 1]) {
                    int temp = input[j];
                    input[j] = input[j + 1];
                    input[j + 1] = temp;
                }
            }
            al.add(input[input.length - i - 1]);
        }
        return al;
    }

    //    public static void main(String[] args) {
//        int[] i = new int[]{4,5,1,6,2,7,3,11,8,9};
//        ArrayList<Integer> integers = GetLeastNumbers_Solution2(i, 4);
//        System.out.println(integers.toString());
//    }


    // 两数之和 [3,2,4],6
    public static int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.get(target - numbers[i]) != null) {
                result[0] = map.get(target - numbers[i]) + 1;
                result[1] = i + 1;
            }
            map.put(numbers[i], i);
        }
        return result;
    }

//    public static void main(String[] args) {
//        int[] a ={3,2,4};
//        twoSum(a ,6);
//    }

    // 寻找最大数组
    public static int maxLength(int[] arr) {
        // write code here
        int[] lastPos = new int[100005];
        int len = arr.length;
        int start = 0;
        int res = 0;
        for (int i = 0; i < len; i++) {
            int now = arr[i];
            start = Math.max(start, lastPos[now]);
            res = Math.max(res, i - start + 1);
            lastPos[now] = i + 1;
        }

        return res;
    }

//    public static void main(String[] args) {
//        int[] a = {2,2,3,4,3};
//        System.out.println(maxLength(a));
//    }

    // 括号序列
    public static boolean isValid(String s) {
        // write code here
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '[')
                stack.push(']');
            else if (c == '{')
                stack.push('}');
            else if (stack.empty() || stack.pop() != c)
                return false;
        }
        return stack.empty();
    }

//    public static void main(String[] args) {
//        System.out.println(isValid("[][][]{{{"));
//    }

    // 返回斐波那契数列的第N个
    public static int Fibonacci(int n) {
        int[] array = new int[n + 1];
        if (n == 0 || n == 1) return n;
        if (n > 39) return 0;
        array[0] = 0;
        array[1] = 1;
        for (int i = 2; i <= n; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }
        return array[n];
    }

    // 二分查找
    public static int search(int[] nums, int target) {
        // write code here
        if(nums==null||nums.length==0){
            return -1;
        }
        int first = 0;
        int last = nums.length;
        while(first<last){
            int middle = (first +last)/2;
            if(nums[middle]>target){
                last = middle-1;
            }else if(nums[middle]<target){
                first=middle+1;
            }else{
                last=middle;
            }
        }
        if(nums[first]==target){
            return first;
        }
        return -1;
    }

//    public static void main(String[] args) {
//        int[] a = {1, 2, 2, 2, 7, 7, 7, 9, 9, 10};
//        System.out.println(search(a, 2));
//    }

    // 找字符串内最长回文串
    public static int getLongestPalindrome(String A, int n) {
        // write code here
        char[] ch = A.toCharArray();
        int res = 0;
        for(int i = 0; i < n; i++){
            int l = i, r = i;
//            定位左右两边,避免abba和aba
            while(l - 1 >= 0 && ch[l - 1] == ch[i])
                l--;
            while(r + 1 < n && ch[r + 1] == ch[i])
                r++;
            while(l - 1 >= 0 && r + 1 < n && ch[l - 1] == ch[r + 1]){
                l--;
                r++;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }

//    public static void main(String[] args) {
//        System.out.println(getLongestPalindrome("aaa", 3));
//    }

    // 数组中出现次数超过数组长度一半的数字
    public static int MoreThanHalfNum_Solution(int [] array) {
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < array.length; i++) {
            int i1 = array[i];
            if (map.containsKey(i1)) {
                map.put(i1,map.get(i1)+1);
            } else {
                map.put(i1, 1);
            }
        }
        for (Integer integer : map.keySet()) {
            if (map.get(integer) > array.length/2) {
                return integer;
            }
        }
        return 0;
    }

    // 寻找链表中环的入口节点 2(a+b) = a+b+c+b
    public ListNode detectCycle(ListNode head) {
        // 慢指针
        ListNode p1 = head;
        // 快指针
        ListNode p2 = head;
        // 如果没环 就停止了
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            // 第一次相遇
            if (p1 == p2) {
                // 慢指针回起点
                p1 = head;
                while(p1 != p2) {
                    p1 = p1.next;
                    p2 = p2.next;
                }
                // 第二次相遇为入口
                break;
            }
        }
        if (p2 == null || p2.next == null) return null;
        return p1;
    }

    // 奖学金
//    public static void main(String[] args){
//        Scanner sc=new Scanner(System.in);
//        while(sc.hasNext()){
//            int n=sc.nextInt();
//            int full=sc.nextInt();
//            int avg=sc.nextInt();
//            int[][] nums=new int[n][2];
//            for(int i=0;i<n;i++){
//                nums[i][0]=sc.nextInt();
//                nums[i][1]=sc.nextInt();
//            }
//            Arrays.sort(nums,(o1,o2)->o1[1]-o2[1]);//按复习代价从小到大排序
//            long sum=0;
//            for(int[] a:nums) {
//                sum+=a[0];
//            }
//            long limit=avg*n;
//            int index=0;
//            long time=0;
//            while(sum<limit){
//                int tmp=full-nums[index][0];
//                if(tmp+sum<=limit){                  //如果一门课程复习到满分，小于限制，
//                    time+=tmp*nums[index][1];
//                    sum+=tmp;
//                    index++;
//                }
//                else{                              //如果一门课程复习到满分，大于限制，
//                    time+=(limit-sum)*nums[index][1];
//                    sum=limit;
//                }
//            }
//            System.out.println(time);
//        }
//    }

    // 路灯问题
//    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String line;
//        int[] pos;
//
//        while ((line = reader.readLine()) != null) {
//            String[] temp = line.split(" ");
//            int n = Integer.parseInt(temp[0]);
//            int l = Integer.parseInt(temp[1]);
//
//            line = reader.readLine();
//            temp = line.split(" ");
//            pos = new int[n];
//            for (int i = 0; i < n; i++) {
//                pos[i] = Integer.parseInt(temp[i]);
//            }
//
//            Arrays.sort(pos);
//            double max_gap = Math.max(pos[0], l - pos[n-1]);
//            for (int i = 0; i < n - 1; i++) {
//                double gap = (pos[i + 1] - pos[i]) / 2.0;
//                max_gap = Math.max(gap, max_gap);
//            }
//
//            // double ans = max_gap / 2.0;
//            System.out.println(String.format("%.2f", max_gap));
//        }
//    }

//    public static void main(String[] args) {
//        ExecutorService executorService = Executors.newCachedThreadPool();
//        ExecutorService executorService1 = new ThreadPoolExecutor(10, 20,
//                60L, TimeUnit.SECONDS,
//                new LinkedBlockingQueue<Runnable>(10));
//        for (int i = 0; i < 100000; i++) {
////            executorService1.execute(new MyTak(i));
//            Future<?> submit = executorService1.submit(new MyTak(i));
//            System.out.println(submit.toString());
//        }
//        executorService1.shutdown();
//    }

    public static class MyTak implements Runnable {

        private int i;

        MyTak(int i){
            this.i = i;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "-----------" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }



    public static int findStr(String str) {
        if(str.length() <=1) {
            return str.length();
        }
        int sta = 0;
        int end = 1;
        int length = 0;

        while ( end <= str.length()) {
            String sub = str.substring(sta, end);
            HashSet<String> set = new HashSet<String>();

            char[] chars = sub.toCharArray();

            for (char aChar : chars) {
                set.add(String.valueOf(aChar));
            }
            if (set.size() != chars.length) {
                sta ++;
            } else {
                end ++;
                length = Math.max(length, set.size());
            }
        }
        return length;
    }

//    public static void main(String[] args) {
//        System.out.println(findStr("acaassab"));
//    }
}
