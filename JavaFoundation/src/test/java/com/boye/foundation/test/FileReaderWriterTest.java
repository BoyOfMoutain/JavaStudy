package com.boye.foundation.test;

import org.junit.Test;

import java.io.*;

public class FileReaderWriterTest {


    public void testRead1(){
        FileReader fileReader = null;
        try {
            File file = new File("src/hello.txt");
            fileReader = new FileReader(file);
            int data;//读入的是字符的ASCII码的数值
            while((data = fileReader.read()) != -1){
                System.out.print((char)data);
            }
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null){
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void testRead2(){
        FileReader fileReader = null;
        try {
            File file = new File("src/hello.txt");
            fileReader = new FileReader(file);
            char[] chars = new char[5];
            int len = 0;
            while((len = fileReader.read(chars)) != -1){
                for (int i = 0; i < len; i++) {
                    System.out.print(chars[i]);
                }
            }
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null){
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void testRead3(){
        FileReader fileReader = null;
        try {
            File file = new File("src/hello.txt");
            fileReader = new FileReader(file);
            char[] chars = new char[5];
            int len = 0;
            while((len = fileReader.read(chars)) != -1){
                String str = new String(chars, 0, len);
                System.out.print(str);
            }
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null){
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void testWrite1(){
        FileWriter fileWriter = null;
        try {
            File file = new File("src/world.txt");//没有文件会直接创建
            fileWriter = new FileWriter(file);//会直接替换掉
            fileWriter.write("haha,我是谁？\n");
            fileWriter.write("hehe,为什么会来到这个世界上？");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileWriter != null){
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void testWrite2(){
        FileWriter fileWriter = null;
        try {
            File file = new File("src/world.txt");//没有文件会直接创建
            fileWriter = new FileWriter(file,true);//会直接替换掉
            fileWriter.write("我是谁？\n");
            fileWriter.write("为什么会来到这个世界上？");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileWriter != null){
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void testReadAndWrite1(){
        FileReader fileReader = null;
        FileWriter fileWriter = null;
        try {
            File resFile = new File("src/hello.txt");
            File desFile = new File("src/world.txt");
            fileReader = new FileReader(resFile);
            fileWriter = new FileWriter(desFile, false);
            char[] chars = new char[3];
            int len = 0;
            while( (len = fileReader.read(chars)) != -1){
                fileWriter.write(chars, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fileReader != null){
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    if( fileReader != null){
                        fileWriter.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void testReadAndWrite2(){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            File resFile = new File("src/exam.png");
            File desFile = new File("src/exam-back.png");
            fis = new FileInputStream(resFile);
            fos = new FileOutputStream(desFile, false);
            byte[] bytes = new byte[3];
            int len = 0;
            while( (len = fis.read(bytes)) != -1){
                fos.write(bytes, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fis != null){
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    if( fos != null){
                        fos.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
