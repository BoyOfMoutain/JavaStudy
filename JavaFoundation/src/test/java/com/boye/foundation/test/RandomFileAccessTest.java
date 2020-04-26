package com.boye.foundation.test;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomFileAccessTest {


    @Test
    public void test1(){
        RandomAccessFile raf1 = null;
        RandomAccessFile raf2 = null;
        try {
            raf1 = new RandomAccessFile(new File("src/hello.txt"), "r");
            raf2 = new RandomAccessFile(new File("src/random.txt"), "rw");

            byte[] buff = new byte[1024];
            int len;
            while ((len = raf1.read(buff)) != -1){
                raf2.write(buff, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(raf1 != null){
                try {
                    raf1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(raf2 != null){
                try {
                    raf2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }


    }

}
