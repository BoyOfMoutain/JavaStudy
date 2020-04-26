package com.boye.foundation.test;

import org.junit.Test;

import java.io.*;

//可以通过字节流对文件进行加密和解密
public class FileStreamTest {

    //加密
    public void testEncrypt(){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            File resFile = new File("src/exam.png");
            File desFile = new File("src/exam-Encrypt.png");
            fis = new FileInputStream(resFile);
            fos = new FileOutputStream(desFile);
            int len = 0;
            byte[] bytes = new byte[5];
            while(( len = fis.read(bytes)) != -1){
                for (int i=0; i< len; i++){
                    fos.write(bytes[i] ^ 5);
                }
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
                if(fos != null){
                    try {
                        fos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
    }

    //解密
    @Test
    public void testDecrypt(){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            File resFile = new File("src/exam-Encrypt.png");
            File desFile = new File("src/exam-Decrypt.png");
            fis = new FileInputStream(resFile);
            fos = new FileOutputStream(desFile);
            int len = 0;
            byte[] bytes = new byte[5];
            while(( len = fis.read(bytes)) != -1){
                for (int i=0; i< len; i++){
                    fos.write(bytes[i] ^ 5);
                }
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
                if(fos != null){
                    try {
                        fos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
    }
}
