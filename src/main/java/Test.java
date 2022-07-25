package main.java;

import sun.font.FontRunIterator;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Test {


  static   int a = 0;

    public int find(int[] arr, int k) {
        for(int i = 0; i <= k ; i ++) {
            for (int j = 0; j <= arr.length-i; j ++) {
                if (arr[j] < arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr[k];
    }

    public static void blockQueue (int number)  {
        for (int i = 0; i < 100; i++) {
            new Thread(()-> {
                a += 1;
                System.out.println(a);
            }).start();

        }
        Executors.newCachedThreadPool();
    }

    public static void main(String[] args) {
        blockQueue(1);
    }
}
