package boye.test;

import org.junit.Test;

public class MyTest {

    @Test
    public void test(){
        Integer a = new Integer(100);
        Integer b = new Integer(100);
        Integer c = 100;
        Integer d = 100;
        System.out.println(a == b);
        System.out.println(c == d);

        int[][] arr = new int[8][2];
        System.out.println(arr[6][1]);
    }
}
