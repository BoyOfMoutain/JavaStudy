package com.boye.nowcoder.huawei;

import java.util.Scanner;

/**
 * @project: JavaStudy
 * @classname: <code>MostOfPriceNP</code>
 * @description: 最大价值的0-1背包问题
 * @create: 2020/4/26 15:45
 * @author: dongboye
 */
public class MostOfPrice01Bag {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();//总钱数
        int m = scanner.nextInt();//产品的个数

        int[] rt = new int[N +1];//用来记录最大的值
        Product[][] goods = new Product[m + 1][3];

        for (int i = 1; i <= m; i++) {
            int v = scanner.nextInt();
            int p = scanner.nextInt();
            int q = scanner.nextInt();
            Product pt = new Product(v, v*p);
            if (q == 0){//说明当前是主件
                goods[i][0] = pt;
            }else{
                if(goods[q][1] == null){//找到它的主件，然后再在其附件1上赋值
                    goods[q][1] = pt;
                }else{//默认的判断是pts[q][2] == null
                    goods[q][2] = pt;
                }
            }
        }
        //有四种情况：主件， 主件和附件1 ， 主件和附件2 ， 主件和附件1，2 ； 由此可以确定必须要有主件
        for (int i = 1; i <= m; i++) {//从第1个开始算起
            Product master = goods[i][0];
            for (int j = N; j >= 0 && master != null ; j--) {//注意，要让master不为null，可以减少遍历次数，从而降低时间复杂度
                int max = rt[j];
                int vt;
                if(j >= (vt = master.v) && max < rt[j - vt] + master.vp){//在不超过master.v的情况下，如果max小于选中当前主件的话
                    max = rt[j - vt] + master.vp;
                }
                if(goods[i][1] != null){//说明有第1个附件的情况下
                    if (j >= (vt = master.v + goods[i][1].v) && max < rt[j - vt] + master.vp + goods[i][1].vp){
                        max = rt[j - vt] + master.vp + goods[i][1].vp;
                    }
                }
                if(goods[i][1] != null && goods[i][2] != null){
                    //说明有第2个附件的情况下
                    if (j >= (vt = master.v + goods[i][2].v) && max < rt[j - vt] + master.vp + goods[i][2].vp){
                        max = rt[j - vt] + master.vp + goods[i][2].vp;
                    }
                    //有两个附件的情况下
                    if (j >= (vt = master.v + goods[i][1].v + goods[i][2].v)
                            && max < rt[j - vt] + master.vp + goods[i][1].vp + goods[i][2].vp){
                        max = rt[j - vt] + master.vp + goods[i][1].vp  + goods[i][2].vp;
                    }
                }
                rt[j] = max;
            }
        }
        System.out.println(rt[N]);
    }
}

class Product{
    int v;//价值
    int vp;//重要程度

    public Product(int v, int vp) {
        this.v = v;
        this.vp = vp;
    }
}