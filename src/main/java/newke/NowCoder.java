package main.java.newke;

public class NowCoder {

    public static void main(String[] args) {
       try {
           throw new RuntimeException("aaa");
       } catch (Exception exception) {
           exception.printStackTrace();
       } finally {
           System.out.println("我执行了");
       }
    }
}
