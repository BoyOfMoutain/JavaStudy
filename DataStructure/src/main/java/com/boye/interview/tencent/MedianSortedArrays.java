package com.boye.interview.tencent;

/*
 * 1.首先，让我们在任一位置 i 将 A(长度为m) 划分成两个部分：
 *            leftA            |                rightA
 *   A[0],A[1],...      A[i-1] |  A[i],A[i+1],...A[m - 1]
 *
 * 由于A有m个元素，所以有m + 1中划分方式(i = 0 ~ m)
 *
 * 我们知道len(leftA) = i, len(rightA) = m - i;
 * 注意：当i = 0时，leftA是空集，而当i = m时，rightA为空集。
 *
 * 2.采用同样的方式，将B也划分为两部分：
 *            leftB            |                rightB
 *   B[0],B[1],...      B[j-1] |   B[j],B[j+1],...B[n - 1]
 *  我们知道len(leftA) = j, len(rightA) = n - j;
 *
 *  将leftA和leftB放入一个集合，将rightA和rightB放入一个集合。再把这两个集合分别命名为leftPart和rightPart。
 *
 *            leftPart         |                rightPart
 *   A[0],A[1],...      A[i-1] |  A[i],A[i+1],...A[m - 1]
 *   B[0],B[1],...      B[j-1] |  B[j],B[j+1],...B[n - 1]
 *
 *   如果我们可以确认：
 *   1.len(leftPart) = len(rightPart); =====> 该条件在m+n为奇数时，该推理不成立
 *   2.max(leftPart) <= min(rightPart);
 *
 *   median = (max(leftPart) + min(rightPart)) / 2;  目标结果
 *
 *   要确保这两个条件满足：
 *   1.i + j = m - i + n - j(或m - i + n - j + 1)  如果n >= m。只需要使i = 0 ~ m，j = (m+n+1)/2-i =====> 该条件在m+n为奇数/偶数时，该推理都成立
 *   2.B[j] >= A[i-1] 并且 A[i] >= B[j-1]
 *
 *   注意:
 *   1.临界条件：i=0,j=0,i=m,j=n。需要考虑
 *   2.为什么n >= m ? 由于0 <= i <= m且j = (m+n+1)/2-i,必须确保j不能为负数。
 *
 *   按照以下步骤进行二叉树搜索
 *   1.设imin = 0,imax = m，然后开始在[imin,imax]中进行搜索
 *   2.令i = (imin+imax) / 2, j = (m+n+1)/2-i
 *   3.现在我们有len(leftPart) = len(rightPart)。而我们只会遇到三种情况：
 *
 *      ①.B[j] >= A[i-1] 并且 A[i] >= B[j-1]  满足条件
 *      ②.B[j-1] > A[i]。此时应该把i增大。 即imin = i + 1;
 *      ③.A[i-1] > B[j]。此时应该把i减小。 即imax = i - 1;
 *
 * */
public class MedianSortedArrays {

    public static double findMedianSortedArrays(int[] A, int[] B){
        int m = A.length;
        int n = B.length;
        if(m > n){//交换A和B
            return findMedianSortedArrays(B, A);
        }
        int iMin = 0,iMax = m, halfLen = (m + n + 1) >> 1;
        while(iMin <= iMax){
            int i = (iMin + iMax) >> 1;
            int j = halfLen - i;
            if(j != 0 && i != m && B[j-1] > A[i]){//j != 0 && i != m 为了保证数组不越界， i 需要增大
                iMin = i+1;
            }else if(i != 0 && j != n && A[i-1] > B[j] ){//i != 0 && j != n 为了保证数组不越界，i 需要变小
                iMax = i-1;
            }else{// 达到要求，并且将边界条件列出来单独考虑
                //1.先把左边最大值算出来
                int maxLeft = 0;
                if(i == 0){
                    maxLeft = B[j-1];
                }else if(j == 0){
                    maxLeft = A[i-1];
                }else{
                    maxLeft = Math.max(B[j-1], A[i-1]);
                }
                if( (m + n) % 2 == 1 ){//奇数的时候
                    return maxLeft;
                }
                //然后再算下右边的最小值
                int minRight = 0;
                if (i == m){
                    minRight = B[j];
                }else if(j == n){
                    minRight = A[i];
                }else{
                    minRight = Math.min(B[j], A[i]);
                }
                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }

    public static void main(String[] args) {
        int[] num1 = {1,3};
        int[] num2 = {2};

        System.out.println(findMedianSortedArrays(num1, num2));
    }
}
