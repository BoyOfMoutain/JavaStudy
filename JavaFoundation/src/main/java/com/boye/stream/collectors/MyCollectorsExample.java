package com.boye.stream.collectors;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MyCollectorsExample {

    public static void main(String[] args) {
        List<Integer> listOfInt = Arrays.asList(1,2,3,4);
        List<String> listOfStr = Arrays.asList("A","B","C","D");
        List<Integer> listOfNum = Arrays.asList(30,10,20,35);
        System.out.println("=======================Collectors的测试类===========================");
        Double r1 = listOfInt.stream().collect(Collectors.averagingDouble(d->d*2));
        Double r2 = listOfInt.stream().collect(Collectors.averagingInt(v->v*2));
        Double r3 = listOfInt.stream().collect(Collectors.averagingLong(v->v*2));
        Double r4 = listOfInt.stream().collect(Collectors.collectingAndThen(Collectors.averagingLong(v->v*2), s-> s*s + 2));
        System.out.println("averagingDouble: r1 = "+r1);
        System.out.println("averagingInt: r2 = "+r2);
        System.out.println("averagingLong: r3 = "+r3);
        System.out.println("collectingAndThen: r4 = "+r4);
        String r5 =  listOfStr.stream().collect(Collectors.joining(",","(",")"));
        System.out.println("joining: r5 = "+r5);
        listOfNum.stream().collect(Collectors.maxBy(new MyCollectorsExample().new IntegerComparator())).ifPresent( i -> System.out.println("maxBy : "+i));
        listOfNum.stream().collect(Collectors.minBy(new MyCollectorsExample().new IntegerComparator())).ifPresent( i -> System.out.println("minBy : "+i));
    }

    class IntegerComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer i1, Integer i2) {
            return i1 >=i2 ? 1 : -1;
        }
    }
}
