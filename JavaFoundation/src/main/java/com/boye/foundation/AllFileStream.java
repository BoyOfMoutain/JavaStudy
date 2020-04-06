package com.boye.foundation;

import java.io.*;

public class AllFileStream {

    //一个字节一个字节的复制
    private static void copyFile1(){
        try {
            long start = System.currentTimeMillis();
            FileInputStream in = new FileInputStream("/Users/dongboye/Desktop/算法的乐趣.pdf");
            FileOutputStream out = new FileOutputStream("/Users/dongboye/Desktop/算法的乐趣副本1.pdf");
            int by = 0;
            try {
                while ((by = in.read()) != -1){
                    out.write(by);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    in.close();
                    out.close();
                    long end = System.currentTimeMillis();
                    System.out.println("总共花的时间是"+(end - start) +"ms");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    //1024字节的复制
    private static void copyFile2(){
        try {
            long start = System.currentTimeMillis();
            FileInputStream in = new FileInputStream("/Users/dongboye/Desktop/算法的乐趣.pdf");
            FileOutputStream out = new FileOutputStream("/Users/dongboye/Desktop/算法的乐趣副本2.pdf");
            int len = 0;
            byte[] bytes = new byte[1024];
            try {
                while ((len = in.read(bytes)) != -1){
                    out.write(bytes, 0, len);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    in.close();
                    out.close();
                    long end = System.currentTimeMillis();
                    System.out.println("总共花的时间是"+(end - start) +"ms");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    //一个字节一个字节的复制，但用到缓冲流处理
    private static void copyFile3(){
        try {
            long start = System.currentTimeMillis();
            BufferedInputStream in = new BufferedInputStream(new FileInputStream("/Users/dongboye/Desktop/算法的乐趣.pdf"));
            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("/Users/dongboye/Desktop/算法的乐趣副本3.pdf"));
            int by = 0;
            try {
                while ((by = in.read()) != -1){
                    out.write(by);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    in.close();
                    out.close();
                    long end = System.currentTimeMillis();
                    System.out.println("总共花的时间是"+(end - start) +"ms");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    //1024字节的复制，但用到缓冲流
    private static void copyFile4(){
        try {
            long start = System.currentTimeMillis();
            BufferedInputStream in = new BufferedInputStream(new FileInputStream("/Users/dongboye/Desktop/算法的乐趣.pdf"));
            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("/Users/dongboye/Desktop/算法的乐趣副本4.pdf"));
            int len = 0;
            byte[] bytes = new byte[1024];
            try {
                while ((len = in.read(bytes)) != -1){
                    out.write(bytes, 0, len);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    in.close();
                    out.close();
                    long end = System.currentTimeMillis();
                    System.out.println("总共花的时间是"+(end - start) +"ms");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 写数据到文件里,写出数据
     *用的是输出流
     * @param fileName String
     */
    private static void writeToFile(String fileName){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("/Users/dongboye/Desktop/"+ fileName, true);
            byte[] bytes = {97,98,99,100,101};
            try {
                fileOutputStream.write(bytes, 1, 3);
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    fileOutputStream.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 读数据到屏幕里，读入数据
     * 用的是输入流
     * @param fileName  String
     */
    private static void readFromFile(String fileName){
        try {
            FileInputStream input = new FileInputStream("/Users/dongboye/Desktop/"+ fileName);
          //  byte[] bytes = new byte[1024];
            int by = 0;
            try {
                while((by=input.read())!=-1){
                    System.out.print((char)by);
                   // System.out.println(new String(bytes, 0, bytes.length));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        /*writeToFile("a.txt");
        readFromFile("a.txt");*/

        /**
         * 总共花的时间是46468ms
         * 总共花的时间是71ms
         * 总共花的时间是307ms
         * 总共花的时间是36ms 可选
         */
        copyFile1();
        copyFile2();
        copyFile3();
        copyFile4();
    }
}
