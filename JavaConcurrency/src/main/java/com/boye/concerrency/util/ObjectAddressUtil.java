package com.boye.concerrency.util;




import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * 对象引用的值
 */
public class ObjectAddressUtil {

    static Unsafe unsafe = null;
    static final boolean is64bit = true; // auto detect if possible.

    public ObjectAddressUtil(){
        try {
            //获取 Unsafe 内部的私有的实例化单例对象
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            //无视权限
            field.setAccessible(true);
            unsafe = (Unsafe) field.get(null);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
    //打印Java对象的值
    public static void print(Object a) {
        // hashcode
        System.out.println("Hashcode :       " + a.hashCode());
        System.out.println("Hashcode :       " + System.identityHashCode(a));
        System.out.println("Hashcode (HEX) : " + Integer.toHexString(a.hashCode()));// Integer.toHexString(int)是将一个整型转成一个十六进制数

        // toString
        System.out.println("toString :       " + String.valueOf(a));

        //通过sun.misc.Unsafe;
        printAddresses("Address", a);
    }

    //打印java对象的地址
    private static void printAddresses(String label, Object... objects) {
        System.out.print(label + ":         0x");
        long last = 0;
        int offset = unsafe.arrayBaseOffset(objects.getClass());
        int scale = unsafe.arrayIndexScale(objects.getClass());
        switch (scale) {
            case 4:
                long factor = is64bit ? 8 : 1;
                final long i1 = (unsafe.getInt(objects, offset) & 0xFFFFFFFFL) * factor;
                System.out.print(Long.toHexString(i1));
                last = i1;
                for (int i = 1; i < objects.length; i++) {
                    final long i2 = (unsafe.getInt(objects, offset + i * 4) & 0xFFFFFFFFL) * factor;
                    if (i2 > last) {
                        System.out.print(", +" + Long.toHexString(i2 - last));
                    } else {
                        System.out.print(", -" + Long.toHexString(last - i2));
                    }
                    last = i2;
                }
                break;
            case 8:
                throw new AssertionError("Not supported");
        }
        System.out.println();
    }

    public static String getAddresses(Object... objects){
        StringBuilder sb = new StringBuilder("");
        long last = 0;
        int offset = unsafe.arrayBaseOffset(objects.getClass());
        int scale = unsafe.arrayIndexScale(objects.getClass());
        switch (scale){
            case 4:
                long factor = is64bit? 8 : 1;
                final long i1 = (unsafe.getInt(objects, offset) & 0xFFFFFFFFL) * factor;
                sb.append(Long.toHexString(i1));
                last = i1;
                for (int i=0; i< objects.length; i++){
                    final long i2 = (unsafe.getInt(objects, offset + i * 4) & 0XFFFFFFFFL) * factor;
                    if(i2 > last){
                        sb.append(", +" + Long.toHexString(i2 - last));
                    }else{
                        sb.append(", -"+ Long.toHexString(last - i2));
                    }
                    last = i2;
                }
                break;
            case 8:
                throw new AssertionError("不支持！");
        }
        return sb.toString();
    }

}
