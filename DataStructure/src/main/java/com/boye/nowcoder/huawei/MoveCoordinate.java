package com.boye.nowcoder.huawei;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @project: JavaStudy
 * @classname: <code>MoveCoordinate</code>
 * @description: 坐标的移动计算
 * @create: 2020/4/27 12:58
 * @author: dongboye
 */
public class MoveCoordinate {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String line;
            while((line = br.readLine()) != null){
                String[] cur=line.split(";");
                int x=0;
                int y=0;
                for(int i=0;i<cur.length;i++){
                    char[] arr=cur[i].toCharArray();
                    int change= getInt(arr);
                    switch(arr[0]){
                        case 'A':
                            x-=change;
                            break;
                        case 'D':
                            x+=change;
                            break;
                        case 'W':
                            y+=change;
                            break;
                        case 'S':
                            y-=change;
                            break;
                    }
                }
                System.out.println(x+","+y);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static int getInt(char[] chars){
        int change = 0;
        for(int j=1;j<chars.length;j++){
            if(chars[j]>='0'&&chars[j]<='9'){
                change = change*10+(chars[j]-'0');
            }else{
                break;
            }
        }
        return change;
    }
}
