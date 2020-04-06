package com.boye.foundation;

import java.io.*;

public class FileReaderOrWriterExample {

    private static void write() throws IOException{
        FileWriter writer = new FileWriter("/Users/dongboye/Desktop/a.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        String msg = "真的就是这么容易吗？好好想想下！";
        bufferedWriter.write(msg, 0, msg.length());
        msg = "66666666666666666666";
        bufferedWriter.newLine();//换行
        bufferedWriter.write(msg, 0, msg.length());
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    private static void read1() throws IOException{
        FileReader reader = new FileReader("/Users/dongboye/Desktop/a.txt");
        BufferedReader bw = new BufferedReader(reader);
      //  String line = bw.readLine();
      //  System.out.println(line);
        int ch = 0;
        while((ch = bw.read()) != -1){
            System.out.print((char)ch);
        }
    }

    private static void read2() throws IOException{
        FileReader reader =  new FileReader("/Users/dongboye/Desktop/a.txt");
        BufferedReader bw = new BufferedReader(reader);
        char[] s = new char[1024];
        int num = 0;
        while((num = bw.read(s)) != -1){
            System.out.print(new String(s, 0, num));
        }
    }

    public static void main(String[] args) throws IOException {
       // write();
        read1();
      //  read2();
    }
}
