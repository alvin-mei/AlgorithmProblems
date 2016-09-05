package com.stringProblems;

import java.util.List;

/**
 * Created by Alvin on 15/11/16.
 */
public class Exe {

    /**
     * 变形数
     */
    public boolean isChange(String str1,String str2){
        //若有一个字符串为null或者两个字符串的长度不相等,那么必不为变形
        if(str1 == null || str1 == null || str1.length() != str2.length())
            return false;
        //转换为char类型的数组
        char[] c1 = str1.toCharArray();
        char[] c2 = str2.toCharArray();
        //设置一个容器,存放每个字母在字符串中出现的数量
        int[] contrainer = new int[26];
        for(int i = 0;i < c1.length;i++)
            contrainer[c1[i]-'a']++;
        //若c2的字母数量c1的字母数量不想等,则相互不为变形字符串
        for(int j = 0;j <c2.length; j++)
            if(contrainer[c2[j]-'a']--==0)
                return false;
        return true;
    }

    /**
     * 移除字符串中的数字
     */
    public String deleteNumFromString(String str){
        if(str == null)
            return null;
        char[] c = str.toCharArray();
        int len = c.length;
        //j用于指向非数字数,i用于指向整个字符串
        int i = 0,j = 0;
        for(;i < len && j < len;i++,j++)
        {
            //移动i若遇到数字,则直接后移
            //此时j不移动指向数字前的一个字母
            while(c[i] >= '0' && c[i] <='9')
                i++;
            //交换将i赋值给j,就是将数字后的第一个字母
            //覆盖掉数字
            c[j] = c[i];
        }
        //这里只截取0-j的字符串,因为j一直指向的是字母
        String result = String.valueOf(c,0,j);
        return result;
    }

    /**
     * 判断是否为回文
     */
    public boolean isPlalindrome(String str){
        if(str == null)
            return false;
        int len = str.length();
        //比较左右两个偏移相同的字符是否一致
        for(int i = 0; i < len/2;i++)
            if(str.charAt(i) != str.charAt(len-1-i))
                return false;
        return true;
    }

    /**
     * 递归法反转单向链表
     */
    public Node reverseListByRec(Node head) {
        //若链表为空或只有一个节点,则直接返回
        if(null == head || null == head.next)
            return head;
        //遍历链表,直到链表末尾,然后从后向前赋值
        reverseListByRec(head.next).next = head;
        //此时的头节点为尾节点,所以next节点应该为null
        head.next = null;
        return head;
    }

    /**
     * 遍历法反转单向链表
     */
    public void reverseList(Node head) {
        if(null == head || null == head.next)
            return ;
        //上一个节点
        Node pre = head;
        //当前节点
        Node cur = head.next;
        Node temp;
        while(null != cur) {
            //将当前节点的下一个节点保存起来
            temp = cur.next;
            //将当前节点的下一个节点指向前一个节点
            cur.next = pre;
            //将当前前一个节点设置为当前节点
            pre = cur;
            //将当前节点设置为下一个节点
            cur = temp;
        }
        //此时的头节点为尾节点,所以next节点应该为null
        head.next = null;
    }

    /**
     * 反转双向链表
     */
    public void reverseDuList(Node head) {
        if(null == head || null == head.next)
            return ;
        //当前节点
        Node cur = head;
        //前置节点
        Node pre;
        while(null != cur) {
            //保存后置节点
            Node temp = cur.next;
            //反转当前节点
            cur.next = cur.pre;
            cur.pre = temp;
            //向后传递
            cur = temp;
        }
    }
}
