package com.boye.foundation.test;

import org.junit.Test;

import java.io.*;

/**
 * 字符转字节的存储
 * 字符转换流
 */
public class InputStreamReaderTest {

    @Test
    public void test(){
        InputStreamReader isr = null;
        OutputStreamWriter osr = null;
        try {
            //1.先造文件
            File file1  = new File("src/hello.txt");
            File file2 = new File("src/hello_gbk.txt");
            //2.再造文件流
            FileInputStream fis = new FileInputStream(file1);
            FileOutputStream fos = new FileOutputStream(file2);
            //3.再造转换流
            isr = new InputStreamReader(fis, "UTF-8");
            osr = new OutputStreamWriter(fos, "GBK");
            char[] chars = new char[10];
            int len = 0;
            while((len = isr.read(chars)) != -1){
                osr.write(chars, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (isr != null){
                    isr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (osr != null){
                    osr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
