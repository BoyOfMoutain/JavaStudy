package com.boye.foundation.test;

import org.junit.Test;

import java.io.*;

public class OtherInputStreamTest {


   /* public static void main(String[] args) {
        test1();
    }
*/
    public static void test1(){

        BufferedReader bufferedReader = null;
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(System.in);
            bufferedReader = new BufferedReader(inputStreamReader);

            while(true){
                System.out.println("请输入字符：");
                String data = bufferedReader.readLine();
                if("q".equalsIgnoreCase(data)){
                    System.out.println("正常退出！");
                    break;
                }else{
                    System.out.println(data.toUpperCase());;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(bufferedReader != null){
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void test2(){
        PrintStream ps = null;
        try {
            FileOutputStream fos = new FileOutputStream(new File("src/print-data.txt"));
            ps = new PrintStream(fos, true);
            if (ps != null){
                System.setOut(ps);
            }
            for (int i = 0; i <= 255; i++) {
                System.out.print((char)i);
                if(i % 50 == 0){
                    System.out.println();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ps != null){
                ps.close();
            }
        }
    }

   //写数据到txt文件，输出数据
    public void test3(){
        DataOutputStream dataOutputStream = null;
        try {
            dataOutputStream = new DataOutputStream(new FileOutputStream("src/read-datastream.txt"));
            dataOutputStream.writeUTF("天行健");
            dataOutputStream.flush();
            dataOutputStream.writeUTF("男");
            dataOutputStream.flush();
            dataOutputStream.writeBoolean(true);
            dataOutputStream.flush();
            dataOutputStream.writeInt(28);
            dataOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (dataOutputStream != null){
                try {
                    dataOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    //写数据到内存中。输入数据
    @Test
    public void test4(){
        DataInputStream dataInputStream = null;
        try {
            dataInputStream = new DataInputStream(new FileInputStream("src/read-datastream.txt"));
            String name = dataInputStream.readUTF();
            String sex = dataInputStream.readUTF();
            boolean flag = dataInputStream.readBoolean();
            int age = dataInputStream.readInt();
            System.out.println("name=" + name + ", sex=" + sex +", flag="+flag +", age="+age);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(dataInputStream != null){
                try {
                    dataInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
