package com.boye.foundation;

import java.io.File;
import java.io.IOException;

public class FileExample {

    public static void main(String[] args) throws IOException {
        File file = new File("/Users/dongboye/Desktop/password.txt");
        System.out.println("getAbsoluteFile = "+file.getAbsoluteFile());
        System.out.println("getAbsolutePath = " + file.getAbsolutePath());
        System.out.println("getCanonicalPath = " + file.getCanonicalPath());
        System.out.println("getName = " + file.getName());
        System.out.println("getParent = " + file.getParent());
        System.out.println("getPath = " + file.getPath());
        System.out.println("getParentFile = " + file.getParentFile());
        System.out.println("getUsableSpace = " + file.getUsableSpace());
        System.out.println("getFreeSpace = " + file.getFreeSpace());
        System.out.println("getTotalSpace = " + file.getTotalSpace());
        System.out.println("canExecute : " + file.canExecute());
        System.out.println("canRead : " + file.canRead());
        System.out.println("canWrite : " + file.canWrite());
        System.out.println("exists : " + file.exists());
        System.out.println("isAbsolute : " + file.isAbsolute());
        System.out.println("isFile : " + file.isFile());
        System.out.println("isDirectory : " + file.isDirectory());
        System.out.println("isHidden : " + file.isHidden());
    }
}
