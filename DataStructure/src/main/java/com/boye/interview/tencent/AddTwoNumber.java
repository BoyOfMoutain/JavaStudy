package com.boye.interview.tencent;

import java.util.List;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 结果：342 + 465 = 807
 *
 */
public class AddTwoNumber {

    public static ListNode addTwoNumber(ListNode l1, ListNode l2){
        if(l1 ==  null && l2 == null){
            return null;
        }
        ListNode node = new ListNode(0);
        int carry = 0;//进位为0
        ListNode p = l1, q = l2, cur = node;
        while(p!= null || q!= null){
            int x = p!=null ? p.val : 0;
            int y = q!=null ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            //这后面很关键，决定是否要往下面走
            if(p!= null) {p=p.next;}
            if(q!= null) {q=q.next;}
        }
        if(carry > 0){
            cur.next = new ListNode(carry);
        }
        return node.next;//指回头节点
    }

    public static class ListNode{
        private int val;//数
        private ListNode next;//节点
        public ListNode(int val) {
            this.val = val;
        }
    }

    public static void printNode(ListNode node){
        if(node != null){
            ListNode p = node;
            while(p!= null){
                if(p.next != null){
                    System.out.print(p.val + " -> ");
                }else{
                    System.out.print(p.val);
                }
                p = p.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next= new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(6);
        printNode(l1);
        printNode(l2);
        System.out.println("相加后:");
        printNode(addTwoNumber(l1,l2));
    }
}
